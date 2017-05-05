package com.nortal.jroad.client.digilugu;

import com.nortal.jroad.client.digilugu.database.DigiluguXRoadDatabase;
import com.nortal.jroad.client.digilugu.types.eu.x_road.digilugu.producer.Hl7Document;
import com.nortal.jroad.client.digilugu.types.eu.x_road.digilugu.producer.Hl7Paring;
import com.nortal.jroad.client.digilugu.types.eu.x_road.digilugu.producer.Hl7ResponseDocument.Hl7Response;
import com.nortal.jroad.client.digilugu.types.hl7BAoljorgV3.RCMRIN000030UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7EvFkkorgV3.RCMRIN000032UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7VMlkLorgV3.RCMRIN000029UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7_orgV3.RCMRIN000031UV01Document;
import com.nortal.jroad.client.exception.NonTechnicalFaultException;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import org.apache.xmlbeans.XmlException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <code>digilugu</code> database X-tee service implementation.
 * 
 * @author Romet Piho
 */
@Service("digiluguXRoadService")
public class DigiluguXRoadServiceImpl implements DigiluguXRoadService {

  private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
  private static final String DIGILUGU = "digilugu";
  private static final String HL7 = "hl7";
  private static final String V1 = "v1";

  @Resource
  private DigiluguXRoadDatabase digiluguXRoadDatabase;

  @Override
  public RCMRIN000030UV01Document getHl7Document(RCMRIN000029UV01Document input)
      throws XTeeServiceConsumptionException {
    Hl7Response vastus = send(input.xmlText());

    RCMRIN000030UV01Document document;
    try {
      document = RCMRIN000030UV01Document.Factory.parse(vastus.getResponse().getHl7OutputMessage());
    } catch (XmlException e) {
      throw new XTeeServiceConsumptionException(new NonTechnicalFaultException(null, "Error parsing xml"),
                                                DIGILUGU,
                                                HL7,
                                                V1);
    }
    return document;

  }

  @Override
  public RCMRIN000032UV01Document getHl7TSK(RCMRIN000031UV01Document input) throws XTeeServiceConsumptionException {
    Hl7Response vastus = send(input.xmlText());

    RCMRIN000032UV01Document document;
    try {
      document = RCMRIN000032UV01Document.Factory.parse(vastus.getResponse().getHl7OutputMessage());
    } catch (XmlException e) {
      throw new XTeeServiceConsumptionException(new NonTechnicalFaultException(null, "Error parsing xml"),
                                                DIGILUGU,
                                                HL7,
                                                V1);
    }
    return document;

  }

  private Hl7Response send(String input) throws XTeeServiceConsumptionException {
    Hl7Document.Hl7 hl7 = Hl7Document.Hl7.Factory.newInstance();
    Hl7Paring paring = hl7.addNewRequest();
    paring.setHl7InputMessage(XML + input);
    return digiluguXRoadDatabase.hl7V1(hl7);
  }

}
