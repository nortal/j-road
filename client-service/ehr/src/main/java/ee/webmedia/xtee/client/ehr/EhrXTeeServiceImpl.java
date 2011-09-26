package ee.webmedia.xtee.client.ehr;

import ee.webmedia.xtee.client.ehr.database.EhrXTeeDatabase;
import ee.webmedia.xtee.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseAndmedQuery;
import ee.webmedia.xtee.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseAndmedResponse;
import ee.webmedia.xtee.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingQuery;
import ee.webmedia.xtee.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingResponse;
import ee.webmedia.xtee.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingResponse.ENEhitiseOtsing.Ehitised;
import ee.webmedia.xtee.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtQuery;
import ee.webmedia.xtee.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtResponse;
import ee.webmedia.xtee.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtResponse.ENOtsiAadressiAdrTxt.Aadress;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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
   * @see ee.webmedia.xtee.client.service.EhrXTeeService#findENOtsiAadressiAdrTxt(java.lang.String, java.lang.String,
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
   * @see ee.webmedia.xtee.client.service.EhrXTeeService#findENEhitiseOtsing(java.math.BigInteger)
   */
  public List<Ehitised> findENEhitiseOtsing(BigInteger aadressId) throws XTeeServiceConsumptionException {

    ENEhitiseOtsingQuery request = ENEhitiseOtsingQuery.Factory.newInstance();
    request.setAadressId(aadressId);

    return findENEhitiseOtsing(request);
  }

  /**
   * {@inheritDoc}
   *
   * @see ee.webmedia.xtee.client.service.EhrXTeeService#findENEhitiseOtsing(java.math.BigInteger, java.lang.String,
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
   * @see ee.webmedia.xtee.client.service.EhrXTeeService#findENEhitiseAndmed(java.math.BigInteger)
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
