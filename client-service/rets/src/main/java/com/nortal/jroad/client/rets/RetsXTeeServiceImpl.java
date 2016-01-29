package com.nortal.jroad.client.rets;

import java.util.List;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.Hl7DocumentRequestType;
import com.nortal.jroad.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.Hl7DocumentResponseType;
import com.nortal.jroad.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.Hl7EncodingType;
import com.nortal.jroad.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.VeadType;
import com.nortal.jroad.client.service.v2.XTeeDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

/**
 * @author Tanel Käär (tanelk@nortal.com)
 */
public class RetsXTeeServiceImpl extends XTeeDatabaseService implements RetsXTeeService {

  private static final String HL7DOCUMENT = "hl7document";

  public String sendHl7Document(String hl7Xml, String idCode, List<VeadType> veadOut)
      throws XTeeServiceConsumptionException {
    Hl7DocumentRequestType keha = Hl7DocumentRequestType.Factory.newInstance();
    keha.setHL7Encoding(Hl7EncodingType.XML);
    keha.setHL7Document(hl7Xml);
    XTeeMessage<Hl7DocumentResponseType> response =
        send(new XmlBeansXTeeMessage<Hl7DocumentRequestType>(keha), HL7DOCUMENT, "v1", idCode);
    if (response.getContent().getVead() != null && response.getContent().getVead().getItemList() != null) {
      veadOut.addAll(response.getContent().getVead().getItemList());
    }
    return response.getContent().getHL7Document();
  }

}
