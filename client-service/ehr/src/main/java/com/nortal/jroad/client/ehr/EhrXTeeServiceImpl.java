package com.nortal.jroad.client.ehr;

import java.math.BigInteger;
import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.ehr.database.EhrXRoadDatabase;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseAndmedQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseAndmedResponse;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingResponse;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtResponse;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingResponse.ENEhitiseOtsing.Ehitised;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtResponse.ENOtsiAadressiAdrTxt.Aadress;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

/**
 * @author Tanel Tensing
 */
@Service("ehrXTeeService")
public class EhrXTeeServiceImpl implements EhrXTeeService {

  @Resource
  private EhrXRoadDatabase ehrXRoadDatabase;

  /**
   * {@inheritDoc}
   *
   * @see com.nortal.jroad.client.service.EhrXTeeService#findENOtsiAadressiAdrTxt(java.lang.String, java.lang.String,
   *      java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
   *      java.lang.String)
   */
  public List<Aadress> findENOtsiAadressiAdrTxt(ENOtsiAadressiAdrTxtQuery request)
      throws XRoadServiceConsumptionException {

    ENOtsiAadressiAdrTxtResponse response = ehrXRoadDatabase.enOtsiAadressiAdrTxtV1(request);

    return response.getENOtsiAadressiAdrTxt() == null
           ? null
           : response.getENOtsiAadressiAdrTxt().getAadressList();
  }

  /**
   * {@inheritDoc}
   *
   * @see com.nortal.jroad.client.service.EhrXTeeService#findENEhitiseOtsing(java.math.BigInteger)
   */
  public List<Ehitised> findENEhitiseOtsing(BigInteger aadressId) throws XRoadServiceConsumptionException {

    ENEhitiseOtsingQuery request = ENEhitiseOtsingQuery.Factory.newInstance();
    request.setAadressId(aadressId);

    return findENEhitiseOtsing(request);
  }

  /**
   * {@inheritDoc}
   *
   * @see com.nortal.jroad.client.service.EhrXTeeService#findENEhitiseOtsing(java.math.BigInteger, java.lang.String,
   *      java.math.BigInteger, java.math.BigInteger, java.math.BigInteger)
   */
  public List<Ehitised> findENEhitiseOtsing(ENEhitiseOtsingQuery request) throws XRoadServiceConsumptionException {
    ENEhitiseOtsingResponse response = ehrXRoadDatabase.enEhitiseOtsingV1(request);

    return response.getENEhitiseOtsing() == null
           ? null
           : response.getENEhitiseOtsing().getEhitisedList();
  }

  /**
   * {@inheritDoc}
   *
   * @see com.nortal.jroad.client.service.EhrXTeeService#findENEhitiseAndmed(java.math.BigInteger)
   */
  public ENEhitiseAndmedResponse findENEhitiseAndmed(BigInteger ehitId) throws XRoadServiceConsumptionException {
    ENEhitiseAndmedQuery request = ENEhitiseAndmedQuery.Factory.newInstance();

    request.setEhitId(ehitId);

    return ehrXRoadDatabase.enEhitiseAndmedV1(request);
  }


  public void setEhrXRoadDatabase(EhrXRoadDatabase ehrXRoadDatabase) {
    this.ehrXRoadDatabase = ehrXRoadDatabase;
  }

}
