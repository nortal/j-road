package com.nortal.jroad.client.service.configuration.v4;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public interface XRoadServiceConfiguration extends BaseXRoadServiceConfiguration {

  String getClientObjectType();

  String getClientXRoadInstance();

  String getClientMemberClass();

  String getClientMemberCode();

  String getClientSubsystemCode();

  String getServiceObjectType();

  String getServiceXRoadInstance();

  String getServiceMemberClass();

  String getServiceMemberCode();

  String getServiceSubsystemCode();
}
