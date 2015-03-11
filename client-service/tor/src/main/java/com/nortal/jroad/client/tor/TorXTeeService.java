package com.nortal.jroad.client.tor;

import java.util.Date;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKResponseDocument.TORIKResponse;
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
