package com.nortal.jroad.client.service.v3;

import com.nortal.jroad.client.service.BaseXRoadDatabaseService;
import com.nortal.jroad.client.service.configuration.provider.XRoadServiceConfigurationProvider;

import javax.annotation.Resource;
import com.nortal.jroad.client.service.consumer.XRoadConsumer;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
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

  public void setXRoadServiceConfigurationProvider(XRoadServiceConfigurationProvider xRoadServiceConfigurationProvider) {
    this.xRoadServiceConfigurationProvider = xRoadServiceConfigurationProvider;
  }
}
