package com.nortal.jroad.client.ehis;

import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.PolOppurResponseDocument.PolOppurResponse;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadIsik;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadV2Isik;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleOppimisedTellimusResponseDocument.TootukassaleOppimisedTellimusResponse;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleOppimisedVastusResponseDocument.TootukassaleOppimisedVastusResponse;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleTegevusloadResponseDocument.TootukassaleTegevusloadResponse;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Margus Hanni
 */
public interface EhisXRoadService {

  /**
   * <code>ehis.tootukassale_kehtivad.v1</code> service.
   */
  List<TootukassaleKehtivadIsik> findTootukassaleKehtivad(Date algkuup, Date loppkuup, String... isikukoodid)
      throws XRoadServiceConsumptionException;

  /**
   * <code>ehis.tootukassale_kehtivad_v2.v1</code> service.
   */
  List<TootukassaleKehtivadV2Isik> findTootukassaleKehtivadV2(Date algusKp, Date loppKp, String... isikukoodid)
      throws XRoadServiceConsumptionException;

  PolOppurResponse findPolOppur(String isikukood, Calendar algKp, Calendar loppKp)
      throws XRoadServiceConsumptionException;

  /**
   * <code>ehis.tootukassale_oppimised_tellimus.v1</code> service.
   */
  TootukassaleOppimisedTellimusResponse submitTootukassaleOppimisedTellimusV1(Date algusKp,
                                                                              Date loppKp,
                                                                              BigInteger tkId,
                                                                              String... isikukoodid)
      throws XRoadServiceConsumptionException;

  /**
   * <code>ehis.tootukassale_oppimised_vastus.v1</code> service.
   */
  TootukassaleOppimisedVastusResponse getTootukassaleOppimisedVastusV1(BigInteger tkId)
      throws XRoadServiceConsumptionException;

  /**
   * <code>ehis.tootukassale_tegevusload.v1</code> service.
   */
  TootukassaleTegevusloadResponse getTootukassaleTegevusload(String registrikood, Date algusKp, Date loppKp)
      throws XRoadServiceConsumptionException;
}
