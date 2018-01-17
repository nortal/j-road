package com.nortal.jroad.client.ehr;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.nortal.jroad.client.ehr.EhrXTeeServiceImpl;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseAndmedResponse;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingResponse.ENEhitiseOtsing.Ehitised;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtResponse.ENOtsiAadressiAdrTxt.Aadress;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

/**
 * @author Tanel Tensing
 */
public class EhrXTeeServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private EhrXTeeServiceImpl ehrXTeeServiceImpl;

  @Test
  public void findENOtsiAadressiAdrTxt() throws XRoadServiceConsumptionException {

    String tase1 = "Harjumaa";

    ENOtsiAadressiAdrTxtQuery query = ENOtsiAadressiAdrTxtQuery.Factory.newInstance();
    query.setTase1(tase1);
    query.setTase2("Aegviidu");
    query.setTase3("Aegviidu");
    query.setTase7("1");
    query.setOlek("A");

    List<Aadress> response = ehrXTeeServiceImpl.findENOtsiAadressiAdrTxt(query);

    Assert.assertNotNull(response);
    Assert.assertFalse(response.isEmpty());
    Assert.assertEquals(tase1, response.get(0).getTase1Nimetus());
  }

  @Test
  public void findENEhitiseOtsing() throws XRoadServiceConsumptionException {
    List<Ehitised> response = ehrXTeeServiceImpl.findENEhitiseOtsing(BigInteger.valueOf(3374040));
    Assert.assertNotNull(response);
    Assert.assertFalse(response.isEmpty());
  }

  @Test
  public void findENEhitiseAndmed() throws XRoadServiceConsumptionException {
    ENEhitiseAndmedResponse response = ehrXTeeServiceImpl.findENEhitiseAndmed(BigInteger.valueOf(3374040));
    Assert.assertNotNull(response);
  }

}
