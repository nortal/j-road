package com.nortal.jroad.client.star;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.AsynchronousParingTulemResponse;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.HooldajaHooldusedMassParingResponse;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.HooldajaHooldusedResponse;

import java.util.Collection;
import java.util.Date;

public interface StarXRoadService {

  HooldajaHooldusedResponse findHooldajaHooldused(String isikukood, Date algus, Date lopp)
      throws XTeeServiceConsumptionException;

  HooldajaHooldusedMassParingResponse submitHooldajaHooldusedMassParingV1(Collection<String> isikukoodid, Date algus, Date lopp)
      throws XTeeServiceConsumptionException;

  AsynchronousParingTulemResponse getAsynchronousParingTulemV1(String pilet) throws XTeeServiceConsumptionException;
}
