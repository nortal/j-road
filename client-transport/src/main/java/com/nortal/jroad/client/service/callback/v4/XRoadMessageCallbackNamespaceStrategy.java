package com.nortal.jroad.client.service.callback.v4;

import com.nortal.jroad.client.enums.XroadObjectType;
import com.nortal.jroad.client.service.callback.MessageCallbackNamespaceStrategy;
import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.v4.XRoadServiceConfiguration;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPHeader;
import org.apache.commons.lang.StringUtils;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class XRoadMessageCallbackNamespaceStrategy extends MessageCallbackNamespaceStrategy {

  @Override
  public void addNamespaces(SOAPEnvelope env) throws SOAPException {
    env.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
    env.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
    env.addNamespaceDeclaration("xrd", "http://x-road.eu/xsd/xroad.xsd");
    env.addNamespaceDeclaration("id", "http://x-road.eu/xsd/identifiers");
  }

  @Override
  public void addXTeeHeaderElements(SOAPEnvelope env, BaseXRoadServiceConfiguration serviceConfiguration)
      throws SOAPException {
    XRoadServiceConfiguration v4ServiceConfiguration = (XRoadServiceConfiguration) serviceConfiguration;
    SOAPHeader header = env.getHeader();
    addClientElements(env, v4ServiceConfiguration, header);
    addServiceElements(env, v4ServiceConfiguration, header);

    SOAPElement userId = header.addChildElement("userId", "xrd");
    userId.addTextNode(v4ServiceConfiguration.getIdCode());
    SOAPElement id = header.addChildElement("id", "xrd");
    id.addTextNode(generateUniqueMessageId(v4ServiceConfiguration));
    if (StringUtils.isNotEmpty(v4ServiceConfiguration.getFile())) {
      SOAPElement issue = header.addChildElement("issue", "xrd");
      issue.addTextNode(v4ServiceConfiguration.getFile());
    }

    SOAPElement protocolVersion = header.addChildElement("protocolVersion", "xrd");
    protocolVersion.addTextNode("4.0");
  }

  private void addClientElements(SOAPEnvelope env, XRoadServiceConfiguration serviceConfiguration, SOAPHeader header)
      throws SOAPException {
    SOAPElement client = header.addChildElement("client", "xrd");
    client.addAttribute(env.createName("id:objectType"), serviceConfiguration.getClientObjectType());
    SOAPElement clientXRoadInstance = client.addChildElement("xRoadInstance", "id");
    clientXRoadInstance.addTextNode(serviceConfiguration.getClientXRoadInstance());
    SOAPElement clientMemberClass = client.addChildElement("memberClass", "id");
    clientMemberClass.addTextNode(serviceConfiguration.getClientMemberClass());
    SOAPElement clientMemberCode = client.addChildElement("memberCode", "id");
    clientMemberCode.addTextNode(serviceConfiguration.getClientMemberCode());
    if (StringUtils.isNotEmpty(serviceConfiguration.getClientSubsystemCode())) {
      SOAPElement clientSubsystemCode = client.addChildElement("subsystemCode", "id");
      clientSubsystemCode.addTextNode(serviceConfiguration.getClientSubsystemCode());
    }
  }

  private void addServiceElements(SOAPEnvelope env,
                                  XRoadServiceConfiguration serviceConfiguration,
                                  SOAPHeader header) throws SOAPException {
    SOAPElement service;
    if (StringUtils.equals(XroadObjectType.SERVICE.name(), serviceConfiguration.getServiceObjectType())) {
      service = header.addChildElement("service", "xrd");
    } else {
      service = header.addChildElement("centalService", "xrd");
    }
    service.addAttribute(env.createName("id:objectType"), serviceConfiguration.getServiceObjectType());
    SOAPElement serviceXRoadInstance = service.addChildElement("xRoadInstance", "id");
    serviceXRoadInstance.addTextNode(serviceConfiguration.getServiceXRoadInstance());
    if (StringUtils.equals(XroadObjectType.SERVICE.name(), serviceConfiguration.getServiceObjectType())) {
      SOAPElement serviceMemberClass = service.addChildElement("memberClass", "id");
      serviceMemberClass.addTextNode(serviceConfiguration.getServiceMemberClass());
      SOAPElement serviceMemberCode = service.addChildElement("memberCode", "id");
      serviceMemberCode.addTextNode(serviceConfiguration.getServiceMemberCode());
      SOAPElement subsystemCode = service.addChildElement("subsystemCode", "id");
      subsystemCode.addTextNode(serviceConfiguration.getServiceSubsystemCode());
    }
    SOAPElement database = service.addChildElement("serviceCode", "id");
    database.addTextNode(serviceConfiguration.getMethod());
    if (StringUtils.equals(XroadObjectType.SERVICE.name(), serviceConfiguration.getServiceObjectType())) {
      SOAPElement serviceVersion = service.addChildElement("serviceVersion", "id");
      serviceVersion.addTextNode(serviceConfiguration.getVersion() == null
                                                                            ? "v1"
                                                                            : serviceConfiguration.getVersion());
    }
  }

}
