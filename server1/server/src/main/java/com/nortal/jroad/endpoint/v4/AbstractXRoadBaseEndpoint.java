package com.nortal.jroad.endpoint.v4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.nortal.jroad.endpoint.AbstractXTeeBaseEndpoint;
import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.model.BeanXTeeMessage;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeHeader;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.util.SOAPUtil;
import com.nortal.jroad.util.XTeeUtil;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public abstract class AbstractXRoadBaseEndpoint extends AbstractXTeeBaseEndpoint {

  @SuppressWarnings("unchecked")
  @Override
  protected void getResponse(Document query, SOAPMessage responseMessage, SOAPMessage requestMessage) throws Exception {
    XTeeHeader header = metaService ? null : parseXTeeHeader(requestMessage);

    // Build request message
    List<XTeeAttachment> attachments = new ArrayList<XTeeAttachment>();
    for (Iterator<AttachmentPart> i = requestMessage.getAttachments(); i.hasNext();) {
      AttachmentPart a = i.next();
      attachments.add(new XTeeAttachment(a.getContentId(), a.getContentType(), a.getRawContentBytes()));
    }
    XTeeMessage<Document> request = new BeanXTeeMessage<Document>(header, query, attachments);

    // Build response message
    SOAPElement teenusElement = createXteeMessageStructure(requestMessage, responseMessage);
    Element kehaNode = teenusElement.addChildElement("keha");
    XTeeMessage<Element> response = new BeanXTeeMessage<Element>(header, kehaNode, new ArrayList<XTeeAttachment>());

    // Run logic
    invokeInternalEx(request, response, requestMessage, responseMessage);

    // Add any attachments
    for (XTeeAttachment a : response.getAttachments()) {
      AttachmentPart attachment = responseMessage.createAttachmentPart(a.getDataHandler());
      attachment.setContentId("<" + a.getCid() + ">");
      responseMessage.addAttachmentPart(attachment);
    }

    if (!metaService) {
      addHeader(header, responseMessage);
    }
  }

  @SuppressWarnings("unchecked")
  private XTeeHeader parseXTeeHeader(SOAPMessage paringMessage) throws SOAPException {
    XTeeHeader xRoadHeader = new XTeeHeader();
    SOAPHeader header = paringMessage.getSOAPHeader();
    for (Iterator<Node> headerElemendid = header.getChildElements(); headerElemendid.hasNext();) {
      Node headerElement = headerElemendid.next();
      if (!SOAPUtil.isTextNode(headerElement) && headerElement.getFirstChild() != null) {
        String localName = headerElement.getLocalName();
        String value = headerElement.getFirstChild().getNodeValue();
        xRoadHeader.addElement(new QName(headerElement.getNamespaceURI(), localName), value);
        if (PROTOCOL_VERSION.equals(localName)) {
          version = XRoadProtocolVersion.getValueByVersionCode(value);
        }
      }
    }
    if (version == null) {
      Iterator<Node> elements = header.getChildElements();
      while (version == null && elements.hasNext()) {
        version = XRoadProtocolVersion.getValueByNamespaceURI(elements.next().getNamespaceURI());
      }
    }
    return xRoadHeader;
  }

  protected void addHeader(XTeeHeader header, SOAPMessage message) throws SOAPException {
    XTeeUtil.addXteeNamespace(message, version.getNamespacePrefix(), version.getNamespaceUri());
    SOAPUtil.addNamespace(message, version.getNamespacePrefix(), version.getNamespaceUri());
    for (QName qname : header.getElemendid().keySet()) {
      XTeeUtil.addHeaderElement(message.getSOAPHeader(),
                                qname.getLocalPart(),
                                header.getElemendid().get(qname),
                                version.getNamespacePrefix());
    }
  }

  /**
   * This method can be overridden if you need direct access to the request and response messages.
   */
  protected void invokeInternalEx(XTeeMessage<Document> request,
                                  XTeeMessage<Element> response,
                                  SOAPMessage responseMessage,
                                  SOAPMessage requestMessage) throws Exception {
    invokeInternal(request, response);
  }

  /**
   * Method which must implement the service logic, receives <code>request</code> and <code>response<code>.
   */
  protected void invokeInternal(XTeeMessage<Document> request, XTeeMessage<Element> response) throws Exception {
    throw new IllegalStateException("You must override either the 'invokeInternal' or the 'invokeInternalEx' method!");
  };
}
