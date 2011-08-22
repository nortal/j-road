package ee.webmedia.xtee.client.trelvaregister;

import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR08Paring;

import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR08Vastus;

import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR07Paring;

import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR07Vastus;

import java.math.BigInteger;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Paring;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Vastus;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR05Paring;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR05Vastus;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Paring;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Vastus;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

public class TrelvaregisterXTeeServiceImpl extends XTeeDatabaseService implements TrelvaregisterXTeeService {

	private static final String ISIKUD_ISIKUANDMETE_ALUSEL = "isikud_isikuandmete_alusel";
	private static final String ISIKUD_AADRESSI_ALUSEL = "isikud_aadressi_alusel";
	private static final String ISIK_RELVALOAD_RELVAD = "isik_relvaload_relvad";
	private static final String RELVAD_NIMEKIRI = "relvad_nimekiri";
	private static final String RELV_AJALUGU = "relv_ajalugu";

	public TTRR05Vastus findIsikuAadressiAlusel(String ehakKood,
			String tanavTalu, String maja, String korter) throws XTeeServiceConsumptionException {

		TTRR05Paring paring = TTRR05Paring.Factory.newInstance();

		paring.setEhak("");
		paring.setTanavtalu("");
		paring.setMaja("");
		paring.setKorter("");
		
		if (ehakKood != null)
			paring.setEhak(ehakKood);
		if (tanavTalu != null)
			paring.setTanavtalu(tanavTalu);
		if (maja != null)
			paring.setMaja(maja);
		if (korter != null)
			paring.setKorter(korter);
		

		XTeeMessage<TTRR05Vastus> response = send(new XmlBeansXTeeMessage<TTRR05Paring>(paring), ISIKUD_AADRESSI_ALUSEL, "v1");
		return response.getContent();
	}

	public TTRR04Vastus findIsikudIsikuandmeteAlusel(String eesnimi,
			String perenimi, String isikukood) throws XTeeServiceConsumptionException {
		TTRR04Paring paring = TTRR04Paring.Factory.newInstance();

		paring.setEesnimi("");
		paring.setPerenimi("");
		paring.setIsikukood("");
		paring.setAsutus("");
		paring.setSynniaeg("");
		paring.setAsutus("");
		
		if (eesnimi != null)
			paring.setEesnimi(eesnimi);
		if (perenimi != null)
			paring.setPerenimi(perenimi);
		if (isikukood != null)
			paring.setIsikukood(isikukood);
		
		return findIsikudIsikuandmeteAlusel(paring);
	}

	public TTRR06Vastus findIsikRelvaloadRelvad(BigInteger isikId,
			String isikukood, String kood) throws XTeeServiceConsumptionException {

		TTRR06Paring paring = TTRR06Paring.Factory.newInstance();

		if (isikId != null)
			paring.setIsikId(isikId);
		if (isikukood != null)
			paring.setIsikukood(isikukood);
		if (kood != null)
			paring.setKood(kood);

		return findIsikRelvaloadRelvad(paring);
	}
	
	public TTRR07Vastus findRelvadNimekiri(String kaliiber, BigInteger liik, String mark, String mudel, BigInteger olek, BigInteger staatus, String tehasenr) throws XTeeServiceConsumptionException {
	  TTRR07Paring paring = TTRR07Paring.Factory.newInstance();
	  paring.setKaliiber(kaliiber);
	  paring.setLiik(liik);
	  paring.setMark(mark);
	  paring.setMudel(mudel);
	  paring.setOlek(olek);
	  paring.setStaatus(staatus);
	  paring.setTehasenr(tehasenr);
	  XTeeMessage<TTRR07Vastus> response = send(new XmlBeansXTeeMessage<TTRR07Paring>(paring), RELVAD_NIMEKIRI);
	  return response.getContent();
	}
	
	public TTRR08Vastus findRelvAjalugu(BigInteger relvId) throws XTeeServiceConsumptionException {
	  TTRR08Paring paring = TTRR08Paring.Factory.newInstance();
	  paring.setRelvId(relvId);
	  XTeeMessage<TTRR08Vastus> response = send(new XmlBeansXTeeMessage<TTRR08Paring>(paring), RELV_AJALUGU);
	  return response.getContent();
	}

  public TTRR04Vastus findIsikudIsikuandmeteAlusel(TTRR04Paring paring) throws XTeeServiceConsumptionException {
    XTeeMessage<TTRR04Vastus> response = send(new XmlBeansXTeeMessage<TTRR04Paring>(paring), ISIKUD_ISIKUANDMETE_ALUSEL, "v1");
    return response.getContent();
  }

  public TTRR06Vastus findIsikRelvaloadRelvad(TTRR06Paring paring) throws XTeeServiceConsumptionException {
    XTeeMessage<TTRR06Vastus> response = send(new XmlBeansXTeeMessage<TTRR06Paring>(paring), ISIK_RELVALOAD_RELVAD, "v1");
    return response.getContent();
  }
}
