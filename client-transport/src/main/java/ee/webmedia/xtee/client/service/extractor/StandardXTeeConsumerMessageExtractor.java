package ee.webmedia.xtee.client.service.extractor;

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

import ee.webmedia.xtee.client.exception.NonTechnicalFaultException;
import ee.webmedia.xtee.client.util.XmlBeansUtil;
import ee.webmedia.xtee.model.XTeeAttachment;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMetadata;
import ee.webmedia.xtee.util.SOAPUtil;

/**
 * @author Dmitri Danilkin
 */
public class StandardXTeeConsumerMessageExtractor implements WebServiceMessageExtractor {
  private final XmlBeansXTeeMetadata metadata;

  public StandardXTeeConsumerMessageExtractor(XmlBeansXTeeMetadata metadata) {
    this.metadata = metadata;
  }

  public XTeeMessage<XmlObject> extractData(WebServiceMessage response) throws IOException {
    Node kehaNode;
    try {
      SaajSoapMessage message = (SaajSoapMessage) response;
      SOAPMessage mes = message.getSaajMessage();
      Element body = mes.getSOAPBody();
      NodeList kehaNodes = body.getElementsByTagName("keha");
	  if (kehaNodes.getLength() == 0) {
	    kehaNodes = body.getChildNodes();
	  }
      kehaNode = kehaNodes.item(0);
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