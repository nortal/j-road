package com.nortal.jroad.client.trelvaregister;

import java.math.BigInteger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.v2.XTeeDatabaseService;
import com.nortal.jroad.client.trelvaregister.database.TrelvaregisterXTeeDatabase;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Paring;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Vastus;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR05Paring;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR05Vastus;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Paring;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Vastus;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR07Paring;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR07Vastus;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR08Paring;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR08Vastus;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

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
