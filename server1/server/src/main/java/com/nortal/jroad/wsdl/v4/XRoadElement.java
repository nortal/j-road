package com.nortal.jroad.wsdl.v4;

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
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class XRoadElement implements ExtensibilityElement {
  public static final QName VERSION_TYPE =
      new QName(XRoadWsdlDefinition.XROAD_NAMESPACE, "version", XRoadWsdlDefinition.XROAD_PREFIX);
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
      pw.append("        <" + XRoadWsdlDefinition.XROAD_PREFIX + ":" + elementType.getLocalPart() + ">");
      pw.append(((XRoadElement) extension).getValue());
      pw.append("</" + XRoadWsdlDefinition.XROAD_PREFIX + ":" + elementType.getLocalPart() + ">\n");
    }
  }

}
