package ee.webmedia.xtee.client.service.configuration.provider;

import ee.webmedia.xtee.client.service.configuration.SimpleXTeeServiceConfiguration;
import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;

/**
 * @author Roman Tekhov
 */
public abstract class AbstractXTeeServiceConfigurationProvider implements XTeeServiceConfigurationProvider {

  public XTeeServiceConfiguration createConfiguration(String database,
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
