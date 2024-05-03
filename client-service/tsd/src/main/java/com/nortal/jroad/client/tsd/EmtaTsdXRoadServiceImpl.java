package com.nortal.jroad.client.tsd;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.tsd.database.TsdXRoadDatabase;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.PersonalIdentityCodeAndPeriod;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.SmMaksustatavadAndmedDocument;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.SmMaksustatavadAndmedRequestType;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.SmMaksustatavadAndmedResponseDocument
.SmMaksustatavadAndmedResponse;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.XteeKindlustusDocument;
import com.nortal.jroad.client.tsd.types.eu.x_road.emta_v6.XteeKindlustusResponseType.PerioodJada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.annotation.Resource;

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

//  @PostConstruct
//TODO: remove
//  public void init() {
//    tsdXRoadDatabase.setDatabase("emta-v6");
//  }

  private static final DateTimeFormatter MONTH_YEAR_FORMATTER = DateTimeFormatter.ofPattern("MM.yyyy");

  @Override
  public SmMaksustatavadAndmedResponse smMaksustatavadAndmed(String personCode, LocalDate startDate, LocalDate endDate)
      throws XRoadServiceConsumptionException {
    SmMaksustatavadAndmedDocument.SmMaksustatavadAndmed input =
        SmMaksustatavadAndmedDocument.SmMaksustatavadAndmed.Factory.newInstance();
    SmMaksustatavadAndmedRequestType request = input.addNewRequest();
    request.setIsikukood(personCode);
    request.setPerioodiAlgus(MONTH_YEAR_FORMATTER.format(startDate));
    request.setPerioodiLopp(MONTH_YEAR_FORMATTER.format(endDate));

    return tsdXRoadDatabase.smMaksustatavadAndmedV1(input);
  }

  @Override
  public PerioodJada xteeKindlustus(String personCode, LocalDate startDate, LocalDate endDate)
      throws XRoadServiceConsumptionException {
    XteeKindlustusDocument.XteeKindlustus input = XteeKindlustusDocument.XteeKindlustus.Factory.newInstance();
    PersonalIdentityCodeAndPeriod keha = input.addNewKeha();
    keha.setIsikukood(personCode);
    keha.setAlgkuup(MONTH_YEAR_FORMATTER.format(startDate));
    keha.setLoppkuup(MONTH_YEAR_FORMATTER.format(endDate));

    return tsdXRoadDatabase.xteeKindlustusV1(input).getKeha().getPerioodJada();
  }
}
