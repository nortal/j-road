package com.nortal.jroad.client.tosjuht;

import java.io.IOException;
import java.util.List;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.tosjuht.model.ManusModel;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseDigiDokResponse;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseManusResponse;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfResponse;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.VastuseKood;

/**
 * ePria xtee teenused
 * 
 * @author Allar Tammik
 * @author Lauri Lättemäe 
 * @date 10.09.2010
 */
public interface EpriaXRoadService {

  /**
   * @param xml
   * @param securityServer
   * @param isikukood
   * @return
   * @throws XRoadServiceConsumptionException
   */
  public String epria(String xml, String securityServer, String isikukood) throws XRoadServiceConsumptionException;

  /**
   * @param xml
   * @param securityServer
   * @param isikukood
   * @return
   * @throws XRoadServiceConsumptionException
   */
  String epriaParingManusega(String xml, String securityServer, String isikukood)
      throws XRoadServiceConsumptionException;

  /**
   * @param kandeNumber
   * @return
   * @throws XRoadServiceConsumptionException
   */
  DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String kandeNumber) throws XRoadServiceConsumptionException;

  /**
   * @param securityServer
   * @param kandeNumber
   * @return
   * @throws XRoadServiceConsumptionException
   */
  DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String securityServer, String kandeNumber)
      throws XRoadServiceConsumptionException;

  /**
   * Tagastab ePria esitatud taotluse PDFi DHSist
   * 
   * @param kandeNumber Taotluse kande number
   * @return {@link DhVaataEsitatudPdfResponse}
   * @throws XRoadServiceConsumptionException
   * @throws IOException
   */
  DhsVaataTaotlusePdfResponse vaataTaotlusePdf(String kandeNumber) throws XRoadServiceConsumptionException;

  /**
   * @param securityServer
   * @param kandeNumber
   * @return
   * @throws XRoadServiceConsumptionException
   */
  DhsVaataTaotlusePdfResponse vaataTaotlusePdf(String securityServer, String kandeNumber)
      throws XRoadServiceConsumptionException;

  /**
   * @param kandeNumber Taotluse kande number
   * @param portaaliId Manuse id ePria portaalis
   * @param sisuFailId Kanderaamatu id
   * @return {@link DhVaataTaotluseManusResponse}
   * @throws XRoadServiceConsumptionException
   */
  DhsVaataTaotluseManusResponse vaataTatoluseManus(String kandeNumber,
                                                   String portaaliId,
                                                   String sisuFailId,
                                                   String vaataja,
                                                   Integer priaRoll) throws XRoadServiceConsumptionException;

  /**
   * @param securityServer
   * @param kandeNumber
   * @param portaaliId
   * @param sisuFailId
   * @param vaataja
   * @param priaRoll
   * @return
   * @throws XRoadServiceConsumptionException
   */
  DhsVaataTaotluseManusResponse vaataTatoluseManus(String securityServer,
                                                   String kandeNumber,
                                                   String portaaliId,
                                                   String sisuFailId,
                                                   String vaataja,
                                                   Integer priaRoll) throws XRoadServiceConsumptionException;

  /**
   * @param kandeNumber
   * @param digiDoc
   * @param pdf
   * @param manused
   * @return
   * @throws XRoadServiceConsumptionException
   */
  VastuseKood saadaTaotlus(String kandeNumber, ManusModel digiDoc, ManusModel pdf, List<ManusModel> manused)
      throws XRoadServiceConsumptionException;

  /**
   * @param securityServer
   * @param kandeNumber
   * @param digiDoc
   * @param pdf
   * @param manused
   * @return
   * @throws XRoadServiceConsumptionException
   */
  VastuseKood saadaTaotlus(String securityServer,
                           String kandeNumber,
                           ManusModel digiDoc,
                           ManusModel pdf,
                           List<ManusModel> manused) throws XRoadServiceConsumptionException;
}
