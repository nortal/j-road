package com.nortal.jroad.client.emta;

import java.util.Calendar;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.EmtaFieTooandjadJaSotsmVastus;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.FieIsikAndmed;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.Periood;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.SissetulekResponse;
import com.nortal.jroad.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.VptValjund;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * <code>emta</code> (Maksu- ja Tolliamet) database X-tee service.
 * 
 * @author Roman Tekhov
 * @author Dmitri Danilkin
 */
public interface EmtaXTeeService {

  /**
   * <code>emta.xteeKindlustus.v2</code> service.
   */
  List<Periood> findXteeKindlustusV2(String isikukood, Date algkuup, Date loppkuup)
      throws XTeeServiceConsumptionException;

  /**
   * <code>emta.xteeFieAndmed.v1</code> service.
   */
  List<FieIsikAndmed> findXteeFieAndmed(String isikukood) throws XTeeServiceConsumptionException;
  
  /**
   * <code>emta.xteeFieAndmed.v1</code> service.
   */
  SissetulekResponse findSissetulek(String isikukood, BigInteger aasta) throws XTeeServiceConsumptionException;
  
  /**
   * <code>emta.vpt.v1</code> service.
   */
  VptValjund findXteeVpt(String kood, Calendar millal) throws XTeeServiceConsumptionException;
  
  /**
   * <code>emta.xteeFieTooandjadJaSotsm.v1</code> service.
   */
  EmtaFieTooandjadJaSotsmVastus findXteeFieTooandjadJaSotsm(String isikukood, Date algkuup, Date loppkuup) throws XTeeServiceConsumptionException;
}
