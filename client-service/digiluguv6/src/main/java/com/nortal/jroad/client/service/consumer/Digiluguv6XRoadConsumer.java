package com.nortal.jroad.client.service.consumer;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.client.service.extractor.Digiluguv6XRoadConsumerMessageExtractor;
import com.nortal.jroad.client.util.XmlBeansUtil;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMetadata;

@Service("digiluguv6XRoadConsumer")
public class Digiluguv6XRoadConsumer extends StandardXRoadConsumer {
	private Map<String, XmlBeansXRoadMetadata> metadata;
	
	@Override
	protected void initGateway() throws Exception {
		super.initGateway();
		metadata = XmlBeansUtil.loadMetadata();
	}

	@Override
	public <I, O> XRoadMessage<O> sendRequest(XRoadMessage<I> input, XRoadServiceConfiguration xroadServiceConfiguration)
		throws XRoadServiceConsumptionException {
		return sendRequest(input, xroadServiceConfiguration, null, null);
	}
	
	@Override
	public <I, O> XRoadMessage<O> sendRequest(XRoadMessage<I> input, XRoadServiceConfiguration xroadServiceConfiguration, CustomCallback callback,
		CustomExtractor extractor) throws XRoadServiceConsumptionException {
		
		if (extractor == null) {

			XmlBeansXRoadMetadata curdata = metadata.get(xroadServiceConfiguration.getWsdlDatabase().toLowerCase()
				+ xroadServiceConfiguration.getMethod().toLowerCase());

			if (curdata == null) {
				throw new IllegalStateException(String.format("Could not find metadata for %s.%s! Most likely the method name has been specified incorrectly.",
					xroadServiceConfiguration.getWsdlDatabase().toLowerCase(),
					xroadServiceConfiguration.getMethod().toLowerCase()));
			}
			
			return super.sendRequest(input, xroadServiceConfiguration, callback, new Digiluguv6XRoadConsumerMessageExtractor(curdata));
		}
		return super.sendRequest(input, xroadServiceConfiguration, callback, extractor);
	}
	
}
