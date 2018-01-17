package com.nortal.jroad.client.service;

import javax.annotation.Resource;

import com.nortal.jroad.client.service.configuration.provider.XRoadServiceConfigurationProvider;
import com.nortal.jroad.client.service.consumer.XRoadConsumer;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
// TODO Lauri: replace with XRoadDatabaseService
@Deprecated
public abstract class XTeeDatabaseService extends BaseXRoadDatabaseService {

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
