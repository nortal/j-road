package com.nortal.jroad.client.service.configuration.provider;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

/**
 * Creates configurations
 * 
 * @author Dmitri Danilkin
 */
public interface XRoadServiceConfigurationProvider {

  BaseXRoadServiceConfiguration createConfiguration(String database, String wsdldatabase, String method, String version);

}
