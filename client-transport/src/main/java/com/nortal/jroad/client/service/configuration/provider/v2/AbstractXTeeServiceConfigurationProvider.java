package com.nortal.jroad.client.service.configuration.provider.v2;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

import com.nortal.jroad.client.service.configuration.provider.XRoadServiceConfigurationProvider;
import com.nortal.jroad.client.service.configuration.v2.SimpleXTeeServiceConfiguration;

/**
 * @author Roman Tekhov
 */
public abstract class AbstractXTeeServiceConfigurationProvider implements XRoadServiceConfigurationProvider {

  public BaseXRoadServiceConfiguration createConfiguration(String database,
                                                           String wsdlDatabase,
                                                           String method,
                                                           String version) {
    SimpleXTeeServiceConfiguration configuration = new SimpleXTeeServiceConfiguration();

    configuration.setDatabase(database);
    configuration.setWsdlDatabase(wsdlDatabase);
    configuration.setMethod(method);
    configuration.setVersion(version);

    configuration.setSecurityServer(getSecurityServer(database, method, version));
    configuration.setIdCode(getIdCode(database, method, version));
    configuration.setInstitution(getInstitution(database, method, version));
    configuration.setFile(getFile(database, method, version));
    configuration.setUseDeprecatedApi(useDeprecatedApi(wsdlDatabase, method, version));
    return configuration;
  }

  protected abstract String getSecurityServer(String database, String method, String version);

  protected abstract String getIdCode(String database, String method, String version);

  protected abstract String getInstitution(String database, String method, String version);

  protected abstract String getFile(String database, String method, String version);

  protected abstract boolean useDeprecatedApi(String database, String method, String version);
}
