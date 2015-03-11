package com.nortal.jroad.client.kutseregister;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kutseregister.database.KutseregisterXTeeDatabase;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusParing;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusVastus;

/**
 * @author Anti Orgla
 */
@Service("kutseregisterXTeeServiceImpl")
public class KutseregisterXTeeServiceImpl implements KutseregisterXTeeService {

  @Resource
  private KutseregisterXTeeDatabase kutseregisterXTeeDatabase;

  @Override
  public KutsetunnistusVastus findKutseTunnistus(String isikukood, String nimi) throws XTeeServiceConsumptionException {
    KutsetunnistusParing paring = KutsetunnistusParing.Factory.newInstance();
	if(isikukood != null){
    	paring.setIsikukood(isikukood);
	}
	if(nimi != null){
		paring.setNimi(nimi);
	}
    return kutseregisterXTeeDatabase.kutsetunnistusV2(paring);

  }
}
