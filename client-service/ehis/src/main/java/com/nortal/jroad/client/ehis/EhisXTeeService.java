package com.nortal.jroad.client.ehis;

import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.*;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Margus Hanni
 */
public interface EhisXTeeService {

  /**
   * <code>ehis.tootukassale_kehtivad.v1</code> service.
   */
  List<TootukassaleKehtivadIsik> findTootukassaleKehtivad(Date algkuup, Date loppkuup, String... isikukoodid)
      throws XTeeServiceConsumptionException;

  /**
   * <code>ehis.tootukassale_kehtivad_v2.v1</code> service.
   */
  List<TootukassaleKehtivadV2Isik> findTootukassaleKehtivadV2(Date algusKp, Date loppKp, String... isikukoodid)
      throws XTeeServiceConsumptionException;

  PolOppurVastus findPolOppur(String isikukood, Calendar algKp, Calendar loppKp) throws XTeeServiceConsumptionException;

  /**
   * <code>ehis.tootukassale_oppimised_tellimus.v1</code> service.
   */
  TootukassaleOppimisedTellimusVastus submitTootukassaleOppimisedTellimusV1(Date algusKp, Date loppKp, BigInteger tkId, String... isikukoodid)
      throws XTeeServiceConsumptionException;

  /**
   * <code>ehis.tootukassale_oppimised_vastus.v1</code> service.
   */
  TootukassaleOppimisedVastusVastus getTootukassaleOppimisedVastusV1(BigInteger tkId)
      throws XTeeServiceConsumptionException;
  
  /**
   * <code>ehis.tootukassale_tegevusload.v1</code> service.
   */
  TootukassaleTegevusloadVastus getTootukassaleTegevusload(String registrikood, Date algusKp, Date loppKp)
      throws XTeeServiceConsumptionException;
}
