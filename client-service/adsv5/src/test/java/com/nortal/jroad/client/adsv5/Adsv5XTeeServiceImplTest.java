package com.nortal.jroad.client.adsv5;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.nortal.jroad.client.adsv5.Adsv5XTeeService.NormalParamCallback;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalRequestType.NormalParam;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalRequestType.NormalParam.Aadressid;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalRequestType.NormalParam.Aadressid.Aadress;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalVastusType;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalVastusType.NormalTulem;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

public class Adsv5XTeeServiceImplTest extends BaseXRoadServiceImplTest {
  @Resource
  private Adsv5XTeeServiceImpl adsXTeeServiceImpl;
  
  @Test
  public void adsNormalOk() throws XRoadServiceConsumptionException {
  	ADSnormalVastusType v = adsXTeeServiceImpl.adsNormal(new NormalParamCallback() {
			public void populate(NormalParam normalParam) {
		  	Aadressid aadressid = normalParam.addNewAadressid();
		  	Aadress aadress = aadressid.addNewAadress();
		  	aadress.setTekst("kadaka tee 163");
      }
  	});
  	  	
  	NormalTulem result1 = v.getNormalTulemArray(0);
  	ADSnormalVastusType.NormalTulem.Aadressid.Aadress firstAdr = result1.getAadressid().getAadressArray(0);
  	Assert.assertTrue(StringUtils.isEmpty(firstAdr.getTekst()));
  }
  
  @Test
  public void adsNormalNotFound() throws XRoadServiceConsumptionException {
  	ADSnormalVastusType v = adsXTeeServiceImpl.adsNormal(new NormalParamCallback() {
			public void populate(NormalParam normalParam) {
		  	Aadressid aadressid = normalParam.addNewAadressid();
		  	Aadress aadress = aadressid.addNewAadress();
		  	aadress.setTekst("kadaka tee 7001");
      }
  	});
  	
  	NormalTulem result1 = v.getNormalTulemArray(0);
  	ADSnormalVastusType.NormalTulem.Aadressid.Aadress firstAdr = result1.getAadressid().getAadressArray(0);
  	
  	// unsuccessful normalization leaves part which were not normalized
  	Assert.assertFalse(StringUtils.isEmpty(firstAdr.getTekst()));
  }
}
