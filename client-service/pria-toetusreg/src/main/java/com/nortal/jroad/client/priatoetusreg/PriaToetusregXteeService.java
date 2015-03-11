package com.nortal.jroad.client.priatoetusreg;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.priatoetusreg.types.ee.riik.xtee.pria_toetusreg.producers.producer.pria_toetusreg.VtaJaakResponse;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
public interface PriaToetusregXteeService {
  VtaJaakResponse vtaJaakV1ByIsikukood(String isikukood) throws XTeeServiceConsumptionException;

  VtaJaakResponse vtaJaakV1ByRegistrikood(String registrikood) throws XTeeServiceConsumptionException;

  VtaJaakResponse vtaJaakV1(String isikukood, String registrikood) throws XTeeServiceConsumptionException;
}
