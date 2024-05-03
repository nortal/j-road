package com.nortal.jroad.client.priatoetusreg;

import java.math.BigDecimal;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.priatoetusreg.PriaToetusregXteeService;
import com.nortal.jroad.client.priatoetusreg.types.ee.riik.xtee.pria_toetusreg.producers.producer.pria_toetusreg.VtaJaakResponse;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 * @since 05.11.2013
 */
public class PriaToetusregXTeeServiceImplTest extends BaseXRoadServiceImplTest {
  @Resource
  private PriaToetusregXteeService priaToetusregXteeService;

  @Test
  public void vtaJaakV1() throws XRoadServiceConsumptionException {
    VtaJaakResponse rsp = priaToetusregXteeService.vtaJaakV1(null, null);

    Assertions.assertNull(rsp.getPriaIsikVtaJaak());
    Assertions.assertNull(rsp.getPriaEttevoteVtaJaak());
    Assertions.assertTrue(rsp.getVeakood() == -1);

    rsp = priaToetusregXteeService.vtaJaakV1("123", "xyz");

    Assertions.assertNotNull(rsp.getPriaIsikVtaJaak());
    Assertions.assertNotNull(rsp.getPriaEttevoteVtaJaak());

    rsp = priaToetusregXteeService.vtaJaakV1ByIsikukood("456");

    Assertions.assertTrue(rsp.getPriaIsikVtaJaak() != null && rsp.getPriaIsikVtaJaak().compareTo(BigDecimal.ZERO) >= 0);
    Assertions.assertNull(rsp.getPriaEttevoteVtaJaak());

    rsp = priaToetusregXteeService.vtaJaakV1ByRegistrikood("123456");

    Assertions.assertTrue(rsp.getPriaEttevoteVtaJaak() != null
        && rsp.getPriaEttevoteVtaJaak().compareTo(BigDecimal.ZERO) >= 0);
    Assertions.assertNull(rsp.getPriaIsikVtaJaak());
  }
}
