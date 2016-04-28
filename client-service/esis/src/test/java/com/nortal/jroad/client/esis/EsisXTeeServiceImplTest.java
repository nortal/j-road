package com.nortal.jroad.client.esis;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import com.nortal.jroad.client.esis.EsisXTeeServiceImpl;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.classifier.data.dto.ClassifierDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.BanknoteQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.BlankDocumentQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.FirearmQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.HeaderDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.IssuedDocumentQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.PersonQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.QueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.query.sis1Query.VehicleQueryDTO;
import com.nortal.jroad.client.esis.types.com.tietoenator.sis.common.dto.result.sis1Result.ResultDTO;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

/**
 * @author Tatjana Kulikova
 */
public class EsisXTeeServiceImplTest extends BaseXRoadServiceImplTest {
  @Resource
  private EsisXTeeServiceImpl esisXTeeServiceImpl;
  
  private static void fillRequest(QueryDTO request) {
    HeaderDTO header = request.addNewHeader();
    header.setEndUser("ARK");
    ClassifierDTO role = header.addNewRole();
    role.setId(5);
    role.setCode("0005.01");
  }
  
  private static void checkAnswer(ResultDTO response) {
    Assert.isTrue("Operation completed successfully.".equals(response.getErrorDescription()));
  }

  @Test
  public void findVehicle() throws XRoadServiceConsumptionException {
    VehicleQueryDTO request = VehicleQueryDTO.Factory.newInstance();
    fillRequest(request);

    request.setVinNumber("2184");

    checkAnswer(esisXTeeServiceImpl.findVehicle(request));
  }

  @Test
  public void findPerson() throws XRoadServiceConsumptionException {
    PersonQueryDTO request = PersonQueryDTO.Factory.newInstance();
    fillRequest(request);

    request.setFirstName("TEST");
    request.setLastName("SUBJECT");
    
    checkAnswer(esisXTeeServiceImpl.findPerson(request));
  }
  
  @Test
  public void findFirearm() throws XRoadServiceConsumptionException {
    FirearmQueryDTO request = FirearmQueryDTO.Factory.newInstance();
    fillRequest(request);
    
    request.setNumber("1234567");
    
    checkAnswer(esisXTeeServiceImpl.findFirearm(request));
  }
  
  @Test
  public void findBlankDocument() throws XRoadServiceConsumptionException {
    BlankDocumentQueryDTO request = BlankDocumentQueryDTO.Factory.newInstance();
    fillRequest(request);
    
    request.setNumber("1234567");
    
    checkAnswer(esisXTeeServiceImpl.findBlankDocument(request));
  }
  
  @Test
  public void findIssuedDocument() throws XRoadServiceConsumptionException {
    IssuedDocumentQueryDTO request = IssuedDocumentQueryDTO.Factory.newInstance();
    fillRequest(request);
    
    request.setNumber("1234567");
    
    checkAnswer(esisXTeeServiceImpl.findIssuedDocument(request));
  }
  
  @Test
  public void findBankNote() throws XRoadServiceConsumptionException {
    BanknoteQueryDTO request = BanknoteQueryDTO.Factory.newInstance();
    fillRequest(request);
    
    request.setNumber("1234567");
    
    checkAnswer(esisXTeeServiceImpl.findBanknote(request));
  }
  
}
