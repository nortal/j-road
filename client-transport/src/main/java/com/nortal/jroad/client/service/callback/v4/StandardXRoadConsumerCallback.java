package com.nortal.jroad.client.service.callback.v4;

import com.nortal.jroad.client.service.callback.StandardXTeeConsumerCallback;
import com.nortal.jroad.client.service.callback.XTeeMessageCallback;
import com.nortal.jroad.model.XmlBeansXTeeMetadata;
import org.springframework.oxm.Marshaller;

public class StandardXRoadConsumerCallback extends StandardXTeeConsumerCallback {

  public StandardXRoadConsumerCallback(Object object,
                                       XTeeMessageCallback callback,
                                       Marshaller marshaller,
                                       XmlBeansXTeeMetadata metadata,
                                       String namespace,
                                       boolean setEncodingStyle) {
    super(object, callback, marshaller, metadata, namespace, setEncodingStyle);
  }

  @Override
  protected String getRequestElementName(XmlBeansXTeeMetadata metadata) {
    return metadata.getRequestElementName();
  }

  @Override
  protected String getRequestElementNs(XmlBeansXTeeMetadata metadata) {
    return metadata.getRequestElementNs();
  }

}
