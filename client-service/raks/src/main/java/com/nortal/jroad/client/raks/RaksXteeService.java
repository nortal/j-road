package com.nortal.jroad.client.raks;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.raks.types.eu.x_road.raks.producer.TaotlejaKaitseSaajaV1ResponseDocument.TaotlejaKaitseSaajaV1Response;
import java.util.Calendar;

/**
 * Created by mikkb on 4.01.2017.
 */
public interface RaksXteeService {

  TaotlejaKaitseSaajaV1Response taotlejaKaitseSaaja(String isikukood, String vptunnistusNr, Calendar kuupaev)
      throws XTeeServiceConsumptionException;
}
