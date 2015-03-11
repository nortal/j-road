package com.nortal.jroad.client.tosjuht;

import java.io.IOException;
import java.util.List;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
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
public interface EpriaXTeeService {

  /**
   * @param xml
   * @param securityServer
   * @param isikukood
   * @return
   * @throws XTeeServiceConsumptionException
   */
  public String epria(String xml, String securityServer, String isikukood) throws XTeeServiceConsumptionException;

  /**
   * @param xml
   * @param securityServer
   * @param isikukood
   * @return
   * @throws XTeeServiceConsumptionException
   */
  String epriaParingManusega(String xml, String securityServer, String isikukood)
      throws XTeeServiceConsumptionException;

  /**
   * @param kandeNumber
   * @return
   * @throws XTeeServiceConsumptionException
   */
  DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String kandeNumber) throws XTeeServiceConsumptionException;

  /**
   * @param securityServer
   * @param kandeNumber
   * @return
   * @throws XTeeServiceConsumptionException
   */
  DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String securityServer, String kandeNumber)
      throws XTeeServiceConsumptionException;

  /**
   * Tagastab ePria esitatud taotluse PDFi DHSist
   * 
   * @param kandeNumber Taotluse kande number
   * @return {@link DhVaataEsitatudPdfResponse}
   * @throws XTeeServiceConsumptionException
   * @throws IOException
   */
  DhsVaataTaotlusePdfResponse vaataTaotlusePdf(String kandeNumber) throws XTeeServiceConsumptionException;

  /**
   * @param securityServer
   * @param kandeNumber
   * @return
   * @throws XTeeServiceConsumptionException
   */
  DhsVaataTaotlusePdfResponse vaataTaotlusePdf(String securityServer, String kandeNumber)
      throws XTeeServiceConsumptionException;

  /**
   * @param kandeNumber Taotluse kande number
   * @param portaaliId Manuse id ePria portaalis
   * @param sisuFailId Kanderaamatu id
   * @return {@link DhVaataTaotluseManusResponse}
   * @throws XTeeServiceConsumptionException
   */
  DhsVaataTaotluseManusResponse vaataTatoluseManus(String kandeNumber,
                                                   String portaaliId,
                                                   String sisuFailId,
                                                   String vaataja,
                                                   Integer priaRoll) throws XTeeServiceConsumptionException;

  /**
   * @param securityServer
   * @param kandeNumber
   * @param portaaliId
   * @param sisuFailId
   * @param vaataja
   * @param priaRoll
   * @return
   * @throws XTeeServiceConsumptionException
   */
  DhsVaataTaotluseManusResponse vaataTatoluseManus(String securityServer,
                                                   String kandeNumber,
                                                   String portaaliId,
                                                   String sisuFailId,
                                                   String vaataja,
                                                   Integer priaRoll) throws XTeeServiceConsumptionException;

  /**
   * @param kandeNumber
   * @param digiDoc
   * @param pdf
   * @param manused
   * @return
   * @throws XTeeServiceConsumptionException
   */
  VastuseKood saadaTaotlus(String kandeNumber, ManusModel digiDoc, ManusModel pdf, List<ManusModel> manused)
      throws XTeeServiceConsumptionException;

  /**
   * @param securityServer
   * @param kandeNumber
   * @param digiDoc
   * @param pdf
   * @param manused
   * @return
   * @throws XTeeServiceConsumptionException
   */
  VastuseKood saadaTaotlus(String securityServer,
                           String kandeNumber,
                           ManusModel digiDoc,
                           ManusModel pdf,
                           List<ManusModel> manused) throws XTeeServiceConsumptionException;
}
