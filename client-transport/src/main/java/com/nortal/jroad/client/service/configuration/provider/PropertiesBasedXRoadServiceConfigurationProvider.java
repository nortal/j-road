package com.nortal.jroad.client.service.configuration.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jakarta.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nortal.jroad.client.enums.XroadObjectType;
import com.nortal.jroad.client.service.configuration.SimpleXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;
import com.nortal.jroad.client.util.PropertiesUtil;
import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class PropertiesBasedXRoadServiceConfigurationProvider extends AbstractXRoadServiceConfigurationProvider {
  public static final String XROAD_DATABASE_PROPERTIES_FORMAT = "xroad-%s.properties";
  public static final String XROAD_CLIENT_PROPERTIES = "xroad.properties";
  public static final String CLIENT_KEY = "client";

  private Resource resource;
  private final Map<String, Properties> properties = new HashMap<>();

  @PostConstruct
  public void init() {
    if (resource == null) {
      resource = new ClassPathResource(XROAD_CLIENT_PROPERTIES);
    }
    properties.put(XROAD_CLIENT_PROPERTIES, loadProperties(resource));
  }

  @Override
  protected XRoadServiceConfiguration fillConfuguration(SimpleXRoadServiceConfiguration configuration) {
    configuration.setSecurityServer(resolveCommonProperty(configuration, "security-server"));
    configuration.setIdCode(resolveCommonProperty(configuration, "id-code"));
    configuration.setFile(resolveCommonProperty(configuration, "file"));

    fillClientProperties(configuration);
    fillServiceProperties(configuration);

    return configuration;
  }

  protected void fillClientProperties(SimpleXRoadServiceConfiguration configuration) {
    configuration.setClientXRoadInstance(getClientProperty(XROAD_INSTANCE_FORMAT));
    configuration.setClientMemberClass(getClientProperty(XROAD_MEMBER_CLASS_FORMAT));
    configuration.setClientMemberCode(getClientProperty(XROAD_MEMBER_CODE_FORMAT));
    configuration.setClientSubsystemCode(getClientProperty(XROAD_SUBSYSTEM_CODE_FORMAT));
    String objectType = getClientProperty(XROAD_OBJECT_TYPE_FORMAT);
    if (StringUtils.isNotBlank(objectType)) {
      configuration.setClientObjectType(XroadObjectType.valueOf(objectType));
    }
  }

  protected void fillServiceProperties(SimpleXRoadServiceConfiguration configuration) {
    String db = configuration.getDatabase();
    configuration.setProtocolVersion(
      XRoadProtocolVersion.getValueByVersionCode(resolveServiceProperty(configuration, XROAD_PROTOCOL_VERSION_FORMAT, db))
    );
    configuration.setServiceXRoadInstance(resolveServiceProperty(configuration, XROAD_INSTANCE_FORMAT, db));
    configuration.setServiceMemberClass(resolveServiceProperty(configuration, XROAD_MEMBER_CLASS_FORMAT, db));
    configuration.setServiceMemberCode(resolveServiceProperty(configuration, XROAD_MEMBER_CODE_FORMAT, db));
    configuration.setServiceSubsystemCode(resolveServiceProperty(configuration, XROAD_SUBSYSTEM_CODE_FORMAT, db));
    String objectType = resolveServiceProperty(configuration, XROAD_OBJECT_TYPE_FORMAT, db);
    if (StringUtils.isNotBlank(objectType)) {
      configuration.setServiceObjectType(XroadObjectType.valueOf(objectType));
    }
  }

  /**
   * A hook into property resolution process with access to a configuration
   */
  protected String resolveCommonProperty(SimpleXRoadServiceConfiguration configuration, String propertyName) {
    return getProperty(propertyName);
  }

  /**
   * A hook into property resolution process with access to a configuration
   */
  protected String resolveServiceProperty(SimpleXRoadServiceConfiguration configuration, String pattern, String db) {
    return getServiceProperty(pattern, db);
  }

  protected String getClientProperty(String pattern) {
    return getProperty(XROAD_CLIENT_PROPERTIES, getKey(pattern, CLIENT_KEY));
  }

  protected String getServiceProperty(String pattern, String db) {
    return getProperty(getKey(XROAD_DATABASE_PROPERTIES_FORMAT, db), getKey(pattern, db));
  }

  protected String getProperty(String key) {
    return getProperty(XROAD_CLIENT_PROPERTIES, key);
  }

  protected String getProperty(String target, String key) {
    String result = properties.get(XROAD_CLIENT_PROPERTIES).getProperty(key);
    if (StringUtils.isNotBlank(result)) {
      return result;
    }
    return loadProperties(target).getProperty(key);
  }

  protected synchronized Properties loadProperties(String target) {
    if (!properties.containsKey(target)) {
      properties.put(target, loadProperties(new ClassPathResource(target)));
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

  public void setResource(Resource resource) {
    this.resource = resource;
  }
}
