package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kvkr.types.ee.x_road.kvkr.producer.ServiceinfoResponseDocument;

public interface KvkrXTeeService {

  /**
   * <code>kvkr.serviceinfo.v1</code> service.
   *
   * @param nationalIdCode Isikukood
   * @param queryGrounds   Päringu sooritamise põhjus
   */
  ServiceinfoResponseDocument.ServiceinfoResponse getServiceinfoV1(String nationalIdCode, String queryGrounds) throws XTeeServiceConsumptionException;

}