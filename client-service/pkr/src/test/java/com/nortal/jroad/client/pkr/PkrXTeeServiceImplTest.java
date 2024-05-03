package com.nortal.jroad.client.pkr;

import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Valjund;


import jakarta.annotation.Resource;
import java.util.Calendar;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Margus Hanni
 */
public class PkrXTeeServiceImplTest extends BaseXRoadServiceImplTest {

  private static final String TEST_ISIKUKOOD = "43108150028";

  @Resource
  private PkrXTeeServiceImpl pkrXTeeServiceImpl;

  @Test
  public void getTkis2V1() throws Exception {
    Calendar start = Calendar.getInstance();
    start.set(2010, Calendar.JANUARY, 1);
    Calendar end = Calendar.getInstance();
    end.set(2015, Calendar.DECEMBER, 31);
    Tkis2Valjund response = pkrXTeeServiceImpl.getTkis2V1(TEST_ISIKUKOOD, start.getTime(), end.getTime());
    Assertions.assertNotNull(response);
  }
}
