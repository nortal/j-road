package ee.webmedia.xtee.client.arireg;

import ee.webmedia.xtee.client.arireg.AriregXTeeService.Detailandmedv2KehaPopulatingCallback;
import ee.webmedia.xtee.client.arireg.AriregXTeeService.Detailandmedv4KehaPopulatingCallback;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedKaardileKantudIsik;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedKaardileKantudIsikud;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV3Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV3Isikuandmed;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Isikuandmed;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4KaardileKantudIsik;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4KaardileKantudIsikud;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Query;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.Detailandmedv2Query;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingarikeeludKeeld;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import java.util.List;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Roman Tekhov
 */
public class AriregXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  private static final String TEST_ISIKUKOOD = "36605235217";
  private static final int TEST_ARIKOOD = 80191600;
  private static final String TEST_ARINIMI = "korter";

  @Resource
  private AriregXTeeServiceImpl ariregXTeeServiceImpl;

  @Test
  public void findDetailandmedv31() throws XTeeServiceConsumptionException {
    List<DetailandmedV3Ettevotja> items =
        ariregXTeeServiceImpl.findDetailandmedv3(TEST_ISIKUKOOD, true, true, false, false, 10);

    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());

    DetailandmedV3Ettevotja ettevotja = items.get(0);
    DetailandmedV3Isikuandmed isikuandmed = ettevotja.getIsikuandmed();
    Assert.assertNotNull(isikuandmed);

    DetailandmedKaardileKantudIsikud kaardileKantudIsikud = isikuandmed.getKaardileKantudIsikud();
    Assert.assertNotNull(kaardileKantudIsikud);

    List<DetailandmedKaardileKantudIsik> kaardileKantudIsikList = kaardileKantudIsikud.getItemList();
    Assert.assertTrue(!kaardileKantudIsikList.isEmpty());

    DetailandmedKaardileKantudIsik isik = null;
    for (DetailandmedKaardileKantudIsik kaardileKantudIsik : kaardileKantudIsikList) {
      if (TEST_ISIKUKOOD.equals(kaardileKantudIsik.getIsikukoodRegistrikood())
          && "Paavo".equals(kaardileKantudIsik.getEesnimi())) {
        isik = kaardileKantudIsik;
        break;
      }
    }

    Assert.assertNotNull(isik);
  }

  @Test
  public void findDetailandmedv32() throws XTeeServiceConsumptionException {
    List<DetailandmedV3Ettevotja> items =
        ariregXTeeServiceImpl.findDetailandmedv3(TEST_ARIKOOD, true, true, false, false, 10);

    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());

    DetailandmedV3Ettevotja ettevotja = items.get(0);

    Assert.assertEquals(TEST_ARIKOOD, ettevotja.getAriregistriKood());
  }

  @Test
  public void findDetailandmedv33() throws XTeeServiceConsumptionException {
    Detailandmedv2KehaPopulatingCallback callback =
        new AriregXTeeService.Detailandmedv2ReturnedDataSettingCallback(true, false, false, false, 10) {
          @Override
          protected void doPopulate(Detailandmedv2Query keha) {
            keha.setArinimi(TEST_ARINIMI);
          }
        };

    List<DetailandmedV3Ettevotja> items = ariregXTeeServiceImpl.findDetailandmedv3(callback);

    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());

    DetailandmedV3Ettevotja ettevotja = items.get(0);

    Assert.assertTrue(ettevotja.getYldandmed().getArinimed().getItemList().get(0).getSisu().toUpperCase().contains(TEST_ARINIMI.toUpperCase()));
  }

  @Test
  public void findArikeelud() throws XTeeServiceConsumptionException {
    List<ParingarikeeludKeeld> keelud = ariregXTeeServiceImpl.findArikeelud("38001010001", null, null, null);

    Assert.assertNotNull(keelud);
    Assert.assertTrue(!keelud.isEmpty());

    ParingarikeeludKeeld keeld = keelud.get(0);
    Assert.assertEquals(keeld.getOlek(), "J");
  }

  @Test
  public void findDetailandmedv41() throws XTeeServiceConsumptionException {
    List<DetailandmedV4Ettevotja> items =
        ariregXTeeServiceImpl.findDetailandmedv4(TEST_ISIKUKOOD, true, true, false, false, false, 10);

    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());

    DetailandmedV4Ettevotja ettevotja = items.get(0);
    DetailandmedV4Isikuandmed isikuandmed = ettevotja.getIsikuandmed();
    Assert.assertNotNull(isikuandmed);

    DetailandmedV4KaardileKantudIsikud kaardileKantudIsikud = isikuandmed.getKaardileKantudIsikud();
    Assert.assertNotNull(kaardileKantudIsikud);

    List<DetailandmedV4KaardileKantudIsik> kaardileKantudIsikList = kaardileKantudIsikud.getItemList();
    Assert.assertTrue(!kaardileKantudIsikList.isEmpty());

    DetailandmedV4KaardileKantudIsik isik = null;
    for (DetailandmedV4KaardileKantudIsik kaardileKantudIsik : kaardileKantudIsikList) {
      if (TEST_ISIKUKOOD.equals(kaardileKantudIsik.getIsikukoodRegistrikood())
          && "Paavo".equals(kaardileKantudIsik.getEesnimi())) {
        isik = kaardileKantudIsik;
        break;
      }
    }

    Assert.assertNotNull(isik);
  }

  @Test
  public void findDetailandmedv42() throws XTeeServiceConsumptionException {
    List<DetailandmedV4Ettevotja> items =
        ariregXTeeServiceImpl.findDetailandmedv4(TEST_ARIKOOD, true, true, false, false, false, 10);

    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());

    DetailandmedV4Ettevotja ettevotja = items.get(0);

    Assert.assertEquals(TEST_ARIKOOD, ettevotja.getAriregistriKood());
    Assert.assertEquals("Motoklubi Motosummer", ettevotja.getYldandmed().getArinimed().getItemList().get(0).getSisu());

  }

  @Test
  public void findDetailandmedv44() throws XTeeServiceConsumptionException {
    Detailandmedv4KehaPopulatingCallback callback =
        new AriregXTeeService.Detailandmedv4ReturnedDataSettingCallback(true, false, false, false, false, 10) {
          @Override
          protected void doPopulate(DetailandmedV4Query keha) {
            keha.setArinimi(TEST_ARINIMI);
          }
        };

    List<DetailandmedV4Ettevotja> items = ariregXTeeServiceImpl.findDetailandmedv4(callback);

    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());

    DetailandmedV4Ettevotja ettevotja = items.get(0);

    Assert.assertTrue(ettevotja.getYldandmed().getArinimed().getItemList().get(0).getSisu().toUpperCase().contains(TEST_ARINIMI.toUpperCase()));
  }


  public void setAriregXTeeServiceImpl(AriregXTeeServiceImpl ariregXTeeServiceImpl) {
    this.ariregXTeeServiceImpl = ariregXTeeServiceImpl;
  }
}
