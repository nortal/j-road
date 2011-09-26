package ee.webmedia.xtee.client.tosjuht;

import java.io.IOException;
import java.util.List;

import ee.webmedia.xtee.client.tosjuht.model.ManusModel;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseDigiDokResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotluseManusResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfResponse;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.VastuseKood;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

/**
 * ePria xtee teenused
 * 
 * @author Allar Tammik
 * @author Lauri Lättemäe (lauri.lattemaw@webmedia.ee)
 * @date 10.09.2010
 */
public interface EpriaXTeeService {
  /**
   * @param kandeNumber
   * @param digiDok
   * @return
   * @throws XTeeServiceConsumptionException
   */
  VastuseKood saadaTaotluseDigiDok(String kandeNumber, ManusModel digiDok) throws XTeeServiceConsumptionException;	

  /**
   * @param kandeNumber
   * @return
   * @throws XTeeServiceConsumptionException
   */
  DhsVaataTaotluseDigiDokResponse vaataTaotluseDigiDok(String kandeNumber) throws XTeeServiceConsumptionException;	

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
   * @param kandeNumber Taotluse kande number
   * @param portaaliId Manuse id ePria portaalis
   * @return {@link DhVaataTaotluseManusResponse}
   * @throws XTeeServiceConsumptionException
   */
  DhsVaataTaotluseManusResponse vaataTatoluseManus(Long portaaliId) throws XTeeServiceConsumptionException;
  
  /**
   * @param kandeNumber
   * @param pdf
   * @param manused
   * @return
   * @throws XTeeServiceConsumptionException
  */
  VastuseKood saadaTaotlus(String kandeNumber, ManusModel pdf, List<ManusModel> manused) throws XTeeServiceConsumptionException;
}
