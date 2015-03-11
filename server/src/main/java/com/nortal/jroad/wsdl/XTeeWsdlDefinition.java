/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.wsdl;

import java.util.Properties;

import javax.annotation.Resource;
import javax.wsdl.Definition;
import javax.wsdl.Message;
import javax.wsdl.Part;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.schema.Schema;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;
import org.springframework.ws.wsdl.wsdl11.ProviderBasedWsdl4jDefinition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.provider.InliningXsdSchemaTypesProvider;
import org.springframework.ws.wsdl.wsdl11.provider.SuffixBasedMessagesProvider;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.w3c.dom.Element;

import com.nortal.jroad.mapping.XTeeEndpointMapping;
import com.nortal.jroad.model.XTeeHeader;
import com.nortal.jroad.util.XTeeUtil;

/**
 * Generates WSDL for X-Tee services from a schema, much like Spring's WSDL generator it delegates to
 * <code>InliningXsdSchemaTypesProvider</code>, <code>DefaultMessagesProvider</code>,
 * <code>SuffixBasedPortTypesProvider</code>, <code>ProviderBasedWsdl4jDefinition</code> and {@link XTeeSoapProvider}
 * underneath.
 * 
 * @author Dmitri Danilkin
 */
public class XTeeWsdlDefinition implements Wsdl11Definition, InitializingBean {

  private final InliningXsdSchemaTypesProvider typesProvider = new InliningXsdSchemaTypesProvider();
  private final SuffixBasedMessagesProvider messagesProvider = new XTeeMessagesProvider();
  private final XTeePortTypesProvider portTypesProvider = new XTeePortTypesProvider();
  private final XTeeSoapProvider soapProvider = new XTeeSoapProvider();
  private final ProviderBasedWsdl4jDefinition delegate = new ProviderBasedWsdl4jDefinition();
  private String serviceName;

  @Resource(name = "xteeDatabase")
  private String xteeDatabase;
  @Resource
  private XTeeEndpointMapping xTeeEndpointMapping;

  public static final String XTEE_PAIS = "xteeStandardPais";
  public static final String XTEE_PAIS_PART = "xteePais";
  public static final String XTEE_NAMESPACE = "http://x-tee.riik.ee/xsd/xtee.xsd";
  public static final String XTEE_PREFIX = "xtee";

  public XTeeWsdlDefinition() {
    delegate.setTypesProvider(typesProvider);
    delegate.setMessagesProvider(messagesProvider);
    delegate.setPortTypesProvider(portTypesProvider);
    delegate.setBindingsProvider(soapProvider);
    delegate.setServicesProvider(soapProvider);
  }

  /**
   * Sets the single XSD schema to inline. Either this property, or {@link #setSchemaCollection(XsdSchemaCollection)
   * schemaCollection} must be set.
   */
  public void setSchema(final XsdSchema schema) {
    typesProvider.setSchema(schema);
  }

  /**
   * Sets the XSD schema collection to inline. Either this property, or {@link #setSchema(XsdSchema) schema} must be
   * set.
   */
  public void setSchemaCollection(XsdSchemaCollection schemaCollection) {
    typesProvider.setSchemaCollection(schemaCollection);
  }

  /** Sets the port type name used for this definition. Required. */
  public void setPortTypeName(String portTypeName) {
    portTypesProvider.setPortTypeName(portTypeName);
  }

  /** Sets the suffix used to detect request elements in the schema. */
  private void setRequestSuffix(String requestSuffix) {
    portTypesProvider.setRequestSuffix(requestSuffix);
    messagesProvider.setRequestSuffix(requestSuffix);
  }

  /** Sets the suffix used to detect response elements in the schema. */
  private void setResponseSuffix(String responseSuffix) {
    portTypesProvider.setResponseSuffix(responseSuffix);
    messagesProvider.setResponseSuffix(responseSuffix);
  }

  /** Sets the suffix used to detect fault elements in the schema. */
  public void setFaultSuffix(String faultSuffix) {
    portTypesProvider.setFaultSuffix(faultSuffix);
    messagesProvider.setResponseSuffix(faultSuffix);
  }

  public void setUse(String use) {
    soapProvider.setUse(use);
  }

  /**
   * Sets the SOAP Actions for this binding. Keys are {@link javax.wsdl.BindingOperation#getName() binding operation
   * names}; values are {@link javax.wsdl.extensions.soap.SOAPOperation#getSoapActionURI() SOAP Action URIs}.
   * 
   * @param soapActions the soap
   */
  public void setSoapActions(Properties soapActions) {
    soapProvider.setSoapActions(soapActions);
  }

  /** Sets the service name. */
  public void setServiceName(String serviceName) {
    soapProvider.setServiceName(serviceName);
    this.serviceName = serviceName;
  }

  public void afterPropertiesSet() throws Exception {
    soapProvider.setLocationUri("http://TURVASERVER/cgi-bin/consumer_proxy");
    soapProvider.setXteeDatabase(xteeDatabase);
    soapProvider.setxTeeEndpointMapping(xTeeEndpointMapping);
    portTypesProvider.setxTeeEndpointMapping(xTeeEndpointMapping);

    setRequestSuffix("Request");
    setResponseSuffix("Response");
    delegate.setTargetNamespace(XTeeUtil.getDatabaseNamespace(xteeDatabase));

    if (!StringUtils.hasText(delegate.getTargetNamespace()) && typesProvider.getSchemaCollection() != null
        && typesProvider.getSchemaCollection().getXsdSchemas().length > 0) {
      XsdSchema schema = typesProvider.getSchemaCollection().getXsdSchemas()[0];
      delegate.setTargetNamespace(schema.getTargetNamespace());
    }
    if (!StringUtils.hasText(serviceName) && StringUtils.hasText(portTypesProvider.getPortTypeName())) {
      soapProvider.setServiceName(portTypesProvider.getPortTypeName() + "Service");
    }
    delegate.afterPropertiesSet();
    addXteeExtensions(delegate.getDefinition());
  }

  public Source getSource() {
    return delegate.getSource();
  }

  public Definition getDefinition() {
    return delegate.getDefinition();
  }

  private void addXteeExtensions(Definition definition) throws WSDLException {
    // Lisa x-tee nimeruum
    definition.addNamespace(XTEE_PREFIX, XTEE_NAMESPACE);

    // Lisa x-tee pais
    Message message = definition.createMessage();
    message.setQName(new QName(definition.getTargetNamespace(), XTEE_PAIS));

    addXteeHeaderPart(definition, message, XTeeHeader.ASUTUS);
    addXteeHeaderPart(definition, message, XTeeHeader.ANDMEKOGU);
    addXteeHeaderPart(definition, message, XTeeHeader.ISIKUKOOD);
    addXteeHeaderPart(definition, message, XTeeHeader.ID);
    addXteeHeaderPart(definition, message, XTeeHeader.NIMI);
    addXteeHeaderPart(definition, message, XTeeHeader.AMETNIK);

    message.setUndefined(false);
    definition.addMessage(message);

    // Lisa esimesele schemale x-tee schema import
    for (Object ex : definition.getTypes().getExtensibilityElements()) {
      if (ex instanceof Schema) {
        Schema schema = (Schema) ex;
        Element xteeImport =
            schema.getElement().getOwnerDocument().createElement(schema.getElement().getPrefix() == null
                                                                                                        ? "import"
                                                                                                        : schema.getElement().getPrefix()
                                                                                                            + ":import");
        xteeImport.setAttribute("namespace", XTEE_NAMESPACE);
        xteeImport.setAttribute("schemaLocation", XTEE_NAMESPACE);
        schema.getElement().insertBefore(xteeImport, schema.getElement().getFirstChild());
        break;
      }
    }
  }

  private void addXteeHeaderPart(Definition definition, Message message, QName partName) {
    Part part = definition.createPart();
    part.setElementName(partName);
    part.setName(partName.getLocalPart());
    message.addPart(part);
  }
}
