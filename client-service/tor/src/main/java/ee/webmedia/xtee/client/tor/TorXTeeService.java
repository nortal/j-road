package ee.webmedia.xtee.client.tor;

import java.util.Date;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.tor.types.ee.x_road.emtav5.producer.TORIKResponseDocument.TORIKResponse;
/**
 * <code>TOR</code> database X-tee service<br>
 * 
 * @author Eneli Reimets
 */
public interface TorXTeeService {

  /**
   * <code>tor.TORIK</code> service.
   */
  TORIKResponse findTorik(String paringuLiik, Date tootAlgusKp, Date tootLoppKp, String isikukood)
      throws XTeeServiceConsumptionException;

}
