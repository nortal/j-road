package com.nortal.jroad.client.raks;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.raks.database.RaksXRoadDatabase;
import com.nortal.jroad.client.raks.types.eu.x_road.raks.producer.RaksTootukassaDocument.RaksTootukassa;
import com.nortal.jroad.client.raks.types.eu.x_road.raks.producer.RaksTootukassaInput;
import com.nortal.jroad.client.raks.types.eu.x_road.raks.producer.RaksTootukassaResponseDocument.RaksTootukassaResponse;
import java.util.Calendar;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by mikkb on 4.01.2017.
 */
@Service("raksXTeeService")
public class RaksXteeServiceImpl implements RaksXteeService {

  @Resource
  private RaksXRoadDatabase raksXRoadDatabase;

  public RaksTootukassaResponse raksTootukassa(String isikukood, String vptunnistusNr, Calendar kuupaev)
      throws XTeeServiceConsumptionException {
    RaksTootukassa input = RaksTootukassa.Factory.newInstance();
    RaksTootukassaInput raksTootukassaInput = RaksTootukassaInput.Factory.newInstance();
    raksTootukassaInput.setIsikukood(isikukood);
    raksTootukassaInput.setVptunnistusNr(vptunnistusNr);
    raksTootukassaInput.setKuupaev(kuupaev);
    input.setRequest(raksTootukassaInput);
    return raksXRoadDatabase.raksTootukassaV1(input);
  }

}
