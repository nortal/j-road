package com.nortal.jroad.client.service.extractor;

import org.springframework.ws.client.core.WebServiceMessageExtractor;

/**
 * Custom extractor that has a setter for the original extractor used. Can be used to alter response messages that are
 * not WSDL compliant, so that they can be unmarshalled properly.
 * 
 * @author Dmitri Danilkin
 */
@SuppressWarnings("rawtypes")
public abstract class CustomExtractor implements WebServiceMessageExtractor {
  protected WebServiceMessageExtractor extractor;

  public void setOriginalExtractor(WebServiceMessageExtractor extractor) {
    this.extractor = extractor;
  }
}
