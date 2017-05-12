package com.nortal.jroad.client.tsd;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tsd.database.TsdXRoadDatabase;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.PersonalIdentityCodeAndPeriod;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.SmMaksustatavadAndmedDocument;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.SmMaksustatavadAndmedRequestType;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.SmMaksustatavadAndmedResponseDocument
.SmMaksustatavadAndmedResponse;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.XteeKindlustusDocument;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.XteeKindlustusResponseType.PerioodJada;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * EMTA <code>TSD</code> database X-tee service implementation<br>
 * 
 * @author Kauri Kägo
 */
@Service("emtaTsdXRoadServiceImpl")
public class EmtaTsdXRoadServiceImpl implements EmtaTsdXRoadService {

  @Resource
  private TsdXRoadDatabase tsdXRoadDatabase;

  @PostConstruct
  public void init() {
    tsdXRoadDatabase.setDatabase("emta-v6");
  }

  private DateFormat monthYearDateFormatter = new SimpleDateFormat("MM.yyyy");

  @Override
  public SmMaksustatavadAndmedResponse smMaksustatavadAndmed(String isikukood, Date perioodiAlgus, Date perioodiLopp)
      throws XTeeServiceConsumptionException {
    SmMaksustatavadAndmedDocument.SmMaksustatavadAndmed input =
        SmMaksustatavadAndmedDocument.SmMaksustatavadAndmed.Factory.newInstance();
    SmMaksustatavadAndmedRequestType request = input.addNewRequest();
    request.setIsikukood(isikukood);
    request.setPerioodiAlgus(monthYearDateFormatter.format(perioodiAlgus));
    request.setPerioodiLopp(monthYearDateFormatter.format(perioodiLopp));

    return tsdXRoadDatabase.smMaksustatavadAndmedV1(input);
  }

  @Override
  public PerioodJada xteeKindlustus(String isikukood, Date algkuup, Date loppkuup)
      throws XTeeServiceConsumptionException {
    XteeKindlustusDocument.XteeKindlustus input = XteeKindlustusDocument.XteeKindlustus.Factory.newInstance();
    PersonalIdentityCodeAndPeriod keha = input.addNewKeha();
    keha.setIsikukood(isikukood);
    keha.setAlgkuup(monthYearDateFormatter.format(algkuup));
    keha.setLoppkuup(monthYearDateFormatter.format(loppkuup));

    return tsdXRoadDatabase.xteeKindlustusV1(input).getKeha().getPerioodJada();
  }
}
