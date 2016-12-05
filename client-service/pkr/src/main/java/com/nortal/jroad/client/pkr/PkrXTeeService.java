package com.nortal.jroad.client.pkr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.ERIHK1ResponseDocument;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Valjund;

import java.util.Date;
import java.util.List;

/**
 * <code>PKR</code> or <code>TPKR</code> X-tee service
 * 
 * @author Margus Hanni
 */
public interface PkrXTeeService {

  /**
   * <code>pkr.tkis2.v1</code> service.
   */
  Tkis2Valjund getTkis2V1(String isikukood, Date algusKuup, Date loppKuup) throws XTeeServiceConsumptionException;

  /**
   * <code>pkr.ERIHK1.v1</code> service.
   */
  ERIHK1ResponseDocument.ERIHK1Response getTkisErihkVastus(List<String> isikukoodid, Date algusKuup, Date loppKuup) throws XTeeServiceConsumptionException;
}
