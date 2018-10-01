package com.nortal.jroad.util.header;

import com.nortal.jroad.util.SOAPUtil;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import java.util.Iterator;

public class XRoadHeaderUtil {
  private XRoadHeaderUtil() {
  }

  public static XRoadHeader parseXRoadHeader(SOAPMessage paringMessage) throws SOAPException {
    XRoadHeader xroadHeader = new XRoadHeader();

    SOAPHeader header = paringMessage.getSOAPHeader();
    for (Iterator<Node> headerElemendid = header.getChildElements(); headerElemendid.hasNext(); ) {
      Node headerElement = headerElemendid.next();
      if (!SOAPUtil.isTextNode(headerElement) && headerElement.getFirstChild() != null) {
        XRoadHeaderElement el = parseHeaderElement(headerElement, header);
        if (el != null) {
          xroadHeader.addHeaderElement(el);
        }
      }
    }
    return xroadHeader;
  }

  private static void parseChildElements(XRoadHeaderElement headerElement, NodeList nodeList, Node node) {
    for (int i = 0; i < nodeList.getLength(); i++) {
      XRoadHeaderElement childEl = parseHeaderElement(nodeList.item(i), node);
      if (childEl != null) {
        if (childEl.getQName().equals(headerElement.getQName()) && childEl.getValue() != null) {
          headerElement.setValue(childEl.getValue());
        } else {
          headerElement.addChild(childEl);
        }
      }
    }
  }

  private static XRoadHeaderElement parseHeaderElement(Node node, Node parent) {
    if (node == null) {
      return null;
    }
    if (node.getNodeType() == Node.ELEMENT_NODE) {
      NodeList nodeList = node.getChildNodes();
      XRoadHeaderElement headerElement = new XRoadHeaderElement();
      headerElement.setQName(new QName(node.getNamespaceURI(), node.getLocalName()));
      parseChildElements(headerElement, nodeList, node);
      return headerElement;
    }

    if (SOAPUtil.isTextNode(node) && node.getNodeValue() != null && node.getNodeValue().trim().length() > 0) {
      XRoadHeaderElement headerElement = new XRoadHeaderElement();
      headerElement.setQName(new QName(parent.getNamespaceURI(), parent.getLocalName()));
      headerElement.setValue(node.getNodeValue().trim());
      return headerElement;
    }
    return null;
  }
}
