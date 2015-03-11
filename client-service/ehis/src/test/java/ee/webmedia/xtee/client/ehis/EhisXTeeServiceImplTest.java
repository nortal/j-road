package com.nortal.jroad.client.ehis;

import java.util.Calendar;

import javax.annotation.Resource;

import org.junit.Test;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Margus Hanni
 */
public class EhisXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  private static final String TEST_ISIKUKOOD = "38005039562";
  private static final Calendar TEST_ALGUSKP = Calendar.getInstance();
  private static final Calendar TEST_LOPPKP = Calendar.getInstance();

  static {
    TEST_ALGUSKP.set(Calendar.YEAR, 2009);
    TEST_ALGUSKP.set(Calendar.MONTH, 1);
    TEST_ALGUSKP.set(Calendar.DAY_OF_MONTH, 1);

    TEST_LOPPKP.set(Calendar.YEAR, 2009);
    TEST_LOPPKP.set(Calendar.MONTH, 12);
    TEST_LOPPKP.set(Calendar.DAY_OF_MONTH, 1);
  }

  @Resource
  private EhisXTeeServiceImpl ehisXTeeServiceImpl;

  @Test
  public void findTootukassaleKehtivad() throws XTeeServiceConsumptionException {

    /*
     * TODO Kui EHIS hakkab kunagi tööle, siis tuleks koodi kommentaarid eemaldada. Praegu EHIS ei tagasta tulemusi
     */

    // List<Isik> items = ehisXTeeServiceImpl.findTootukassaleKehtivad(
    // TEST_ALGUSKP.getTime(), TEST_LOPPKP.getTime(), TEST_ISIKUKOOD);
    //
    // Assert.assertNotNull(items);
    // Assert.assertFalse(items.isEmpty());
    //
    // Isik isik = items.get(0);
    // List<TkOppimine> oppimine = isik.getOppimineList();
    // Assert.assertNotNull(oppimine);
    //
    // List<TkAkadPuhkus> akadPuhkus = isik.getAkadPuhkusList();
    // Assert.assertNotNull(akadPuhkus);

  }
}
