package com.nortal.jroad.client.esis;

import jakarta.annotation.Resource;

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
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Tatjana Kulikova
 */
public class EsisXTeeServiceImplTest extends BaseXTeeServiceImplTest {
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
  public void findVehicle() throws XTeeServiceConsumptionException {
    VehicleQueryDTO request = VehicleQueryDTO.Factory.newInstance();
    fillRequest(request);

    request.setVinNumber("2184");

    checkAnswer(esisXTeeServiceImpl.findVehicle(request));
  }

  @Test
  public void findPerson() throws XTeeServiceConsumptionException {
    PersonQueryDTO request = PersonQueryDTO.Factory.newInstance();
    fillRequest(request);

    request.setFirstName("TEST");
    request.setLastName("SUBJECT");
    
    checkAnswer(esisXTeeServiceImpl.findPerson(request));
  }
  
  @Test
  public void findFirearm() throws XTeeServiceConsumptionException {
    FirearmQueryDTO request = FirearmQueryDTO.Factory.newInstance();
    fillRequest(request);
    
    request.setNumber("1234567");
    
    checkAnswer(esisXTeeServiceImpl.findFirearm(request));
  }
  
  @Test
  public void findBlankDocument() throws XTeeServiceConsumptionException {
    BlankDocumentQueryDTO request = BlankDocumentQueryDTO.Factory.newInstance();
    fillRequest(request);
    
    request.setNumber("1234567");
    
    checkAnswer(esisXTeeServiceImpl.findBlankDocument(request));
  }
  
  @Test
  public void findIssuedDocument() throws XTeeServiceConsumptionException {
    IssuedDocumentQueryDTO request = IssuedDocumentQueryDTO.Factory.newInstance();
    fillRequest(request);
    
    request.setNumber("1234567");
    
    checkAnswer(esisXTeeServiceImpl.findIssuedDocument(request));
  }
  
  @Test
  public void findBankNote() throws XTeeServiceConsumptionException {
    BanknoteQueryDTO request = BanknoteQueryDTO.Factory.newInstance();
    fillRequest(request);
    
    request.setNumber("1234567");
    
    checkAnswer(esisXTeeServiceImpl.findBanknote(request));
  }
  
}
