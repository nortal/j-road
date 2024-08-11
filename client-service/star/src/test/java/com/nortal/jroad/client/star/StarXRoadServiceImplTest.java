package com.nortal.jroad.client.star;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.AsynchronousParingTulemResponse;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.HooldajaHooldusedMassParingResponse;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.annotation.Resource;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StarXRoadServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private StarXRoadServiceImpl starXRoadServiceImpl;

  @Test
  public void findHooldajaHooldusedMassParingV1_validInput() throws Exception {
    String[] isikukoodid = {"38812192729", "00000000000"};
    HooldajaHooldusedMassParingResponse response = getHooldajaHooldusedMassParingResponse(isikukoodid);
    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getPilet());
  }

  @Test
  public void findHooldajaHooldusedMassParingV1_invalidInput() {
    assertThrows(XRoadServiceConsumptionException.class, this::getHooldajaHooldusedMassParingResponse);
  }

  private HooldajaHooldusedMassParingResponse getHooldajaHooldusedMassParingResponse(String... idCodes)
      throws XRoadServiceConsumptionException {
    Set<String> isikukoodid = new HashSet<String>(Arrays.asList(idCodes));
    Calendar algus = Calendar.getInstance();
    algus.set(2015, Calendar.JANUARY, 1);
    Calendar lopp = Calendar.getInstance();
    lopp.set(2015, Calendar.DECEMBER, 31);
    return starXRoadServiceImpl.submitHooldajaHooldusedMassParingV1(isikukoodid, algus.getTime(), lopp.getTime());
  }

  @Test
  public void getAsynchronousParingTulemV1() throws Exception {
    String[] isikukoodid = {"38812192729", "00000000000"};
    HooldajaHooldusedMassParingResponse response = getHooldajaHooldusedMassParingResponse(isikukoodid);
    AsynchronousParingTulemResponse async = starXRoadServiceImpl.getAsynchronousParingTulemV1(response.getPilet());
    Assertions.assertNotNull(async);
    Assertions.assertNotNull(async.getBase64());
  }
}
