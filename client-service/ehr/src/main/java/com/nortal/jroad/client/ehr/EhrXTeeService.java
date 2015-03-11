package com.nortal.jroad.client.ehr;

import java.math.BigInteger;
import java.util.List;

import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseAndmedResponse;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtQuery;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENEhitiseOtsingResponse.ENEhitiseOtsing.Ehitised;
import com.nortal.jroad.client.ehr.types.ee.riik.xtee.ehr.producers.producer.ehr.ENOtsiAadressiAdrTxtResponse.ENOtsiAadressiAdrTxt.Aadress;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * <code>ehr</code> (Ehitisregister) database X-tee service.
 * 
 * @author Tanel Tensing
 */
public interface EhrXTeeService {

  /**
   * Find list of addresses from ehr database by address fields
   * 
   * @param tase1 Maakonna nimetus
   * @param tase2 Valla/Linna nimetus
   * @param tase3 Küla/Asustusüksuse nimetus
   * @param tase4 Väikekoha nimetus
   * @param tase5 Tänava/liikluspinna nimetus
   * @param tase6 Maaüksus/Nimetus
   * @param tase7 Aadressinumber
   * @param tekst Aadress vaba tekstina, otsingus võib kasutada %. DB stringi kujul: [maakond]+ [,]+ [vald/linn]+ [,]+
   *          [asustusüksus]+ [,]+ [väikekoht]..
   * @param olek ‚A’ – Ajalooline aadress ja ‚K’ – Kehtiv/Ootel/Normaliseerimata Kui olekut ei märgita, siis väljundisse
   *          tulevad nii „A“ kui ka „K“ aadressid
   * @return list of {@link Aadress} objects
   * @throws XTeeServiceConsumptionException
   */
  List<Aadress> findENOtsiAadressiAdrTxt(ENOtsiAadressiAdrTxtQuery request) throws XTeeServiceConsumptionException;

  /**
   * Find list of {@link Ehitised} objects by specified address id
   * 
   * @param aadressId Aadressi ID
   * @return list of {@link Ehitised} objects
   * @throws XTeeServiceConsumptionException
   */
  List<Ehitised> findENEhitiseOtsing(BigInteger aadressId) throws XTeeServiceConsumptionException;

  /**
   * Find list of {@link Ehitised} objects
   * 
   * @param ehrKood EHR kood Ehitise kood ehitisregistris
   * @param nimetus Ehitise nimetus
   * @param aadressId Aadressi ID
   * @param isikId Isiku ID
   * @param kaykId Katastriüksuse ID
   * @return list of {@link Ehitised} objects
   * @throws XTeeServiceConsumptionException
   */
  List<Ehitised> findENEhitiseOtsing(ENEhitiseOtsingQuery request) throws XTeeServiceConsumptionException;

  /**
   * Find building data by specified id
   * 
   * @param ehitId Ehitise ID
   * @return {@link ENEhitiseAndmedResponse} object with specified id
   * @throws XTeeServiceConsumptionException
   */
  ENEhitiseAndmedResponse findENEhitiseAndmed(BigInteger ehitId) throws XTeeServiceConsumptionException;

}
