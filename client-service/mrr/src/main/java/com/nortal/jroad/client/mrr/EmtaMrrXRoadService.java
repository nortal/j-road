package com.nortal.jroad.client.mrr;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.mrr.types.eu.x_road.emta_v6.SkaMitteresidentResponseDocument;

/**
 * mkrliides namespace in wsdl is emta-v6
 *
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
public interface EmtaMrrXRoadService {

  /**
   * <code>mrr.skaMitteresident.v1</code> service.
   */
  SkaMitteresidentResponseDocument.SkaMitteresidentResponse skaMitteresident(String registreerimiskood)
      throws XRoadServiceConsumptionException;

}
