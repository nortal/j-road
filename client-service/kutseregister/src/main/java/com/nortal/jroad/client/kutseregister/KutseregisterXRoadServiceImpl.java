package com.nortal.jroad.client.kutseregister;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kutseregister.database.KutseregisterXRoadDatabase;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusDocument.Kutsetunnistus;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusVastusDocument.KutsetunnistusVastus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Anti Orgla
 */
@Service("kutseregisterXRoadServiceImpl")
public class KutseregisterXRoadServiceImpl implements KutseregisterXRoadService {

  @Resource
  private KutseregisterXRoadDatabase kutseregisterXRoadDatabase;

  @Override
  public KutsetunnistusVastus findKutseTunnistus(String isikukood, String nimi) throws XTeeServiceConsumptionException {
    Kutsetunnistus kutsetunnistus = Kutsetunnistus.Factory.newInstance();
    if (isikukood != null) {
      kutsetunnistus.setIsikukood(isikukood);
    }
    if (nimi != null) {
      kutsetunnistus.setNimi(nimi);
    }
    return kutseregisterXRoadDatabase.kutsetunnistusV2(kutsetunnistus);
  }

}
