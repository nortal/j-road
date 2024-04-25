package com.nortal.jroad.endpoint.v4;

import com.nortal.jroad.mapping.v4.XRoadEndpointMapping;
import com.nortal.jroad.model.v4.XRoadMessage;
import com.nortal.jroad.util.SOAPUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import jakarta.annotation.Resource;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
@Component
public class XroadListMethodsEndpoint extends AbstractXRoadBaseEndpoint {

  private static final Logger log = Logger.getLogger(XroadListMethodsEndpoint.class);
  @Resource
  private XRoadEndpointMapping xRoadEndpointMapping;

  public XroadListMethodsEndpoint() {
    setMetaService(true);
  }

  @Override
  protected void invokeInternal(XRoadMessage<Document> request, XRoadMessage<Element> response) throws Exception {
    SOAPUtil.addTypeAttribute(response.getContent(), "SOAP-ENC:Array");
    SOAPUtil.addArrayTypeAttribute(response.getContent(), "string", xRoadEndpointMapping.getMethods().size());
    SOAPUtil.addArrayOffsetAttribute(response.getContent(), 0);

    for (String meetod : xRoadEndpointMapping.getMethods()) {
      SOAPUtil.addElementTekst(response.getContent(), "item", meetod);
    }
    log.info("Responded to listMethods request.");
  }
}
