package ee.webmedia.xtee.client.ljvis;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.ljvis.LjvisXTeeServiceImpl;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request.Confirmed;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request.Confirmed.Item;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Response;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVqueryV1Response;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;

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
    } catch (XTeeServiceConsumptionException e) {
     //nothing
    }
  }

  @Test
  public void erakorralineConfirm() throws XTeeServiceConsumptionException {
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
