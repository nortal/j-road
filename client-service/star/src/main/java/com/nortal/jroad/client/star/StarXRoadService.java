package com.nortal.jroad.client.star;

import java.util.Collection;
import java.util.Date;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.AsynchronousParingTulemResponse;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.HooldajaHooldusedMassParingResponse;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.HooldajaHooldusedResponse;

import java.util.Collection;
import java.util.Date;

public interface StarXRoadService {

  HooldajaHooldusedResponse findHooldajaHooldused(String isikukood, Date algus, Date lopp)
      throws XRoadServiceConsumptionException;

  HooldajaHooldusedMassParingResponse submitHooldajaHooldusedMassParingV1(Collection<String> isikukoodid, Date algus, Date lopp)
      throws XRoadServiceConsumptionException;

  AsynchronousParingTulemResponse getAsynchronousParingTulemV1(String pilet) throws XRoadServiceConsumptionException;
}
