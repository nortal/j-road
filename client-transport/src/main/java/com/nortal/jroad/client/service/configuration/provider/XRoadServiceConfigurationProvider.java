package com.nortal.jroad.client.service.configuration.provider;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;
import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * Creates configurations
 * 
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public interface XRoadServiceConfigurationProvider {

  BaseXRoadServiceConfiguration createConfiguration(XRoadProtocolVersion protocolVersion,
                                                    String database,
                                                    String wsdldatabase,
                                                    String method,
                                                    String version);

}
