package com.nortal.jroad.client.emkis;

import static org.junit.Assertions.assertNotNull;
import static org.junit.Assertions.fail;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.emkis.types.ee.riik.xtee.emkis.producers.producer.emkis.NaturaApplicationSearchResponse;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

public class EmkisXroadServiceTest extends BaseXRoadServiceImplTest {
  @Resource
  private EmkisXRoadService emkisXRoadService;

  @Test
  public void naturaApplicationSearchTest() {
    try {
      NaturaApplicationSearchResponse rsp = emkisXRoadService.naturaApplicationSearch(new Date(), 1L);
      assertNotNull(rsp.getVeaKood());
      assertNotNull(rsp.getVeaKirjeldus());
    } catch (Exception e) {
      fail();
    }
  }
}
