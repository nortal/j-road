package com.nortal.jroad.endpoint;

import com.nortal.jroad.util.header.XRoadHeader;
import com.nortal.jroad.util.header.XRoadHeaderUtil;
import org.w3c.dom.Document;

import javax.xml.soap.SOAPMessage;

/**
 * This is a wrapper class for JRoad XRoad Endpoint implementation.
 * This handles the headers better as the headers can have multiple levels.
 * Use xRoadHeader instead of the xTeeHeader.
 *
 * @param <T>
 */
public class AbstractXTeeJaxbWithHeaderEndpoint<T> extends AbstractXTeeJAXBEndpoint<T> {
  private XRoadHeader xroadHeader;

  public XRoadHeader getXRoadHeader() {
    return this.xroadHeader;
  }

  @Override
  protected void getResponse(Document query, SOAPMessage responseMessage, SOAPMessage requestMessage) throws Exception {
    this.xroadHeader = metaService ? null : XRoadHeaderUtil.parseXRoadHeader(requestMessage);
    super.getResponse(query, responseMessage, requestMessage);
  }
}
