package com.nortal.jroad.client.tsd;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.SmMaksustatavadAndmedResponseDocument
.SmMaksustatavadAndmedResponse;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.XteeKindlustusResponseType;

import java.time.LocalDate;

/**
 * EMTA <code>TSD</code> database X-tee service<br>
 *
 * @author Kauri Kägo
 */
public interface EmtaTsdXRoadService {

  /**
   * <code>tsd.smMaksustatavadAndmed.v1</code> service.
   */
  SmMaksustatavadAndmedResponse smMaksustatavadAndmed(String personCode, LocalDate startDate, LocalDate endDate)
      throws XRoadServiceConsumptionException;

  /**
   * <code>tsd.xteeKindlustus.v1</code> service.
   */
  XteeKindlustusResponseType.PerioodJada xteeKindlustus(String personCode, LocalDate startDate, LocalDate endDate)
      throws XRoadServiceConsumptionException;

}
