package ee.webmedia.xtee.client.service.configuration.provider;

import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;

/**
 * Creates configurations
 * 
 * @author Dmitri Danilkin
 */
public interface XTeeServiceConfigurationProvider {

  XTeeServiceConfiguration createConfiguration(String database, String wsdldatabase, String method, String version);

}
