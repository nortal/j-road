package com.nortal.jroad.client.raks;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.raks.types.eu.x_road.raks.producer.RaksTootukassaResponseDocument.RaksTootukassaResponse;
import java.util.Calendar;

/**
 * Created by mikkb on 4.01.2017.
 */
public interface RaksXteeService {

  RaksTootukassaResponse raksTootukassa(String isikukood, String vptunnistusNr, Calendar kuupaev)
      throws XTeeServiceConsumptionException;
}
