package com.nortal.jroad.client.service.configuration;

import com.nortal.jroad.client.enums.XroadObjectType;
import com.nortal.jroad.enums.XRoadProtocolVersion;
import java.io.Serializable;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
// TODO Lauri: konfi võiks kuidagi paremini lahendatud olla
public interface XRoadServiceConfiguration extends Serializable {
  /**
   * Returns an URL of institutions security server, typically in form of
   * <code>http://minu_turvaserver/cgi-bin/consumer_proxy</code>.
   */
  String getSecurityServer();

  /**
   * Returns name/prefix of the X-Tee database where the service-to-be-invoked resides.
   */
  String getDatabase();

  /**
   * Returns name/prefix of the X-Tee database, which is actually specified in the WSDL of the service.
   */
  String getWsdlDatabase();

  /** Returns identifier of the person/entity who will be invoking the service */
  String getIdCode();

  /** Returns name of file (or document) related to the service invokation. */
  String getFile();

  /** Returns the service-to-be-invoked version. */
  String getVersion();

  /** Returns the name of the (service's) <code>method</code> that will be called. */
  String getMethod();

  /**
   * Returns database xroad protocol version - by default v4
   */
  XRoadProtocolVersion getProtocolVersion();

  String getClientXRoadInstance();

  String getClientMemberClass();

  String getClientMemberCode();

  String getClientSubsystemCode();

  String getServiceXRoadInstance();

  String getServiceMemberClass();

  String getServiceMemberCode();

  String getServiceSubsystemCode();

  XroadObjectType getClientObjectType();

  XroadObjectType getServiceObjectType();
}
