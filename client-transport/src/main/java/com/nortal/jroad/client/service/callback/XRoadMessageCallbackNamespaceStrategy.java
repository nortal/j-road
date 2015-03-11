/**
 * Copyright 2009 Webmedia Group Ltd. Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.client.service.callback;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;

import com.nortal.jroad.client.service.configuration.XTeeServiceConfiguration;

/**
 * Adds XRoad query header elements (-- as specified by
 * {@link XTeeServiceConfiguration}) and adds the attachments to message.
 *
 * @author Kait Kasak (kait.kasak@nortal.com)
 */
public class XRoadMessageCallbackNamespaceStrategy extends MessageCallbackNamespaceStrategy {

	/**
	 * sets envelope namespaces to SOAP envelope
	 */
	@Override
	public void addNamespaces(SOAPEnvelope env) throws SOAPException {
		env.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
		env.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		env.addNamespaceDeclaration("xro", "http://x-rd.net/xsd/xroad.xsd");
	}

	@Override
	public void addXTeeHeaderElements(SOAPEnvelope env, XTeeServiceConfiguration serviceConfiguration)
	        throws SOAPException {
		SOAPHeader header = env.getHeader();
		SOAPElement consumer = header.addChildElement("consumer", "xro");
		SOAPElement producer = header.addChildElement("producer", "xro");
		SOAPElement userId = header.addChildElement("userId", "xro");
		SOAPElement id = header.addChildElement("id", "xro");
		SOAPElement service = header.addChildElement("service", "xro");
		String issue = serviceConfiguration.getFile();
		if (issue != null) {
			SOAPElement issueEl = header.addChildElement("issue", "xro");
			issueEl.addTextNode(issue);
		}

		consumer.addAttribute(env.createName("xsi:type"), "xsd:string");
		producer.addAttribute(env.createName("xsi:type"), "xsd:string");
		userId.addAttribute(env.createName("xsi:type"), "xsd:string");
		id.addAttribute(env.createName("xsi:type"), "xsd:string");
		service.addAttribute(env.createName("xsi:type"), "xsd:string");
		consumer.addTextNode(serviceConfiguration.getInstitution());
		producer.addTextNode(serviceConfiguration.getDatabase());
		userId.addTextNode(serviceConfiguration.getIdCode());
		id.addTextNode(generateUniqueMessageId(serviceConfiguration));
		StringBuilder sb = new StringBuilder(serviceConfiguration.getDatabase());
		sb.append(".");
		sb.append(serviceConfiguration.getMethod());
		sb.append(".");
		sb.append(serviceConfiguration.getVersion() == null ? "v1" : serviceConfiguration.getVersion());
		service.addTextNode(sb.toString());
	}

}
