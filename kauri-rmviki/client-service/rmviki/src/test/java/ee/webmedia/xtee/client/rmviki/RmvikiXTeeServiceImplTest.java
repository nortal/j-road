package ee.webmedia.xtee.client.rmviki;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Kauri Kägo (kauri@webmedia.ee)
 */
public class RmvikiXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private RmvikiXTeeServiceImpl rmvikiXTeeServiceImpl;

  @Test
  public void zRKOVARV1() throws XTeeServiceConsumptionException {
    ZRKOVARResponse response = rmvikiXTeeServiceImpl.zRKOVARV1("70004324");
    Assert.assertNotNull(response);
  }
}
