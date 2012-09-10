package ee.webmedia.xtee.client.service.consumer;

import org.springframework.stereotype.Service;

import ee.webmedia.xtee.client.service.callback.StandardXTeeConsumerCallback;
import ee.webmedia.xtee.client.service.callback.XRoadMessageCallbackNamespaceStrategy;
import ee.webmedia.xtee.client.service.callback.XTeeMessageCallback;
import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMetadata;

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
