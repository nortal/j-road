package ee.webmedia.xtee.client.karis;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdParing;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdVastus;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikParing;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikVastus;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudParing;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudVastus;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

public class KarisXTeeServiceImpl extends XTeeDatabaseService implements KarisXTeeService {

	private final String KR_ISIK_ID	="krIsik_id";
	private final String KR_ISIKUD	="krIsikud";
	private final String KR_ISIK = "krIsik";
	
	public KrIsikIdVastus findKrIsikId(String isikId) throws XTeeServiceConsumptionException {
		KrIsikIdParing request = KrIsikIdParing.Factory.newInstance();
		if(isikId==null) {
			throw new IllegalArgumentException("Id cannot be null");
		}
		request.setIsikId(isikId);
		XTeeMessage<KrIsikIdVastus> response = send(new XmlBeansXTeeMessage<KrIsikIdParing>(request), KR_ISIK_ID, "v2");
		return response.getContent();
	}

	
	public KrIsikudVastus findKrIsikud(String isikukood, String eesnimi, String perenimi, String synnikuupaev)
			throws XTeeServiceConsumptionException {
		KrIsikudParing request = KrIsikudParing.Factory.newInstance();
		request.setIsikukood(isikukood != null ? isikukood : "");
		request.setEesnimi(eesnimi != null ? eesnimi : "");
		request.setPerenimi(perenimi != null ? perenimi : "");
		request.setSynnikuupaev(synnikuupaev != null ? synnikuupaev : "");
		XTeeMessage<KrIsikudVastus> response = send(new XmlBeansXTeeMessage<KrIsikudParing>(request), KR_ISIKUD, "v2");
		return response.getContent();
	}
	
	public KrIsikVastus findKrIsik(String isikukood) throws XTeeServiceConsumptionException {
		KrIsikParing request = KrIsikParing.Factory.newInstance();
		if(isikukood == null) {
			throw new IllegalArgumentException("Isikukood cannot be null.");
		}
		request.setIsikukood(isikukood);
		XTeeMessage<KrIsikVastus> response = send(new XmlBeansXTeeMessage<KrIsikParing>(request), KR_ISIK, "v2");
		return response.getContent();
	}
	
	
}