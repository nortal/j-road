package com.nortal.jroad.client.arireg;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.nortal.jroad.client.arireg.AriregXTeeService;
import com.nortal.jroad.client.arireg.AriregXTeeServiceImpl;
import com.nortal.jroad.client.arireg.AriregXTeeService.Detailandmedv2KehaPopulatingCallback;
import com.nortal.jroad.client.arireg.AriregXTeeService.Detailandmedv4KehaPopulatingCallback;
import com.nortal.jroad.client.arireg.AriregXTeeService.EttevotjaMuudatusedTasutaReturnedDataSettingCallback;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedKaardileKantudIsik;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedKaardileKantudIsikud;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV3Ettevotja;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV3Isikuandmed;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Ettevotja;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Isikuandmed;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4KaardileKantudIsik;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4KaardileKantudIsikud;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Query;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV5Ettevotja;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.Detailandmedv2Query;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.EttevotjaMuudatusedTasutaParing;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingarikeeludKeeld;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingesindusEttevote;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingesindusV2Ettevote;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingesindusV3Ettevote;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

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
  public void findDetailandmedv31() throws XRoadServiceConsumptionException {
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
  public void findDetailandmedv32() throws XRoadServiceConsumptionException {
    List<DetailandmedV3Ettevotja> items =
        ariregXTeeServiceImpl.findDetailandmedv3(TEST_ARIKOOD, true, true, false, false, 10);
    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());
    DetailandmedV3Ettevotja ettevotja = items.get(0);
    Assert.assertEquals(TEST_ARIKOOD, ettevotja.getAriregistriKood());
  }

  @Test
  public void findDetailandmedv33() throws XRoadServiceConsumptionException {
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
  public void findArikeelud() throws XRoadServiceConsumptionException {
    List<ParingarikeeludKeeld> keelud = ariregXTeeServiceImpl.findArikeelud("38001010001", null, null, null);
    Assert.assertNotNull(keelud);
    Assert.assertTrue(!keelud.isEmpty());
    ParingarikeeludKeeld keeld = keelud.get(0);
    Assert.assertEquals(keeld.getOlek(), "J");
  }

  @Test
  public void findDetailandmedv41() throws XRoadServiceConsumptionException {
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
  public void findDetailandmedv42() throws XRoadServiceConsumptionException {
    List<DetailandmedV4Ettevotja> items =
        ariregXTeeServiceImpl.findDetailandmedv4(TEST_ARIKOOD, true, true, false, false, false, 10);
    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());
    DetailandmedV4Ettevotja ettevotja = items.get(0);
    Assert.assertEquals(TEST_ARIKOOD, ettevotja.getAriregistriKood());
    Assert.assertEquals("Motoklubi Motosummer", ettevotja.getYldandmed().getArinimed().getItemList().get(0).getSisu());
  }

  @Test
  public void findDetailandmedv44() throws XRoadServiceConsumptionException {
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

  @Test
  public void findDetailandmedV5() throws XRoadServiceConsumptionException {
    List<DetailandmedV5Ettevotja> items =
        ariregXTeeServiceImpl.findDetailandmedV5(TEST_ARIKOOD, true, true, false, false, false, false, 10);
    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());
    DetailandmedV5Ettevotja ettevotja = items.get(0);
    Assert.assertEquals(TEST_ARIKOOD, ettevotja.getAriregistriKood().intValue());
    Assert.assertEquals("Motoklubi Motosummer", ettevotja.getYldandmed().getArinimed().getItemList().get(0).getSisu());
  }

  @Test
  public void findParingesindusV1() throws XRoadServiceConsumptionException {
    List<ParingesindusEttevote> items = ariregXTeeServiceImpl.findParingesindusV1(null, TEST_ISIKUKOOD, null, null);
    Assert.assertTrue(!items.isEmpty());
  }

  @Test
  public void findParingesindusV2() throws XRoadServiceConsumptionException {
    List<ParingesindusV2Ettevote> items = ariregXTeeServiceImpl.findParingesindusV2(null, TEST_ISIKUKOOD, null, null);
    Assert.assertTrue(!items.isEmpty());
  }

  @Test
  public void findParingesindusV3() throws XRoadServiceConsumptionException { // Add implementation when we get access to
                                                                             // this service method
    List<ParingesindusV3Ettevote> result =
        ariregXTeeServiceImpl.findParingesindusV3(TEST_ARIKOOD, null, null, null, null);
    Assert.assertTrue(!result.isEmpty());
  }

  @Test
  public void getEttevotjaMuudatusedTasutaV1() throws XRoadServiceConsumptionException {
    try {
      SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
      EttevotjaMuudatusedTasutaReturnedDataSettingCallback callback =
          new EttevotjaMuudatusedTasutaReturnedDataSettingCallback(sf.parse("01.01.2010"),
                                                                   new String[] { "kanded" },
                                                                   null, // new String[] { "isikud" },
                                                                   null,
                                                                   null,
                                                                   null,
                                                                   null,
                                                                   -1) {

            @Override
            protected void doPopulate(EttevotjaMuudatusedTasutaParing query) {
            }
          };
      ariregXTeeServiceImpl.findEttevotjaMuudatusedTasutaV1(callback);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setAriregXTeeServiceImpl(AriregXTeeServiceImpl ariregXTeeServiceImpl) {
    this.ariregXTeeServiceImpl = ariregXTeeServiceImpl;
  }
}
