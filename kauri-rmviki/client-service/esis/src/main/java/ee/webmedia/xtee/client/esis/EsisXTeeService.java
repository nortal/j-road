package ee.webmedia.xtee.client.esis;

import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.BanknoteQueryDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.BlankDocumentQueryDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.FirearmQueryDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.IssuedDocumentQueryDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.PersonQueryDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.VehicleQueryDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.BanknoteResultDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.BlankDocumentResultDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.FirearmResultDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.IssuedDocumentResultDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.PersonResultDTO;
import ee.webmedia.xtee.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.VehicleResultDTO;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

/**
 * <code>esis</code> Esis database X-tee service.
 * 
 * @author Tatjana Kulikova
 */
public interface EsisXTeeService {

  /**
   * <code>esis.queryVehicle.v1</code> service.
   */
  VehicleResultDTO findVehicle(VehicleQueryDTO request) throws XTeeServiceConsumptionException;
  
  PersonResultDTO findPerson(PersonQueryDTO request) throws XTeeServiceConsumptionException;
  
  FirearmResultDTO findFirearm(FirearmQueryDTO request) throws XTeeServiceConsumptionException;
  
  BlankDocumentResultDTO findBlankDocument(BlankDocumentQueryDTO request) throws XTeeServiceConsumptionException;
  
  IssuedDocumentResultDTO findIssuedDocument(IssuedDocumentQueryDTO request) throws XTeeServiceConsumptionException;
  
  BanknoteResultDTO findBanknote(BanknoteQueryDTO request) throws XTeeServiceConsumptionException;
}
