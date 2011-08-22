package ee.webmedia.xtee.client.service.configuration.provider;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;

/**
 * Resolves X-tee service related property values to be used by various property based X-tee data providers. Default
 * property file location to be used is <code>classpath:xtee-service.properties</code>.
 * 
 * @author Roman Tekhov
 */
public class XTeeProviderPropertiesResolver {

  public static final String DEFAULT_LOCATION = "xtee-service.properties";

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

  /**
   * Resolves the property with the specified key.
   * 
   * @param key property key
   * @return resolved property or <code>null</code> if such property is not defined
   */
  public String getProperty(String key) {
    return props.getProperty(key);
  }

  /**
   * Sets the custom property resource location.
   * 
   * @param resource property resource to use
   */
  public void setResource(Resource resource) {
    this.resource = resource;
  }

}
