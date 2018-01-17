package com.nortal.jroad.client.rrv5;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR435Response;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR436Response;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR71FailDownloadResponse;
import java.util.List;

/**
 * <code>RRv5</code> (Rahvastikuregister) database X-tee service.
 * 
 * @author Anti Orgla
 */
public interface Rrv5XTeeService {

  /**
   * <code>rr.RR435.v1</code> service.
   */
  RR435Response findRR435(String legalCode)
      throws XRoadServiceConsumptionException;

  /**
   * <code>rr.RR436.v1</code> service.
   */
  RR436Response findRR436(List<String> idCodes)
      throws XRoadServiceConsumptionException;

  public RR71FailDownloadResponse findRR71(String orderNr) throws XRoadServiceConsumptionException;

}
