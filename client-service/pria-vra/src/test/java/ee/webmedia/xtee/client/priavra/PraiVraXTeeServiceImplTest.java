package ee.webmedia.xtee.client.priavra;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.priavra.types.ee.riik.xtee.pria_vra.producers.producer.pria_vra.VtaJaakResponse;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
// TODO: implements some real tests
public class PraiVraXTeeServiceImplTest extends BaseXTeeServiceImplTest {
  @Resource
  private PriaVraXteeServiceImpl priaVraXteeService;

  @Test
  public void vtaJaakV1() throws XTeeServiceConsumptionException {
    VtaJaakResponse rsp = priaVraXteeService.vtaJaakV1(null, null);

    Assert.assertNotNull(rsp);
  }
}
