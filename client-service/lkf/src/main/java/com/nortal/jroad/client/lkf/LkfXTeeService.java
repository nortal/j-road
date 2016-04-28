package com.nortal.jroad.client.lkf;

import java.util.Calendar;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.AadressVastus;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingParing;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingVastus;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskateVastus;
import com.nortal.jroad.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.RomudeOtsingVastus;


/**
 * <code>lkf</code> (Eesti Liikluskindlustuse Fond) database X-tee service.
 */
public interface LkfXTeeService {
	
  /**
   * <code>lkf.kindlustuskate.v1</code> service.
   */
  KindlustuskateVastus findKindlustuskate(String registrinumber, String tehasetahis) throws XRoadServiceConsumptionException;
	
  /**
   * <code>lkf.aadress.v1</code> service.
   */
  AadressVastus findAadress(String isikukood) throws XRoadServiceConsumptionException;

  /**
   * <code>lkf.romude_otsing.v1</code> service.
   */
  RomudeOtsingVastus romudeOtsing(Calendar startDate, Calendar endDate) throws XRoadServiceConsumptionException;
  
  /**
   *<code>lkf.kindlustuskaitse_otsing.v1</code> 
   */
  KindlustuskaitseOtsingVastus kindlustusKaitseOtsing(KindlustuskaitseOtsingParing paring) throws XRoadServiceConsumptionException;
}
