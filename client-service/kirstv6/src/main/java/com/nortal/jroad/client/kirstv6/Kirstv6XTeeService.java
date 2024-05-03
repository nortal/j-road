package com.nortal.jroad.client.kirstv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2ResponseType;

/**
 * <code>kirstv6</code> (Kindlustatud Isikute Register) database X-tee v6 service.
 *
 * @author Merilyn Renser
 */
public interface Kirstv6XTeeService {

  /**
   * <code>kirstv6.kindlustused2.v1</code> service.
   */
  Kindlustused2ResponseType findKindlustused2(String isikukood, String userId) throws XRoadServiceConsumptionException;
}
