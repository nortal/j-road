package com.nortal.jroad.client.raks;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.raks.database.RaksXRoadDatabase;
import com.nortal.jroad.client.raks.types.eu.x_road.raks.producer.TaotlejaKaitseSaajaV1Document.TaotlejaKaitseSaajaV1;
import com.nortal.jroad.client.raks.types.eu.x_road.raks.producer.TaotlejaKaitseSaajaV1Input;
import com.nortal.jroad.client.raks.types.eu.x_road.raks.producer.TaotlejaKaitseSaajaV1ResponseDocument.TaotlejaKaitseSaajaV1Response;
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

  public TaotlejaKaitseSaajaV1Response taotlejaKaitseSaaja(String isikukood, String vptunnistusNr, Calendar kuupaev)
      throws XTeeServiceConsumptionException {
    TaotlejaKaitseSaajaV1 input = TaotlejaKaitseSaajaV1.Factory.newInstance();
    TaotlejaKaitseSaajaV1Input raksTootukassaInput = TaotlejaKaitseSaajaV1Input.Factory.newInstance();
    if(isikukood != null){
      raksTootukassaInput.setIsikukood(isikukood);
    }
    raksTootukassaInput.setVptunnistusNr(vptunnistusNr);
    raksTootukassaInput.setKuupaev(kuupaev);
    input.setRequest(raksTootukassaInput);
    return raksXRoadDatabase.taotlejaKaitseSaajaV1V1(input);
  }

}
