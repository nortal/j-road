package com.nortal.jroad.client.rrv5;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rrv5.types.eu.x_road.rr.producer.RR81KMAisikkontrollResponseDocument.RR81KMAisikkontrollResponse;

/**
 * <code>RRv5</code> (Rahvastikuregister) database X-tee service.
 * 
 * @author Anti Orgla
 */
public interface Rrv5XRoadService {

  Integer getState() throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR81KMAisikkontroll.v2</code> service.
   */
  RR81KMAisikkontrollResponse getRR81KMAisikkontrollV2(String idCode) throws XTeeServiceConsumptionException;

}
