package com.nortal.jroad.client.tor;

import java.util.Date;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tor.types.eu.x_road.emta_v6.TORIKDocument;
import com.nortal.jroad.client.tor.types.eu.x_road.emta_v6.TORIKResponseDocument;

/**
 * <code>TOR</code> database X-tee service<br>
 *
 * @author Kauri Kägo
 */
public interface TorXRoadService {

  /**
   * <code>tor.TORIK</code> service.
   */
  TORIKResponseDocument.TORIKResponse findTorik(String paringuLiik,
                                                Date tootAlgusKp,
                                                Date tootLoppKp,
                                                Date muutAlgKp,
                                                Date muutLoppKp,
                                                String isikukood)
      throws XTeeServiceConsumptionException;

  TORIKDocument.TORIK getTorikRequest(String paringuLiik,
                                      Date tootAlgusKp,
                                      Date tootLoppKp,
                                      Date muutAlgKp,
                                      Date muutLoppKp,
                                      String isikukood);

}
