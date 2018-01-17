package com.nortal.jroad.wsdl;

import java.io.PrintWriter;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.ExtensionSerializer;
import javax.xml.namespace.QName;

/**
 * Element implementation for WSDL generator
 * 
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class XTeeElement implements ExtensibilityElement {
  public static final QName VERSION_TYPE =
      new QName(XTeeWsdlDefinition.XROAD_NAMESPACE, "version", XTeeWsdlDefinition.XROAD_PREFIX);
  private QName elementType;
  private Boolean required = null;
  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String version) {
    this.value = version;
  }

  public QName getElementType() {
    return elementType;
  }

  public Boolean getRequired() {
    return required;
  }

  public void setElementType(QName elementType) {
    this.elementType = elementType;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public static class XRoadElementSerializer implements ExtensionSerializer {
    @SuppressWarnings({ "rawtypes" })
    public void marshall(Class parentType,
                         QName elementType,
                         ExtensibilityElement extension,
                         PrintWriter pw,
                         Definition def,
                         ExtensionRegistry extReg) throws WSDLException {
      pw.append("        <" + XTeeWsdlDefinition.XROAD_PREFIX + ":" + elementType.getLocalPart() + ">");
      pw.append(((XTeeElement) extension).getValue());
      pw.append("</" + XTeeWsdlDefinition.XROAD_PREFIX + ":" + elementType.getLocalPart() + ">\n");
    }
  }
}
