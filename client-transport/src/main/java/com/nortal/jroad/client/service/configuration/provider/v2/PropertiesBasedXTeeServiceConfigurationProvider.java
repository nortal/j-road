package com.nortal.jroad.client.service.configuration.provider.v2;

import com.nortal.jroad.client.service.configuration.provider.XRoadServiceConfigurationProvider;
import com.nortal.jroad.client.util.PropertiesUtil;
import java.io.IOException;
import java.util.Properties;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * {@link XRoadServiceConfigurationProvider} implementation based on a properties file.
 * 
 * @author Dmitri Danilkin
 */
public class PropertiesBasedXTeeServiceConfigurationProvider extends AbstractXTeeServiceConfigurationProvider {

  public static final String DEFAULT_LOCATION = "xtee.properties";

  private Properties props;
  private Resource resource;

  @PostConstruct
  public void init() throws IOException {
    if (resource == null) {
      resource = new ClassPathResource(DEFAULT_LOCATION);
    }
    props = PropertiesUtil.readProperties(resource);
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  private String resolveProperty(String propertyName) {
    return props.getProperty(propertyName);
  }

  @Override
  protected String getSecurityServer(String database, String method, String version) {
    return resolveProperty("security-server");
  }

  @Override
  protected String getIdCode(String database, String method, String version) {
    return resolveProperty("id-code");
  }

  @Override
  protected String getInstitution(String database, String method, String version) {
    return resolveProperty("institution");
  }

  @Override
  protected String getFile(String database, String method, String version) {
    return resolveProperty("file");
  }

  @Override
  protected boolean useDeprecatedApi(String database, String method, String version) {
    return Boolean.valueOf(resolveProperty("use-deprecated-api"));
  }
}
