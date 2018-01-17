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
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;

public class EsisXTeeServiceImpl extends XRoadDatabaseService implements EsisXTeeService {

  private static final String QUERY_VEHICLE = "queryVehicle";
  private static final String QUERY_PERSON = "queryPerson";
  private static final String QUERY_FIREARM = "queryFirearm";
  private static final String QUERY_BLANKDOCUMENT = "queryBlankDocument";
  private static final String QUERY_ISSUEDDOCUMENT = "queryIssuedDocument";
  private static final String QUERY_BANKNOTE = "queryBanknote";

  public VehicleResultDTO findVehicle(VehicleQueryDTO request) throws XRoadServiceConsumptionException {
    XRoadMessage<VehicleResultDTO> response = send(new XmlBeansXRoadMessage<VehicleQueryDTO>(request), QUERY_VEHICLE);
    return response.getContent();
  }

  public PersonResultDTO findPerson(PersonQueryDTO request) throws XRoadServiceConsumptionException {
    XRoadMessage<PersonResultDTO> response = send(new XmlBeansXRoadMessage<PersonQueryDTO>(request), QUERY_PERSON);
    return response.getContent();
  }

  public FirearmResultDTO findFirearm(FirearmQueryDTO request) throws XRoadServiceConsumptionException {
    XRoadMessage<FirearmResultDTO> response = send(new XmlBeansXRoadMessage<FirearmQueryDTO>(request), QUERY_FIREARM);
    return response.getContent();
  }

  public BlankDocumentResultDTO findBlankDocument(BlankDocumentQueryDTO request) throws XRoadServiceConsumptionException {
    XRoadMessage<BlankDocumentResultDTO> response =
        send(new XmlBeansXRoadMessage<BlankDocumentQueryDTO>(request), QUERY_BLANKDOCUMENT);
    return response.getContent();
  }

  public IssuedDocumentResultDTO findIssuedDocument(IssuedDocumentQueryDTO request)
      throws XRoadServiceConsumptionException {
    XRoadMessage<IssuedDocumentResultDTO> response =
        send(new XmlBeansXRoadMessage<IssuedDocumentQueryDTO>(request), QUERY_ISSUEDDOCUMENT);
    return response.getContent();
  }

  public BanknoteResultDTO findBanknote(BanknoteQueryDTO request) throws XRoadServiceConsumptionException {
    XRoadMessage<BanknoteResultDTO> response = send(new XmlBeansXRoadMessage<BanknoteQueryDTO>(request), QUERY_BANKNOTE);
    return response.getContent();
  }

}
