package com.nortal.jroad.client.service;

import javax.annotation.Resource;

import com.nortal.jroad.client.service.configuration.provider.XRoadServiceConfigurationProvider;
import com.nortal.jroad.client.service.consumer.XRoadConsumer;

/**
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
