package com.nortal.jroad.client.service.configuration.provider.v4;

import com.nortal.jroad.client.service.configuration.v4.SimpleXRoadServiceConfiguration;
import com.nortal.jroad.client.util.PropertiesUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class PropertiesBasedXRoadServiceConfigurationProvider extends AbstractXRoadServiceConfigurationProvider {

  public static final String DEFAULT_LOCATION = "xroad.properties";

  private Properties props;
  private Resource resource;

  @PostConstruct
  public void init() throws IOException {
    if (resource == null) {
      resource = new ClassPathResource(DEFAULT_LOCATION);
    }
    props = PropertiesUtil.readProperties(resource);
  }

  @Override
  protected void fillConfuguration(SimpleXRoadServiceConfiguration configuration) {
    configuration.setSecurityServer(resolveProperty(configuration, "security-server"));
    configuration.setIdCode(resolveProperty(configuration, "id-code"));

    configuration.setClientXRoadInstance(resolveProperty(configuration, "client-xroad-instance"));
    configuration.setClientObjectType(resolveProperty(configuration, "client-object-type"));
    configuration.setClientMemberClass(resolveProperty(configuration, "client-member-class"));
    configuration.setClientMemberCode(resolveProperty(configuration, "client-member-code"));
    configuration.setClientSubsystemCode(resolveProperty(configuration, "client-subsystem-code"));

    configuration.setServiceXRoadInstance(resolveProperty(configuration, "service-xroad-instance"));
    configuration.setServiceObjectType(resolveProperty(configuration, "service-object-type"));
    configuration.setServiceMemberClass(resolveProperty(configuration, "service-member-class"));
    configuration.setServiceMemberCode(resolveProperty(configuration, "service-member-code"));
    configuration.setServiceSubsystemCode(resolveProperty(configuration, "service-subsystem-code"));

    configuration.setFile(resolveProperty(configuration, "file"));
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  protected String resolveProperty(SimpleXRoadServiceConfiguration configuration, String propertyName) {
    return props.getProperty(propertyName);
  }
}
