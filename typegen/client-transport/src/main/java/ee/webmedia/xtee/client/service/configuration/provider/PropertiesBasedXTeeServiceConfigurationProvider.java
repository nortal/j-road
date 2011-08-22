package ee.webmedia.xtee.client.service.configuration.provider;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;

/**
 * {@link XTeeServiceConfigurationProvider} implementation based on a properties file.
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
    props = new Properties();
    new DefaultPropertiesPersister().load(props, resource.getInputStream());
  }

  public void setResource(Resource resource) {
    this.resource = resource;
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

  private String resolveProperty(String propertyName) {
    return props.getProperty(propertyName);
  }

  @Override
  protected boolean useDeprecatedApi(String database, String method, String version) {
    // currently the default value is true
    String value = resolveProperty("use-deprecated-api");
    return value == null || Boolean.valueOf(value);
  }

}
