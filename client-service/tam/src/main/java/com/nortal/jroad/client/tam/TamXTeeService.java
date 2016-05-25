package com.nortal.jroad.client.tam;

import java.util.Calendar;
import java.util.List;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.Registriisik;


/**
 * Queries to Health Board (Terviseamet -- TAM)
 * 
 * @author Klaus-Eduard Runnel
 */
public interface TamXTeeService {
  /**
   * <code>tam.registriisik</code> service.
   */
  List<Registriisik> findRegistriisik(String kood) throws XRoadServiceConsumptionException;

  /**
   * <code>tam.tervishoiutootajamuudatuskood</code> service.
   */
  // TODO: types are integers, should use enum map?
  List<String> findTervishoiutootajamuudatuskood(Calendar startDate, Calendar endDate, int... types) throws XRoadServiceConsumptionException;
}
