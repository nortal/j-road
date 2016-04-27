package com.nortal.jroad.client.service.configuration.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nortal.jroad.client.service.configuration.SimpleXRoadServiceConfiguration;
import com.nortal.jroad.client.util.PropertiesUtil;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class PropertiesBasedXRoadServiceConfigurationProvider extends AbstractXRoadServiceConfigurationProvider {

  public static final String XROAD_COMMON_PROPERTIES_TARGET = "xroad";

  private Resource resource;
  private Map<String, Properties> properties = new HashMap<String, Properties>();

  @PostConstruct
  public void init() {
    if (resource != null) {
      properties.put(XROAD_COMMON_PROPERTIES_TARGET, loadProperties(resource));
    }
  }

  @Override
  protected void fillConfuguration(SimpleXRoadServiceConfiguration configuration) {
    Properties commonProps = getProperties(XROAD_COMMON_PROPERTIES_TARGET);

    configuration.setSecurityServer(resolveProperty(commonProps, "security-server"));
    configuration.setInstitution(resolveProperty(commonProps, "institution"));
    configuration.setIdCode(resolveProperty(commonProps, "id-code"));
    configuration.setFile(resolveProperty(commonProps, "file"));

    configuration.setXRoadInstance(resolveProperty(commonProps, "xroad-instance"));
    configuration.setClientMemberClass(resolveProperty(commonProps, "client-member-class"));
    configuration.setClientSubsystemCode(resolveProperty(commonProps, "client-subsystem-code"));

    fillServiceProperties(configuration);
  }

  protected void fillServiceProperties(SimpleXRoadServiceConfiguration configuration) {
    Properties serviceProps = getProperties(XROAD_COMMON_PROPERTIES_TARGET + "-" + configuration.getDatabase());

    configuration.setServiceMemberClass(resolveProperty(serviceProps, "service-member-class"));
    configuration.setServiceMemberCode(resolveProperty(serviceProps, "service-member-code"));
    configuration.setServiceSubsystemCode(resolveProperty(serviceProps, "service-subsystem-code"));
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  protected String resolveProperty(Properties props, String propertyName) {
    return props.getProperty(propertyName);
  }

  protected synchronized Properties getProperties(String target) {
    if (StringUtils.isBlank(target)) {
      return null;
    }

    if (!properties.containsKey(target)) {
      properties.put(target, loadProperties(new ClassPathResource(target + ".properties")));
    }
    return properties.get(target);
  }

  protected Properties loadProperties(Resource resource) {
    try {
      return PropertiesUtil.readProperties(resource);
    } catch (IOException e) {
      throw new IllegalStateException("Unable to resolve configuration properties: " + resource.getFilename());
    }
  }
}
