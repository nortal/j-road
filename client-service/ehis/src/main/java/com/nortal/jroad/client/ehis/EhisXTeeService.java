package com.nortal.jroad.client.ehis;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.PolOppurVastus;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadVastus.Isikud.Isik;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

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
