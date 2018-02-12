package com.nortal.jroad.client.arireg;

import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.DetailandmedV5Ettevotja;
import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.EttevotjaMuudatusedTasutaParing;
import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.ParingarikeeludKeeld;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.annotation.Resource;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Roman Tekhov
 */
public class AriregXRoadServiceImplTest extends BaseXTeeServiceImplTest {

  private static final String TEST_ISIKUKOOD = "36605235217";
  private static final int TEST_ARIKOOD = 80191600;
  private static final String TEST_ARINIMI = "korter";

  @Resource
  private AriregXRoadServiceImpl ariregXRoadServiceImpl;

  @Test
  public void findArikeelud() throws XTeeServiceConsumptionException {
    List<ParingarikeeludKeeld> keelud = ariregXRoadServiceImpl.findArikeelud("38001010001", null, null, null);
    Assert.assertNotNull(keelud);
    Assert.assertTrue(!keelud.isEmpty());
    ParingarikeeludKeeld keeld = keelud.get(0);
    Assert.assertEquals(keeld.getOlek(), "J");
  }

  @Test
  public void findDetailandmedV5() throws XTeeServiceConsumptionException {
    List<DetailandmedV5Ettevotja> items =
        ariregXRoadServiceImpl.findDetailandmedV1(TEST_ARIKOOD, true, true, false, false, false, false, 10);
    Assert.assertNotNull(items);
    Assert.assertTrue(!items.isEmpty());
    DetailandmedV5Ettevotja ettevotja = items.get(0);
    Assert.assertEquals(TEST_ARIKOOD, ettevotja.getAriregistriKood().intValue());
    Assert.assertEquals("Motoklubi Motosummer", ettevotja.getYldandmed().getArinimed().getItemList().get(0).getSisu());
  }

  @Test
  public void getEttevotjaMuudatusedTasutaV1() throws XTeeServiceConsumptionException {
    try {
      SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
      AriregXRoadService.EttevotjaMuudatusedTasutaReturnedDataSettingCallback callback =
          new AriregXRoadService.EttevotjaMuudatusedTasutaReturnedDataSettingCallback(sf.parse("01.01.2010"),
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
      ariregXRoadServiceImpl.findEttevotjaMuudatusedTasutaV1(callback);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setAriregXRoadServiceImpl(AriregXRoadServiceImpl ariregXRoadServiceImpl) {
    this.ariregXRoadServiceImpl = ariregXRoadServiceImpl;
  }
}
