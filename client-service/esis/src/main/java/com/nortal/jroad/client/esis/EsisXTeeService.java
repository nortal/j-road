package com.nortal.jroad.client.esis;

import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.BanknoteQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.BlankDocumentQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.FirearmQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.IssuedDocumentQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.PersonQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.VehicleQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.BanknoteResultDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.BlankDocumentResultDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.FirearmResultDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.IssuedDocumentResultDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.PersonResultDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.VehicleResultDTO;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

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
