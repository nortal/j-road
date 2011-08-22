package ee.webmedia.xtee.client.rets;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.Hl7DocumentRequestType;
import ee.webmedia.xtee.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.Hl7DocumentResponseType;
import ee.webmedia.xtee.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.Hl7EncodingType;
import ee.webmedia.xtee.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.VeadType;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
import java.util.List;

/**
 * @author Tanel Käär (tanelk@webmedia.ee)
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
