package ee.webmedia.xtee.client.pkr;

import java.util.Calendar;
import java.util.Date;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis1Vastus;
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

  /**
   * <code>pkr.tkis1</code> service.
   */
  Tkis1Vastus getTkis1(String isikukood, Date algusKuup, Date loppKuup, Date kuup) throws XTeeServiceConsumptionException;
}
