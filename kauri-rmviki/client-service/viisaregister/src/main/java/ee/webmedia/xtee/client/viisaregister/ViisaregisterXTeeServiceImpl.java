package ee.webmedia.xtee.client.viisaregister;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.xml.namespace.QName;

import org.apache.xmlbeans.XmlCursor;
import org.springframework.stereotype.Service;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.viisaregister.database.ViisaregisterXTeeDatabase;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.StruktIsikSuguMK;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedIsikReisidokSisend;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedNrLiikSisend;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedVastus;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotlusteNimistuVastus;

@Service("viisaregisterXTeeService")
public class ViisaregisterXTeeServiceImpl extends XTeeDatabaseService implements ViisaregisterXTeeService {

  @Resource
  private ViisaregisterXTeeDatabase viisaregisterXTeeDatabase;

	public TaotlusteNimistuVastus taotluseAndmedIsikReisidokumentParing(String eesnimi, String perenimi, Calendar synniaeg, String sugu, String reisiDokLiik, String reisiDokNr, Calendar reisiDokValjastamisKuup, String toimik) throws XTeeServiceConsumptionException {
		TaotluseAndmedIsikReisidokSisend paring = TaotluseAndmedIsikReisidokSisend.Factory.newInstance();
		if (eesnimi != null || perenimi != null || synniaeg != null || sugu != null) {
			StruktIsikSuguMK isik = paring.addNewIsik();
			isik.setEesnimi(eesnimi);
			isik.setPerenimi(perenimi);
			isik.setSynniaeg(synniaeg);
			ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.Sugu.Enum suguEnum = ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.Sugu.Enum.forString(sugu);
			isik.setSugu(suguEnum);
		}

		ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.ReisiDokLiik.Enum reisiDokLiikEnum = ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.ReisiDokLiik.Enum.forString(reisiDokLiik);
		paring.setReisiDokLiik(reisiDokLiikEnum);
		paring.setReisiDokNr(reisiDokNr);
		paring.setReisiDokValjastamisKuup(reisiDokValjastamisKuup);

		//Kuna viisaregister tahab kindlasti oma xsi:type atribuute näha, siis paneme need käsitsi külge
		XmlCursor cursor = paring.newCursor();
		while (!cursor.isEnddoc()) {
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("isik")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "ns5:struktIsikSuguMK");
			}
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("eesnimi")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "xsd:string");
			}
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("perenimi")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "xsd:string");
			}
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("synniaeg")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "xsd:date");
			}
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("sugu")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "ns5:sugu");
			}
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("reisiDokLiik")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "ns5:reisiDokLiik");
			}
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("reisiDokNr")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "xsd:string");
			}
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("reisiDokValjastamisKuup")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "xsd:date");
			}
			cursor.toNextToken();
		}

		return viisaregisterXTeeDatabase.taotlAndmedIsikReisidokParingV1(paring);
	}

	public TaotluseAndmedVastus taotluseAndmedNrLiikParing(String taotluseLiik, String taotluseNr) throws XTeeServiceConsumptionException {
		TaotluseAndmedNrLiikSisend paring = TaotluseAndmedNrLiikSisend.Factory.newInstance();
		paring.setTaotluseLiik(ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseLiik.Enum.forString(taotluseLiik));
		paring.setTaotluseNr(taotluseNr);

		//Kuna viisaregister tahab kindlasti oma xsi:type atribuute näha, siis paneme need käsitsi külge
		XmlCursor cursor = paring.newCursor();
		while (!cursor.isEnddoc()) {
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("taotluseLiik")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "ns5:taotluseLiik");
			}
			if (cursor.isStart() && cursor.getName().getLocalPart().equals("taotluseNr")) {
				cursor.toNextToken();
				cursor.insertAttributeWithValue(new QName("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi"), "xsd:string");
			}
			cursor.toNextToken();
		}

		return viisaregisterXTeeDatabase.taotlAndmedNrLiikParingV1(paring);
	}


  public void setViisaregisterXTeeDatabase(ViisaregisterXTeeDatabase viisaregisterXTeeDatabase) {
    this.viisaregisterXTeeDatabase = viisaregisterXTeeDatabase;
  }

}
