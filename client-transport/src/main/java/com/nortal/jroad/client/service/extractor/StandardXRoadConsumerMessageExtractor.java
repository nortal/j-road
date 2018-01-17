package com.nortal.jroad.client.service.extractor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.xml.transform.StringResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.nortal.jroad.client.exception.NonTechnicalFaultException;
import com.nortal.jroad.client.util.XmlBeansUtil;
import com.nortal.jroad.model.XRoadAttachment;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMetadata;
import com.nortal.jroad.util.SOAPUtil;

/**
 * @author Dmitri Danilkin
 */
@SuppressWarnings("rawtypes")
public class StandardXRoadConsumerMessageExtractor implements WebServiceMessageExtractor {
  private final XmlBeansXRoadMetadata metadata;

  public StandardXRoadConsumerMessageExtractor(XmlBeansXRoadMetadata metadata) {
    this.metadata = metadata;
  }

  public XRoadMessage<XmlObject> extractData(WebServiceMessage response) throws IOException {
    Node kehaNode;
    try {
      SaajSoapMessage message = (SaajSoapMessage) response;
      SOAPMessage mes = message.getSaajMessage();
      Element body = mes.getSOAPBody();
      NodeList kehaNodes = body.getChildNodes();
      kehaNode = body.getChildNodes().item(0);
      if (kehaNode instanceof javax.xml.soap.Text) {
        kehaNode = getKehaNode(kehaNodes, 1);
      }
      if (kehaNodes.getLength() > 1) {
        // In case of multiple elements take the first one that matches specified hierarchy
        for (int i = 0; i < kehaNodes.getLength(); i++) {
          if (kehaNodes.item(i).getParentNode().getParentNode().equals(body)) {
            kehaNode = kehaNodes.item(i);
            break;
          }
        }
      }
    } catch (SOAPException e) {
      throw new RuntimeException(e);
    }

    checkForNonTechnicalFault(kehaNode);

    try {
      XmlOptions options = new XmlOptions();
      SchemaTypeLoader loader = XmlBeans.getContextTypeLoader();
      QName responseElement = new QName(metadata.getResponseElementNs(), metadata.getResponseElementName());
      SchemaType type = loader.findType(responseElement);
      XmlObject responseObj;

      if (StringUtils.isBlank(responseElement.getNamespaceURI())
          && !StringUtils.equalsIgnoreCase(kehaNode.getNamespaceURI(), responseElement.getNamespaceURI())) {
        DOMSource src = new DOMSource(kehaNode);
        StringResult result = new StringResult();
        TransformerFactory.newInstance().newTransformer().transform(src, result);

        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        fac.setNamespaceAware(false);
        ByteArrayInputStream stream = new ByteArrayInputStream(result.toString().getBytes("UTF-8"));
        kehaNode = SOAPUtil.getFirstNonTextChild(fac.newDocumentBuilder().parse(stream));
      }

      if (type != null) {
        options.setDocumentType(type);
        options.setLoadReplaceDocumentElement(new QName("xml-fragment"));
        responseObj = XmlObject.Factory.parse(XmlObject.Factory.parse(kehaNode, options).toString(),
                                              new XmlOptions().setDocumentType(type));
      } else {
        options.setLoadReplaceDocumentElement(responseElement);
        responseObj = XmlBeansUtil.getResponseObject(XmlObject.Factory.parse(kehaNode, options));
      }

      Map<String, XRoadAttachment> attachments = new HashMap<String, XRoadAttachment>();
      List<XRoadAttachment> undefined = new ArrayList<XRoadAttachment>();
      for (Iterator<?> i = SOAPUtil.extractSoapMessage(response).getAttachments(); i.hasNext();) {
        AttachmentPart part = (AttachmentPart) i.next();
        String cid = part.getContentId();
        if (cid == null) {
          undefined.add(new XRoadAttachment(cid, part.getDataHandler()));
        } else {
          cid = cid.startsWith("<") && cid.endsWith(">") ? cid.substring(1, cid.length() - 1) : cid;
          attachments.put(cid, new XRoadAttachment(part.getContentId(), part.getDataHandler()));
        }
      }
      if (!attachments.isEmpty()) {
        for (XmlObject obj : XmlBeansUtil.getAllObjects(responseObj)) {
          for (Method method : XmlBeansUtil.getSwaRefSetters(obj)) {
            String field = XmlBeansUtil.getFieldName(method);
            String cid = XmlBeansUtil.getCid(obj, field);
            cid = cid.startsWith("cid:") ? cid.substring(4) : cid;

            XRoadAttachment attachment = attachments.get(cid);
            if (attachment != null) {
              attachments.remove(cid);
              method.invoke(obj, attachment.getDataHandler());
            }
          }
        }
      }
      undefined.addAll(attachments.values());
      return new XmlBeansXRoadMessage<XmlObject>(responseObj, undefined);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  private Node getKehaNode(NodeList kehaNodes, int nextIndex) {
    Node kehaNode = kehaNodes.item(nextIndex);
    if (kehaNode instanceof javax.xml.soap.Text) {
      kehaNode = getKehaNode(kehaNodes, ++nextIndex);
    }
    return kehaNode;
  }

  private void checkForNonTechnicalFault(Node kehaNode) throws NonTechnicalFaultException {
    String nonTechnicalFaultCode = null;
    String nonTechnicalFaultString = null;

    NodeList nodes = kehaNode.getChildNodes();
    for (int i = 0; i < nodes.getLength(); i++) {
      Node node = nodes.item(i);
      if ("faultCode".equalsIgnoreCase(node.getLocalName())) {
        nonTechnicalFaultCode = node.getTextContent();
      } else if ("faultString".equalsIgnoreCase(node.getLocalName())) {
        nonTechnicalFaultString = node.getTextContent();
      }
    }

    if (nonTechnicalFaultCode != null || nonTechnicalFaultString != null) {
      throw new NonTechnicalFaultException(nonTechnicalFaultCode, nonTechnicalFaultString);
    }
  }

}