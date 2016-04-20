package com.nortal.jroad.client.service.configuration.provider.v4;

import com.nortal.jroad.client.service.configuration.v4.SimpleXRoadServiceConfiguration;
import com.nortal.jroad.client.util.PropertiesUtil;
import java.io.IOException;
import java.util.Properties;
import javax.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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
    configuration.setSecurityServer(resolveProperty("security-server"));
    configuration.setIdCode(resolveProperty("id-code"));

    configuration.setClientXRoadInstance(resolveProperty("client-xroad-instance"));
    configuration.setClientObjectType(resolveProperty("client-object-type"));
    configuration.setClientMemberClass(resolveProperty("client-member-class"));
    configuration.setClientMemberCode(resolveProperty("client-member-code"));
    configuration.setClientSubsystemCode(resolveProperty("client-subsystem-code"));

    configuration.setServiceXRoadInstance(resolveProperty("service-xroad-instance"));
    configuration.setServiceObjectType(resolveProperty("service-object-type"));
    configuration.setServiceMemberClass(resolveProperty("service-member-class"));
    configuration.setServiceMemberCode(resolveProperty("service-member-code"));
    configuration.setServiceSubsystemCode(resolveProperty("service-subsystem-code"));

    configuration.setFile(resolveProperty("file"));
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  protected String resolveProperty(String propertyName) {
    return props.getProperty(propertyName);
  }
}
