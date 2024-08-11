package com.nortal.jroad.client.ehis;

import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TkAkadPuhkus;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TkOppimine;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadIsik;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadV2Isik;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Margus Hanni
 */
public class EhisXRoadServiceImplTest extends BaseXRoadServiceImplTest {

  private static final String TEST_ISIKUKOOD = "38005039562";
  private static final Date TEST_ALGUSKP;
  private static final Date TEST_LOPPKP;

  static {
    TEST_ALGUSKP = buildDate(2009, Calendar.FEBRUARY, 1);
    TEST_LOPPKP = buildDate(2009, Calendar.UNDECIMBER, 1);
  }

  @Resource
  private EhisXRoadServiceImpl ehisXRoadService;

  @Test
  public void findTootukassaleKehtivad() throws XRoadServiceConsumptionException {

    /*
     * TODO Kui EHIS hakkab kunagi tööle, siis tuleks koodi kommentaarid eemaldada. Praegu EHIS ei tagasta tulemusi
     */

    List<TootukassaleKehtivadIsik> items =
      ehisXRoadService.findTootukassaleKehtivad(TEST_ALGUSKP, TEST_LOPPKP, TEST_ISIKUKOOD);

    Assertions.assertNotNull(items);
    Assertions.assertFalse(items.isEmpty());

    TootukassaleKehtivadIsik isik = items.get(0);
    List<TkOppimine> oppimine = isik.getOppimineList();
    Assertions.assertNotNull(oppimine);

    List<TkAkadPuhkus> akadPuhkus = isik.getAkadPuhkusList();
    Assertions.assertNotNull(akadPuhkus);

  }

  @Test
  public void findTootukassaleKehtivadV2() throws Exception {
    String[] isikud = { "48504270017", "37311186013" };
    Date start = buildDate(2005, Calendar.MARCH, 31);
    Date end = buildDate(2015, Calendar.DECEMBER, 31);
    List<TootukassaleKehtivadV2Isik> kehtivad = ehisXRoadService.findTootukassaleKehtivadV2(start, end, isikud);
    Assertions.assertNotNull(kehtivad);
    Assertions.assertNotNull(kehtivad.get(0).getOppimineList());
  }

  private static Date buildDate(int year, int month, int day) {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, year);
    cal.set(Calendar.MONTH, month);
    cal.set(Calendar.DAY_OF_MONTH, day);
    return cal.getTime();
  }
}
