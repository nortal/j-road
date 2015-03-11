package com.nortal.jroad.client.teavituskalender;

import javax.annotation.Resource;

import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.xmlbeans.XmlString;
import org.junit.Assert;
import org.junit.Test;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.teavituskalender.Syndmus;
import com.nortal.jroad.client.teavituskalender.TeavituskalenderXTeeServiceImpl;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.SyndmuseTyyp;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.Tahtsus;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.Lugejad.Item.KasutajaTyyp;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import com.nortal.jroad.client.util.XmlBeansUtil;

/**
 * @author Aleksandr.Koltakov
 */
public class TeavituskalenderXteeServiceImplTest extends BaseXTeeServiceImplTest {

  private static final Calendar ALGUS = Calendar.getInstance();
  private static final Calendar LOPP = Calendar.getInstance();

  @Resource
  private TeavituskalenderXTeeServiceImpl teavituskalenderXTeeServiceImpl;

  static {
    ALGUS.set(2010, 5, 20, 0, 0);
    LOPP.set(2010, 6, 20, 23, 59);
  }

  @Test
  public void testLisaSyndmus() throws XTeeServiceConsumptionException {
    Syndmus syndmus = new Syndmus();
    syndmus.setIsikukood("37801113714");
    syndmus.setAlgus(ALGUS);
    syndmus.setLopp(LOPP);
    syndmus.setAktivineTeavitus("XTee lisaSynmdus test");
    syndmus.setKirjeldus("Message body");
    syndmus.setKasutajaTyyp(KasutajaTyyp.ISIK);
    syndmus.setTahtsus(Tahtsus.MADAL);
    syndmus.setSyndmuseTyyp(SyndmuseTyyp.LIIGIS);
    syndmus.setLiik("Liiklusregistri teavitused");

    teavituskalenderXTeeServiceImpl.lisaSyndmus(syndmus);
  }
}
