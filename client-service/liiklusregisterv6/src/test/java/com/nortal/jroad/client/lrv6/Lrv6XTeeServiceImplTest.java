package com.nortal.jroad.client.lrv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.lrv6.types.eu.x_road.liiklusregister.AdrJuhtResponse;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Calendar;

import static org.junit.Assert.assertNotNull;


public class Lrv6XTeeServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  Lrv6XTeeServiceImpl lrv6XTeeServiceImpl;

  @Test
  public void findAdrJuht() throws XRoadServiceConsumptionException {

    Calendar calendar = Calendar.getInstance();

    AdrJuhtResponse adrJuhtResponse = lrv6XTeeServiceImpl.findAdrJuht(calendar);
    assertNotNull(adrJuhtResponse);


  }
}
