package com.nortal.jroad.enums;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public enum XRoadProtocolVersion {

  V2_0("2.0", "xtee", "http://x-tee.riik.ee/xsd/xtee.xsd"),
  V3_0("3.0", "xrd", "http://x-rd.net/xsd/xroad.xsd"),
  V3_1("3.1", "xrd", "http://x-road.ee/xsd/x-road.xsd"),
  V4_0("4.0", "xrd", "http://x-road.eu/xsd/xroad.xsd");

  private final String code;
  private final String namespacePrefix;
  private final String namespaceUri;

  private XRoadProtocolVersion(String code, String namespacePrefix, String namespaceUri) {
    this.code = code;
    this.namespaceUri = namespaceUri;
    this.namespacePrefix = namespacePrefix;
  }

  public String getCode() {
    return code;
  }

  public String getNamespacePrefix() {
    return namespacePrefix;
  }

  public String getNamespaceUri() {
    return namespaceUri;
  }

  public static XRoadProtocolVersion getValueByVersionCode(String code) {
    for (XRoadProtocolVersion version : XRoadProtocolVersion.values()) {
      if (version.getCode().equals(code)) {
        return version;
      }
    }
    return null;
  }

  public static XRoadProtocolVersion getValueByNamespaceURI(String uri) {
    for (XRoadProtocolVersion version : XRoadProtocolVersion.values()) {
      if (version.getNamespaceUri().startsWith(uri)) {
        return version;
      }
    }
    return null;
  }

}
