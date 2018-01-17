package com.nortal.jroad.client.kutseregister;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kutseregister.database.KutseregisterXRoadDatabase;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusParing;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusVastus;

/**
 * @author Anti Orgla
 */
@Service("kutseregisterXTeeServiceImpl")
public class KutseregisterXTeeServiceImpl implements KutseregisterXTeeService {

  @Resource
  private KutseregisterXRoadDatabase kutseregisterXRoadDatabase;

  @Override
  public KutsetunnistusVastus findKutseTunnistus(String isikukood, String nimi) throws XRoadServiceConsumptionException {
    KutsetunnistusParing paring = KutsetunnistusParing.Factory.newInstance();
	if(isikukood != null){
    	paring.setIsikukood(isikukood);
	}
	if(nimi != null){
		paring.setNimi(nimi);
	}
    return kutseregisterXRoadDatabase.kutsetunnistusV2(paring);

  }
}
