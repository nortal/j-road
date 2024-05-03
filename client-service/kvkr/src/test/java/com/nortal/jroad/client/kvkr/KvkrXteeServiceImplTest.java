package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.kvkr.types.eu.x_road.kvkr.ServiceinfoResponseDocument;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.annotation.Resource;

public class KvkrXteeServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private KvkrXRoadServiceImpl kvkrXRoadServiceImpl;

  @Test
  public void testGetServiceinfoV1() throws Exception {
    ServiceinfoResponseDocument.ServiceinfoResponse response = kvkrXRoadServiceImpl.getServiceinfoV1("38812192729", "TEST");
    Assertions.assertNotNull(response);
  }

}
