package com.nortal.jroad.client.star;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.annotation.Resource;

import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.star.database.StarXTeeDatabase;

@Service("starXTeeService")
public class StarXTeeServiceImpl implements StarXTeeService {

  @Resource
  private StarXTeeDatabase starXTeeDatabase;

  public HooldajaHooldusedResponse findHooldajaHooldused(String isikukood, Date algus, Date lopp)
      throws XTeeServiceConsumptionException {
    HooldajaHooldusedRequest input = HooldajaHooldusedRequest.Factory.newInstance();
    input.setIsikukood(isikukood);
    input.setAlgus(createCalendar(algus));
    input.setLopp(createCalendar(lopp));
    return starXTeeDatabase.hooldajaHooldusedV1(input);
  }

  private Calendar createCalendar(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
  }

  public HooldajaHooldusedMassParingResponse submitHooldajaHooldusedMassParingV1(Collection<String> isikukoodid, Date algus, Date lopp)
      throws XTeeServiceConsumptionException {
    HooldajaHooldusedMassParingRequest request = HooldajaHooldusedMassParingRequest.Factory.newInstance();
    request.setIsikukoodid(StringUtils.join(isikukoodid.iterator(), ","));
    request.setAlgus(createCalendar(algus));
    request.setLopp(createCalendar(lopp));
    return starXTeeDatabase.hooldajaHooldusedMassParingV1(request);
  }

  public AsynchronousParingTulemResponse getAsynchronousParingTulemV1(String pilet)
      throws XTeeServiceConsumptionException {
    AsynchronousParingTulemRequest request = AsynchronousParingTulemRequest.Factory.newInstance();
    request.setPilet(pilet);
    return starXTeeDatabase.asynchronousParingTulemV1(request);
  }
}
