package com.nortal.jroad.client.karis;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.karis.database.KarisXRoadDatabase;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdParing;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikParing;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudParing;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudVastus;
import com.nortal.jroad.client.service.XRoadDatabaseService;

@Service("karisXTeeService")
public class KarisXTeeServiceImpl extends XRoadDatabaseService implements KarisXTeeService {

  @Resource
  private KarisXRoadDatabase karisXRoadDatabase;


	public KrIsikIdVastus findKrIsikId(String isikId) throws XRoadServiceConsumptionException {
		KrIsikIdParing request = KrIsikIdParing.Factory.newInstance();
		if(isikId==null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		request.setIsikId(isikId);

		return karisXRoadDatabase.krIsikIdV2(request);
	}


	public KrIsikudVastus findKrIsikud(String isikukood, String eesnimi, String perenimi, String synnikuupaev)
			throws XRoadServiceConsumptionException {
		KrIsikudParing request = KrIsikudParing.Factory.newInstance();
		request.setIsikukood(isikukood != null ? isikukood : "");
		request.setEesnimi(eesnimi != null ? eesnimi : "");
		request.setPerenimi(perenimi != null ? perenimi : "");
		request.setSynnikuupaev(synnikuupaev != null ? synnikuupaev : "");
		return karisXRoadDatabase.krIsikudV2(request);
	}

	public KrIsikVastus findKrIsik(String isikukood) throws XRoadServiceConsumptionException {
		KrIsikParing request = KrIsikParing.Factory.newInstance();
		if(isikukood == null) {
			throw new IllegalArgumentException("Isikukood cannot be null.");
		}
		request.setIsikukood(isikukood);
		return karisXRoadDatabase.krIsikV2(request);
	}


  public void setKarisXRoadDatabase(KarisXRoadDatabase karisXRoadDatabase) {
    this.karisXRoadDatabase = karisXRoadDatabase;
  }
}