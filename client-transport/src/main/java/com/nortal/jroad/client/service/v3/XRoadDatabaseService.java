package com.nortal.jroad.client.service.v3;

import com.nortal.jroad.client.service.BaseXRoadDatabaseService;

import javax.annotation.Resource;
import com.nortal.jroad.client.service.consumer.XRoadConsumer;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public abstract class XRoadDatabaseService extends BaseXRoadDatabaseService {

	@Resource
	protected XRoadConsumer xRoadConsumer;

	@Override
	protected XRoadConsumer getXRoadConsumer() {
		return xRoadConsumer;
	}

}
