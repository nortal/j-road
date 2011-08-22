package ee.webmedia.xtee.client.emta;

import java.math.BigInteger;

import ee.webmedia.xtee.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.FieIsikAndmed;
import ee.webmedia.xtee.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.Periood;
import ee.webmedia.xtee.client.emta.types.ee.riik.xtee.emta.producers.producer.emta.VptValjund;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Calendar;

/**
 * @author Roman Tekhov
 */
public class EmtaXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private EmtaXTeeServiceImpl emtaXTeeServiceImpl;

  @Test
  public void findXteeKindlustusV2() throws ParseException, XTeeServiceConsumptionException {
    String isikukood = "45804300304";

    DateFormat dateFormat = new SimpleDateFormat("MM.yyyy");

    Date algkuup = dateFormat.parse("01.2008");
    Date loppkuup = dateFormat.parse("12.2008");

    List<Periood> response = emtaXTeeServiceImpl.findXteeKindlustusV2(isikukood, algkuup, loppkuup);

    Assert.assertNotNull(response);
    Assert.assertFalse(response.isEmpty());
    Assert.assertEquals("01.2008", response.get(0).getKuuAasta());
  }

  @Test
  public void findXteeFieAndmed() throws XTeeServiceConsumptionException {
    String isikukood = "45804300304";

    List<FieIsikAndmed> response = emtaXTeeServiceImpl.findXteeFieAndmed(isikukood);

    Assert.assertNotNull(response);
  }
  
  @Test
  public void findSissetulek() throws XTeeServiceConsumptionException {
    Assert.assertNotNull(emtaXTeeServiceImpl.findSissetulek("45804300304", new BigInteger("2008")).getVastus());
  }
  
  @Test
  public void findXteeVpt() throws XTeeServiceConsumptionException {
	  String kood = "37304050222";
	  Calendar c = Calendar.getInstance();
	  c.set(2009, 9, 29);
	  
	  VptValjund response = emtaXTeeServiceImpl.findXteeVpt(kood, c);
	  Assert.assertNotNull(response);
  }
}
