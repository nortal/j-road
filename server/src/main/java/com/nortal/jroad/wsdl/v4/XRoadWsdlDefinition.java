package com.nortal.jroad.wsdl.v4;

import com.nortal.jroad.mapping.v4.XRoadEndpointMapping;
import com.nortal.jroad.model.v4.XRoadHeader;

import java.util.List;
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

import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * * Generates WSDL for XRoad services from a schema, much like Spring's WSDL generator it delegates to
 * <code>InliningXsdSchemaTypesProvider</code>, <code>DefaultMessagesProvider</code>,
 * <code>SuffixBasedPortTypesProvider</code>, <code>ProviderBasedWsdl4jDefinition</code> and {@link XRoadSoapProvider}
 * underneath.
 * 
 * @author Dmitri Danilkin
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class XRoadWsdlDefinition implements Wsdl11Definition, InitializingBean {

  private final InliningXsdSchemaTypesProvider typesProvider = new InliningXsdSchemaTypesProvider();
  private final SuffixBasedMessagesProvider messagesProvider = new XRoadMessagesProvider();
  private final XRoadPortTypesProvider portTypesProvider = new XRoadPortTypesProvider();
  private final XRoadSoapProvider soapProvider = new XRoadSoapProvider();
  private final ProviderBasedWsdl4jDefinition delegate = new ProviderBasedWsdl4jDefinition();
  private String serviceName;
  private List<String> inputsWithRepresentedParty;
  private List<String> outputsWithRepresentedParty;
  private List<String> inputsWithIssue;
  private List<String> outputsWithIssue;

  @Resource(name = "database")
  private String database;
  @Resource
  private XRoadEndpointMapping xRoadEndpointMapping;

  public static final String XROAD_HEADER = "requestheader";
  public static final String XROAD_NAMESPACE = "http://x-road.eu/xsd/xroad.xsd";
  public static final String XROAD_PREFIX = "xrd";
  public static final String XROAD_REPRESENTED_PARTY_NAMESPACE = "http://x-road.eu/xsd/representation.xsd";
  public static final String XROAD_REPRESENTED_PARTY_PREFIX = "repr";
  public static final QName REPRESENTED_PARTY = new QName(XROAD_REPRESENTED_PARTY_NAMESPACE, "representedParty");
  public static final QName ISSUE = new QName(XROAD_NAMESPACE, "issue");

  public XRoadWsdlDefinition() {
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
    messagesProvider.setFaultSuffix(faultSuffix);
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
    soapProvider.setLocationUri("http://SECURITY_SERVER/cgi-bin/consumer_proxy");
    soapProvider.setXRoadDatabase(database);
    soapProvider.setXRoadEndpointMapping(xRoadEndpointMapping);
    soapProvider.setInputsWithRepresentedParty(inputsWithRepresentedParty);
    soapProvider.setOutputsWithRepresentedParty(outputsWithRepresentedParty);
    soapProvider.setInputsWithIssue(inputsWithIssue);
    soapProvider.setOutputsWithIssue(outputsWithIssue);
    portTypesProvider.setXRoadEndpointMapping(xRoadEndpointMapping);

    setRequestSuffix("Request");
    setResponseSuffix("Response");
    delegate.setTargetNamespace("http://" + database + ".x-road.eu");

    if (!StringUtils.hasText(delegate.getTargetNamespace()) && typesProvider.getSchemaCollection() != null
        && typesProvider.getSchemaCollection().getXsdSchemas().length > 0) {
      XsdSchema schema = typesProvider.getSchemaCollection().getXsdSchemas()[0];
      delegate.setTargetNamespace(schema.getTargetNamespace());
    }
    if (!StringUtils.hasText(serviceName) && StringUtils.hasText(portTypesProvider.getPortTypeName())) {
      soapProvider.setServiceName(portTypesProvider.getPortTypeName() + "Service");
    }
    delegate.afterPropertiesSet();
    addXRoadExtensions(delegate.getDefinition());
  }

  public Source getSource() {
    return delegate.getSource();
  }

  public Definition getDefinition() {
    return delegate.getDefinition();
  }

  private void addXRoadExtensions(Definition definition) throws WSDLException {
    definition.addNamespace(XROAD_PREFIX, XROAD_NAMESPACE);

    Message message = definition.createMessage();
    message.setQName(new QName(definition.getTargetNamespace(), XROAD_HEADER));

    addXroadHeaderPart(definition, message, XRoadHeader.CLIENT);
    addXroadHeaderPart(definition, message, XRoadHeader.SERVICE);
    addXroadHeaderPart(definition, message, XRoadHeader.ID);
    addXroadHeaderPart(definition, message, XRoadHeader.USER_ID);
    addXroadHeaderPart(definition, message, XRoadHeader.PROTOCOL_VERSION);

    if (!isEmpty(inputsWithIssue) || !isEmpty(outputsWithIssue)) {
      addXroadHeaderPart(definition, message, ISSUE);
    }

    if (!isEmpty(inputsWithRepresentedParty) || !isEmpty(outputsWithRepresentedParty)) {
      definition.addNamespace(XROAD_REPRESENTED_PARTY_PREFIX, XROAD_REPRESENTED_PARTY_NAMESPACE);
      addXroadHeaderPart(definition, message, REPRESENTED_PARTY);
    }

    message.setUndefined(false);
    definition.addMessage(message);

    // Add XRoad schema import to the first schema
    for (Object ex : definition.getTypes().getExtensibilityElements()) {
      if (ex instanceof Schema) {
        Schema schema = (Schema) ex;
        Element xRoadImport =
            schema.getElement().getOwnerDocument().createElement(schema.getElement().getPrefix() == null
                                                                                                        ? "import"
                                                                                                        : schema.getElement().getPrefix()
                                                                                                            + ":import");
        xRoadImport.setAttribute("namespace", XROAD_NAMESPACE);
        xRoadImport.setAttribute("schemaLocation", XROAD_NAMESPACE);
        schema.getElement().insertBefore(xRoadImport, schema.getElement().getFirstChild());
        break;
      }
    }
  }

  private void addXroadHeaderPart(Definition definition, Message message, QName partName) {
    Part part = definition.createPart();
    part.setElementName(partName);
    part.setName(partName.getLocalPart());
    message.addPart(part);
  }

  public void setInputsWithRepresentedParty(List<String> inputsWithRepresentedParty) {
    this.inputsWithRepresentedParty = inputsWithRepresentedParty;
  }

  public void setOutputsWithRepresentedParty(List<String> outputsWithRepresentedParty) {
    this.outputsWithRepresentedParty = outputsWithRepresentedParty;
  }

  public void setInputsWithIssue(List<String> inputsWithIssue) {
    this.inputsWithIssue = inputsWithIssue;
  }

  public void setOutputsWithIssue(List<String> outputsWithIssue) {
    this.outputsWithIssue = outputsWithIssue;
  }
}
