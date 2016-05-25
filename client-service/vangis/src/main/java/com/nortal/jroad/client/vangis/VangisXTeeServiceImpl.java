package com.nortal.jroad.client.vangis;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.vangis.database.VangisXRoadDatabase;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.KaristuseKohtParing;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.KaristuseKohtVastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Oigusnorm;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring14Paring;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring16Vastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring2Paring;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring2Vastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring5Paring;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring5Vastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring8Paring;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring8Vastus;
import com.nortal.jroad.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.PerLiik;

@Service("vangisXTeeService")
public class VangisXTeeServiceImpl extends XRoadDatabaseService implements VangisXTeeService {

	@Resource
	private VangisXRoadDatabase vangisXRoadDatabase;


	public KaristuseKohtVastus karistuse_koht(String isikukood, String eesnimi, String perenimi, Calendar synniKp) throws XRoadServiceConsumptionException{
		KaristuseKohtParing paring = KaristuseKohtParing.Factory.newInstance();
		paring.setIsikukood(isikukood);
		paring.setEesnimi(eesnimi);
		paring.setPerekonnanimi(perenimi);
		paring.setSynnikpv(synniKp);

		return vangisXRoadDatabase.karistuseKohtV1(paring);
	}


	public Paring2Vastus paring2(String isikukood, String eesnimi, String perenimi, Calendar synniKp)
		throws XRoadServiceConsumptionException{
		Paring2Paring paring = Paring2Paring.Factory.newInstance();
		paring.setIsikukood(isikukood);
		paring.setEesnimi(eesnimi);
		paring.setPerekonnanimi(perenimi);
		paring.setSynnikpv(synniKp);
		return vangisXRoadDatabase.paring2V1(paring);
	}

	public Paring16Vastus paring16(String isikukood, String eesnimi, String perenimi) throws XRoadServiceConsumptionException{
		Paring14Paring paring = Paring14Paring.Factory.newInstance();
		paring.setIsikukood(isikukood);
		paring.setEesnimi(eesnimi);
		paring.setPerekonnanimi(perenimi);
		return vangisXRoadDatabase.paring16V1(paring);
	}

	public Paring8Vastus paring8(String perioodiLiik, Calendar algus, Calendar lopp,
			String oigusnorm, String parag, String loige, String punkt) throws XRoadServiceConsumptionException{
		Paring8Paring paring = Paring8Paring.Factory.newInstance();
		paring.setPerLiik(PerLiik.Enum.forString(perioodiLiik));
		paring.setAlgus(algus);
		paring.setLopp(lopp);
		paring.setOigusnorm(Oigusnorm.Enum.forString(oigusnorm));
		paring.setParagrahv(parag);
		paring.setLoige(loige);
		paring.setPunkt(punkt);
		return vangisXRoadDatabase.paring8V1(paring);
	}

	public Paring5Vastus paring5(Calendar algus, Calendar lopp, String kood) throws XRoadServiceConsumptionException{
		Paring5Paring paring = Paring5Paring.Factory.newInstance();
		paring.setAlgus(algus);
		paring.setLopp(lopp);
		paring.setKood(kood);
		return vangisXRoadDatabase.paring5V1(paring);
	}


  public void setVangisXRoadDatabase(VangisXRoadDatabase vangisXRoadDatabase) {
    this.vangisXRoadDatabase = vangisXRoadDatabase;
  }

}
