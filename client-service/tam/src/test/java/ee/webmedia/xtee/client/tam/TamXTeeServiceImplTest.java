package ee.webmedia.xtee.client.tam;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.Registriisik;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;

public class TamXTeeServiceImplTest extends BaseXTeeServiceImplTest {
  
  @Resource
  private TamXTeeServiceImpl tamXTeeServiceImpl;
  
  @Test
  public void testRegistriisik() throws XTeeServiceConsumptionException {
    String kood = "D03115";
    List<Registriisik> result = tamXTeeServiceImpl.findRegistriisik(kood);
    Assert.assertEquals("One result expected", 1, result.size());
    Assert.assertEquals("35210010248", result.get(0).getIsikukood());
  }
  
  @Test
  public void testTervishoiutootajamuudatuskood() throws XTeeServiceConsumptionException {
    int type = 1;
    Calendar startDate = Calendar.getInstance();
    Calendar endDate = startDate;
    List<String> result = tamXTeeServiceImpl.findTervishoiutootajamuudatuskood(startDate, endDate, type);
    Assert.assertNotNull(result);
  }
  
}
