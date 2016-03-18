package com.nortal.jroad.client.star;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.AsynchronousParingTulemResponse;
import com.nortal.jroad.client.star.types.ee.riik.xtee.star.producers.producer.star.HooldajaHooldusedMassParingResponse;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class StarXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private StarXTeeServiceImpl starXTeeServiceImpl;

  @Test
  public void findHooldajaHooldusedMassParingV1_validInput() throws Exception {
    String[] isikukoodid = {"38812192729", "00000000000"};
    HooldajaHooldusedMassParingResponse response = getHooldajaHooldusedMassParingResponse(isikukoodid);
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getPilet());
  }

  @Test(expected = XTeeServiceConsumptionException.class)
  public void findHooldajaHooldusedMassParingV1_invalidInput() throws Exception {
    String[] isikukoodid = {};
    getHooldajaHooldusedMassParingResponse(isikukoodid);
    Assert.fail();
  }

  private HooldajaHooldusedMassParingResponse getHooldajaHooldusedMassParingResponse(String... idCodes)
      throws XTeeServiceConsumptionException {
    Set<String> isikukoodid = new HashSet<String>(Arrays.asList(idCodes));
    Calendar algus = Calendar.getInstance();
    algus.set(2015, Calendar.JANUARY, 1);
    Calendar lopp = Calendar.getInstance();
    lopp.set(2015, Calendar.DECEMBER, 31);
    return starXTeeServiceImpl.submitHooldajaHooldusedMassParingV1(isikukoodid, algus.getTime(), lopp.getTime());
  }

  @Test
  public void getAsynchronousParingTulemV1() throws Exception {
    String[] isikukoodid = {"38812192729", "00000000000"};
    HooldajaHooldusedMassParingResponse response = getHooldajaHooldusedMassParingResponse(isikukoodid);
    AsynchronousParingTulemResponse async = starXTeeServiceImpl.getAsynchronousParingTulemV1(response.getPilet());
    Assert.assertNotNull(async);
    Assert.assertNotNull(async.getBase64());
  }
}
