package com.nortal.jroad.client.kirstv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2ResponseType;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

/**
 * @author Merilyn Renser
 */
public class Kirstv6XTeeServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private Kirstv6XTeeServiceImpl kirstv6XTeeServiceImpl;

  @Test
  public void testFindHealthInsurances() throws XRoadServiceConsumptionException {
    Kindlustused2ResponseType responseType = kirstv6XTeeServiceImpl.findKindlustused2("39109260217", "EE11111111111");
    assertNotNull(responseType);
  }
}
