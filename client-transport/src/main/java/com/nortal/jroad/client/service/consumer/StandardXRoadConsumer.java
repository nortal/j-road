package com.nortal.jroad.client.service.consumer;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.service.callback.StandardXTeeConsumerCallback;
import com.nortal.jroad.client.service.callback.XRoadMessageCallbackNamespaceStrategy;
import com.nortal.jroad.client.service.callback.XTeeMessageCallback;
import com.nortal.jroad.client.service.configuration.XTeeServiceConfiguration;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMetadata;

@Service("xRoadConsumer")
public class StandardXRoadConsumer extends StandardXTeeConsumer {

	@Override
	protected boolean isKehaElementNeeded() {
		return false;
	}

	@Override
	protected <I> StandardXTeeConsumerCallback getNewConsumerCallback(XTeeMessage<I> input,
	        XTeeServiceConfiguration xteeServiceConfiguration, XmlBeansXTeeMetadata curdata) {
		return new StandardXTeeConsumerCallback(input.getContent(), getNewMessageCallback(input,
		        xteeServiceConfiguration), getMarshaller(), curdata, true);
	}

	@Override
	protected <I> XTeeMessageCallback getNewMessageCallback(XTeeMessage<I> input,
	        XTeeServiceConfiguration xteeServiceConfiguration) {
		return new XTeeMessageCallback(xteeServiceConfiguration, input.getAttachments(),
		        new XRoadMessageCallbackNamespaceStrategy());
	}

}
