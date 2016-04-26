/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.util;

import java.util.Collection;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathFactory;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Helper methods for handling SOAP messages
 *
 * @author Dmitri Danilkin
 * @author Roman Tekhov
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class SOAPUtil {
  public static final String TEENUS_NS_PREFIX = "tns";

  /**
   * Returns the first child of the parent {@link Node} with the given name, or <code>null</code> if such child is not
   * found.
   *
   * @param root The root node.
   * @param childName Name of the child node.
   * @return {@link Node} if a child node was found, <code>null</code> otherwise.
   */
  public static Node getFirstChildByName(Node root, String childName) {
    Node node = null;
    try {
      node = getNodeByXPath(root, "/" + childName);
    } catch (XPathException e) {
      // Did not get any node
    }
    return node;
  }

  /**
   * Returns the first non-text child node of the given node.
   *
   * @param root The {@link Node}, which should be searched.
   * @return {@link Node} if a child node was found, <code>null</code> if it was not.
   */
  public static Node getFirstNonTextChild(Node root) {
    Node resultNode = null;
    NodeList nl = root.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      if (!isTextNode(nl.item(i))) {
        resultNode = nl.item(i);
        break;
      }
    }
    return resultNode;
  }

  /**
   * Evaluates an {@link XPath} expression and returns a <i>single</i> matching node.
   *
   * @param context The context in which to run the expression.
   * @param expression A valid {@link XPath} expression.
   * @return {@link Node}, if one is found, <code>null</code> otherwise.
   * @throws XPathException If the provided expression is invalid or multiple nodes match.
   */
  public static Node getNodeByXPath(Object context, String expression) throws XPathException {
    return (Node) XPathFactory.newInstance().newXPath().evaluate(expression, context, XPathConstants.NODE);
  }

  /**
   * Returns whether given {@link Node} is text {@link Node}.
   *
   * @param node the {@link Node}
   * @return whether given node was text node
   */
  public static boolean isTextNode(Node node) {
    return node != null ? Node.TEXT_NODE == node.getNodeType() : false;
  }

  /**
   * Returns the text content of a given Node.
   *
   * @param node {@link Node} instance
   * @return text content of a node
   */
  public static String getTextContent(Node node) {
    if (node == null) {
      return null;
    }

    NodeList nl = node.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      Node childNode = nl.item(i);

      if (isTextNode(childNode)) {
        return childNode.getNodeValue();
      }
    }

    return null;
  }

  public static SOAPMessage extractSoapMessage(WebServiceMessage webServiceMessage) {
    return ((SaajSoapMessage) webServiceMessage).getSaajMessage();
  }

  /**
   * Adds base MIME headers to a {@link SOAPMessage}.
   *
   * @param message The {@link SOAPMessage} to add the headers to.
   */
  public static void addBaseMimeHeaders(SOAPMessage message) {
    SOAPUtil.addMimeHeader(message, "Content-Type", "multipart/related");
    SOAPUtil.addMimeHeader(message, "SOAPAction", "\"\"");
    SOAPUtil.addMimeHeader(message, "Accept", "application/soap+xml, application/mime, multipart/related, text/*");
    SOAPUtil.addMimeHeader(message, "Cache-Control", "no-cache");
    SOAPUtil.addMimeHeader(message, "Pragma", "no-cache");

    message.getSOAPPart().setMimeHeader("Content-Type", "text/xml; charset=UTF-8");
    message.getSOAPPart().setMimeHeader("Content-Transfer-Encoding", "8bit");
  }

  /**
   * Adds a custom MIME header to a {@link SOAPMessage}.
   *
   * @param message The {@link SOAPMessage} to add the header to.
   * @param name The name of the header.
   * @param value The value (content) of the header.
   */
  public static void addMimeHeader(SOAPMessage message, String name, String value) {
    message.getMimeHeaders().setHeader(name, value);
  }

  /**
   * Adds the base required namespaces (with prefixes <code>xsi</code>, <code>xsd</code>, <code>SOAP-ENC</code>,
   * <code>SOAP-ENV</code>) to a {@link SOAPMessage} .
   *
   * @param message The {@link SOAPMessage} to add the namespaces to.
   * @throws SOAPException
   */
  public static void addBaseNamespaces(SOAPMessage message) throws SOAPException {
    SOAPUtil.addNamespace(message, "xsi", "http://www.w3.org/2001/XMLSchema-instance");
    SOAPUtil.addNamespace(message, "xsd", "http://www.w3.org/2001/XMLSchema");
    SOAPUtil.addNamespace(message, "SOAP-ENC", "http://schemas.xmlsoap.org/soap/encoding/");
    SOAPUtil.addNamespace(message, "SOAP-ENV", "http://schemas.xmlsoap.org/soap/envelope/");
  }

  /**
   * Adds a specified namespace to a {@link SOAPMessage}.
   *
   * @param message The {@link SOAPMessage} to add the namespace to.
   * @param prefix namespace prefix
   * @param uri namespace URI
   * @throws SOAPException
   */
  public static void addNamespace(SOAPMessage message, String prefix, String uri) throws SOAPException {
    message.getSOAPPart().getEnvelope().addNamespaceDeclaration(prefix, uri);
  }

  /**
   * Helper methods for adding an array.
   */
  public static void addArrayAnyTypeAttribute(Element element, Collection<?> col) {
    addArrayAnyTypeAttribute(element, col.size());
  }

  public static void addArrayAnyTypeAttribute(Element element, int size) {
    element.setAttribute("SOAP-ENC:arrayType", getAnyTypeAttribute(size));
  }

  public static void addArrayTypeAttribute(Element element, String type, Collection<?> col) {
    addArrayTypeAttribute(element, type, col.size());
  }

  public static void addArrayTypeAttribute(Element element, String type, int size) {
    element.setAttribute("SOAP-ENC:arrayType", getArrayTypeAttribute(type, size));
  }

  public static void addArrayOffsetAttribute(Element element, int offset) {
    element.setAttribute("SOAP-ENC:offset", new StringBuilder("[").append(offset).append("]").toString());
  }

  public static String getAnyTypeAttribute(int size) {
    return getArrayTypeAttribute("anyType", size);
  }

  public static String getArrayTypeAttribute(String type, int size) {
    return new StringBuilder("xsd:").append(type).append("[").append(size).append("]").toString();
  }

  /**
   * Adds a type attribute to an element as required by the RPC/Encoded binding. Please note, <code>RPC/Encoded</code>
   * has been deprecated a very long time ago. This is only used to provide backwards compatibility to "metateenused".
   * You should never use this in regular services, as <code>RPC/Literal</code> is compatible with
   * <code>RPC/Encoded</code> parsers.
   *
   * @param element The <code>Element</code> to add the type declaration for.
   * @param type Valid xsi type.
   */
  public static void addTypeAttribute(Element element, String type) {
    if (type != null) {
      element.setAttribute("xsi:type", type);
    }
  }

  public static Element addElementInteger(Element element, String id, Long value) throws SOAPException {
    return addElement(element, id, "xsd:integer", String.valueOf(value));
  }

  public static Element addElementTekst(Element element, String id, String value) throws SOAPException {
    return addElement(element, id, "xsd:string", value);
  }

  /**
   * Adds a new element to an existing element
   *
   * @param element The parent {@link Element}, which the child will be added to.
   * @param id Tag name of the new {@link Element}
   * @param type xsi type of the new {@link Element}
   * @param value Text value of the new {@link Element}
   * @return
   * @throws SOAPException
   */
  public static Element addElement(Element element, String id, String type, String value) throws SOAPException {
    Element child = element.getOwnerDocument().createElement(id);

    if (value != null) {
      child.setTextContent(value);
    }

    SOAPUtil.addTypeAttribute(child, type);

    element.appendChild(child);
    return child;
  }

  /**
   * Substitutes all occurences of some given string inside the given {@link WebServiceMessage} with another value.
   *
   * @param message message to substitute in
   * @param from the value to substitute
   * @param to the value to substitute with
   * @throws TransformerException
   */
  public static void substitute(WebServiceMessage message, String from, String to) throws TransformerException {
    SaajSoapMessage saajSoapMessage = (SaajSoapMessage) message;
    SOAPPart soapPart = saajSoapMessage.getSaajMessage().getSOAPPart();

    Source source = new DOMSource(soapPart);
    StringResult stringResult = new StringResult();

    TransformerFactory.newInstance().newTransformer().transform(source, stringResult);

    String content = stringResult.toString().replaceAll(from, to);

    try {
      soapPart.setContent(new StringSource(content));
    } catch (SOAPException e) {
      throw new TransformerException(e);
    }
  }

  /**
   * Returns child elements according to name and namespace
   * 
   * @param root
   * @param name
   * @param ns
   * @return
   */
  public static NodeList getNsElements(Element root, String name, String ns) {
    if (root == null) {
      return null;
    }
    return root.getElementsByTagNameNS(ns, name);
  }

  /**
   * Returns child element according to name and namespace
   * 
   * @param root
   * @param name
   * @param ns
   * @return
   */
  public static Element getNsElement(Element root, String name, String ns) {
    NodeList nl = getNsElements(root, name, ns);
    if (nl == null || nl.getLength() != 1) {
      return null;
    }
    return (Element) nl.item(0);
  }

  /**
   * Returns child element value according to name and namespace
   * 
   * @param root
   * @param name
   * @param ns
   * @return
   */
  public static String getNsElementValue(Element root, String name, String ns) {
    return getTextContent(getNsElement(root, name, ns));
  }
}
