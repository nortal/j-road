package com.nortal.jroad.client.star;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.star.database.StarXTeeDatabase;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.HooldajaHooldusedRequest;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.HooldajaHooldusedResponse;

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
}
