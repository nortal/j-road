package com.nortal.jroad.wsdl.v4;

import com.ibm.wsdl.Constants;
import com.nortal.jroad.annotation.XRoadService;
import com.nortal.jroad.mapping.v4.XRoadEndpointMapping;
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

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class XRoadPortTypesProvider extends SuffixBasedPortTypesProvider {
  private XRoadEndpointMapping xRoadEndpointMapping;

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
        Element titleEelement = doc.createElementNS(XRoadWsdlDefinition.XROAD_NAMESPACE, "title");
        titleEelement.setPrefix(XRoadWsdlDefinition.XROAD_PREFIX);

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
          XRoadService xRoadServiceAnnotation = endpoint.getClass().getAnnotation(XRoadService.class);
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

  public void setXRoadEndpointMapping(XRoadEndpointMapping xRoadEndpointMapping) {
    this.xRoadEndpointMapping = xRoadEndpointMapping;
  }
}
