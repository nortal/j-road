package com.nortal.jroad.client.kirst;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.TvlLoetelu2ResponseType;

import java.util.Date;
import java.util.Set;
/**
 * <code>kirst</code> (Kindlustatud Isikute Register) database X-tee service.
 * 
 * @author Roman Tekhov
 */
public interface KirstXTeeService {

  /**
   * <code>kirst.tvl_loetelu2.v1</code> service.
   */
  TvlLoetelu2ResponseType findTvlLoetelu2V1(Set<String> isikukoodid, Date alates, Date kuni) throws XRoadServiceConsumptionException;

}
