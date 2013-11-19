package ee.webmedia.xtee.client.priavra;

import java.math.BigDecimal;

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
public class PraiVraXTeeServiceImplTest extends BaseXTeeServiceImplTest {
  @Resource
  private PriaVraXteeService priaVraXteeService;

  @Test
  public void vtaJaakV1() throws XTeeServiceConsumptionException {
    VtaJaakResponse rsp = priaVraXteeService.vtaJaakV1(null, null);

    Assert.assertNull(rsp.getPriaIsikVtaJaak());
    Assert.assertNull(rsp.getPriaEttevoteVtaJaak());
    Assert.assertTrue(rsp.getVeakood() == -1);

    rsp = priaVraXteeService.vtaJaakV1("123", "xyz");

    Assert.assertNotNull(rsp.getPriaIsikVtaJaak());
    Assert.assertNotNull(rsp.getPriaEttevoteVtaJaak());

    rsp = priaVraXteeService.vtaJaakV1ByIsikukood("456");

    Assert.assertTrue(rsp.getPriaIsikVtaJaak() != null && rsp.getPriaIsikVtaJaak().compareTo(BigDecimal.ZERO) >= 0);
    Assert.assertNull(rsp.getPriaEttevoteVtaJaak());

    rsp = priaVraXteeService.vtaJaakV1ByRegistrikood("123456");

    Assert.assertTrue(rsp.getPriaEttevoteVtaJaak() != null
        && rsp.getPriaEttevoteVtaJaak().compareTo(BigDecimal.ZERO) >= 0);
    Assert.assertNull(rsp.getPriaIsikVtaJaak());
  }
}
