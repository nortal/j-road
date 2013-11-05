package ee.webmedia.xtee.client.priavra;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.priavra.types.ee.riik.xtee.pria_vra.producers.producer.pria_vra.VtaJaakResponse;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
public interface PriaVraXteeService {
  VtaJaakResponse vtaJaakV1(String isikukood, String registrikood) throws XTeeServiceConsumptionException;
}
