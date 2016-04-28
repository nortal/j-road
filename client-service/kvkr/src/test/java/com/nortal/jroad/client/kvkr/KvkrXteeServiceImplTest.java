package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.kvkr.types.ee.x_road.kvkr.producer.ServiceinfoResponseDocument;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class KvkrXteeServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private KvkrXTeeServiceImpl kvkrXTeeServiceImpl;

  @Test
  public void testGetServiceinfoV1() throws Exception {
    ServiceinfoResponseDocument.ServiceinfoResponse response = kvkrXTeeServiceImpl.getServiceinfoV1("38812192729", "TEST");
    Assert.assertNotNull(response);
  }

}
