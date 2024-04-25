package com.nortal.jroad.client.tam;

import java.util.Calendar;
import java.util.List;

import jakarta.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tam.TamXTeeServiceImpl;
import com.nortal.jroad.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.Registriisik;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

public class TamXTeeServiceImplTest extends BaseXTeeServiceImplTest {
  
  @Resource
  private TamXTeeServiceImpl tamXTeeServiceImpl;
  
  @Test
  public void testRegistriisik() throws XTeeServiceConsumptionException {
    String kood = "D03115";
    List<Registriisik> result = tamXTeeServiceImpl.findRegistriisik(kood);
    Assert.assertEquals("One result expected", 1, result.size());
    Assert.assertEquals("35210010248", result.get(0).getIsikukood());
  }
  
  @Test
  public void testTervishoiutootajamuudatuskood() throws XTeeServiceConsumptionException {
    int type = 1;
    Calendar startDate = Calendar.getInstance();
    Calendar endDate = startDate;
    List<String> result = tamXTeeServiceImpl.findTervishoiutootajamuudatuskood(startDate, endDate, type);
    Assert.assertNotNull(result);
  }
  
}
