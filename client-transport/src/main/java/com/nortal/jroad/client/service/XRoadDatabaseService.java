package com.nortal.jroad.client.service;

import com.nortal.jroad.client.service.configuration.provider.XRoadServiceConfigurationProvider;
import jakarta.annotation.Resource;
import com.nortal.jroad.client.service.consumer.XRoadConsumer;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public abstract class XRoadDatabaseService extends BaseXRoadDatabaseService {

  @Resource
  protected XRoadConsumer xRoadConsumer;
  @Resource
  protected XRoadServiceConfigurationProvider xRoadServiceConfigurationProvider;

  @Override
  protected XRoadConsumer getXRoadConsumer() {
    return xRoadConsumer;
  }

  @Override
  protected XRoadServiceConfigurationProvider getXRoadServiceConfigurationProvider() {
    return xRoadServiceConfigurationProvider;
  }

}
