package ee.webmedia.xtee.client.trelvaregister;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.trelvaregister.database.TrelvaregisterXTeeDatabase;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Paring;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Vastus;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR05Paring;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR05Vastus;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Paring;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Vastus;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR07Paring;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR07Vastus;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR08Paring;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR08Vastus;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
import java.math.BigInteger;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("trelvaregisterXTeeService")
public class TrelvaregisterXTeeServiceImpl extends XTeeDatabaseService implements TrelvaregisterXTeeService {

  @Resource
  private TrelvaregisterXTeeDatabase trelvaregisterXTeeDatabase;

	private static final String ISIKUD_ISIKUANDMETE_ALUSEL = "isikud_isikuandmete_alusel";
	private static final String ISIK_RELVALOAD_RELVAD = "isik_relvaload_relvad";

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

		return trelvaregisterXTeeDatabase.isikudAadressiAluselV1(paring);
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

	  return trelvaregisterXTeeDatabase.relvadNimekiriV1(paring);
	}

	public TTRR08Vastus findRelvAjalugu(BigInteger relvId) throws XTeeServiceConsumptionException {
	  TTRR08Paring paring = TTRR08Paring.Factory.newInstance();
	  paring.setRelvId(relvId);
	  return trelvaregisterXTeeDatabase.relvAjaluguV1(paring);
	}

  public TTRR04Vastus findIsikudIsikuandmeteAlusel(TTRR04Paring paring) throws XTeeServiceConsumptionException {
    XTeeMessage<TTRR04Vastus> response = send(new XmlBeansXTeeMessage<TTRR04Paring>(paring), ISIKUD_ISIKUANDMETE_ALUSEL, "v1");
    return response.getContent();
  }

  public TTRR06Vastus findIsikRelvaloadRelvad(TTRR06Paring paring) throws XTeeServiceConsumptionException {
    XTeeMessage<TTRR06Vastus> response = send(new XmlBeansXTeeMessage<TTRR06Paring>(paring), ISIK_RELVALOAD_RELVAD, "v1");
    return response.getContent();
  }

  public void setTrelvaregisterXTeeDatabase(TrelvaregisterXTeeDatabase trelvaregisterXTeeDatabase) {
    this.trelvaregisterXTeeDatabase = trelvaregisterXTeeDatabase;
  }

}
