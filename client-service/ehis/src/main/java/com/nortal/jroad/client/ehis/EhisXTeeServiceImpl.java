package com.nortal.jroad.client.ehis;

import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.*;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.ehis.database.EhisXTeeDatabase;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.nortal.jroad.client.service.v2.XTeeDatabaseService;

/**
 * @author Margus Hanni
 */
@Service("ehisXTeeService")
public class EhisXTeeServiceImpl extends XTeeDatabaseService implements EhisXTeeService {

  @Resource
  private EhisXTeeDatabase ehisXTeeDatabase;

  public List<TootukassaleKehtivadIsik> findTootukassaleKehtivad(Date algkuup, Date loppkuup, String... isikukoodid)
      throws XTeeServiceConsumptionException {
    TootukassaleKehtivadParing paring = TootukassaleKehtivadParing.Factory.newInstance();
    TootukassaleKehtivadIsikukoodid isikud = paring.addNewIsikukoodid();
    isikud.setIsikukoodArray(isikukoodid);
    paring.setAlgusKp(toCalendar(algkuup));
    paring.setLoppKp(toCalendar(loppkuup));

    return ehisXTeeDatabase.tootukassaleKehtivadV1(paring).getIsikud().getIsikList();
  }

  public List<TootukassaleKehtivadV2Isik> findTootukassaleKehtivadV2(Date algusKp, Date loppKp, String... isikukoodid)
      throws XTeeServiceConsumptionException {
    TootukassaleKehtivadV2Paring request = TootukassaleKehtivadV2Paring.Factory.newInstance();
    TootukassaleKehtivadV2Isikukoodid isikud = request.addNewIsikukoodid();
    isikud.setIsikukoodArray(isikukoodid);
    request.setAlgusKp(toCalendar(algusKp));
    request.setLoppKp(toCalendar(loppKp));

    return ehisXTeeDatabase.tootukassaleKehtivadV2V1(request).getIsikud().getIsikList();
  }

  public PolOppurVastus findPolOppur(String isikukood, Calendar algKp, Calendar loppKp) throws XTeeServiceConsumptionException {
    PolOppurParing paring = PolOppurParing.Factory.newInstance();
    paring.setIsikukood(isikukood);
    paring.setAlgKpv(algKp);
    paring.setLoppKpv(loppKp);

    return ehisXTeeDatabase.polOppurV1(paring);
  }

  public TootukassaleOppimisedTellimusVastus submitTootukassaleOppimisedTellimusV1(Date algusKp, Date loppKp, BigInteger tkId, String... isikukoodid)
      throws XTeeServiceConsumptionException {
    TootukassaleOppimisedTellimusParing request = TootukassaleOppimisedTellimusParing.Factory.newInstance();
    TootukassaleIsikukoodidTellimus isikud = request.addNewIsikukoodid();
    isikud.setIsikukoodArray(isikukoodid);
    request.setAlgusKp(toCalendar(algusKp));
    request.setLoppKp(toCalendar(loppKp));
    request.setTkId(tkId);

    return ehisXTeeDatabase.tootukassaleOppimisedTellimusV1(request);
  }

  public TootukassaleOppimisedVastusVastus getTootukassaleOppimisedVastusV1(BigInteger tkId) throws XTeeServiceConsumptionException {
    TootukassaleOppimisedVastusParing request = TootukassaleOppimisedVastusParing.Factory.newInstance();
    request.setTkId(tkId);
    return ehisXTeeDatabase.tootukassaleOppimisedVastusV1(request);
  }

  public TootukassaleTegevusloadVastus getTootukassaleTegevusload(String registrikood, Date algusKp, Date loppKp)
          throws XTeeServiceConsumptionException {
      TootukassaleTegevusloadParing request = TootukassaleTegevusloadParing.Factory.newInstance();
      request.setRegistrikood(registrikood);
      request.setAlgusKp(toCalendar(algusKp));
      request.setLoppKp(toCalendar(loppKp));
      return ehisXTeeDatabase.tootukassaleTegevusloadV1(request);
  }

  private Calendar toCalendar(Date date) {
    if (date == null) {
      return null;
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar;
  }

  public void setEhisXTeeDatabase(EhisXTeeDatabase ehisXTeeDatabase) {
    this.ehisXTeeDatabase = ehisXTeeDatabase;
  }
}
