package com.nortal.jroad.client.karis;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.karis.database.KarisXTeeDatabase;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdParing;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikParing;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudParing;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudVastus;
import com.nortal.jroad.client.service.v2.XTeeDatabaseService;

@Service("karisXTeeService")
public class KarisXTeeServiceImpl extends XTeeDatabaseService implements KarisXTeeService {

  @Resource
  private KarisXTeeDatabase karisXTeeDatabase;


	public KrIsikIdVastus findKrIsikId(String isikId) throws XTeeServiceConsumptionException {
		KrIsikIdParing request = KrIsikIdParing.Factory.newInstance();
		if(isikId==null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		request.setIsikId(isikId);

		return karisXTeeDatabase.krIsikIdV2(request);
	}


	public KrIsikudVastus findKrIsikud(String isikukood, String eesnimi, String perenimi, String synnikuupaev)
			throws XTeeServiceConsumptionException {
		KrIsikudParing request = KrIsikudParing.Factory.newInstance();
		request.setIsikukood(isikukood != null ? isikukood : "");
		request.setEesnimi(eesnimi != null ? eesnimi : "");
		request.setPerenimi(perenimi != null ? perenimi : "");
		request.setSynnikuupaev(synnikuupaev != null ? synnikuupaev : "");
		return karisXTeeDatabase.krIsikudV2(request);
	}

	public KrIsikVastus findKrIsik(String isikukood) throws XTeeServiceConsumptionException {
		KrIsikParing request = KrIsikParing.Factory.newInstance();
		if(isikukood == null) {
			throw new IllegalArgumentException("Isikukood cannot be null.");
		}
		request.setIsikukood(isikukood);
		return karisXTeeDatabase.krIsikV2(request);
	}


  public void setKarisXTeeDatabase(KarisXTeeDatabase karisXTeeDatabase) {
    this.karisXTeeDatabase = karisXTeeDatabase;
  }
}
