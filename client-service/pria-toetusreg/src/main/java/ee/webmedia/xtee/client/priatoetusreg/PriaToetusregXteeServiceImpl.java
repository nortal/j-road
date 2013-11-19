package ee.webmedia.xtee.client.priatoetusreg;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.priatoetusreg.database.PriaToetusregXTeeDatabase;
import ee.webmedia.xtee.client.priatoetusreg.types.ee.riik.xtee.pria_toetusreg.producers.producer.pria_toetusreg.VtaJaakRequest;
import ee.webmedia.xtee.client.priatoetusreg.types.ee.riik.xtee.pria_toetusreg.producers.producer.pria_toetusreg.VtaJaakResponse;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
@Service("priaToetusregXteeService")
public class PriaToetusregXteeServiceImpl implements PriaToetusregXteeService {
  @Resource
  private PriaToetusregXTeeDatabase priaToetusregXTeeDatabase;

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
    return priaToetusregXTeeDatabase.vtaJaakV1(req);
  }
}
