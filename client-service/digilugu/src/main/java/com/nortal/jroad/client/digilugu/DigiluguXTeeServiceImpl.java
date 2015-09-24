package com.nortal.jroad.client.digilugu;

import org.apache.xmlbeans.XmlException;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.digilugu.types.ee.riik.xtee.digilugu.producers.producer.digilugu.Hl7Paring;
import com.nortal.jroad.client.digilugu.types.ee.riik.xtee.digilugu.producers.producer.digilugu.Hl7Vastus;
import com.nortal.jroad.client.digilugu.types.hl7WErUTorgV3.RCMRIN000032UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7_orgV3.RCMRIN000029UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7_orgV3.RCMRIN000030UV01Document;
import com.nortal.jroad.client.digilugu.types.hl7_orgV3.RCMRIN000031UV01Document;
import com.nortal.jroad.client.exception.NonTechnicalFaultException;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.XTeeDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

/**
 * <code>digilugu</code> database X-tee service implementation.
 * 
 * @author Romet Piho
 */
@Service("digiluguXTeeService")
public class DigiluguXTeeServiceImpl extends XTeeDatabaseService implements DigiluguXTeeService {

  private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
  private static final String HL7 = "hl7";
  private static final String V1 = "v1";

  private final boolean useTestDatabase;

  public DigiluguXTeeServiceImpl() {
    this(false);
  }

  public DigiluguXTeeServiceImpl(boolean useTestDatabase) {
    this.useTestDatabase = useTestDatabase;
  }

  @Override
  public void init() {
    super.init();
    if (useTestDatabase) {
      setDatabase("digilugu-arendus");
    }
  }

  @Override
  public RCMRIN000030UV01Document getHl7Document(RCMRIN000029UV01Document input) throws XTeeServiceConsumptionException {
    XTeeMessage<Hl7Vastus> vastus = send(input.xmlText());

    RCMRIN000030UV01Document document = null;
    try {
      document = RCMRIN000030UV01Document.Factory.parse(vastus.getContent().getHl7OutputMessage());
    } catch (XmlException e) {
      throw new XTeeServiceConsumptionException(new NonTechnicalFaultException(null, "Error parsing xml"),
                                                getDatabase(),
                                                HL7,
                                                V1);
    }
    return document;

  }

  @Override
  public RCMRIN000032UV01Document getHl7TSK(RCMRIN000031UV01Document input) throws XTeeServiceConsumptionException {
    XTeeMessage<Hl7Vastus> vastus = send(input.xmlText());

    RCMRIN000032UV01Document document = null;
    try {
      document = RCMRIN000032UV01Document.Factory.parse(vastus.getContent().getHl7OutputMessage());
    } catch (XmlException e) {
      throw new XTeeServiceConsumptionException(new NonTechnicalFaultException(null, "Error parsing xml"),
                                                getDatabase(),
                                                HL7,
                                                V1);
    }
    return document;

  }

  private XTeeMessage<Hl7Vastus> send(String input) throws XTeeServiceConsumptionException {
    Hl7Paring request = Hl7Paring.Factory.newInstance();
    request.setHl7InputMessage(XML + input);

    XTeeMessage<Hl7Vastus> vastus = send(new XmlBeansXTeeMessage<Hl7Paring>(request), HL7, V1);
    return vastus;
  }

}
