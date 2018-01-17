package com.nortal.jroad.wsdl;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.naming.NameNotFoundException;
import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.PortType;
import javax.wsdl.WSDLException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.ws.server.endpoint.MessageEndpoint;
import org.springframework.ws.wsdl.wsdl11.provider.SuffixBasedPortTypesProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.ibm.wsdl.Constants;
import com.nortal.jroad.annotation.XTeeService;
import com.nortal.jroad.mapping.XTeeEndpointMapping;

/**
 * Part of the serverside WSDL generator
 * 
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class XTeePortTypesProvider extends SuffixBasedPortTypesProvider {
  private XTeeEndpointMapping xRoadEndpointMapping;

  @Override
  @SuppressWarnings("unchecked")
  public void addPortTypes(Definition definition) throws WSDLException {
    super.addPortTypes(definition);
    Document doc = null;
    try {
      doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    } catch (ParserConfigurationException e) {
      throw new RuntimeException(e);
    }

    for (Entry<QName, PortType> entry : (Set<Entry<QName, PortType>>) definition.getPortTypes().entrySet()) {
      for (Operation operation : (List<Operation>) entry.getValue().getOperations()) {
        Element docElement = doc.createElementNS(Constants.NS_URI_WSDL, "documentation");
        docElement.setPrefix("wsdl");
        Element titleEelement = doc.createElementNS(XTeeWsdlDefinition.XROAD_NAMESPACE, "title");
        titleEelement.setPrefix(XTeeWsdlDefinition.XROAD_PREFIX);

        try {
          // Get endpoint
          MessageEndpoint endpoint = null;
          for (String method : xRoadEndpointMapping.getMethods()) {
            String methodTail = method.substring(method.indexOf('.') + 1).toLowerCase();
            if (methodTail.startsWith(operation.getName().toLowerCase() + ".")) {
              endpoint = xRoadEndpointMapping.getMethodMap().get(method);
              break;
            }
          }
          if (endpoint == null)
            throw new NameNotFoundException();

          // Get annotation from endpoint and check that it contains a name.
          XTeeService xRoadServiceAnnotation = endpoint.getClass().getAnnotation(XTeeService.class);
          if (xRoadServiceAnnotation == null || xRoadServiceAnnotation.title().equals(""))
            throw new NameNotFoundException();

          titleEelement.appendChild(doc.createTextNode(xRoadServiceAnnotation.title()));
        } catch (NameNotFoundException e) {
          titleEelement.appendChild(doc.createTextNode(operation.getName()));
        }

        docElement.appendChild(titleEelement);
        operation.setDocumentationElement(docElement);
      }
    }

  }

  public void setXRoadEndpointMapping(XTeeEndpointMapping xRoadEndpointMapping) {
    this.xRoadEndpointMapping = xRoadEndpointMapping;
  }
}
