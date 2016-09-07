package com.nortal.jroad.wsdl.v4;

import com.nortal.jroad.mapping.v4.XRoadEndpointMapping;
import com.nortal.jroad.model.v4.XRoadHeader;
import org.springframework.ws.wsdl.wsdl11.provider.Soap11Provider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.wsdl.*;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.UnknownExtensibilityElement;
import javax.wsdl.extensions.soap.SOAPBinding;
import javax.wsdl.extensions.soap.SOAPBody;
import javax.wsdl.extensions.soap.SOAPHeader;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Creates XRoad specific SOAP headers and bindings (<code>RPC/Literal</code> is used). Used by
 * {@link XRoadWsdlDefinition}.
 * 
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class XRoadSoapProvider extends Soap11Provider {
  private static final String ENCODED = "encoded";
  private static final String LITERAL = "literal";
  private static final String ENCODING = "http://schemas.xmlsoap.org/soap/encoding/";

  private String xRoadDatabase;
  private String use = LITERAL;

  private XRoadEndpointMapping xRoadEndpointMapping;

  private List<SOAPHeader> makeHeaders(Definition definition) throws WSDLException {
    List<SOAPHeader> list = new ArrayList<SOAPHeader>();
    String[] parts =
        new String[] { XRoadHeader.CLIENT.getLocalPart(), XRoadHeader.SERVICE.getLocalPart(),
                       XRoadHeader.USER_ID.getLocalPart(), XRoadHeader.ID.getLocalPart(), XRoadHeader.PROTOCOL_VERSION.getLocalPart() };
    ExtensionRegistry extReg = definition.getExtensionRegistry();
    for (int i = 0; i < parts.length; i++) {
      SOAPHeader header =
          (SOAPHeader) extReg.createExtension(BindingInput.class, new QName(SOAP_11_NAMESPACE_URI, "header"));
      header.setMessage(new QName(definition.getTargetNamespace(), XRoadWsdlDefinition.XROAD_HEADER));
      header.setPart(parts[i]);
      if (use.equalsIgnoreCase(LITERAL)) {
        header.setUse(LITERAL);
      } else {
        header.setUse(ENCODED);
        header.setEncodingStyles(Arrays.asList(ENCODING));
      }
      header.setNamespaceURI(XRoadWsdlDefinition.XROAD_NAMESPACE);
      list.add(header);
    }

    return list;
  }

  @Override
  protected void populateBindingInput(Definition definition, BindingInput bindingInput, Input input)
      throws WSDLException {
    for (SOAPHeader header : makeHeaders(definition)) {
      bindingInput.addExtensibilityElement(header);
    }
    super.populateBindingInput(definition, bindingInput, input);
    for (Iterator<?> i = bindingInput.getExtensibilityElements().iterator(); i.hasNext();) {
      ExtensibilityElement element = (ExtensibilityElement) i.next();
      if (element instanceof SOAPBody) {
        ((SOAPBody) element).setNamespaceURI(definition.getTargetNamespace());
      }
    }
  }

  @Override
  protected void populateBindingOutput(Definition definition, BindingOutput bindingOutput, Output output)
      throws WSDLException {
    for (SOAPHeader header : makeHeaders(definition)) {
      bindingOutput.addExtensibilityElement(header);
    }
    super.populateBindingOutput(definition, bindingOutput, output);
    for (Iterator<?> i = bindingOutput.getExtensibilityElements().iterator(); i.hasNext();) {
      ExtensibilityElement element = (ExtensibilityElement) i.next();
      if (element instanceof SOAPBody) {
        ((SOAPBody) element).setNamespaceURI(definition.getTargetNamespace());
      }
    }
  }

  @Override
  protected void populateBindingOperation(Definition definition, BindingOperation bindingOperation)
      throws WSDLException {
    super.populateBindingOperation(definition, bindingOperation);
    XRoadElement element =
        (XRoadElement) definition.getExtensionRegistry().createExtension(BindingOperation.class,
                                                                         XRoadElement.VERSION_TYPE);
    String version = "v1";
    String name = bindingOperation.getName().toLowerCase();
    for (String method : xRoadEndpointMapping.getMethods()) {
      method = method.substring(method.indexOf('.') + 1).toLowerCase();
      if (method.startsWith(name + ".")) {
        version = method.substring(method.indexOf('.') + 1);
        break;
      }
    }
    element.setValue(version);
    bindingOperation.addExtensibilityElement(element);
  }

  @Override
  protected void populateBinding(Definition definition, Binding binding) throws WSDLException {
    definition.getExtensionRegistry().mapExtensionTypes(BindingOperation.class,
                                                        XRoadElement.VERSION_TYPE,
                                                        XRoadElement.class);
    definition.getExtensionRegistry().registerSerializer(BindingOperation.class,
                                                         XRoadElement.VERSION_TYPE,
                                                         new XRoadElement.XRoadElementSerializer());
    super.populateBinding(definition, binding);
  }

  @Override
  protected void populateSoapBinding(SOAPBinding soapBinding, Binding binding) throws WSDLException {
    soapBinding.setStyle("document");
    soapBinding.setTransportURI(getTransportUri());
  }

  @Override
  protected void populatePort(Definition definition, Port port) throws WSDLException {
    super.populatePort(definition, port);
    ExtensionRegistry extensionRegistry = definition.getExtensionRegistry();
    extensionRegistry.mapExtensionTypes(Port.class,
                                        new QName(XRoadWsdlDefinition.XROAD_NAMESPACE,
                                                  "address",
                                                  XRoadWsdlDefinition.XROAD_PREFIX),
                                        UnknownExtensibilityElement.class);
    UnknownExtensibilityElement element =
        (UnknownExtensibilityElement) extensionRegistry.createExtension(Port.class,
                                                                        new QName(XRoadWsdlDefinition.XROAD_NAMESPACE,
                                                                                  "address",
                                                                                  XRoadWsdlDefinition.XROAD_NAMESPACE));
    Document doc;
    try {
      doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    } catch (ParserConfigurationException e) {
      throw new RuntimeException(e);
    }
    Element xRoadAddr = doc.createElementNS(XRoadWsdlDefinition.XROAD_NAMESPACE, "address");
    xRoadAddr.setPrefix(XRoadWsdlDefinition.XROAD_PREFIX);
    xRoadAddr.setAttribute("producer", xRoadDatabase);
    element.setElement(xRoadAddr);
    port.addExtensibilityElement(element);
  }

  public void setXRoadDatabase(String xRoadDatabase) {
    this.xRoadDatabase = xRoadDatabase;
  }

  public void setXRoadEndpointMapping(XRoadEndpointMapping xRoadEndpointMapping) {
    this.xRoadEndpointMapping = xRoadEndpointMapping;
  }

  public void setUse(String use) {
    this.use = use;
  }

  @Override
  protected void populateSoapBody(SOAPBody soapBody) throws WSDLException {
    if (use.equalsIgnoreCase(LITERAL)) {
      soapBody.setUse(LITERAL);
    } else {
      soapBody.setUse(ENCODED);
      List<String> encStyles = new ArrayList<String>(1);
      encStyles.add(ENCODING);
      soapBody.setEncodingStyles(encStyles);
    }
  }

}
