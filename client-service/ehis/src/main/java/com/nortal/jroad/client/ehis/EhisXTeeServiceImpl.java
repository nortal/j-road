package com.nortal.jroad.client.ehis;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.ehis.database.EhisXTeeDatabase;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.PolOppurParing;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.PolOppurVastus;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadParing;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadParing.Isikukoodid;
import com.nortal.jroad.client.ehis.types.ee.riik.xtee.ehis.producers.producer.ehis.TootukassaleKehtivadVastus.Isikud.Isik;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.XTeeDatabaseService;

/**
 * <code>ehis</code> (teenus töötukassale kehtivad)
 *
 * @author Margus Hanni
 */
@Service("ehisXTeeService")
public class EhisXTeeServiceImpl extends XTeeDatabaseService implements EhisXTeeService {

  @Resource
  private EhisXTeeDatabase ehisXTeeDatabase;

  public List<Isik> findTootukassaleKehtivad(Date algkuup, Date loppkuup, String... isikukoodid)
      throws XTeeServiceConsumptionException {

    TootukassaleKehtivadParing paring = TootukassaleKehtivadParing.Factory.newInstance();

    Isikukoodid isikud = paring.addNewIsikukoodid();
    isikud.setIsikukoodArray(isikukoodid);

    Calendar algus = Calendar.getInstance();
    algus.setTime(algkuup);
    paring.setAlgusKp(algus);

    Calendar lopp = Calendar.getInstance();
    lopp.setTime(loppkuup);
    paring.setLoppKp(lopp);

    return ehisXTeeDatabase.tootukassaleKehtivadV1(paring).getIsikud().getIsikList();
  }

  public PolOppurVastus findPolOppur(String isikukood, Calendar algKp, Calendar loppKp) throws XTeeServiceConsumptionException {
    PolOppurParing paring = PolOppurParing.Factory.newInstance();
    paring.setIsikukood(isikukood);
    paring.setAlgKpv(algKp);
    paring.setLoppKpv(loppKp);

    return ehisXTeeDatabase.polOppurV1(paring);
  }


  public void setEhisXTeeDatabase(EhisXTeeDatabase ehisXTeeDatabase) {
    this.ehisXTeeDatabase = ehisXTeeDatabase;
  }
}
