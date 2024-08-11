/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.client.service.callback;

import java.util.Collection;

import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.nortal.jroad.client.service.configuration.XRoadServiceConfiguration;
import com.nortal.jroad.model.XRoadAttachment;

/**
 * <code>WebServiceMessageCallback</code> implementation that sets envelope namespaces for SOAP envelope.
 *
 * @author Rando Mihkelsaar
 * @author Kait Kasak (kait.kasak@nortal.com)
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
public class XRoadMessageCallback implements WebServiceMessageCallback {

  private final Collection<XRoadAttachment> attachments;
  private final XRoadServiceConfiguration serviceConfiguration;
  private MessageCallbackNamespaceStrategy protocolVersionStrategy;

  public XRoadMessageCallback(XRoadServiceConfiguration serviceConfiguration, Collection<XRoadAttachment> attachments) {
    this.serviceConfiguration = serviceConfiguration;
    this.attachments = attachments;
    this.protocolVersionStrategy = new XRoadProtocolNamespaceStrategyV4();
  }

  public void doWithMessage(WebServiceMessage wsMessage) {
    SaajSoapMessage saajMessage = (SaajSoapMessage) wsMessage;
    try {
      // Add attachments
      if (attachments != null) {
        for (XRoadAttachment attachment : attachments) {
          saajMessage.addAttachment("<" + attachment.getCid() + ">", attachment, attachment.getContentType());
        }
      }
      SOAPMessage soapMessage = saajMessage.getSaajMessage();
      SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();

      protocolVersionStrategy.addNamespaces(envelope);
      protocolVersionStrategy.addXRoadHeaderElements(envelope, serviceConfiguration);
    } catch (SOAPException e) {
      throw new RuntimeException(e);
    }
  }

  public XRoadServiceConfiguration getServiceConfiguration() {
    return serviceConfiguration;
  }

}
