package com.nortal.jroad.client.pkr;

import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Valjund;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @author Margus Hanni
 */
public class PkrXTeeServiceImplTest extends BaseXTeeServiceImplTest {

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
    Assert.assertNotNull(response);
  }
}
