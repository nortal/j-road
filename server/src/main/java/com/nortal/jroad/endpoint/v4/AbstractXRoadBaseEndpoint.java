package com.nortal.jroad.endpoint.v4;

import com.nortal.jroad.endpoint.AbstractXTeeBaseEndpoint;
import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.model.v4.BeanXRoadMessage;
import com.nortal.jroad.model.v4.XRoadAttachment;
import com.nortal.jroad.model.v4.XRoadHeader;
import com.nortal.jroad.model.v4.XRoadMessage;
import com.nortal.jroad.util.SOAPUtil;
import com.nortal.jroad.util.XTeeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.namespace.QName;
import jakarta.xml.soap.AttachmentPart;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.soap.SOAPMessage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public abstract class AbstractXRoadBaseEndpoint extends AbstractXTeeBaseEndpoint {

  @SuppressWarnings("unchecked")
  @Override
  protected void getResponse(Document query, SOAPMessage responseMessage, SOAPMessage requestMessage)
      throws Exception {
    XRoadHeader header = metaService ? null : parseXRoadHeader(requestMessage);

    // Build request message
    List<XRoadAttachment> attachments = new ArrayList<>();
    for (Iterator<AttachmentPart> i = requestMessage.getAttachments(); i.hasNext();) {
      AttachmentPart a = i.next();
      attachments.add(new XRoadAttachment(a.getContentId(), a.getContentType(), a.getRawContentBytes()));
    }
    XRoadMessage<Document> request = new BeanXRoadMessage<>(header, query, attachments);

    // Build response message
    SOAPElement teenusElement = createXteeMessageStructure(requestMessage, responseMessage);
    Element kehaNode = teenusElement.addChildElement("keha");
    XRoadMessage<Element> response = new BeanXRoadMessage<>(header, kehaNode, new ArrayList<>());

    // Run logic
    invokeInternalEx(request, response, requestMessage, responseMessage);

    // Add any attachments
    for (XRoadAttachment a : response.getAttachments()) {
      AttachmentPart attachment = responseMessage.createAttachmentPart(a.getDataHandler());
      attachment.setContentId("<" + a.getCid() + ">");
      responseMessage.addAttachmentPart(attachment);
    }

    if (!metaService) {
      addHeader(header, responseMessage);
    }
  }

  @SuppressWarnings("unchecked")
  private XRoadHeader parseXRoadHeader(SOAPMessage paringMessage) throws SOAPException {
    XRoadHeader xRoadHeader = new XRoadHeader();
    SOAPHeader header = paringMessage.getSOAPHeader();
    for (Iterator<? extends Node> headerElemendid = header.getChildElements(); headerElemendid.hasNext();) {
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
      Iterator<? extends Node> elements = header.getChildElements();
      while (version == null && elements.hasNext()) {
        version = XRoadProtocolVersion.getValueByNamespaceURI(elements.next().getNamespaceURI());
      }
    }
    return xRoadHeader;
  }

  protected void addHeader(XRoadHeader header, SOAPMessage message) throws SOAPException {
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
  protected void invokeInternalEx(XRoadMessage<Document> request,
                                  XRoadMessage<Element> response,
                                  SOAPMessage responseMessage,
                                  SOAPMessage requestMessage) throws Exception {
    invokeInternal(request, response);
  }

  /**
   * Method which must implement the service logic, receives <code>request</code> and <code>response<code>.
   */
  protected void invokeInternal(XRoadMessage<Document> request, XRoadMessage<Element> response) throws Exception {
    throw new IllegalStateException("You must override either the 'invokeInternal' or the 'invokeInternalEx' method!");
  };
}
