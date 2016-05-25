package com.nortal.jroad.client.priatoetusreg;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.priatoetusreg.database.PriaToetusregXRoadDatabase;
import com.nortal.jroad.client.priatoetusreg.types.ee.riik.xtee.pria_toetusreg.producers.producer.pria_toetusreg.VtaJaakRequest;
import com.nortal.jroad.client.priatoetusreg.types.ee.riik.xtee.pria_toetusreg.producers.producer.pria_toetusreg.VtaJaakResponse;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
@Service("priaToetusregXteeService")
public class PriaToetusregXteeServiceImpl implements PriaToetusregXteeService {
  @Resource
  private PriaToetusregXRoadDatabase priaToetusregXRoadDatabase;

  public VtaJaakResponse vtaJaakV1ByIsikukood(String isikukood) throws XRoadServiceConsumptionException {
    return vtaJaakV1(isikukood, null);
  }

  public VtaJaakResponse vtaJaakV1ByRegistrikood(String registrikood) throws XRoadServiceConsumptionException {
    return vtaJaakV1(null, registrikood);
  }

  public VtaJaakResponse vtaJaakV1(String isikukood, String registrikood) throws XRoadServiceConsumptionException {
    VtaJaakRequest req = VtaJaakRequest.Factory.newInstance();
    req.setIsikukood(isikukood);
    req.setRegistrikood(registrikood);
    return priaToetusregXRoadDatabase.vtaJaakV1(req);
  }
}
