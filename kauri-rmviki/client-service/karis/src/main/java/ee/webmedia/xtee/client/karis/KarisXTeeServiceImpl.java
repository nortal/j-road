package ee.webmedia.xtee.client.karis;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.karis.database.KarisXTeeDatabase;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdParing;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdVastus;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikParing;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikVastus;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudParing;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudVastus;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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