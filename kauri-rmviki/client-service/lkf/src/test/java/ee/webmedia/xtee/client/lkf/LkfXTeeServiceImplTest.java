package ee.webmedia.xtee.client.lkf;

import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingVastus;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.KindlustuskaitseOtsingParing;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.RomudeOtsingVastus;
import ee.webmedia.xtee.client.lkf.types.ee.riik.xtee.lkf.producers.producer.lkf.RomudeOtsingVastus.ClaimBangers.Item.Vehicle;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import java.util.Calendar;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tatjana Kulikova (tatjana.kulikova@webmedia.ee)
 * @date 17.02.2011
 */
public class LkfXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private LkfXTeeServiceImpl lkfXTeeServiceImpl;
  
  private static final Calendar START = Calendar.getInstance();
  private static final Calendar END = Calendar.getInstance();
  
  static {
	  START.set(2010, 10, 1, 0, 0);
	  END.set(2011, 10, 1, 23, 59);
  }

  @Test
  public void romudeOtsing() throws XTeeServiceConsumptionException {

	RomudeOtsingVastus response = lkfXTeeServiceImpl.romudeOtsing(START, END);
    Assert.assertNotNull(response);
    Assert.assertFalse(response.getClaimBangers().getItemList().isEmpty());
    Vehicle vehicle= response.getClaimBangers().getItemList().get(0).getVehicle();
    Assert.assertEquals("280BAF", vehicle.getVehicleRegNo());
    Assert.assertEquals("VSSZZZ5PZ7R039967", vehicle.getVehicleVin());
  }
  
  @Test
  public void kindlustusKaitseOtsing() throws XTeeServiceConsumptionException {
    KindlustuskaitseOtsingParing paring = KindlustuskaitseOtsingParing.Factory.newInstance();
    paring.setVehicleVin("VSSZZZ5PZ7R039967");
    KindlustuskaitseOtsingVastus vastus = lkfXTeeServiceImpl.kindlustusKaitseOtsing(paring);
    Assert.assertEquals(vastus.getInsuranceCovers().getItemArray(0).getInsuranceCover().getVehicleMake(), "SEAT");
  }
}
