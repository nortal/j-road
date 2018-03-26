package com.nortal.jroad.client.kirstv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.KindlustusParingType;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2ResponseType;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

/**
 * @author Merilyn Renser
 */
public class Kirstv6XRoadServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private Kirstv6XRoadServiceImpl kirstv6XRoadService;

  @Test
  public void testFindKindlustused2V1() throws XRoadServiceConsumptionException {
    Kindlustused2ResponseType responseType = kirstv6XRoadService.findKindlustused2V1("48907010230",
        "EE11111111111", KindlustusParingType.T_4);
    assertNotNull(responseType);
  }
}
