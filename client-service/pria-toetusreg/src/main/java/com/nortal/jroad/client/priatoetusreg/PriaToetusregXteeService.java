package com.nortal.jroad.client.priatoetusreg;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.priatoetusreg.types.ee.riik.xtee.pria_toetusreg.producers.producer.pria_toetusreg.VtaJaakResponse;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
public interface PriaToetusregXteeService {
  VtaJaakResponse vtaJaakV1ByIsikukood(String isikukood) throws XRoadServiceConsumptionException;

  VtaJaakResponse vtaJaakV1ByRegistrikood(String registrikood) throws XRoadServiceConsumptionException;

  VtaJaakResponse vtaJaakV1(String isikukood, String registrikood) throws XRoadServiceConsumptionException;
}
