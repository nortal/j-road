package ee.webmedia.xtee.client.viisaregister;

import java.util.Calendar;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedIsikReisidokSisend;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedVastus;
import ee.webmedia.xtee.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotlusteNimistuVastus;

public interface ViisaregisterXTeeService {
	public TaotlusteNimistuVastus taotluseAndmedIsikReisidokumentParing(String eesnimi, String perenimi, Calendar synniaeg, String sugu, String reisiDokLiik, String reisiDokNr, Calendar valjastAeg, String toimik) throws XTeeServiceConsumptionException;
	public TaotluseAndmedVastus taotluseAndmedNrLiikParing(String taotluseLiik, String taotluseNumber) throws XTeeServiceConsumptionException;
}
