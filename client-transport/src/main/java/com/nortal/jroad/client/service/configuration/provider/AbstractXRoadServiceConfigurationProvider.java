package com.nortal.jroad.client.service.configuration.provider;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.SimpleXRoadServiceConfiguration;
import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public abstract class AbstractXRoadServiceConfigurationProvider implements XRoadServiceConfigurationProvider {

  @Override
  public BaseXRoadServiceConfiguration createConfiguration(XRoadProtocolVersion protocolVersion,
                                                           String database,
                                                           String wsdlDatabase,
                                                           String method,
                                                           String version) {
    SimpleXRoadServiceConfiguration configuration = new SimpleXRoadServiceConfiguration();
    configuration.setProtocolVersion(protocolVersion);
    configuration.setDatabase(database);
    configuration.setWsdlDatabase(wsdlDatabase);
    configuration.setMethod(method);
    configuration.setVersion(version);

    fillConfuguration(configuration);

    return configuration;
  }

  protected abstract void fillConfuguration(SimpleXRoadServiceConfiguration configuration);

}
