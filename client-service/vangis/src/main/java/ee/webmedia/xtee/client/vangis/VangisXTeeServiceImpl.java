package ee.webmedia.xtee.client.vangis;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.vangis.database.VangisXTeeDatabase;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.KaristuseKohtParing;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.KaristuseKohtVastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Oigusnorm;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring14Paring;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring16Vastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring2Paring;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring2Vastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring5Paring;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring5Vastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring8Paring;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring8Vastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.PerLiik;
import java.util.Calendar;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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
