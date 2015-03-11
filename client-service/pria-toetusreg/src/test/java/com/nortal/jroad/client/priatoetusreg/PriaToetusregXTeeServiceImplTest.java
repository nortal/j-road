package com.nortal.jroad.client.priatoetusreg;

import java.math.BigDecimal;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.priatoetusreg.PriaToetusregXteeService;
import com.nortal.jroad.client.priatoetusreg.types.ee.riik.xtee.pria_toetusreg.producers.producer.pria_toetusreg.VtaJaakResponse;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
public class PriaToetusregXTeeServiceImplTest extends BaseXTeeServiceImplTest {
  @Resource
  private PriaToetusregXteeService priaToetusregXteeService;

  @Test
  public void vtaJaakV1() throws XTeeServiceConsumptionException {
    VtaJaakResponse rsp = priaToetusregXteeService.vtaJaakV1(null, null);

    Assert.assertNull(rsp.getPriaIsikVtaJaak());
    Assert.assertNull(rsp.getPriaEttevoteVtaJaak());
    Assert.assertTrue(rsp.getVeakood() == -1);

    rsp = priaToetusregXteeService.vtaJaakV1("123", "xyz");

    Assert.assertNotNull(rsp.getPriaIsikVtaJaak());
    Assert.assertNotNull(rsp.getPriaEttevoteVtaJaak());

    rsp = priaToetusregXteeService.vtaJaakV1ByIsikukood("456");

    Assert.assertTrue(rsp.getPriaIsikVtaJaak() != null && rsp.getPriaIsikVtaJaak().compareTo(BigDecimal.ZERO) >= 0);
    Assert.assertNull(rsp.getPriaEttevoteVtaJaak());

    rsp = priaToetusregXteeService.vtaJaakV1ByRegistrikood("123456");

    Assert.assertTrue(rsp.getPriaEttevoteVtaJaak() != null
        && rsp.getPriaEttevoteVtaJaak().compareTo(BigDecimal.ZERO) >= 0);
    Assert.assertNull(rsp.getPriaIsikVtaJaak());
  }
}
