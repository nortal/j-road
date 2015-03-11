package com.nortal.jroad.client.vangis;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.XTeeDatabaseService;
import com.nortal.jroad.client.vangis.database.VangisXTeeDatabase;
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
public class VangisXTeeServiceImpl extends XTeeDatabaseService implements VangisXTeeService {

	@Resource
	private VangisXTeeDatabase vangisXTeeDatabase;


	public KaristuseKohtVastus karistuse_koht(String isikukood, String eesnimi, String perenimi, Calendar synniKp) throws XTeeServiceConsumptionException{
		KaristuseKohtParing paring = KaristuseKohtParing.Factory.newInstance();
		paring.setIsikukood(isikukood);
		paring.setEesnimi(eesnimi);
		paring.setPerekonnanimi(perenimi);
		paring.setSynnikpv(synniKp);

		return vangisXTeeDatabase.karistuseKohtV1(paring);
	}


	public Paring2Vastus paring2(String isikukood, String eesnimi, String perenimi, Calendar synniKp)
		throws XTeeServiceConsumptionException{
		Paring2Paring paring = Paring2Paring.Factory.newInstance();
		paring.setIsikukood(isikukood);
		paring.setEesnimi(eesnimi);
		paring.setPerekonnanimi(perenimi);
		paring.setSynnikpv(synniKp);
		return vangisXTeeDatabase.paring2V1(paring);
	}

	public Paring16Vastus paring16(String isikukood, String eesnimi, String perenimi) throws XTeeServiceConsumptionException{
		Paring14Paring paring = Paring14Paring.Factory.newInstance();
		paring.setIsikukood(isikukood);
		paring.setEesnimi(eesnimi);
		paring.setPerekonnanimi(perenimi);
		return vangisXTeeDatabase.paring16V1(paring);
	}

	public Paring8Vastus paring8(String perioodiLiik, Calendar algus, Calendar lopp,
			String oigusnorm, String parag, String loige, String punkt) throws XTeeServiceConsumptionException{
		Paring8Paring paring = Paring8Paring.Factory.newInstance();
		paring.setPerLiik(PerLiik.Enum.forString(perioodiLiik));
		paring.setAlgus(algus);
		paring.setLopp(lopp);
		paring.setOigusnorm(Oigusnorm.Enum.forString(oigusnorm));
		paring.setParagrahv(parag);
		paring.setLoige(loige);
		paring.setPunkt(punkt);
		return vangisXTeeDatabase.paring8V1(paring);
	}

	public Paring5Vastus paring5(Calendar algus, Calendar lopp, String kood) throws XTeeServiceConsumptionException{
		Paring5Paring paring = Paring5Paring.Factory.newInstance();
		paring.setAlgus(algus);
		paring.setLopp(lopp);
		paring.setKood(kood);
		return vangisXTeeDatabase.paring5V1(paring);
	}


  public void setVangisXTeeDatabase(VangisXTeeDatabase vangisXTeeDatabase) {
    this.vangisXTeeDatabase = vangisXTeeDatabase;
  }

}
