package ee.webmedia.xtee.client.pkr;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus;

/**
 * <code>PKR</code> or <code>TPKR</code> X-tee service
 * 
 * @author Margus Hanni
 */
public interface PkrXTeeService {

  /**
   * <code>pkr.tta_pension_toetus</code> service.
   */
  TtaPensionToetusVastus getPensionToetus(String isikukood) throws XTeeServiceConsumptionException;
}
