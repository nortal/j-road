package com.nortal.jroad.client.service.callback;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;

import org.apache.commons.lang.StringUtils;

import com.nortal.jroad.client.enums.XroadObjectType;
import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;
import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class XRoadProtocolNamespaceStrategyV4 extends MessageCallbackNamespaceStrategy {

  private XRoadProtocolVersion protocol = XRoadProtocolVersion.V4_0;

  @Override
  public void addNamespaces(SOAPEnvelope env) throws SOAPException {
    env.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
    env.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
    env.addNamespaceDeclaration(protocol.getNamespacePrefix(), protocol.getNamespaceUri());
    env.addNamespaceDeclaration("id", "http://x-road.eu/xsd/identifiers");
  }

  @Override
  public void addXTeeHeaderElements(SOAPEnvelope env, BaseXRoadServiceConfiguration serviceConfiguration)
      throws SOAPException {
    XRoadServiceConfiguration conf = (XRoadServiceConfiguration) serviceConfiguration;
    SOAPHeader header = env.getHeader();

    SOAPElement userId = header.addChildElement("userId", protocol.getNamespacePrefix());
    userId.addTextNode(conf.getIdCode());
    SOAPElement id = header.addChildElement("id", protocol.getNamespacePrefix());
    id.addTextNode(generateUniqueMessageId(conf));
    if (StringUtils.isNotBlank(conf.getFile())) {
      SOAPElement issue = header.addChildElement("issue", protocol.getNamespacePrefix());
      issue.addTextNode(conf.getFile());
    }
    SOAPElement protocolVersion = header.addChildElement("protocolVersion", protocol.getNamespacePrefix());
    protocolVersion.addTextNode(protocol.getCode());

    addClientElements(env, conf, header);
    addServiceElements(env, conf, header);
  }

  private void addClientElements(SOAPEnvelope env, XRoadServiceConfiguration conf, SOAPHeader header)
      throws SOAPException {
    SOAPElement client = header.addChildElement("client", protocol.getNamespacePrefix());
    client.addAttribute(env.createName("id:objectType"), XroadObjectType.MEMBER.name());
    SOAPElement clientXRoadInstance = client.addChildElement("xRoadInstance", "id");
    clientXRoadInstance.addTextNode(conf.getXRoadInstance());
    SOAPElement clientMemberClass = client.addChildElement("memberClass", "id");
    clientMemberClass.addTextNode(conf.getClientMemberClass());
    SOAPElement clientMemberCode = client.addChildElement("memberCode", "id");
    clientMemberCode.addTextNode(conf.getInstitution());

    if (StringUtils.isNotBlank(conf.getClientSubsystemCode())) {
      SOAPElement clientSubsystemCode = client.addChildElement("subsystemCode", "id");
      clientSubsystemCode.addTextNode(conf.getClientSubsystemCode());
    }
  }

  private void addServiceElements(SOAPEnvelope env, XRoadServiceConfiguration conf, SOAPHeader header)
      throws SOAPException {
    SOAPElement service = header.addChildElement("service", protocol.getNamespacePrefix());
    service.addAttribute(env.createName("id:objectType"), XroadObjectType.SERVICE.name());
    SOAPElement serviceXRoadInstance = service.addChildElement("xRoadInstance", "id");
    serviceXRoadInstance.addTextNode(conf.getXRoadInstance());
    SOAPElement serviceMemberClass = service.addChildElement("memberClass", "id");
    serviceMemberClass.addTextNode(conf.getServiceMemberClass());
    SOAPElement serviceMemberCode = service.addChildElement("memberCode", "id");
    serviceMemberCode.addTextNode(conf.getServiceMemberCode());

    if (StringUtils.isNotBlank(conf.getServiceSubsystemCode())) {
      SOAPElement subsystemCode = service.addChildElement("subsystemCode", "id");
      subsystemCode.addTextNode(conf.getServiceSubsystemCode());
    }

    SOAPElement database = service.addChildElement("serviceCode", "id");
    database.addTextNode(conf.getMethod());
    SOAPElement serviceVersion = service.addChildElement("serviceVersion", "id");
    serviceVersion.addTextNode(StringUtils.isBlank(conf.getVersion()) ? conf.getVersion() : "v1");
  }
}
