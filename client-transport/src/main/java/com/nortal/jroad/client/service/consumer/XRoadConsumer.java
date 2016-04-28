package com.nortal.jroad.client.service.consumer;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.model.XRoadMessage;

/**
 * Service consumer which act as as a high level abstraction for X-Road data exchange processes.
 *
 * @author Roman Tekhov
 */
public interface XRoadConsumer {

  /**
   * Performs an invocation of some X-tee service.
   *
   * @param <I> input object type
   * @param <O> output object type
   * @param input Java object representing the request
   * @param xTeeServiceConfiguration service configuration data
   * @return Java object representing the response
   */
  <I, O> XRoadMessage<O> sendRequest(XRoadMessage<I> input, XRoadServiceConfiguration xTeeServiceConfiguration)
      throws XRoadServiceConsumptionException;

  /**
   * Performs an invocation of some X-tee service.
   *
   * @param <I> input object type
   * @param <O> output object type
   * @param input Java object representing the request
   * @param xTeeServiceConfiguration service configuration data
   * @param callback Custom callback to invoke for sending the message
   * @param extractor Custom extractor to invoke for extracting the message
   * @return Java object representing the response
   */
  <I, O> XRoadMessage<O> sendRequest(XRoadMessage<I> input,
                                     XRoadServiceConfiguration xTeeServiceConfiguration,
                                     CustomCallback callback,
                                     CustomExtractor extractor) throws XRoadServiceConsumptionException;

}
