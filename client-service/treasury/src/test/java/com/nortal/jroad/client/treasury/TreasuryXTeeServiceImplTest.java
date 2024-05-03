package com.nortal.jroad.client.treasury;

import java.io.InputStream;
import java.util.UUID;

import jakarta.annotation.Resource;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

/**
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 */
public class TreasuryXTeeServiceImplTest extends BaseXRoadServiceImplTest {
  private static final String TYPE = "PAYMENT";

  @Resource
  private TreasuryXTeeServiceImpl treasuryXTeeService;

  @Before
  public void init() {
    treasuryXTeeService.setDatabase("rmviki");
  }

  @Test
  public void sendDocumentTestV1() throws XRoadServiceConsumptionException {

    try {
      InputStream is = getClass().getClassLoader().getResourceAsStream("makseM3.bdoc");
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      os.write(is);
      is.close();
      os.close();
      treasuryXTeeService.sendDocument(UUID.randomUUID().toString(), TYPE, os.toByteArray());
    } catch (Exception e) {
      e.printStackTrace();
      Assertions.fail("TreasuryXTeeServiceImplTest.sendDocumentTestV1: exception occurred");
    }
  }
}
