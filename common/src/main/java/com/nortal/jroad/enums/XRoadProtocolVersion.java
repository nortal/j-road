package com.nortal.jroad.enums;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public enum XRoadProtocolVersion {

  V2_0("2.0", "xtee", "http://x-tee.riik.ee/xsd/xtee.xsd", "v2"),
  V3_0("3.0", "xrd", "http://x-rd.net/xsd/xroad.xsd", "v3"),
  V3_1("3.1", "xrd", "http://x-road.ee/xsd/x-road.xsd", "v3"),
  V4_0("4.0", "xrd", "http://x-road.eu/xsd/xroad.xsd", "v4");

  private final String code;
  private final String namespacePrefix;
  private final String namespaceUri;
  private final String packageSuffix;

  XRoadProtocolVersion(String code, String namespacePrefix, String namespaceUri, String packageSuffix) {
    this.code = code;
    this.namespaceUri = namespaceUri;
    this.namespacePrefix = namespacePrefix;
    this.packageSuffix = packageSuffix;
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

  public String getPackageSuffix() {
    return packageSuffix;
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
      if (version.getNamespaceUri().equals(uri)) {
        return version;
      }
    }
    return null;
  }

}
