/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.endpoint;

import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.model.BeanXRoadMessage;
import com.nortal.jroad.model.XRoadAttachment;
import com.nortal.jroad.model.XTeeHeader;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.util.SOAPUtil;
import com.nortal.jroad.wsdl.XTeeWsdlDefinition;
import jakarta.xml.soap.AttachmentPart;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPHeader;
import jakarta.xml.soap.SOAPMessage;
import org.apache.log4j.Logger;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.MessageEndpoint;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Base class for X-Tee Spring web-service endpoints, extension classes must implement
 * {@link AbstractXTeeBaseEndpoint#invokeInternal(XRoadMessage request, XRoadMessage response)}.
 *
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public abstract class AbstractXTeeBaseEndpoint implements MessageEndpoint {
  private static final Logger log = Logger.getLogger(AbstractXTeeBaseEndpoint.class);
  protected static final String PROTOCOL_VERSION = "protocolVersion";
  public final static String RESPONSE_SUFFIX = "Response";
  protected boolean metaService = false;
  protected XRoadProtocolVersion version;

  public final void invoke(MessageContext messageContext) throws Exception {
    handleRequest(messageContext);
    SOAPMessage paringMessage = SOAPUtil.extractSoapMessage(messageContext.getRequest());
    SOAPMessage responseMessage = SOAPUtil.extractSoapMessage(messageContext.getResponse());

    version = parseProtocolVersion(paringMessage);

    // meta-service does not need 'header' element
    if (metaService) {
      responseMessage.getSOAPHeader().detachNode();
    }

    Document paring = metaService ? null : parseQuery(paringMessage);

    getResponse(paring, responseMessage, paringMessage);
    handleResponse(messageContext);
  }

  @SuppressWarnings("unchecked")
  protected XRoadProtocolVersion parseProtocolVersion(SOAPMessage requestMessage) throws SOAPException {
    XRoadProtocolVersion version = null;
    // Extract protocol version by headers
    if (requestMessage.getSOAPHeader() != null) {
      NodeList reqHeaders = requestMessage.getSOAPHeader().getChildNodes();
      for (int i = 0; i < reqHeaders.getLength(); i++) {
        Node reqHeader = reqHeaders.item(i);
        if (reqHeader.getNodeType() != Node.ELEMENT_NODE
            || !reqHeader.getLocalName().equals(XTeeHeader.PROTOCOL_VERSION.getLocalPart())) {
          continue;
        }

        if ((version = XRoadProtocolVersion.getValueByVersionCode(SOAPUtil.getTextContent(reqHeader))) != null) {
          return version;
        }
      }
    }
// @SuppressWarnings("unchecked")
//  protected void getResponse(Document query, SOAPMessage responseMessage, SOAPMessage requestMessage) throws Exception {
//    XTeeHeader header = metaService ? null : parseXteeHeader(requestMessage);
//
//    // Build request message
//    List<XRoadAttachment> attachments = new ArrayList<>();
//    for (Iterator<AttachmentPart> i = requestMessage.getAttachments(); i.hasNext();) {
//      AttachmentPart a = i.next();
//      attachments.add(new XRoadAttachment(a.getContentId(), a.getContentType(), a.getRawContentBytes()));
//    }
//    XRoadMessage<Document> request = new BeanXRoadMessage<>(header, query, attachments);
//
//    SOAPElement teenusElement = createXRoadMessageStructure(requestMessage, responseMessage);
//    if (XRoadProtocolVersion.V2_0 == version) {
//      if (!metaService) {
//        copyParing(query, teenusElement);
//      }
//      teenusElement = teenusElement.addChildElement("keha");
//    }
//
//    // Build response message
//    XRoadMessage<Element> response = new BeanXRoadMessage<>(header,
//      teenusElement,
//      new ArrayList<>());
//
//    // Run logic
//    invokeInternalEx(request, response, requestMessage, responseMessage);
//
//    // Add any attachments
//    for (XRoadAttachment a : response.getAttachments()) {
//      AttachmentPart attachment = responseMessage.createAttachmentPart(a.getDataHandler());
//      attachment.setContentId("<" + a.getCid() + ">");
//      responseMessage.addAttachmentPart(attachment);
//    }
//  }


    // Extract protocol version by namespaces
    SOAPEnvelope soapEnv = requestMessage.getSOAPPart().getEnvelope();
    Iterator<String> prefixes = soapEnv.getNamespacePrefixes();
    while (prefixes.hasNext()) {
      String nsPrefix = prefixes.next();
      String nsURI = soapEnv.getNamespaceURI(nsPrefix).toLowerCase();
      if ((version = XRoadProtocolVersion.getValueByNamespaceURI(nsURI)) != null) {
        return version;
      }
    }
    throw new IllegalStateException("Unsupported protocol version");
  }

  @SuppressWarnings("unchecked")
  protected void getResponse(Document query, SOAPMessage responseMessage, SOAPMessage requestMessage) throws Exception {
    XTeeHeader header = metaService ? null : parseXteeHeader(requestMessage);

    // Build request message
    List<XRoadAttachment> attachments = new ArrayList<XRoadAttachment>();
    for (Iterator<AttachmentPart> i = requestMessage.getAttachments(); i.hasNext();) {
      AttachmentPart a = i.next();
      attachments.add(new XRoadAttachment(a.getContentId(), a.getContentType(), a.getRawContentBytes()));
    }
    XRoadMessage<Document> request = new BeanXRoadMessage<Document>(header, query, attachments);

    SOAPElement teenusElement = createXRoadMessageStructure(requestMessage, responseMessage);
    if (XRoadProtocolVersion.V2_0 == version) {
      if (!metaService) {
        copyParing(query, teenusElement);
      }
      teenusElement = teenusElement.addChildElement("keha");
    }

    // Build response message
    XRoadMessage<Element> response =
        new BeanXRoadMessage<Element>(header, teenusElement, new ArrayList<XRoadAttachment>());

    // Run logic
    invokeInternalEx(request, response, requestMessage, responseMessage);

    // Add any attachments
    for (XRoadAttachment a : response.getAttachments()) {
      AttachmentPart attachment = responseMessage.createAttachmentPart(a.getDataHandler());
      attachment.setContentId("<" + a.getCid() + ">");
      responseMessage.addAttachmentPart(attachment);
    }
  }

  @SuppressWarnings("unchecked")
  private XTeeHeader parseXteeHeader(SOAPMessage paringMessage) throws SOAPException {
    XTeeHeader pais = new XTeeHeader();
    if (paringMessage.getSOAPHeader() == null) {
      return pais;
    }

    SOAPHeader header = paringMessage.getSOAPHeader();
    for (Iterator<? extends Node> headerElemendid = header.getChildElements(); headerElemendid.hasNext();) {
      Node headerElement = headerElemendid.next();
      if (!SOAPUtil.isTextNode(headerElement) && headerElement.getFirstChild() != null) {
        String localName = headerElement.getLocalName();
        String value = headerElement.getFirstChild().getNodeValue();
        NodeList childNodes = headerElement.getChildNodes();
        if (childNodes.getLength() > 1) {
          for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getLocalName() == null) {
              continue;
            }
            pais.addElement(new QName(item.getNamespaceURI(), localName + "." + item.getLocalName()),
                              item.getFirstChild().getNodeValue());

          }
        }
        pais.addElement(new QName(headerElement.getNamespaceURI(), localName), value);
      }
    }
    return pais;
  }

  protected Document parseQuery(SOAPMessage queryMsg) throws Exception {
    Node bodyNode = SOAPUtil.getFirstNonTextChild(queryMsg.getSOAPBody());
    if (XRoadProtocolVersion.V2_0 == version) {
      bodyNode = SOAPUtil.getNodeByXPath(bodyNode, "//keha");
      if (bodyNode == null) {
        throw new IllegalStateException("Service is not metaservice, but query is missing mandatory body ('//keha\')");
      }
    }

    Document query = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    bodyNode = query.importNode(bodyNode, true);
    query.appendChild(bodyNode);
    return query;
  }

  @SuppressWarnings("unchecked")
  protected SOAPElement createXRoadMessageStructure(SOAPMessage requestMessage, SOAPMessage responseMessage)
      throws Exception {
    SOAPUtil.addBaseMimeHeaders(responseMessage);
    SOAPUtil.addBaseNamespaces(responseMessage);
    if (!metaService) {
      // Assign xroad namespaces according to request
      List<String> xteeNamespaces = new ArrayList<String>();
      xteeNamespaces.add(version.getNamespaceUri());
      if (XRoadProtocolVersion.V4_0 == version) {
        xteeNamespaces.add(XTeeWsdlDefinition.XROAD_IDEN_NAMESPACE);
      }

      Iterator<String> prefixes = requestMessage.getSOAPPart().getEnvelope().getNamespacePrefixes();
      while (prefixes.hasNext()) {
        String nsPrefix = prefixes.next();
        String nsURI = requestMessage.getSOAPPart().getEnvelope().getNamespaceURI(nsPrefix).toLowerCase();
        if (xteeNamespaces.contains(nsURI)) {
          SOAPUtil.addNamespace(responseMessage, nsPrefix, nsURI);
        }
      }

      // Copy headers from request
      NodeList reqHeaders = requestMessage.getSOAPHeader().getChildNodes();
      for (int i = 0; i < reqHeaders.getLength(); i++) {
        Node reqHeader = reqHeaders.item(i);
        if (reqHeader.getNodeType() != Node.ELEMENT_NODE) {
          continue;
        }
        Node rspHeader = responseMessage.getSOAPPart().importNode(reqHeader, true);
        responseMessage.getSOAPHeader().appendChild(rspHeader);
      }
    }
    responseMessage.getSOAPPart().getEnvelope().setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");

    Node teenusElement = SOAPUtil.getFirstNonTextChild(requestMessage.getSOAPBody());
    if (teenusElement.getPrefix() == null || teenusElement.getNamespaceURI() == null) {
      throw new IllegalStateException("Service request is missing namespace.");
    }
    String prefix = teenusElement.getPrefix() == null ? "rsp" : teenusElement.getPrefix();
    SOAPUtil.addNamespace(responseMessage, prefix, teenusElement.getNamespaceURI());

    String teenusElementName = teenusElement.getLocalName();
    if (teenusElementName.endsWith(SuffixBasedMessagesProvider.DEFAULT_REQUEST_SUFFIX)) {
      teenusElementName =
          teenusElementName.substring(0,
                                      teenusElementName.lastIndexOf(SuffixBasedMessagesProvider.DEFAULT_REQUEST_SUFFIX));
    }
    teenusElementName += SuffixBasedMessagesProvider.DEFAULT_RESPONSE_SUFFIX;
    return responseMessage.getSOAPBody().addChildElement(teenusElementName,
                                                         prefix,
                                                         teenusElement.getNamespaceURI());
  }

  private void copyParing(Document paring, Node response) throws Exception {
    Node paringElement = response.appendChild(response.getOwnerDocument().createElement("paring"));
    Node kehaNode = response.getOwnerDocument().importNode(paring.getDocumentElement(), true);

    NamedNodeMap attrs = kehaNode.getAttributes();
    for (int i = 0; i < attrs.getLength(); i++) {
      paringElement.getAttributes().setNamedItem(attrs.item(i).cloneNode(true));
    }

    while (kehaNode.hasChildNodes()) {
      paringElement.appendChild(kehaNode.getFirstChild());
    }
  }

  /**
   * If true, request will be processed as a meta-request (an example of a meta-query is <code>listMethods</code>).
   */
  public void setMetaService(boolean metaService) {
    this.metaService = metaService;
  }

  /** Returns <code>true</code>, if this is a meta service. */
  public boolean isMetaService() {
    return metaService;
  }

  /**
   * This method can be overridden if you need direct access to the request and response messages.
   *
   * @param request
   * @param response
   * @param responseMessage
   * @param requestMessage
   * @throws Exception
   */
  protected void invokeInternalEx(XRoadMessage<Document> request,
                                  XRoadMessage<Element> response,
                                  SOAPMessage responseMessage,
                                  SOAPMessage requestMessage) throws Exception {
    invokeInternal(request, response);
  }

  /**
   * Method which must implement the service logic, receives <code>request</code> and <code>response</code>.
   *
   * @param request
   * @param response
   */
  protected void invokeInternal(XRoadMessage<Document> request, XRoadMessage<Element> response) throws Exception {
    throw new IllegalStateException("You must override either the 'invokeInternal' or the 'invokeInternalEx' method!");
  }

  protected enum MessageType {

    REQUEST, RESPONSE, FAULT;
  }

  protected boolean handleRequest(MessageContext mc) throws WebServiceClientException {
    return logMessage(mc, MessageType.REQUEST);
  }

  protected boolean handleResponse(MessageContext mc) throws WebServiceClientException {
    return true;
  }

  protected boolean logMessage(MessageContext mc, MessageType messageType) {
    if (log.isDebugEnabled()) {
      WebServiceMessage message = MessageType.REQUEST.equals(messageType) ? mc.getRequest() : mc.getResponse();

      if (message instanceof SaajSoapMessage) {
        OutputStream out = new ByteArrayOutputStream();
        try {
          message.writeTo(out);
          log.debug(messageType + " message follows:\n" + out.toString());
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }

    return true;
  }
}
