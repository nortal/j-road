package com.nortal.jroad.client.service.configuration.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nortal.jroad.client.service.configuration.SimpleXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;
import com.nortal.jroad.client.util.PropertiesUtil;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public abstract class AbstractXRoadServiceConfigurationProvider implements XRoadServiceConfigurationProvider {
  public static final String DATABSE_PROPERTIES_FORMAT = "xroad-%s.properties";
  public static final String PROTOCOL_VERSION_FORMAT = "%s-protocol-version";
  public static final String XROAD_INSTANCE_FORMAT = "%s-xroad-instance";
  public static final String MEMBER_CLASS_FORMAT = "%s-member-class";
  public static final String SUBSYSTEM_FORMAT = "%s-subsystem-code";
  public static final String MEMBER_CODE_FORMAT = "%s-member-code";

  private Map<String, Properties> databaseProperties = new HashMap<String, Properties>();

  @Override
  public XRoadServiceConfiguration createConfiguration(String database,
                                                       String wsdlDatabase,
                                                       String method,
                                                       String version) {
    SimpleXRoadServiceConfiguration configuration = new SimpleXRoadServiceConfiguration();
    configuration.setDatabase(database);
    configuration.setWsdlDatabase(wsdlDatabase);
    configuration.setMethod(method);
    configuration.setVersion(version);

    fillConfuguration(configuration);

    return configuration;
  }

  @Override
  public String getDatabaseProperty(String database, String propertyName) {
    return loadProperties(String.format(DATABSE_PROPERTIES_FORMAT, database)).getProperty(propertyName);
  }

  protected abstract void fillConfuguration(SimpleXRoadServiceConfiguration configuration);

  protected synchronized Properties loadProperties(String target) {
    if (!databaseProperties.containsKey(target)) {
      databaseProperties.put(target, loadProperties(new ClassPathResource(target)));
    }
    return databaseProperties.get(target);
  }

  protected Properties loadProperties(Resource resource) {
    try {
      return PropertiesUtil.readProperties(resource);
    } catch (IOException e) {
      throw new IllegalStateException("Unable to resolve configuration properties: " + resource.getFilename());
    }
  }
}
