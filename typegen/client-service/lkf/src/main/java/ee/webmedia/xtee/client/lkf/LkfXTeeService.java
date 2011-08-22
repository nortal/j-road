package ee.webmedia.xtee.client.lkf;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.AadressVastus;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingParing;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingVastus;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskateVastus;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.RomudeOtsingVastus;
import java.util.Calendar;


/**
 * <code>lkf</code> (Eesti Liikluskindlustuse Fond) database X-tee service.
 */
public interface LkfXTeeService {
	
  /**
   * <code>lkf.kindlustuskate.v1</code> service.
   */
  KindlustuskateVastus findKindlustuskate(String registrinumber, String tehasetahis) throws XTeeServiceConsumptionException;
	
  /**
   * <code>lkf.aadress.v1</code> service.
   */
  AadressVastus findAadress(String isikukood) throws XTeeServiceConsumptionException;

  /**
   * <code>lkf.romude_otsing.v1</code> service.
   */
  RomudeOtsingVastus romudeOtsing(Calendar startDate, Calendar endDate) throws XTeeServiceConsumptionException;
  
  /**
   *<code>lkf.kindlustuskaitse_otsing.v1</code> 
   */
  KindlustuskaitseOtsingVastus kindlustusKaitseOtsing(KindlustuskaitseOtsingParing paring) throws XTeeServiceConsumptionException;
}
