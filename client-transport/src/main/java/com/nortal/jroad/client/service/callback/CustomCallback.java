package com.nortal.jroad.client.service.callback;

import org.springframework.ws.client.core.WebServiceMessageCallback;

/**
 * Custom callback that has a setter for the original callback used. Can be used to alter request messages after
 * marshalling, that are not WSDL compliant or just override the logic entirely.
 * 
 * @author Dmitri Danilkin
 */
public abstract class CustomCallback implements WebServiceMessageCallback {
  protected WebServiceMessageCallback callback;

  public void setOriginalCallback(WebServiceMessageCallback callback) {
    this.callback = callback;
  }
}
