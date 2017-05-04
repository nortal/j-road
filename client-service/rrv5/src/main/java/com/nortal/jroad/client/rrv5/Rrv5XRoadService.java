package com.nortal.jroad.client.rrv5;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rrv5.types.eu.x_road.rr.producer.RR435ResponseDocument.RR435Response;
import com.nortal.jroad.client.rrv5.types.eu.x_road.rr.producer.RR436ResponseDocument.RR436Response;
import com.nortal.jroad.client.rrv5.types.eu.x_road.rr.producer.RR71FailDownloadResponseDocument.RR71FailDownloadResponse;

import java.util.List;

/**
 * <code>RRv5</code> (Rahvastikuregister) database X-tee service.
 * 
 * @author Anti Orgla
 */
public interface Rrv5XRoadService {

  /**
   * <code>rr.RR435.v1</code> service.
   */
  RR435Response findRR435(String legalCode) throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR436.v1</code> service.
   */
  RR436Response findRR436(List<String> idCodes) throws XTeeServiceConsumptionException;

  public RR71FailDownloadResponse findRR71(String orderNr) throws XTeeServiceConsumptionException;

  Integer getState() throws XTeeServiceConsumptionException;
}
