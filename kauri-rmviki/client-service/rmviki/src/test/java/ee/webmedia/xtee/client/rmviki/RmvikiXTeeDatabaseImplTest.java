package ee.webmedia.xtee.client.rmviki;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.rmviki.database.RmvikiXTeeDatabaseImpl;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest;
import ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Kauri Kägo (kauri@webmedia.ee)
 */
public class RmvikiXTeeDatabaseImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private RmvikiXTeeDatabaseImpl rmvikiXTeeDatabaseImpl;

  @Test
  public void zRKOVARV1() throws XTeeServiceConsumptionException {
    ZRKOVARRequest req = ZRKOVARRequest.Factory.newInstance();
    req.setKOOD("70004324");
    ZRKOVARResponse response = rmvikiXTeeDatabaseImpl.zRKOVARV1(req);

    Assert.assertNotNull(response);
  }
}
