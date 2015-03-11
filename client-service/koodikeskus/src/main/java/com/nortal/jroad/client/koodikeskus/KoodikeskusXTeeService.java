package com.nortal.jroad.client.koodikeskus;

import java.util.Date;
import java.util.List;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.ATCKlassifikaator;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Haigus;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Hinnakokkulepe;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Myygiluba;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Pakend;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Piirhind;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Ravimvorm;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Soodustus;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Toimeaine;

/**
 * Koodikeskus database X-tee service.
 *
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public interface KoodikeskusXTeeService {

  /**
   * <code>koodikeskus.toimeained.v1</code> service.
   */
  List<String> findToimeainedv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.toimeainedByIDArray.v1</code> service.
   */
  List<Toimeaine> findToimeainedDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.ravimvormid.v1</code> service.
   */
  List<String> findRavimvormidv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.ravimvormidByIDArray.v1</code> service.
   */
  List<Ravimvorm> findRavimvormidDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.ATCKlassifikaatorid.v1</code> service.
   */
  List<String> findATCKlassifikaatoridv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.ATCKlassifikaatoridByIDArray.v1</code> service.
   */
  List<ATCKlassifikaator> findATCKlassifikaatoridDetailandmedv1(List<String> items)
      throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.pakendid.v1</code> service.
   */
  List<String> findPakendidv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.PakendidByIDArray.v1</code> service.
   */
  List<Pakend> findPakendidDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.haigused.v1</code> service.
   */
  List<String> findHaigusedv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.haigusedByIDArray.v1</code> service.
   */
  List<Haigus> findHaigusedDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.soodustused.v1</code> service.
   */
  List<String> findSoodustusedv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.soodustusedByIDArray.v1</code> service.
   */
  List<Soodustus> findSoodustusedDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.piirhinnad.v1</code> service.
   */
  List<String> findPiirhinnadv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.soodustusedByIDArray.v1</code> service.
   */
  List<Piirhind> findPiirhinnadDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.hinnakokkulepped.v1</code> service.
   */
  List<String> findHinnakokkuleppedv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.hinnakokkuleppedByIDArray.v1</code> service.
   */
  List<Hinnakokkulepe> findHinnakokkuleppedDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.myygiload.v1</code> service.
   */
  List<String> findMyygiloadv1(Date date) throws XTeeServiceConsumptionException;

  /**
   * <code>koodikeskus.myygiloadByIDArray.v1</code> service.
   */
  List<Myygiluba> findMyygiloadDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException;
}
