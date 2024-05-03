package com.nortal.jroad.client.kvkr3;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.producer.ServiceInfoV1Response;

public interface Kvkr3XRoadService {
  /**
   * <code>kvkr.serviceinfo.v1</code> service.
   *
   * @param nationalIdCode Isikukood
   * @param queryGrounds   Päringu sooritamise põhjus
   */
  ServiceInfoV1Response getServiceinfoV1(String nationalIdCode, String queryGrounds) throws XRoadServiceConsumptionException;
}
