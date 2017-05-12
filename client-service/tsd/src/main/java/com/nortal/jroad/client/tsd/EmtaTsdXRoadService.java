package com.nortal.jroad.client.tsd;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.SmMaksustatavadAndmedResponseDocument
.SmMaksustatavadAndmedResponse;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.XteeKindlustusResponseType;

import java.util.Date;

/**
 * EMTA <code>TSD</code> database X-tee service<br>
 * 
 * @author Kauri Kägo
 */
public interface EmtaTsdXRoadService {

  /**
   * <code>tsd.smMaksustatavadAndmed.v1</code> service.
   */
  SmMaksustatavadAndmedResponse smMaksustatavadAndmed(String isikukood,
                                                                                            Date perioodiAlgus,
                                                                                            Date perioodiLopp)
      throws XTeeServiceConsumptionException;

  /**
   * <code>tsd.xteeKindlustus.v1</code> service.
   */
  XteeKindlustusResponseType.PerioodJada xteeKindlustus(String isikukood, Date algkuup, Date loppkuup)
      throws XTeeServiceConsumptionException;

}
