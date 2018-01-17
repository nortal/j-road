/**
 * Copyright 2015 Nortal Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 **/

package com.nortal.jroad.endpoint;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.nortal.jroad.mapping.XTeeEndpointMapping;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.util.SOAPUtil;

/**
 * Implements <code>listMethods</code> metaservice, which is mandatory for X-Tee adapter server and will be called only
 * by database's own security server.
 * 
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com) - protocol 4.0
 */
@Component
public class ListMethodsEndpoint extends AbstractXTeeBaseEndpoint {
  private static final Logger log = Logger.getLogger(ListMethodsEndpoint.class);
  @Resource
  private XTeeEndpointMapping xRoadEndpointMapping;

  public ListMethodsEndpoint() {
    setMetaService(true);
  }

  @Override
  protected void invokeInternal(XTeeMessage<Document> request, XTeeMessage<Element> response) throws Exception {
    SOAPUtil.addTypeAttribute(response.getContent(), "SOAP-ENC:Array");
    SOAPUtil.addArrayTypeAttribute(response.getContent(), "string", xRoadEndpointMapping.getMethods().size());
    SOAPUtil.addArrayOffsetAttribute(response.getContent(), 0);

    for (String meetod : xRoadEndpointMapping.getMethods()) {
      SOAPUtil.addElementTekst(response.getContent(), "item", meetod);
    }
    log.info("Responded to listMethods request.");
  }
}
