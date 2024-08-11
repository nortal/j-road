package com.nortal.jroad.client.star;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.star.database.StarXRoadDatabase;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.star.database.StarXRoadDatabase;
import jakarta.annotation.Resource;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Service("starXRoadService")
public class StarXRoadServiceImpl implements StarXRoadService {

  @Resource
  private StarXRoadDatabase starXRoadDatabase;

  public HooldajaHooldusedResponse findHooldajaHooldused(String isikukood, Date algus, Date lopp)
      throws XRoadServiceConsumptionException {
    HooldajaHooldusedRequest input = HooldajaHooldusedRequest.Factory.newInstance();
    input.setIsikukood(isikukood);
    input.setAlgus(createCalendar(algus));
    input.setLopp(createCalendar(lopp));
    return starXRoadDatabase.hooldajaHooldusedV1(input);
  }

  private Calendar createCalendar(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
  }

  public HooldajaHooldusedMassParingResponse submitHooldajaHooldusedMassParingV1(Collection<String> isikukoodid, Date algus, Date lopp)
      throws XRoadServiceConsumptionException {
    HooldajaHooldusedMassParingRequest request = HooldajaHooldusedMassParingRequest.Factory.newInstance();
    request.setIsikukoodid(StringUtils.join(isikukoodid.iterator(), ","));
    request.setAlgus(createCalendar(algus));
    request.setLopp(createCalendar(lopp));
    return starXRoadDatabase.hooldajaHooldusedMassParingV1(request);
  }

  public AsynchronousParingTulemResponse getAsynchronousParingTulemV1(String pilet)
      throws XRoadServiceConsumptionException {
    AsynchronousParingTulemRequest request = AsynchronousParingTulemRequest.Factory.newInstance();
    request.setPilet(pilet);
    return starXRoadDatabase.asynchronousParingTulemV1(request);
  }
}
