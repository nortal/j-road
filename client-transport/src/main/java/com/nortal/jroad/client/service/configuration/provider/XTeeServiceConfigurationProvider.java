package com.nortal.jroad.client.service.configuration.provider;

import com.nortal.jroad.client.service.configuration.XTeeServiceConfiguration;

/**
 * Creates configurations
 * 
 * @author Dmitri Danilkin
 */
public interface XTeeServiceConfigurationProvider {

  XTeeServiceConfiguration createConfiguration(String database, String wsdldatabase, String method, String version);

}
