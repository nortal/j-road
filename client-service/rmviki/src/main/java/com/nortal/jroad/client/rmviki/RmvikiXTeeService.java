package com.nortal.jroad.client.rmviki;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaResponseType;
import com.nortal.jroad.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR;
import com.nortal.jroad.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse;

/**
 * @author Kauri Kägo (kauri@nortal.com)
 */
public interface RmvikiXTeeService {

  /**
   * <code>rmviki.Z_RKOVAR.v1</code> X-tee service.
   */
  ZRKOVARResponse zRKOVARV1(String kood) throws XTeeServiceConsumptionException;

  /**
   * Returns first not empty ZRKOVAR object, which KOOD is not empty,
   * from response. 
   */
  ZRKOVAR getZrkovarFromResponse(ZRKOVARResponse response);
  
  /**
   * <code>rmviki.rarVta.v1</code> X-tee service.
   */
  RarVtaResponseType rarVtaV1(String kood) throws XTeeServiceConsumptionException;
}
