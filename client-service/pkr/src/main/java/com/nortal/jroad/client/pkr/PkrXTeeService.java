package com.nortal.jroad.client.pkr;

import java.util.Calendar;
import java.util.Date;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis1Vastus;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus;

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
