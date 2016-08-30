package com.nortal.jroad.client.service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.model.XTeeMessage;

public interface XroadDatabaseClient {

  <I, O> XTeeMessage<O> send(XTeeMessage<I> input, String method, String version)
      throws XTeeServiceConsumptionException;

  <I, O> XTeeMessage<O> send(XTeeMessage<I> input,
                             String method,
                             String version,
                             CustomCallback callback,
                             CustomExtractor extractor) throws XTeeServiceConsumptionException;

}
