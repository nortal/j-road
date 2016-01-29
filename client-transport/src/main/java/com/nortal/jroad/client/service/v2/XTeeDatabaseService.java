package com.nortal.jroad.client.service.v2;

import com.nortal.jroad.client.service.BaseXRoadDatabaseService;

import javax.annotation.Resource;
import com.nortal.jroad.client.service.consumer.XRoadConsumer;

/**
 * Base class for all standard X-tee services implementations. Database name
 * will be determined automatically based on the class name unless it is
 * explicitly defined. The following naming convention is used for that:
 * <code>implementation class name = database name + XTeeServiceImpl</code>
 *
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 */
public abstract class XTeeDatabaseService extends BaseXRoadDatabaseService {

  @Resource
  protected XRoadConsumer xTeeConsumer;

  @Override
  protected XRoadConsumer getXRoadConsumer() {
    return xTeeConsumer;
  }

  public void setxTeeConsumer(XRoadConsumer xTeeConsumer) {
    this.xTeeConsumer = xTeeConsumer;
  }

}
