package com.nortal.jroad.client.service.callback;

import com.nortal.jroad.client.enums.XroadObjectType;
import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;
import com.nortal.jroad.enums.XRoadProtocolVersion;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPHeader;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class XRoadProtocolNamespaceStrategyV4 extends MessageCallbackNamespaceStrategy {

  private static final XRoadProtocolVersion protocol = XRoadProtocolVersion.V4_0;
  private static final String XRD_REPRESENTATION_PREFIX = "repr";
  private static final String XRD_IDENTIFIERS_PREFIX = "id";
  private static final String XRD_OBJECT_TYPE_ATTRIBUTE = XRD_IDENTIFIERS_PREFIX + ":objectType";

  public XRoadProtocolNamespaceStrategyV4() {}

  @Override
  public void addNamespaces(SOAPEnvelope envelope) throws SOAPException {
    envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
    envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
    envelope.addNamespaceDeclaration(protocol.getNamespacePrefix(), protocol.getNamespaceUri());
    envelope.addNamespaceDeclaration(XRD_IDENTIFIERS_PREFIX, "http://x-road.eu/xsd/identifiers");
    envelope.addNamespaceDeclaration(XRD_REPRESENTATION_PREFIX, "http://x-road.eu/xsd/representation.xsd");
  }

  @Override
  public void addXRoadHeaderElements(SOAPEnvelope envelope, XRoadServiceConfiguration conf) throws SOAPException {
    SOAPHeader header = envelope.getHeader();
    if(StringUtils.isNotBlank(conf.getIdCode())) {
      header.addChildElement("userId", protocol.getNamespacePrefix())
        .addTextNode(conf.getIdCode());
    }

    header.addChildElement("id", protocol.getNamespacePrefix())
      .addTextNode(generateUniqueMessageId(conf));

    if (StringUtils.isNotBlank(conf.getIssue())) {
        header.addChildElement("issue", protocol.getNamespacePrefix())
          .addTextNode(conf.getIssue());
    }

    header.addChildElement("protocolVersion", protocol.getNamespacePrefix())
      .addTextNode(protocol.getCode());

    if (conf.getRepresentedPartyClass() != null && conf.getRepresentedPartyCode() != null){
      addRepresentedPartyElement(conf, header);
    }
    addClientElements(envelope, conf, header);
    addServiceElements(envelope, conf, header);
  }

  private void addRepresentedPartyElement(XRoadServiceConfiguration conf, SOAPHeader header)
    throws SOAPException {
    SOAPElement representedParty = header.addChildElement("representedParty", XRD_REPRESENTATION_PREFIX);
    representedParty.addChildElement("partyClass", XRD_REPRESENTATION_PREFIX)
      .addTextNode(conf.getRepresentedPartyClass());
    representedParty.addChildElement("partyCode", XRD_REPRESENTATION_PREFIX)
      .addTextNode(conf.getRepresentedPartyCode());
  }

  private void addClientElements(SOAPEnvelope envelope, XRoadServiceConfiguration conf, SOAPHeader header)
      throws SOAPException {
    // TODO: maybe we should create headers differently according to object type?
    XroadObjectType objectType =
        conf.getClientObjectType() != null ? conf.getClientObjectType() : XroadObjectType.SUBSYSTEM;
    SOAPElement client = header.addChildElement("client", protocol.getNamespacePrefix());
    client.addAttribute(envelope.createName(XRD_OBJECT_TYPE_ATTRIBUTE), objectType.name());

    client.addChildElement("xRoadInstance", XRD_IDENTIFIERS_PREFIX)
      .addTextNode(conf.getClientXRoadInstance());
    client.addChildElement("memberClass", XRD_IDENTIFIERS_PREFIX)
      .addTextNode(conf.getClientMemberClass());
    client.addChildElement("memberCode", XRD_IDENTIFIERS_PREFIX)
      .addTextNode(conf.getClientMemberCode());

    if (StringUtils.isNotBlank(conf.getClientSubsystemCode())) {
      client.addChildElement("subsystemCode", XRD_IDENTIFIERS_PREFIX)
        .addTextNode(conf.getClientSubsystemCode());
    }
  }

  private void addServiceElements(SOAPEnvelope envelope, XRoadServiceConfiguration conf, SOAPHeader header)
      throws SOAPException {

    // TODO: maybe we should create headers differently according to object type?
    XroadObjectType objectType =
        conf.getServiceObjectType() != null ? conf.getServiceObjectType() : XroadObjectType.SERVICE;

    SOAPElement service = header.addChildElement("service", protocol.getNamespacePrefix());
    service.addAttribute(envelope.createName(XRD_OBJECT_TYPE_ATTRIBUTE), objectType.name());

    service.addChildElement("xRoadInstance", XRD_IDENTIFIERS_PREFIX)
      .addTextNode(conf.getServiceXRoadInstance());
    service.addChildElement("memberClass", XRD_IDENTIFIERS_PREFIX)
      .addTextNode(conf.getServiceMemberClass());
    service.addChildElement("memberCode", XRD_IDENTIFIERS_PREFIX)
      .addTextNode(conf.getServiceMemberCode());

    if (StringUtils.isNotBlank(conf.getServiceSubsystemCode())) {
      service.addChildElement("subsystemCode", XRD_IDENTIFIERS_PREFIX)
        .addTextNode(conf.getServiceSubsystemCode());
    }

    service.addChildElement("serviceCode", XRD_IDENTIFIERS_PREFIX)
      .addTextNode(conf.getMethod());

    if(StringUtils.isNotBlank(conf.getVersion())){
      service.addChildElement("serviceVersion", XRD_IDENTIFIERS_PREFIX)
        .addTextNode(conf.getVersion());
    }

  }
}
