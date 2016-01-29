package com.nortal.jroad.client.service.consumer.v3;

import com.nortal.jroad.client.service.configuration.BaseXRoadServiceConfiguration;

import com.nortal.jroad.client.service.consumer.v2.StandardXTeeConsumer;
import com.nortal.jroad.client.service.callback.v3.XRoadMessageCallbackNamespaceStrategy;
import com.nortal.jroad.client.service.callback.XTeeMessageCallback;
import com.nortal.jroad.model.XTeeMessage;
import org.springframework.stereotype.Service;

@Service("xRoadConsumer")
public class StandardXRoadConsumer extends StandardXTeeConsumer {

  @Override
  protected boolean isKehaElementNeeded() {
    return false;
  }

  @Override
  protected String getNamespace(BaseXRoadServiceConfiguration xteeServiceConfiguration) {
    return String.format("http://%s.ee.x-rd.net/producer", xteeServiceConfiguration.getDatabase());
  }

  @Override
  protected boolean isEncodingStyleNeeded() {
    return false;
  }

  @Override
  protected <I> XTeeMessageCallback getNewMessageCallback(XTeeMessage<I> input,
                                                          BaseXRoadServiceConfiguration xteeServiceConfiguration) {
    return new XTeeMessageCallback(xteeServiceConfiguration,
                                   input.getAttachments(),
                                   new XRoadMessageCallbackNamespaceStrategy());
  }

}
