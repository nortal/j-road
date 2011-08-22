package ee.webmedia.xtee.client.service.consumer;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.callback.CustomCallback;
import ee.webmedia.xtee.client.service.configuration.XTeeServiceConfiguration;
import ee.webmedia.xtee.client.service.extractor.CustomExtractor;
import ee.webmedia.xtee.model.XTeeMessage;

/**
 * Service consumer which actas as a high level abstraction for X-tee data exchange processes.
 * 
 * @author Roman Tekhov
 */
public interface XTeeConsumer {

  /**
   * Performs an invocation of some X-tee service.
   * 
   * @param <I> input object type
   * @param <O> output object type
   * @param input Java object representing the request
   * @param xTeeServiceConfiguration service configuration data
   * @return Java object representing the response
   */
  <I, O> XTeeMessage<O> sendRequest(XTeeMessage<I> input, XTeeServiceConfiguration xTeeServiceConfiguration)
      throws XTeeServiceConsumptionException;

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
  <I, O> XTeeMessage<O> sendRequest(XTeeMessage<I> input,
                                    XTeeServiceConfiguration xTeeServiceConfiguration,
                                    CustomCallback callback,
                                    CustomExtractor extractor) throws XTeeServiceConsumptionException;

}
