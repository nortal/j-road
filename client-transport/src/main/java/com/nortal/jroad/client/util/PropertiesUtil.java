package com.nortal.jroad.client.util;

import java.io.IOException;
import java.util.Properties;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class PropertiesUtil {

  public static Properties readProperties(Resource resource) throws IOException {
    if (resource == null) {
      return null;
    }
    Properties props = new Properties();
    new DefaultPropertiesPersister().load(props, resource.getInputStream());
    return props;
  }
}
