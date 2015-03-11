/**
 * Copyright 2009 Webmedia Group Ltd. Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.wsdl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.wsdl.Binding;
import javax.wsdl.BindingInput;
import javax.wsdl.BindingOperation;
import javax.wsdl.BindingOutput;
import javax.wsdl.Definition;
import javax.wsdl.Input;
import javax.wsdl.Output;
import javax.wsdl.Port;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.ExtensionRegistry;
import javax.wsdl.extensions.UnknownExtensibilityElement;
import javax.wsdl.extensions.soap.SOAPBinding;
import javax.wsdl.extensions.soap.SOAPBody;
import javax.wsdl.extensions.soap.SOAPHeader;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.ws.wsdl.wsdl11.provider.Soap11Provider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nortal.jroad.mapping.XTeeEndpointMapping;
import com.nortal.jroad.model.XTeeHeader;

/**
 * Creates X-Tee specific SOAP headers and bindings (<code>RPC/Literal</code> is used). Used by
 * {@link XTeeWsdlDefinition}.
 */
public class XTeeSoapProvider extends Soap11Provider {
  private static final String ENCODED = "encoded";
  private static final String LITERAL = "literal";
  private static final String ENCODING = "http://schemas.xmlsoap.org/soap/encoding/";

  private String xteeDatabase;
  private String use = LITERAL;

  private XTeeEndpointMapping xTeeEndpointMapping;

  private List<SOAPHeader> makeHeaders(Definition definition) throws WSDLException {
    List<SOAPHeader> list = new ArrayList<SOAPHeader>();
    String[] parts =
        new String[] { XTeeHeader.ASUTUS.getLocalPart(), XTeeHeader.ANDMEKOGU.getLocalPart(),
                      XTeeHeader.ISIKUKOOD.getLocalPart(), XTeeHeader.ID.getLocalPart(), XTeeHeader.NIMI.getLocalPart() };
    ExtensionRegistry extReg = definition.getExtensionRegistry();
    for (int i = 0; i < parts.length; i++) {
      SOAPHeader header =
          (SOAPHeader) extReg.createExtension(BindingInput.class, new QName(SOAP_11_NAMESPACE_URI, "header"));
      header.setMessage(new QName(definition.getTargetNamespace(), XTeeWsdlDefinition.XTEE_PAIS));
      header.setPart(parts[i]);
      if (use.equalsIgnoreCase(LITERAL)) {
        header.setUse(LITERAL);
      } else {
        header.setUse(ENCODED);
        header.setEncodingStyles(Arrays.asList(ENCODING));
      }
      header.setNamespaceURI(XTeeWsdlDefinition.XTEE_NAMESPACE);
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
    XTeeElement element =
        (XTeeElement) definition.getExtensionRegistry().createExtension(BindingOperation.class,
                                                                        XTeeElement.VERSION_TYPE);
    String version = "v1";
    String name = bindingOperation.getName().toLowerCase();
    for (String method : xTeeEndpointMapping.getMethods()) {
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
                                                        XTeeElement.VERSION_TYPE,
                                                        XTeeElement.class);
    definition.getExtensionRegistry().registerSerializer(BindingOperation.class,
                                                         XTeeElement.VERSION_TYPE,
                                                         new XTeeElement.XteeElementSerializer());
    super.populateBinding(definition, binding);
  }

  @Override
  protected void populateSoapBinding(SOAPBinding soapBinding, Binding binding) throws WSDLException {
    soapBinding.setStyle("rpc");
    soapBinding.setTransportURI(getTransportUri());
  }

  @Override
  protected void populatePort(Definition definition, Port port) throws WSDLException {
    super.populatePort(definition, port);
    ExtensionRegistry extensionRegistry = definition.getExtensionRegistry();
    extensionRegistry.mapExtensionTypes(Port.class,
                                        new QName(XTeeWsdlDefinition.XTEE_NAMESPACE,
                                                  "address",
                                                  XTeeWsdlDefinition.XTEE_PREFIX),
                                        UnknownExtensibilityElement.class);
    UnknownExtensibilityElement element =
        (UnknownExtensibilityElement) extensionRegistry.createExtension(Port.class,
                                                                        new QName(XTeeWsdlDefinition.XTEE_NAMESPACE,
                                                                                  "address",
                                                                                  XTeeWsdlDefinition.XTEE_PREFIX));
    Document doc;
    try {
      doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    } catch (ParserConfigurationException e) {
      throw new RuntimeException(e);
    }
    Element xteeaddr = doc.createElementNS(XTeeWsdlDefinition.XTEE_NAMESPACE, "address");
    xteeaddr.setPrefix(XTeeWsdlDefinition.XTEE_PREFIX);
    xteeaddr.setAttribute("producer", xteeDatabase);
    element.setElement(xteeaddr);
    port.addExtensibilityElement(element);
  }

  public void setXteeDatabase(String xteeDatabase) {
    this.xteeDatabase = xteeDatabase;
  }

  public void setxTeeEndpointMapping(XTeeEndpointMapping xTeeEndpointMapping) {
    this.xTeeEndpointMapping = xTeeEndpointMapping;
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
