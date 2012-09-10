package ee.webmedia.xtee.client.service;

import javax.annotation.Resource;

import ee.webmedia.xtee.client.service.consumer.XTeeConsumer;

/**
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public abstract class XRoadDatabaseService extends BaseXTeeDatabaseService {

	@Resource
	protected XTeeConsumer xRoadConsumer;

	@Override
	protected XTeeConsumer getXTeeConsumer() {
		return xRoadConsumer;
	}

}
