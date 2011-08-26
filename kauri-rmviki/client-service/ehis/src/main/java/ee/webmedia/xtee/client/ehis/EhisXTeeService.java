package ee.webmedia.xtee.client.ehis;

import ee.webmedia.xtee.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.PolOppurVastus;
import java.util.Calendar;

import ee.webmedia.xtee.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadVastus.Isikud.Isik;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import java.util.Date;
import java.util.List;

/**
 * <code>ehis</code> (teenus töötukassale kehtivad) database X-tee service.
 * 
 * @author Margus Hanni
 */
public interface EhisXTeeService {

  /**
   * <code>ehis.tootukassale_kehtivad.v1</code> service.
   */
  List<Isik> findTootukassaleKehtivad(Date algkuup, Date loppkuup, String... isikukoodid)
      throws XTeeServiceConsumptionException;
  
  PolOppurVastus findPolOppur(String isikukood, Calendar algKp, Calendar loppKp) throws XTeeServiceConsumptionException;
}
