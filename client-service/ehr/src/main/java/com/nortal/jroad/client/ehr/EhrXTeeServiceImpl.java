package com.nortal.jroad.client.ehr;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.ehr.database.EhrXTeeDatabase;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseAndmedQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseAndmedResponse;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingResponse;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtResponse;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingResponse.ENEhitiseOtsing.Ehitised;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtResponse.ENOtsiAadressiAdrTxt.Aadress;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * @author Tanel Tensing
 */
@Service("ehrXTeeService")
public class EhrXTeeServiceImpl implements EhrXTeeService {

  @Resource
  private EhrXTeeDatabase ehrXTeeDatabase;

  /**
   * {@inheritDoc}
   *
   * @see com.nortal.jroad.client.service.EhrXTeeService#findENOtsiAadressiAdrTxt(java.lang.String, java.lang.String,
   *      java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
   *      java.lang.String)
   */
  public List<Aadress> findENOtsiAadressiAdrTxt(ENOtsiAadressiAdrTxtQuery request)
      throws XTeeServiceConsumptionException {

    ENOtsiAadressiAdrTxtResponse response = ehrXTeeDatabase.enOtsiAadressiAdrTxtV1(request);

    return response.getENOtsiAadressiAdrTxt() == null
           ? null
           : response.getENOtsiAadressiAdrTxt().getAadressList();
  }

  /**
   * {@inheritDoc}
   *
   * @see com.nortal.jroad.client.service.EhrXTeeService#findENEhitiseOtsing(java.math.BigInteger)
   */
  public List<Ehitised> findENEhitiseOtsing(BigInteger aadressId) throws XTeeServiceConsumptionException {

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
  public List<Ehitised> findENEhitiseOtsing(ENEhitiseOtsingQuery request) throws XTeeServiceConsumptionException {
    ENEhitiseOtsingResponse response = ehrXTeeDatabase.enEhitiseOtsingV1(request);

    return response.getENEhitiseOtsing() == null
           ? null
           : response.getENEhitiseOtsing().getEhitisedList();
  }

  /**
   * {@inheritDoc}
   *
   * @see com.nortal.jroad.client.service.EhrXTeeService#findENEhitiseAndmed(java.math.BigInteger)
   */
  public ENEhitiseAndmedResponse findENEhitiseAndmed(BigInteger ehitId) throws XTeeServiceConsumptionException {
    ENEhitiseAndmedQuery request = ENEhitiseAndmedQuery.Factory.newInstance();

    request.setEhitId(ehitId);

    return ehrXTeeDatabase.enEhitiseAndmedV1(request);
  }


  public void setEhrXTeeDatabase(EhrXTeeDatabase ehrXTeeDatabase) {
    this.ehrXTeeDatabase = ehrXTeeDatabase;
  }

}
