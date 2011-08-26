package ee.webmedia.xtee.client.teavituskalender;

import javax.annotation.Resource;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.teavituskalender.Syndmus;
import ee.webmedia.xtee.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.SyndmuseTyyp;
import ee.webmedia.xtee.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.Tahtsus;
import ee.webmedia.xtee.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.Lugejad.Item.KasutajaTyyp;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.xmlbeans.XmlString;
import org.junit.Assert;
import org.junit.Test;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import ee.webmedia.xtee.client.util.XmlBeansUtil;

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
