package com.nortal.jroad.client.service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.model.XRoadMessage;

public interface XroadDatabaseClient {

  <I, O> XRoadMessage<O> send(XRoadMessage<I> input, String method, String version)
      throws XRoadServiceConsumptionException;

  <I, O> XRoadMessage<O> send(XRoadMessage<I> input,
                             String method,
                             String version,
                             CustomCallback callback,
                             CustomExtractor extractor) throws XRoadServiceConsumptionException;


  String getDatabase();
}
