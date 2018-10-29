package com.nortal.jroad.endpoint;

import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.util.header.XRoadHeader;
import com.nortal.jroad.util.header.XRoadHeaderUtil;
import org.w3c.dom.Document;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

/**
 * This is a wrapper class for JRoad XRoad Endpoint implementation.
 * This handles the headers better as the headers can have multiple levels.
 * Use xRoadHeader instead of the xTeeHeader.
 *
 * @param <T>
 */
public class AbstractXTeeJaxbWithHeaderEndpoint<T> extends AbstractXTeeJAXBEndpoint<T> {
  protected XRoadHeader getXRoadHeader(XTeeMessage<?> message) {
    return getXRoadHeader(message);
  }

  protected XRoadHeader getXRoadHeader(SOAPMessage message) {
    try {
      return metaService ? null : XRoadHeaderUtil.parseXRoadHeader(message);
    } catch (SOAPException e) {
      throw new RuntimeException(e);
    }
  }
}
