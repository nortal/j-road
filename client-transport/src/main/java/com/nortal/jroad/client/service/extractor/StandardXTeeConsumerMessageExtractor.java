package com.nortal.jroad.client.service.extractor;

import com.nortal.jroad.client.exception.NonTechnicalFaultException;
import com.nortal.jroad.client.util.XmlBeansUtil;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import com.nortal.jroad.util.SOAPUtil;
import com.sun.xml.messaging.saaj.soap.impl.TextImpl;
import org.apache.xmlbeans.*;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageExtractor;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.xml.transform.StringResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import jakarta.xml.soap.AttachmentPart;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author Dmitri Danilkin
 */
public class StandardXTeeConsumerMessageExtractor implements WebServiceMessageExtractor<XTeeMessage<XmlObject>> {
  private final XmlBeansXTeeMetadata metadata;
  private final boolean extractKehaElement;

  public StandardXTeeConsumerMessageExtractor(XmlBeansXTeeMetadata metadata, boolean extractKehaElement) {
    this.metadata = metadata;
    this.extractKehaElement = extractKehaElement;
  }

  @Override
  public XTeeMessage<XmlObject> extractData(WebServiceMessage response) throws IOException {
    Node kehaNode;
    try {
      SaajSoapMessage message = (SaajSoapMessage) response;
      SOAPMessage mes = message.getSaajMessage();
      Element body = mes.getSOAPBody();
      NodeList kehaNodes = getKehaNodes(body, extractKehaElement);
      kehaNode = kehaNodes.item(0);
      if (kehaNode instanceof TextImpl) {
        kehaNode = kehaNodes.item(1);
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
      Node NSCheckNode = SOAPUtil.getFirstNonTextChild(kehaNode);
      if (NSCheckNode != null && !(NSCheckNode.getNamespaceURI() == null || "".equals(NSCheckNode.getNamespaceURI()))) {
        DOMSource src = new DOMSource(kehaNode);
        StringResult result = new StringResult();
        TransformerFactory.newInstance().newTransformer().transform(src, result);

        DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
        fac.setNamespaceAware(false);
        ByteArrayInputStream stream = new ByteArrayInputStream(result.toString().getBytes("UTF-8"));
        kehaNode = SOAPUtil.getFirstNonTextChild(fac.newDocumentBuilder().parse(stream));
      }

      XmlOptions options = new XmlOptions();
      SchemaTypeLoader loader = XmlBeans.getContextTypeLoader();
      QName responseElement = new QName(metadata.getResponseElementNs(), metadata.getResponseElementName());
      SchemaType type = loader.findType(responseElement);
      XmlObject responseObj;

      if (type != null) {
        options.setDocumentType(type);
        options.setLoadReplaceDocumentElement(new QName("xml-fragment"));
        responseObj =
            XmlObject.Factory.parse(XmlObject.Factory.parse(kehaNode, options).toString(),
                new XmlOptions().setDocumentType(type));
      } else {
        options.setLoadReplaceDocumentElement(responseElement);
        responseObj = XmlBeansUtil.getResponseObject(XmlObject.Factory.parse(kehaNode, options));
      }

      Map<String, XTeeAttachment> attachments = new HashMap<String, XTeeAttachment>();
      List<XTeeAttachment> undefined = new ArrayList<XTeeAttachment>();
      for (Iterator<?> i = SOAPUtil.extractSoapMessage(response).getAttachments(); i.hasNext();) {
        AttachmentPart part = (AttachmentPart) i.next();
        String cid = part.getContentId();
        if (cid == null) {
          undefined.add(new XTeeAttachment(cid, part.getDataHandler()));
        } else {
          cid = cid.startsWith("<") && cid.endsWith(">") ? cid.substring(1, cid.length() - 1) : cid;
          attachments.put(cid, new XTeeAttachment(part.getContentId(), part.getDataHandler()));
        }
      }
      if (!attachments.isEmpty()) {
        for (XmlObject obj : XmlBeansUtil.getAllObjects(responseObj)) {
          for (Method method : XmlBeansUtil.getSwaRefSetters(obj)) {
            String field = XmlBeansUtil.getFieldName(method);
            String cid = XmlBeansUtil.getCid(obj, field);
            cid = cid.startsWith("cid:") ? cid.substring(4) : cid;

            XTeeAttachment attachment = attachments.get(cid);
            if (attachment != null) {
              attachments.remove(cid);
              method.invoke(obj, attachment.getDataHandler());
            }
          }
        }
      }
      undefined.addAll(attachments.values());
      return new XmlBeansXTeeMessage<XmlObject>(responseObj, undefined);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  private NodeList getKehaNodes(Element body, boolean isKehaElementNeeded) {
    NodeList kehaNodes = null;
    if(isKehaElementNeeded){
      kehaNodes = body.getElementsByTagName("keha");
    }
    if (kehaNodes == null || kehaNodes.getLength() == 0) {
      kehaNodes = body.getChildNodes();
    }
    return kehaNodes;
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
