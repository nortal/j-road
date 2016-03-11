package com.nortal.jroad.wsdl.v4;

import java.util.HashMap;
import java.util.Map;
import javax.wsdl.Definition;
import javax.wsdl.Part;
import javax.wsdl.WSDLException;
import javax.xml.namespace.QName;
import org.springframework.ws.wsdl.wsdl11.provider.SuffixBasedMessagesProvider;
import org.w3c.dom.Element;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class XRoadMessagesProvider extends SuffixBasedMessagesProvider {
  private final Map<String, QName> elementTypeMap = new HashMap<String, QName>();
  private int nscounter = 1;

  @Override
  protected void populatePart(Definition definition, Part part, QName elementName) throws WSDLException {
    QName typeName = elementTypeMap.get(elementName.getLocalPart());
    part.setTypeName(typeName);
    part.setName(elementName.getLocalPart());
    if (definition.getPrefix(typeName.getNamespaceURI()) == null) {
      definition.addNamespace("xns" + nscounter++, typeName.getNamespaceURI());
    }
  }

  @Override
  protected boolean isMessageElement(Element element) {
    boolean result = super.isMessageElement(element);
    if (result) {
      String[] prefixAndType = element.getAttribute("type").split(":");
      String ns;
      String name;
      if (prefixAndType.length > 1) {
        ns = element.lookupNamespaceURI(prefixAndType[0]);
        name = prefixAndType[1];
      } else {
        ns = element.lookupNamespaceURI(null);
        name = prefixAndType[0];
      }
      elementTypeMap.put(element.getAttribute("name"), ns == null ? new QName(name) : new QName(ns, name));
    }
    return result;
  }
}
