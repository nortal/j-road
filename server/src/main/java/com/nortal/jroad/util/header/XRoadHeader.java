package com.nortal.jroad.util.header;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XRoadHeader {
  public static final String XROAD_NS_URI = "http://x-road.eu/xsd/xroad.xsd";
  public static final String XROAD_ID_NS_URI = "http://x-road.eu/xsd/identifiers";
  public static final String XROAD_REPR_NS_URI = "http://x-road.eu/xsd/representation.xsd";

  public static final QName CLIENT = new QName(XROAD_NS_URI, "client");
  public static final QName SERVICE = new QName(XROAD_NS_URI, "service");
  public static final QName REPRESENTED_PARTY = new QName(XROAD_REPR_NS_URI, "representedParty");

  public static final QName X_ROAD_INSTANCE = new QName(XROAD_ID_NS_URI, "xRoadInstance");
  public static final QName MEMBER_CLASS = new QName(XROAD_ID_NS_URI, "memberClass");
  public static final QName MEMBER_CODE = new QName(XROAD_ID_NS_URI, "memberCode");
  public static final QName USER_ID = new QName(XROAD_ID_NS_URI, "userId");
  public static final QName SUBSYSTEM_CODE = new QName(XROAD_ID_NS_URI, "subsystemCode");
  public static final QName SERVICE_CODE = new QName(XROAD_ID_NS_URI, "serviceCode");
  public static final QName SERVICE_VERSION = new QName(XROAD_ID_NS_URI, "serviceVersion");

  public static final QName PARTY_CLASS = new QName(XROAD_REPR_NS_URI, "partyClass");
  public static final QName PARTY_CODE = new QName(XROAD_REPR_NS_URI, "partyCode");

  private List<XRoadHeaderElement> elements = new ArrayList<XRoadHeaderElement>();

  public String getClientXRoadInstanceValue() {
    return getValueByQName(CLIENT, X_ROAD_INSTANCE);
  }

  public String getClientMemberClassValue() {
    return getValueByQName(CLIENT, MEMBER_CLASS);
  }

  public String getClientMemberCodeValue() {
    return getValueByQName(CLIENT, MEMBER_CODE);
  }

  public String getClientUserIdValue() {
    return getValueByQName(CLIENT, USER_ID);
  }

  public String getClientSubsystemCodeValue() {
    return getValueByQName(CLIENT, SUBSYSTEM_CODE);
  }

  public String getServiceXRoadInstanceValue() {
    return getValueByQName(SERVICE, X_ROAD_INSTANCE);
  }

  public String getServiceMemberClassValue() {
    return getValueByQName(SERVICE, MEMBER_CLASS);
  }

  public String getServiceMemberCodeValue() {
    return getValueByQName(SERVICE, MEMBER_CODE);
  }

  public String getServiceSubsystemCodeValue() {
    return getValueByQName(SERVICE, SUBSYSTEM_CODE);
  }

  public String getServiceCodeValue() {
    return getValueByQName(SERVICE, SERVICE_CODE);
  }

  public String getServiceVersionValue() {
    return getValueByQName(SERVICE, SERVICE_VERSION);
  }

  public String getRepresentedPartyClassValue() {
    return getValueByQName(REPRESENTED_PARTY, PARTY_CLASS);
  }

  public String getRepresentedPartyCodeValue() {
    return getValueByQName(REPRESENTED_PARTY, PARTY_CODE);
  }

  /**
   * Get Header element by QNames, the ordering of the QNames is important as the levels are searched in the provided
   * order. For example, getting memberCode would require the path with 2 QNames. First one for the xroad:client
   * element and second one for id:memberCode element
   *
   * @param names
   */
  public XRoadHeaderElement getByQName(QName... names) {
    return getByQName(this.elements, names);
  }

  private XRoadHeaderElement getByQName(List<XRoadHeaderElement> elements, QName... names) {
    for (XRoadHeaderElement element : elements) {
      if (names == null) {
        return element;
      }
      if (element.getQName().equals(names[0])) {
        if (element.getChildren() == null || element.getChildren().isEmpty() || names.length == 1) {
          return element;
        }
        return getByQName(element.getChildren(), Arrays.copyOfRange(names, 1, names.length));
      }
    }
    return null;
  }

  public String getValueByQName(QName... names) {
    XRoadHeaderElement element = getByQName(names);
    return element == null ? null : element.getValue();
  }

  public void addHeaderElement(XRoadHeaderElement element) {
    elements.add(element);
  }
}
