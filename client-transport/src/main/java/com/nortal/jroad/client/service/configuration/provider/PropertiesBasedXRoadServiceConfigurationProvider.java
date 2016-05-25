package com.nortal.jroad.client.service.configuration.provider;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nortal.jroad.client.service.configuration.SimpleXRoadServiceConfiguration;
import com.nortal.jroad.enums.XRoadProtocolVersion;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class PropertiesBasedXRoadServiceConfigurationProvider extends AbstractXRoadServiceConfigurationProvider {
  public static final String XROAD_COMMON_PROPERTIES = "xroad.properties";

  private Resource resource;
  private Properties commonProps;

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
    configuration.setProtocolVersion(XRoadProtocolVersion.getValueByVersionCode(getDatabaseProperty(db,
                                                                                                        String.format(PROTOCOL_VERSION_FORMAT,
                                                                                                                      db))));
    configuration.setServiceXRoadInstance(getDatabaseProperty(db, String.format(XROAD_INSTANCE_FORMAT, db)));
    configuration.setServiceMemberClass(getDatabaseProperty(db, String.format(MEMBER_CLASS_FORMAT, db)));
    configuration.setServiceMemberCode(getDatabaseProperty(db, String.format(MEMBER_CODE_FORMAT, db)));
    configuration.setServiceSubsystemCode(getDatabaseProperty(db, String.format(SUBSYSTEM_FORMAT, db)));
  }

  @Override
  public String getDatabaseProperty(String database, String propertyName) {
    String result = commonProps.getProperty(propertyName);
    if (StringUtils.isNotBlank(result)) {
      return result;
    }
    return super.getDatabaseProperty(database, propertyName);
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }
}
