package ee.webmedia.xtee.client.rets;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.VeadType;
import java.util.List;

/**
 * <code>rets</code> (Retseptikeskus) database X-tee service.
 * 
 * @author Tanel Käär (tanelk@webmedia.ee)
 */
public interface RetsXTeeService {

  /**
   * <code>rets.hl7document.v1</code> service.
   */
  String sendHl7Document(String hl7Xml, String idCode, List<VeadType> veadOut) throws XTeeServiceConsumptionException;

}
