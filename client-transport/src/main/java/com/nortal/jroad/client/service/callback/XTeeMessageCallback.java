/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.client.service.callback;

import java.util.Collection;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import com.nortal.jroad.client.service.configuration.XTeeServiceConfiguration;
import com.nortal.jroad.model.XTeeAttachment;

/**
 * <code>WebServiceMessageCallback</code> implementation that sets envelope
 * namespaces for SOAP envelope.
 *
 * @author Rando Mihkelsaar
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public class XTeeMessageCallback implements WebServiceMessageCallback {

	private final Collection<XTeeAttachment> attachments;
	private final XTeeServiceConfiguration serviceConfiguration;
	private MessageCallbackNamespaceStrategy namespaceStrategy;

	public XTeeMessageCallback(XTeeServiceConfiguration serviceConfiguration, Collection<XTeeAttachment> attachments,
	        MessageCallbackNamespaceStrategy namespaceStrategy) {
		this.serviceConfiguration = serviceConfiguration;
		this.attachments = attachments;
		this.namespaceStrategy = namespaceStrategy;
	}

	public void doWithMessage(WebServiceMessage message) {
		SaajSoapMessage saajMessage = (SaajSoapMessage) message;
		try {
			// Add attachments
			if (attachments != null) {
				for (XTeeAttachment attachment : attachments) {
					saajMessage.addAttachment("<" + attachment.getCid() + ">", attachment, attachment.getContentType());
				}
			}
			SOAPMessage soapmess = saajMessage.getSaajMessage();
			SOAPEnvelope env = soapmess.getSOAPPart().getEnvelope();

			namespaceStrategy.addNamespaces(env);
			namespaceStrategy.addXTeeHeaderElements(env, serviceConfiguration);
		} catch (SOAPException e) {
			throw new RuntimeException(e);
		}
	}

	public XTeeServiceConfiguration getServiceConfiguration() {
		return serviceConfiguration;
	}

}
