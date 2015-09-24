package com.nortal.jroad.client.digilugu;

import com.nortal.jroad.client.digilugu.types.hl7WErUTorgV3.RCMRIN000032UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7_orgV3.RCMRIN000029UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7_orgV3.RCMRIN000031UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7_orgV3.RCMRIN000030UV01Document;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * <code>digilugu</code> database X-tee service.
 * 
 * @author Romet Piho
 */
public interface DigiluguXTeeService {

	/**
	 * <code>digilugu.hl7</code> service document query.
	 */
  RCMRIN000030UV01Document getHl7Document(RCMRIN000029UV01Document input) throws XTeeServiceConsumptionException;
  
  /**
   * <code>digilugu.hl7</code> service TSK query.
   */
  RCMRIN000032UV01Document getHl7TSK(RCMRIN000031UV01Document input) throws XTeeServiceConsumptionException;

}