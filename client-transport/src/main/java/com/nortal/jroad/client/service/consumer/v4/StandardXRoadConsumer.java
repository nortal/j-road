package com.nortal.jroad.client.service.consumer.v4;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

import com.nortal.jroad.client.service.callback.XTeeMessageCallback;
import com.nortal.jroad.client.service.callback.v4.XRoadMessageCallbackNamespaceStrategy;
import com.nortal.jroad.client.service.consumer.v2.StandardXTeeConsumer;
import com.nortal.jroad.model.XTeeMessage;
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
