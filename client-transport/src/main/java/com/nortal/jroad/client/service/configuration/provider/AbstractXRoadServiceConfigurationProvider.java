package com.nortal.jroad.client.service.configuration.provider;

import com.nortal.jroad.client.service.configuration.SimpleXRoadServiceConfiguration;
import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public abstract class AbstractXRoadServiceConfigurationProvider implements XRoadServiceConfigurationProvider {
  public static final String XROAD_PROTOCOL_VERSION_FORMAT = "%s-protocol-version";
  public static final String XROAD_INSTANCE_FORMAT = "%s-xroad-instance";
  public static final String XROAD_MEMBER_CLASS_FORMAT = "%s-member-class";
  public static final String XROAD_SUBSYSTEM_CODE_FORMAT = "%s-subsystem-code";
  public static final String XROAD_MEMBER_CODE_FORMAT = "%s-member-code";

  @Override
  public XRoadServiceConfiguration createConfiguration(String database,
                                                       String wsdlDatabase,
                                                       String method,
                                                       String version) {
    SimpleXRoadServiceConfiguration configuration = new SimpleXRoadServiceConfiguration();
    configuration.setDatabase(database);
    configuration.setWsdlDatabase(wsdlDatabase);
    configuration.setMethod(method);
    configuration.setVersion(version);

    return fillConfuguration(configuration);
  }

  protected String getKey(String pattern, String value) {
    return String.format(pattern, value);
  }

  protected abstract XRoadServiceConfiguration fillConfuguration(SimpleXRoadServiceConfiguration configuration);
}
