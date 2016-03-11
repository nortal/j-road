package com.nortal.jroad.model.v4;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
@SuppressWarnings("serial")
public class XRoadHeader implements Serializable {

  public static final String XROAD_NS_URI = "http://x-road.eu/xsd/xroad.xsd";

  public static final QName CLIENT = new QName(XROAD_NS_URI, "client");
  public static final QName SERVICE = new QName(XROAD_NS_URI, "service");
  public static final QName USER_ID = new QName(XROAD_NS_URI, "userId");
  public static final QName ID = new QName(XROAD_NS_URI, "id");
  public static final QName PROTOCOL_VERSION = new QName(XROAD_NS_URI, "protocolVersion");

  private Map<QName, String> elemendid;

  public Map<QName, String> getElemendid() {
    return elemendid;
  }

  public void setElemendid(Map<QName, String> elemendid) {
    this.elemendid = elemendid;
  }

  public void addElement(QName nimi, String vaartus) {
    if (elemendid == null) {
      elemendid = new HashMap<QName, String>();
    }

    elemendid.put(nimi, vaartus);
  }

}
