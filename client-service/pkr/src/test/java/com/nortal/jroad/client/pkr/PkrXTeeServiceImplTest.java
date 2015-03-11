package com.nortal.jroad.client.pkr;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.pkr.PkrXTeeServiceImpl;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus.ToetusJada;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus.ToetusJada.Item;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Margus Hanni
 */
public class PkrXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  private static final String TEST_ISIKUKOOD = "35803107903";

  @Resource
  private PkrXTeeServiceImpl pkrXTeeServiceImpl;

  @Test
  public void getPensionToetus() throws XTeeServiceConsumptionException {

    TtaPensionToetusVastus toetusVastus = pkrXTeeServiceImpl.getPensionToetus(TEST_ISIKUKOOD);

    Assert.assertNotNull(toetusVastus);
    Assert.assertNotNull(toetusVastus.getKood());

    ToetusJada toetusJada = toetusVastus.getToetusJada();
    Assert.assertNotNull(toetusJada);

    List<Item> items = toetusJada.getItemList();
    Assert.assertNotNull(items);
  }
}
