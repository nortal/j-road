package ee.webmedia.xtee.client.rmviki;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaResponseType;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVAR;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse;

/**
 * @author Kauri Kägo (kauri@webmedia.ee)
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
