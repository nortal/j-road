package com.nortal.jroad.client.service.configuration.provider;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

/**
 * Creates configurations
 * 
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public interface XRoadServiceConfigurationProvider {

  BaseXRoadServiceConfiguration createConfiguration(String database,
                                                    String wsdldatabase,
                                                    String method,
                                                    String version);

}
