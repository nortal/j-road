package ee.webmedia.xtee.client.priavra;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.priavra.database.PriaVraXTeeDatabase;
import ee.webmedia.xtee.client.priavra.types.ee.riik.xtee.pria_vra.producers.producer.pria_vra.VtaJaakRequest;
import ee.webmedia.xtee.client.priavra.types.ee.riik.xtee.pria_vra.producers.producer.pria_vra.VtaJaakResponse;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
@Service("priaVraXteeService")
public class PriaVraXteeServiceImpl implements PriaVraXteeService {
  @Resource
  private PriaVraXTeeDatabase priaVraXTeeDatabase;

  public VtaJaakResponse vtaJaakV1ByIsikukood(String isikukood) throws XTeeServiceConsumptionException {
    return vtaJaakV1(isikukood, null);
  }

  public VtaJaakResponse vtaJaakV1ByRegistrikood(String registrikood) throws XTeeServiceConsumptionException {
    return vtaJaakV1(null, registrikood);
  }

  public VtaJaakResponse vtaJaakV1(String isikukood, String registrikood) throws XTeeServiceConsumptionException {
    VtaJaakRequest req = VtaJaakRequest.Factory.newInstance();
    req.setIsikukood(isikukood);
    req.setRegistrikood(registrikood);
    return priaVraXTeeDatabase.vtaJaakV1(req);
  }
}
