package com.nortal.jroad.client.ljvis;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ljvis.LjvisXTeeServiceImpl;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Response;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVqueryV1Response;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request.Confirmed;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request.Confirmed.Item;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Tatjana Kulikova
 */
public class LjvisXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private LjvisXTeeServiceImpl ljvisXTeeServiceImpl;

  @Test
  public void erakorralineYlevaatused() {
    try {
      ErakorralineYVqueryV1Response response = ljvisXTeeServiceImpl.erakorralineYlevaatused();

      Assert.assertNotNull(response);
      Assert.assertNotNull(response.getTargetedForInspection().getItemList().get(0).getLicencePlateNo());
      Assert.assertNotNull(response.getTargetedForInspection().getItemList().get(0).getInspector());
    } catch (XRoadServiceConsumptionException e) {
     //nothing
    }
  }

  @Test
  public void erakorralineConfirm() throws XRoadServiceConsumptionException {
   ErakorralineYVconfirmV1Request request = ErakorralineYVconfirmV1Request.Factory.newInstance();

    Confirmed confirmed = request.addNewConfirmed();

    Item item = confirmed.addNewItem();
    item.setInspectionId("1");
    item.setCode("00");
    item.setValue("Andmed salvestatud");

    confirmed.setItemArray(0, item);

    Item item1 = confirmed.addNewItem();
    item1.setInspectionId("2");
    item1.setCode("01");
    item1.setValue("Sõiduk on juba erakorralisele suunatud");

    confirmed.setItemArray(1, item1);

    request.setConfirmed(confirmed);
    ErakorralineYVconfirmV1Response response = ljvisXTeeServiceImpl.erakorralineConfirm(request);

    Assert.assertNotNull(response);

  }
}
