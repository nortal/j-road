package com.nortal.jroad.client.ehis;

import com.nortal.jroad.client.ehis.database.EhisXRoadDatabase;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.PolOppurDocument.PolOppur;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.PolOppurResponseDocument.PolOppurResponse;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.*;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadDocument.TootukassaleKehtivad;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadV2Document.TootukassaleKehtivadV2;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleOppimisedTellimusDocument.TootukassaleOppimisedTellimus;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleOppimisedTellimusResponseDocument.TootukassaleOppimisedTellimusResponse;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleOppimisedVastusDocument.TootukassaleOppimisedVastus;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleOppimisedVastusResponseDocument.TootukassaleOppimisedVastusResponse;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleTegevusloadDocument.TootukassaleTegevusload;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleTegevusloadResponseDocument.TootukassaleTegevusloadResponse;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Margus Hanni
 */
@Service("ehisXRoadService")
public class EhisXRoadServiceImpl implements EhisXRoadService {

  @Resource
  private EhisXRoadDatabase ehisXRoadDatabase;

  public List<TootukassaleKehtivadIsik> findTootukassaleKehtivad(Date algkuup, Date loppkuup, String... isikukoodid)
      throws XTeeServiceConsumptionException {
    TootukassaleKehtivad paring = TootukassaleKehtivad.Factory.newInstance();
    TootukassaleKehtivadIsikukoodid isikud = paring.addNewIsikukoodid();
    isikud.setIsikukoodArray(isikukoodid);
    paring.setAlgusKp(toCalendar(algkuup));
    paring.setLoppKp(toCalendar(loppkuup));

    return ehisXRoadDatabase.tootukassaleKehtivadV1(paring).getIsikud().getIsikList();
  }

  public List<TootukassaleKehtivadV2Isik> findTootukassaleKehtivadV2(Date algusKp, Date loppKp, String... isikukoodid)
      throws XTeeServiceConsumptionException {
    TootukassaleKehtivadV2 request = TootukassaleKehtivadV2.Factory.newInstance();
    TootukassaleKehtivadV2Isikukoodid isikud = request.addNewIsikukoodid();
    isikud.setIsikukoodArray(isikukoodid);
    request.setAlgusKp(toCalendar(algusKp));
    request.setLoppKp(toCalendar(loppKp));

    return ehisXRoadDatabase.tootukassaleKehtivadV2V1(request).getIsikud().getIsikList();
  }

  public PolOppurResponse findPolOppur(String isikukood, Calendar algKp, Calendar loppKp)
      throws XTeeServiceConsumptionException {
    PolOppur paring = PolOppur.Factory.newInstance();
    paring.setIsikukood(isikukood);
    paring.setAlgKpv(algKp);
    paring.setLoppKpv(loppKp);

    return ehisXRoadDatabase.polOppurV1(paring);
  }

  public TootukassaleOppimisedTellimusResponse submitTootukassaleOppimisedTellimusV1(Date algusKp,
                                                                                     Date loppKp,
                                                                                     BigInteger tkId,
                                                                                     String... isikukoodid)
      throws XTeeServiceConsumptionException {
    TootukassaleOppimisedTellimus request = TootukassaleOppimisedTellimus.Factory.newInstance();
    TootukassaleIsikukoodidTellimus isikud = request.addNewIsikukoodid();
    isikud.setIsikukoodArray(isikukoodid);
    request.setAlgusKp(toCalendar(algusKp));
    request.setLoppKp(toCalendar(loppKp));
    request.setTkId(tkId);

    return ehisXRoadDatabase.tootukassaleOppimisedTellimusV1(request);
  }

  public TootukassaleOppimisedVastusResponse getTootukassaleOppimisedVastusV1(BigInteger tkId)
      throws XTeeServiceConsumptionException {
    TootukassaleOppimisedVastus request = TootukassaleOppimisedVastus.Factory.newInstance();
    request.setTkId(tkId);
    return ehisXRoadDatabase.tootukassaleOppimisedVastusV1(request);
  }

  public TootukassaleTegevusloadResponse getTootukassaleTegevusload(String registrikood, Date algusKp, Date loppKp)
      throws XTeeServiceConsumptionException {
    TootukassaleTegevusload request = TootukassaleTegevusload.Factory.newInstance();
    request.setRegistrikood(registrikood);
    request.setAlgusKp(toCalendar(algusKp));
    request.setLoppKp(toCalendar(loppKp));
    return ehisXRoadDatabase.tootukassaleTegevusloadV1(request);
  }

  private Calendar toCalendar(Date date) {
    if (date == null) {
      return null;
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
  }

}
