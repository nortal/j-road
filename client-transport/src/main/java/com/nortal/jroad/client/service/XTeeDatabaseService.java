package com.nortal.jroad.client.service;

import javax.annotation.Resource;

import com.nortal.jroad.client.service.consumer.XTeeConsumer;

/**
 * Base class for all standard X-tee services implementations. Database name will be determined automatically based on
 * the class name unless it is explicitly defined. The following naming convention is used for that:
 * <code>implementation class name = database name + XTeeServiceImpl</code>
 *
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 */
public abstract class XTeeDatabaseService extends BaseXTeeDatabaseService {

	@Resource
	protected XTeeConsumer xTeeConsumer;

	@Override
	protected XTeeConsumer getXTeeConsumer() {
		return xTeeConsumer;
	}

	public void setxTeeConsumer(XTeeConsumer xTeeConsumer) {
		this.xTeeConsumer = xTeeConsumer;
	}

}
