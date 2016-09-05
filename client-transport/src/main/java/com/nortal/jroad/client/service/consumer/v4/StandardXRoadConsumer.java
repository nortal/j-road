package com.nortal.jroad.client.service.consumer.v4;

import com.nortal.jroad.client.service.callback.StandardXTeeConsumerCallback;
import com.nortal.jroad.client.service.callback.v4.StandardXRoadConsumerCallback;
import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

import com.nortal.jroad.client.service.callback.XTeeMessageCallback;
import com.nortal.jroad.client.service.callback.v4.XRoadMessageCallbackNamespaceStrategy;
import com.nortal.jroad.client.service.consumer.v2.StandardXTeeConsumer;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import org.springframework.stereotype.Service;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
@Service("xRoadV4Consumer")
public class StandardXRoadConsumer extends StandardXTeeConsumer {

  @Override
  protected String getNamespace(BaseXRoadServiceConfiguration xteeServiceConfiguration) {
    return String.format("http://%s.x-road.eu/producer", xteeServiceConfiguration.getDatabase());
  }

  @Override
  protected <I> StandardXTeeConsumerCallback getNewConsumerCallback(XTeeMessage<I> input,
                                                                    BaseXRoadServiceConfiguration xteeServiceConfiguration,
                                                                    XmlBeansXTeeMetadata curdata) {
    return new StandardXRoadConsumerCallback(input.getContent(),
                                             getNewMessageCallback(input, xteeServiceConfiguration),
                                             getMarshaller(),
                                             curdata,
                                             getNamespace(xteeServiceConfiguration),
                                             isEncodingStyleNeeded());
  }

  @Override
  protected <I> XTeeMessageCallback getNewMessageCallback(XTeeMessage<I> input,
                                                          BaseXRoadServiceConfiguration xteeServiceConfiguration) {
    return new XTeeMessageCallback(xteeServiceConfiguration,
                                   input.getAttachments(),
                                   new XRoadMessageCallbackNamespaceStrategy());
  }

  @Override
  protected boolean isKehaElementNeeded() {
    return false;
  }

  @Override
  protected boolean isEncodingStyleNeeded() {
    return false;
  }
}
