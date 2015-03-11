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
import com.nortal.jroad.client.service.XTeeDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

public class EsisXTeeServiceImpl extends XTeeDatabaseService implements EsisXTeeService {

  private static final String QUERY_VEHICLE = "queryVehicle";
  private static final String QUERY_PERSON = "queryPerson";
  private static final String QUERY_FIREARM = "queryFirearm";
  private static final String QUERY_BLANKDOCUMENT = "queryBlankDocument";
  private static final String QUERY_ISSUEDDOCUMENT = "queryIssuedDocument";
  private static final String QUERY_BANKNOTE = "queryBanknote";

  public VehicleResultDTO findVehicle(VehicleQueryDTO request) throws XTeeServiceConsumptionException {
    XTeeMessage<VehicleResultDTO> response = send(new XmlBeansXTeeMessage<VehicleQueryDTO>(request), QUERY_VEHICLE);
    return response.getContent();
  }

  public PersonResultDTO findPerson(PersonQueryDTO request) throws XTeeServiceConsumptionException {
    XTeeMessage<PersonResultDTO> response = send(new XmlBeansXTeeMessage<PersonQueryDTO>(request), QUERY_PERSON);
    return response.getContent();
  }

  public FirearmResultDTO findFirearm(FirearmQueryDTO request) throws XTeeServiceConsumptionException {
    XTeeMessage<FirearmResultDTO> response = send(new XmlBeansXTeeMessage<FirearmQueryDTO>(request), QUERY_FIREARM);
    return response.getContent();
  }

  public BlankDocumentResultDTO findBlankDocument(BlankDocumentQueryDTO request) throws XTeeServiceConsumptionException {
    XTeeMessage<BlankDocumentResultDTO> response =
        send(new XmlBeansXTeeMessage<BlankDocumentQueryDTO>(request), QUERY_BLANKDOCUMENT);
    return response.getContent();
  }

  public IssuedDocumentResultDTO findIssuedDocument(IssuedDocumentQueryDTO request)
      throws XTeeServiceConsumptionException {
    XTeeMessage<IssuedDocumentResultDTO> response =
        send(new XmlBeansXTeeMessage<IssuedDocumentQueryDTO>(request), QUERY_ISSUEDDOCUMENT);
    return response.getContent();
  }

  public BanknoteResultDTO findBanknote(BanknoteQueryDTO request) throws XTeeServiceConsumptionException {
    XTeeMessage<BanknoteResultDTO> response = send(new XmlBeansXTeeMessage<BanknoteQueryDTO>(request), QUERY_BANKNOTE);
    return response.getContent();
  }

}
