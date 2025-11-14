package com.nortal.jroad.wsdl;

import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

import javax.wsdl.Definition;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.PortType;
import javax.wsdl.WSDLException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.nortal.jroad.annotation.XTeeService;
import com.nortal.jroad.endpoint.AbstractXTeeBaseEndpoint;
import org.springframework.ws.wsdl.wsdl11.provider.SuffixBasedPortTypesProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.wsdl.Constants;
import com.nortal.jroad.mapping.XTeeEndpointMapping;

import static java.util.function.Predicate.not;

/**
 * Part of the serverside WSDL generator
 */
public class XTeePortTypesProvider extends SuffixBasedPortTypesProvider {
  private static final Pattern DOT = Pattern.compile("\\.");

  private XTeeEndpointMapping xRoadEndpointMapping;

  public void setXRoadEndpointMapping(XTeeEndpointMapping xRoadEndpointMapping) {
    this.xRoadEndpointMapping = xRoadEndpointMapping;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void addPortTypes(Definition definition) throws WSDLException {
    super.addPortTypes(definition);
    Document doc = createDocument();
    for (Entry<QName, PortType> entry : (Set<Entry<QName, PortType>>) definition.getPortTypes().entrySet()) {
      for (Operation operation : (List<Operation>) entry.getValue().getOperations()) {
        Element docElement = doc.createElementNS(Constants.NS_URI_WSDL, "documentation");
        docElement.setPrefix("wsdl");

        Element titleEelement = doc.createElementNS(XTeeWsdlDefinition.XROAD_NAMESPACE, "title");
        titleEelement.setPrefix(XTeeWsdlDefinition.XROAD_PREFIX);
        String title = getTitle(operation);
        titleEelement.appendChild(doc.createTextNode(title));

        docElement.appendChild(titleEelement);

        operation.setDocumentationElement(docElement);
      }
    }

  }

  private String getTitle(Operation operation) {
    return getMatchingEndpoint(operation)
               .map(Object::getClass)
               .map(clazz -> clazz.getAnnotation(XTeeService.class))
               .map(XTeeService::title)
               .filter(not(String::isEmpty))
               .orElse(operation.getName());
  }

  private Optional<AbstractXTeeBaseEndpoint> getMatchingEndpoint(Operation operation) {
    String operationServiceCode = operation.getName().toLowerCase() + ".";
    return xRoadEndpointMapping.getMethodMap()
               .entrySet()
               .stream()
               .filter(methodEndpoint -> operationServiceCode.equals(normalizedServiceCode(methodEndpoint.getKey())))
               .map(Entry::getValue)
               .findAny();
  }

  private static String normalizedServiceCode(String methodKey) {
    String[] tokens = DOT.split(methodKey);
    if (tokens.length == 3) {
      return tokens[1].toLowerCase();
    }
    throw new IllegalStateException("Malformed method key in endpointMapping: " + methodKey);
  }

  private static Document createDocument() {
    try {
      return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    } catch (ParserConfigurationException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected String getOperationName(Message message) {
    String messageName = this.getMessageName(message);
    if (messageName == null) {
      return null;
    }

    if (messageName.endsWith(this.getRequestSuffix())) {
      return messageName.substring(0, messageName.length() - this.getRequestSuffix().length());
    }

    if (messageName.endsWith(this.getFaultSuffix())) {
      return messageName.substring(0, messageName.length() - this.getFaultSuffix().length());
    }

    if (messageName.endsWith(this.getResponseSuffix())) {
      return messageName.substring(0, messageName.length() - this.getResponseSuffix().length());
    }

    return messageName;
  }

  @Override
  protected boolean isInputMessage(Message message) {
    String messageName = this.getMessageName(message);
    return messageName != null
           && !messageName.endsWith(this.getFaultSuffix())
           && !messageName.endsWith(this.getResponseSuffix());
  }

  // from org.springframework.ws.wsdl.wsdl11.provider.SuffixBasedPortTypesProvider.getMessageName()
  private String getMessageName(Message message) {
    return message.getQName().getLocalPart();
  }
}
