package com.nortal.jroad.client.pkr;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Valjund;
import junit.framework.Assert;

import org.junit.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus.ToetusJada;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus.ToetusJada.Item;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Margus Hanni
 */
public class PkrXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  private static final String TEST_ISIKUKOOD = "43108150028";

  @Resource
  private PkrXTeeServiceImpl pkrXTeeServiceImpl;

  @Test
  public void getPensionToetus() throws XRoadServiceConsumptionException {

    TtaPensionToetusVastus toetusVastus = pkrXTeeServiceImpl.getPensionToetus(TEST_ISIKUKOOD);

    Assert.assertNotNull(toetusVastus);
    Assert.assertNotNull(toetusVastus.getKood());

    ToetusJada toetusJada = toetusVastus.getToetusJada();
    Assert.assertNotNull(toetusJada);

    List<Item> items = toetusJada.getItemList();
    Assert.assertNotNull(items);
  }

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
