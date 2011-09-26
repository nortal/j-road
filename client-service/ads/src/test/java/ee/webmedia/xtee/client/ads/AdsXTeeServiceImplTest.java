package ee.webmedia.xtee.client.ads;

import java.math.BigInteger;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;

import ee.webmedia.xtee.client.ads.AdsXTeeService;
import ee.webmedia.xtee.client.ads.AdsXTeeServiceImpl;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType.KlassifParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType.MuudatusedParam;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;

public class AdsXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private AdsXTeeServiceImpl adsXTeeServiceImpl;
  
  @Test
  public void findKompklassifV1() throws XTeeServiceConsumptionException {
	  AdsXTeeService.KlassifParamCallback cb = new AdsXTeeService.KlassifParamCallback() {
		  public void populate(KlassifParam kp) {
			  kp.setMaxarv(BigInteger.valueOf(5));
			  kp.setLogId(BigInteger.valueOf(0));
		  }
	  };

	  ADSkompklassifVastusType response = adsXTeeServiceImpl.kompklassifV1(cb);

	  Assert.assertNotNull(response);
  }
  

  @Test
  public void findKindlustusV1() throws XTeeServiceConsumptionException {
	  AdsXTeeService.MuudatusedParamCallback cb = new AdsXTeeService.MuudatusedParamCallback() {
		  public void populate(MuudatusedParam mp) {
			  mp.setMaxarv(BigInteger.valueOf(5));
			  mp.setLogId(BigInteger.valueOf(0));
		  }
	  };

	  ADSmuudatusedVastusType response = adsXTeeServiceImpl.muudatusedV1(cb);

	  Assert.assertNotNull(response);
  }
}
