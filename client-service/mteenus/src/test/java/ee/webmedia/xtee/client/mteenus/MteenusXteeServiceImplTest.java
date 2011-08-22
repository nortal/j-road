package ee.webmedia.xtee.client.mteenus;

import javax.annotation.Resource;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.mteenus.Sms;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import org.junit.Test;
import java.util.List;
import javax.annotation.Resource;
import org.apache.xmlbeans.XmlString;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import ee.webmedia.xtee.client.util.XmlBeansUtil;

/**
 * @author Aleksandr.Koltakov
 */
public class MteenusXteeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private MteenusXTeeServiceImpl mteenusXTeeServiceImpl;

  @Test
  public void testSend() throws XTeeServiceConsumptionException {
    Sms sms = new Sms();
    sms.setIsikukood("37801113714");
    sms.setTeenusId("169");
    sms.setSaatjaNumber("0");
    sms.setSisu("XTee test message");
    mteenusXTeeServiceImpl.send(sms);
  }
}