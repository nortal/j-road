package com.nortal.jroad.client.service.configuration;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
// TODO Lauri: konfi võiks kuidagi paremini lahendatud olla
public interface XRoadServiceConfiguration extends BaseXRoadServiceConfiguration {
  String getXRoadInstance();

  String getClientMemberClass();

  String getClientSubsystemCode();

  String getServiceMemberClass();

  String getServiceMemberCode();

  String getServiceSubsystemCode();
}
