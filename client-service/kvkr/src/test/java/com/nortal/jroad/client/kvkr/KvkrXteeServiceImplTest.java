package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.kvkr.types.eu.x_road.kvkr.ServiceinfoResponseDocument;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class KvkrXteeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private KvkrXRoadServiceImpl kvkrXRoadServiceImpl;

  @Test
  public void testGetServiceinfoV1() throws Exception {
    ServiceinfoResponseDocument.ServiceinfoResponse response = kvkrXRoadServiceImpl.getServiceinfoV1("38812192729", "TEST");
    Assert.assertNotNull(response);
  }

}
