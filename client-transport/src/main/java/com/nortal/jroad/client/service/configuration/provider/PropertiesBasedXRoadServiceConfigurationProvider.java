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
import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class PropertiesBasedXRoadServiceConfigurationProvider extends AbstractXRoadServiceConfigurationProvider {
  public static final String PROTOCOL_VERSION_FORMAT = "%s-protocol-version";
  public static final String XROAD_INSTANCE_FORMAT = "%s-xroad-instance";
  public static final String MEMBER_CLASS_FORMAT = "%s-member-class";
  public static final String SUBSYSTEM_FORMAT = "%s-subsystem-code";
  public static final String MEMBER_CODE_FORMAT = "%s-member-code";

  public static final String XROAD_COMMON_PROPERTIES = "xroad.properties";

  private Resource resource;
  private Properties commonProps;
  private Map<String, Properties> properties = new HashMap<String, Properties>();

  @PostConstruct
  public void init() {
    if (resource == null) {
      resource = new ClassPathResource(XROAD_COMMON_PROPERTIES);
    }
    commonProps = loadProperties(resource);
  }

  @Override
  protected void fillConfuguration(SimpleXRoadServiceConfiguration configuration) {
    configuration.setSecurityServer(commonProps.getProperty("security-server"));
    configuration.setIdCode(commonProps.getProperty("id-code"));
    configuration.setFile(commonProps.getProperty("file"));

    configuration.setClientXRoadInstance(commonProps.getProperty(String.format(XROAD_INSTANCE_FORMAT, "client")));
    configuration.setClientMemberClass(commonProps.getProperty(String.format(MEMBER_CLASS_FORMAT, "client")));
    configuration.setClientMemberCode(commonProps.getProperty(String.format(MEMBER_CODE_FORMAT, "client")));
    configuration.setClientSubsystemCode(commonProps.getProperty(String.format(SUBSYSTEM_FORMAT, "client")));

    fillServiceProperties(configuration);
  }

  protected void fillServiceProperties(SimpleXRoadServiceConfiguration configuration) {
    String db = configuration.getDatabase();
    Properties serviceProps = loadProperties(String.format("xroad-%s.properties", db));

    configuration.setProtocolVersion(XRoadProtocolVersion.getValueByVersionCode(resolveDatabaseProperty(String.format(PROTOCOL_VERSION_FORMAT,
                                                                                                                      db),
                                                                                                        serviceProps)));
    configuration.setServiceXRoadInstance(resolveDatabaseProperty(String.format(XROAD_INSTANCE_FORMAT, db),
                                                                  serviceProps));
    configuration.setServiceMemberClass(resolveDatabaseProperty(String.format(MEMBER_CLASS_FORMAT, db), serviceProps));
    configuration.setServiceMemberCode(resolveDatabaseProperty(String.format(MEMBER_CODE_FORMAT, db), serviceProps));
    configuration.setServiceSubsystemCode(resolveDatabaseProperty(String.format(SUBSYSTEM_FORMAT, db), serviceProps));
  }

  protected String resolveDatabaseProperty(String propertyName, Properties databaseProps) {
    String result = commonProps.getProperty(propertyName);
    if (StringUtils.isNotBlank(result)) {
      return result;
    }
    return databaseProps.getProperty(propertyName);
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
