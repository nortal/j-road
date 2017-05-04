package com.nortal.jroad.client.rr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.IsikuStaatus;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR40IsikTaielikIsikukoodResponseDocument.RR40IsikTaielikIsikukoodResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR41IsikPohiandmedResponseDocument.RR41IsikPohiandmedResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR42IsikAadressKoodDocument.RR42IsikAadressKood;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR42IsikAadressKoodResponseDocument.RR42IsikAadressKoodResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR52ResponseDocument.RR52Response;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR63IsikAadrDokResponseDocument.RR63IsikAadrDokResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR67MuutusResponseType.TtKood.TtKoodid;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR72IsikResponseType.TtIsik.TtIsikud;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR81KMAisikkontrollResponseDocument.RR81KMAisikkontrollResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR84IsikuSeosedResponseDocument.RR84IsikuSeosedResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR96IsikDokElukSuheResponseDocument.RR96IsikDokElukSuheResponse;

import java.util.Date;
import java.util.List;

/**
 * <code>rr</code> (Rahvastikuregister) database X-tee service.
 * 
 * @author Roman Tekhov
 */
public interface RrXRoadService {

  Integer getState() throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR72_isik.v1</code> service.
   */
  List<TtIsikud> findRR72Isik(String... idCodes) throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR63isikAadrDok.v1</code> service.
   */
  RR63IsikAadrDokResponse findRR63IsikAadrDok(String surname, String firstName, String idCode, String birthDate)
      throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR81KMAisikkontroll.v1</code> service.
   */
  RR81KMAisikkontrollResponse getRR81KMAisikkontrollV1(String idCode) throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR81KMAisikkontroll.v2</code> service.
   */
  RR81KMAisikkontrollResponse getRR81KMAisikkontrollV2(String idCode) throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR40isikTaielikIsikukood.v1</code> service.
   */
  RR40IsikTaielikIsikukoodResponse findRR40isikTaielikIsikukood(String isikukood)
      throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR42isikAadressKood.v1</code> service.
   */
  RR42IsikAadressKoodResponse findRR42isikAadressKood(RR42RequestCallback cb) throws XTeeServiceConsumptionException;

  interface RR42RequestCallback {
    void populate(RR42IsikAadressKood paring);
  }

  /**
   * <code>rr.RR52.v1</code> service.
   */
  RR52Response getRR52(String idCode, String forename, String surname) throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR96IsikDokElukSuhe_v1.v1</code> service.
   */
  RR96IsikDokElukSuheResponse getRR96isikDokElukSuhe(String isikueesnimi,
                                                     String isikuperenimi,
                                                     String isikukood,
                                                     Long vastusteArv)
      throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR67MuutusV1.v1</code> service.
   */
  List<TtKoodid> findRR67MuutusV1(Date algus, Date lopp, String... koodid) throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR84IsikuSeosed.v1</code> service.
   */
  RR84IsikuSeosedResponse findRR84IsikuSeosed(String isikukood) throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RR41isikPohiandmedV1.v1</code> service.
   */
  RR41IsikPohiandmedResponse findRR41isikPohiandmedV1(String perenimi,
                                                      String eesnimi,
                                                      String isikukood,
                                                      String vald,
                                                      IsikuStaatus staatus,
                                                      Long vastusteArv)
      throws XTeeServiceConsumptionException;

}
