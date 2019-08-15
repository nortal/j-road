package com.nortal.jroad.client.kvkr3;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.ServiceInfoV1ResponseDocument;

public interface Kvkr3XRoadService {
  /**
   * <code>kvkr.serviceinfo.v1</code> service.
   *
   * @param nationalIdCode Isikukood
   * @param queryGrounds   Päringu sooritamise põhjus
   */
  ServiceInfoV1ResponseDocument.ServiceInfoV1Response getServiceinfoV1(String nationalIdCode, String queryGrounds) throws XTeeServiceConsumptionException;
}
