package com.nortal.jroad.client.service.v4;

import com.nortal.jroad.client.service.BaseXRoadDatabaseService;
import com.nortal.jroad.client.service.configuration.provider.XRoadServiceConfigurationProvider;
import com.nortal.jroad.client.service.consumer.XRoadConsumer;
import jakarta.annotation.Resource;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public abstract class XRoadDatabaseService extends BaseXRoadDatabaseService {

  @Resource
  protected XRoadConsumer xRoadV4Consumer;
  @Resource
  protected XRoadServiceConfigurationProvider xRoadV4ServiceConfigurationProvider;

  @Override
  protected XRoadConsumer getXRoadConsumer() {
    return xRoadV4Consumer;
  }

  @Override
  protected XRoadServiceConfigurationProvider getXRoadServiceConfigurationProvider() {
    return xRoadV4ServiceConfigurationProvider;
  }
}
