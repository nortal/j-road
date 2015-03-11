/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.client.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

/**
 * Simple logging interceptor that logs all the web service invocation results on 'debug' level.
 * 
 * @author Rando Mihkelsaar
 * @author Roman Tekhov
 */
public class WSConsumptionLoggingInterceptor implements ClientInterceptor {
  private final static Logger log = Logger.getLogger(WSConsumptionLoggingInterceptor.class);

  private static enum MessageType {

    REQUEST, RESPONSE, FAULT;
  }

  /**
   * X-tee soap fault messages are different than ordinary SOAP fault messages.
   */
  public boolean handleFault(MessageContext mc) throws WebServiceClientException {
    return logMessage(mc, MessageType.FAULT);
  }

  public boolean handleRequest(MessageContext mc) throws WebServiceClientException {
    return logMessage(mc, MessageType.REQUEST);
  }

  public boolean handleResponse(MessageContext mc) throws WebServiceClientException {
    return logMessage(mc, MessageType.RESPONSE);
  }

  private boolean logMessage(MessageContext mc, MessageType messageType) {
    if (log.isDebugEnabled()) {
      WebServiceMessage message = MessageType.REQUEST.equals(messageType) ? mc.getRequest() : mc.getResponse();

      if (message instanceof SaajSoapMessage) {
        OutputStream out = new ByteArrayOutputStream();
        try {
          ((SaajSoapMessage) message).writeTo(out);
          log.debug(messageType + " message follows:\n" + out.toString());
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }

    return true;
  }

  public void afterCompletion(MessageContext arg0, Exception arg1) throws WebServiceClientException {}

}
