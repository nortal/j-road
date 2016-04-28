package com.nortal.jroad.client.ads;

import java.math.BigInteger;
import java.util.Calendar;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.nortal.jroad.client.ads.AdsXTeeService;
import com.nortal.jroad.client.ads.AdsXTeeServiceImpl;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2VastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompklassifVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkomponendidVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompotsingVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSmuudatusedVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSnormalVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjmuudatusedv2VastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjotsingv2VastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSprobleemidVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSteavitusedVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADStekstotsingVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2ParingType.AadrMuudatusedParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompklassifParingType.KlassifParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkomponendidParingType.KompParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompotsingParingType.AadrKompParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSmuudatusedParingType.MuudatusedParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSnormalParingType.NormalParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSnormalParingType.NormalParam.Aadressid;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSnormalParingType.NormalParam.Aadressid.Aadress;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSnormalParingType.NormalParam.Aadressid.Aadress.AdsTase1;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedParingType.ObjMuudatusedParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjotsingv2ParingType.ObjKompParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSprobleemidParingType.ProbleemidParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSteavitusedParingType.TeavitusedParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADStekstotsingParingType.AadrTekstParam;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

public class AdsXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private AdsXTeeServiceImpl adsXTeeServiceImpl;
  
  @Test
  public void findKompklassifV1() throws XRoadServiceConsumptionException {
	  AdsXTeeService.KlassifParamCallback cb = new AdsXTeeService.KlassifParamCallback() {
		  public void populate(KlassifParam kp) {
			  kp.setMaxarv(BigInteger.valueOf(5));
			  kp.setLogId(BigInteger.valueOf(0));
		  }
	  };

	  ADSkompklassifVastusType response = adsXTeeServiceImpl.kompklassifV1(cb);

	  Assert.assertNotNull(response);
  }
  
  @Test
  public void findMuudatusedsV1() throws XRoadServiceConsumptionException {
	  AdsXTeeService.MuudatusedParamCallback cb = new AdsXTeeService.MuudatusedParamCallback() {
		  public void populate(MuudatusedParam mp) {
			  mp.setMaxarv(BigInteger.valueOf(5));
			  mp.setLogId(BigInteger.valueOf(0));
		  }
	  };

	  ADSmuudatusedVastusType response = adsXTeeServiceImpl.muudatusedV1(cb);

	  Assert.assertNotNull(response);
  }

  @Test
  public void findKompotsingV1() throws XRoadServiceConsumptionException {
    AdsXTeeService.AadrKompParamCallback cb = new AdsXTeeService.AadrKompParamCallback() {

      @Override
      public void populate(AadrKompParam aadrKompParam) {
        aadrKompParam.setMaxarv(BigInteger.valueOf(5));
      }
    };
    ADSkompotsingVastusType response = adsXTeeServiceImpl.kompotsingV1(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findObjotsingV2() throws XRoadServiceConsumptionException {
    AdsXTeeService.ObjKompParamCallback cb = new AdsXTeeService.ObjKompParamCallback() {

      @Override
      public void populate(ObjKompParam objKompParam) {
        objKompParam.setMaxarv(BigInteger.valueOf(5));
      }
    };
    ADSobjotsingv2VastusType response = adsXTeeServiceImpl.objotsingV2(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findKomponendidV1() throws XRoadServiceConsumptionException {
    AdsXTeeService.KompParamCallback cb = new AdsXTeeService.KompParamCallback() {

      @Override
      public void populate(KompParam kompParam) {
        kompParam.setMaxarv(5);
      }
    };

    ADSkomponendidVastusType response = adsXTeeServiceImpl.komponendidV1(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findNormalV1() throws XRoadServiceConsumptionException {
    AdsXTeeService.NormalParamCallback cb = new AdsXTeeService.NormalParamCallback() {

      @Override
      public void populate(NormalParam normalParam) {
        Aadressid aadressid = Aadressid.Factory.newInstance();
        Aadress aadress = aadressid.addNewAadress();
        AdsTase1 tase1 = AdsTase1.Factory.newInstance();
        tase1.setKood("1");
        aadress.setAdsTase1Array(new AdsTase1[] { tase1 });
        normalParam.setAadressid(aadressid);
      }
    };

    ADSnormalVastusType response = adsXTeeServiceImpl.normalV1(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findTeavitusedV1() throws XRoadServiceConsumptionException {
    AdsXTeeService.TeavitusedParamCallback cb = new AdsXTeeService.TeavitusedParamCallback() {

      @Override
      public void populate(TeavitusedParam teavitusedParam) {
        teavitusedParam.setMaxarv(BigInteger.valueOf(5));
      }
    };

    ADSteavitusedVastusType response = adsXTeeServiceImpl.teavitusedV1(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findTekstotsingV1() throws XRoadServiceConsumptionException {
    AdsXTeeService.AadrTekstParamCallback cb = new AdsXTeeService.AadrTekstParamCallback() {

      @Override
      public void populate(AadrTekstParam aadrTekstParam) {
        aadrTekstParam.setMaxarv(BigInteger.valueOf(5));
      }
    };

    ADStekstotsingVastusType response = adsXTeeServiceImpl.tekstotsingV1(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findAadrmuudatusedV2() throws XRoadServiceConsumptionException {
    AdsXTeeService.AadrMuudatusedParamCallback cb = new AdsXTeeService.AadrMuudatusedParamCallback() {

      @Override
      public void populate(AadrMuudatusedParam aadrMuudatusedParam) {
        aadrMuudatusedParam.setMaxarv(BigInteger.valueOf(5));
      }
    };

    ADSaadrmuudatusedv2VastusType response = adsXTeeServiceImpl.aadrmuudatusedV2(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findObjaadrmuudatusedV1() throws XRoadServiceConsumptionException {
    AdsXTeeService.ObjAadrMuudatusedParamCallback cb = new AdsXTeeService.ObjAadrMuudatusedParamCallback() {

      @Override
      public void populate(ObjMuudatusedParam objMuudatusedParam) {
        objMuudatusedParam.setMaxarv(BigInteger.valueOf(5));
      }
    };

    ADSobjaadrmuudatusedVastusType response = adsXTeeServiceImpl.objaadrmuudatusedV1(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findObjmuudatusedV2() throws XRoadServiceConsumptionException {
    AdsXTeeService.ObjMuudatusedParamCallback cb = new AdsXTeeService.ObjMuudatusedParamCallback() {

      @Override
      public void populate(com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjmuudatusedv2ParingType.ObjMuudatusedParam objMuudatusedParam) {
        objMuudatusedParam.setMaxarv(BigInteger.valueOf(5));
      }
    };

    ADSobjmuudatusedv2VastusType response = adsXTeeServiceImpl.objmuudatusedV2(cb);

    Assert.assertNotNull(response);
  }

  @Test
  public void findProbleemidV1() throws XRoadServiceConsumptionException {
    AdsXTeeService.ProbleemidParamCallback cb = new AdsXTeeService.ProbleemidParamCallback() {

      @Override
      public void populate(ProbleemidParam probleemidParam) {
        probleemidParam.setMaxarv(BigInteger.valueOf(5));
        Calendar muudetudAlates = Calendar.getInstance();
        muudetudAlates.set(Calendar.DATE, muudetudAlates.get(Calendar.DATE) - 7);
        probleemidParam.setMuudetudAlates(muudetudAlates);
      }
    };

    ADSprobleemidVastusType response = adsXTeeServiceImpl.probleemidV1(cb);

    Assert.assertNotNull(response);
  }
}
