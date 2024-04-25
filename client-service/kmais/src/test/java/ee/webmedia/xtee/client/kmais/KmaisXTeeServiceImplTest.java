package com.nortal.jroad.client.kmais;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kmais.KmaisXTeeService;
import com.nortal.jroad.client.kmais.KmaisXTeeService.IsikukoodNimiFragSalaCallback;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.AlalineElamislubaKleebisPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.BlacklistVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.DokNumberSala;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.EestiKodanikuPassPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdIsikukoodNimiFrag;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IllegaalVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikukoodNimiFragSala;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikutToendavatePvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ToolubaPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ValismaalasePassPvaVastus;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import jakarta.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;

public class KmaisXTeeServiceImplTest extends BaseXTeeServiceImplTest {
  @Resource
  private KmaisXTeeService kmaisXTeeService;
  private static final String TEST_IK = "38606282771";

  @Test
  public void isikutToendavate6V1() throws XTeeServiceConsumptionException {
    IsikutToendavatePvaVastus isikutToendavate6V1 =
        kmaisXTeeService.isikutToendavate6V1(TEST_IK, null, null, null, null);
    Assert.assertEquals(isikutToendavate6V1.getDetailandmed().getIsikukood(), TEST_IK);
  }

  @Test
  public void eestiKodaniku19V1() throws XTeeServiceConsumptionException {
    IsikukoodNimiFragSalaCallback callback = new IsikukoodNimiFragSalaCallback() {

      public void populate(IsikukoodNimiFragSala infs) {
        infs.setIsikukood(TEST_IK);
      }
    };

    EestiKodanikuPassPvaVastus eestiKodaniku19V1 = kmaisXTeeService.eestiKodaniku19V1(callback);
    Assert.assertEquals(eestiKodaniku19V1.getDetailandmed().getIsikukood(), TEST_IK);
  }

  @Test
  public void valismaalasePassiandmete12V1() throws XTeeServiceConsumptionException {
    IsikukoodNimiFragSalaCallback callback = new IsikukoodNimiFragSalaCallback() {

      public void populate(IsikukoodNimiFragSala infs) {
        infs.setIsikukood("50507295724");
      }
    };
    
    ValismaalasePassPvaVastus valismaalasePassiandmete12V1 = kmaisXTeeService.valismaalasePassiandmete12V1(callback);
    Assert.assertEquals(valismaalasePassiandmete12V1.getDetailandmed().getIsikukood(), "50507295724");
  }
  
  @Test
  public void ebaseaduslikult2() throws XTeeServiceConsumptionException {
    IdIsikukoodNimiFrag request = IdIsikukoodNimiFrag.Factory.newInstance();
    request.setSynniaeg("1991");
    request.setEesnimi("ARDE");
    request.setPerenimi("IZIBAEV");
    IllegaalVastus ebaseaduslikult2 = kmaisXTeeService.ebaseaduslikult2(request);
    Assert.assertEquals(ebaseaduslikult2.getDetailandmed().getEnimi().toUpperCase(), "ARDE");
  }
  
  @Test
  public void sissesoiduKeelduOmavate2() throws XTeeServiceConsumptionException {
    IdIsikukoodNimiFrag request = IdIsikukoodNimiFrag.Factory.newInstance();
    request.setSynniaeg("1976");
    request.setEesnimi("ABEL");
    request.setPerenimi("FOMITSOV");
    BlacklistVastus sissesoiduKeelduOmavate2 = kmaisXTeeService.sissesoiduKeelduOmavate2(request);
    Assert.assertEquals(sissesoiduKeelduOmavate2.getDetailandmed().getEnimi().toUpperCase(), "ABEL");
  }
  
  @Test
  public void eestiKodaniku17() throws XTeeServiceConsumptionException {
	DokNumberSala request = DokNumberSala.Factory.newInstance();
    request.setDokNumber("K1166492");
    EestiKodanikuPassPvaVastus eestiKodanikuPassPvaVastus = kmaisXTeeService.eestiKodaniku17(request);
    Assert.assertEquals(eestiKodanikuPassPvaVastus.getDetailandmed().getPassNr().toUpperCase(), "K1166492");
  }
  
  @Test
  public void isikutunnistuseAndmete10() throws XTeeServiceConsumptionException {
	DokNumberSala request = DokNumberSala.Factory.newInstance();
    request.setDokNumber("A0027818");
    IdPvaVastus idPvaVastus = kmaisXTeeService.isikutunnistuseAndmete10(request);
    Assert.assertEquals(idPvaVastus.getDetailandmed().getDokNr().toUpperCase(), "A0027818");
  }
  
  @Test
  public void valismaalasePassiandmete10() throws XTeeServiceConsumptionException {
	DokNumberSala request = DokNumberSala.Factory.newInstance();
    request.setDokNumber("V0115316");
    ValismaalasePassPvaVastus valismaalasePassPvaVastus = kmaisXTeeService.valismaalasePassiandmete10(request);
    Assert.assertEquals(valismaalasePassPvaVastus.getDetailandmed().getPassNr().toUpperCase(), "V0115316");
  }  
  
  @Test
  public void alaliseElamisloa6() throws XTeeServiceConsumptionException {
	IsikukoodNimiFragSala request = IsikukoodNimiFragSala.Factory.newInstance();
    request.setIsikukood("37611122210");
    AlalineElamislubaKleebisPvaVastus alalineElamislubaKleebisPvaVastus = kmaisXTeeService.alaliseElamisloa6(request);
    Assert.assertEquals(alalineElamislubaKleebisPvaVastus.getDetailandmed().getEesnimi().toUpperCase(), "ABEL");
  }
  
  @Test
  public void tooloaAndmete10() throws XTeeServiceConsumptionException {
	IsikukoodNimiFragSala request = IsikukoodNimiFragSala.Factory.newInstance();
    request.setIsikukood("47106190348");
    ToolubaPvaVastus toolubaPvaVastus = kmaisXTeeService.tooloaAndmete10(request);
    Assert.assertEquals(toolubaPvaVastus.getDetailandmed().getEesnimi().toUpperCase(), "ALIISE-MADILDE");
  }
}
