package com.nortal.jroad.client.arireg;

import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.DetailandmedV5Ettevotja;
import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.EttevotjaMuudatusedTasutaParing;
import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.ParingarikeeludKeeld;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Roman Tekhov
 */
public class AriregXRoadServiceImplTest extends BaseXRoadServiceImplTest {

  private static final String TEST_ISIKUKOOD = "36605235217";
  private static final int TEST_ARIKOOD = 80191600;
  private static final String TEST_ARINIMI = "korter";

  @Resource
  private AriregXRoadServiceImpl ariregXRoadServiceImpl;

  @Test
  public void findArikeelud() throws XRoadServiceConsumptionException {
    List<ParingarikeeludKeeld> keelud = ariregXRoadServiceImpl.findArikeelud("38001010001", null, null, null);
    Assertions.assertNotNull(keelud);
    Assertions.assertTrue(!keelud.isEmpty());
    ParingarikeeludKeeld keeld = keelud.get(0);
    Assertions.assertEquals(keeld.getOlek(), "J");
  }

  @Test
  public void findDetailandmedV5() throws XRoadServiceConsumptionException {
    List<DetailandmedV5Ettevotja> items =
        ariregXRoadServiceImpl.findDetailandmedV1(TEST_ARIKOOD, true, true, false, false, false, false, 10);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(!items.isEmpty());
    DetailandmedV5Ettevotja ettevotja = items.get(0);
    Assertions.assertEquals(TEST_ARIKOOD, ettevotja.getAriregistriKood().intValue());
    Assertions.assertEquals("Motoklubi Motosummer", ettevotja.getYldandmed().getArinimed().getItemList().get(0).getSisu());
  }

  @Test
  public void getEttevotjaMuudatusedTasutaV1() throws XRoadServiceConsumptionException {
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
