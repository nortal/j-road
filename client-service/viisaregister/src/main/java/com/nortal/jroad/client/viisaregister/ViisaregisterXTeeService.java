package com.nortal.jroad.client.viisaregister;

import java.util.Calendar;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedIsikReisidokSisend;
import com.nortal.jroad.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotluseAndmedVastus;
import com.nortal.jroad.client.viisaregister.types.ee.riik.xtee.viisaregister.producers.producer.viisaregister.TaotlusteNimistuVastus;

public interface ViisaregisterXTeeService {
	public TaotlusteNimistuVastus taotluseAndmedIsikReisidokumentParing(String eesnimi, String perenimi, Calendar synniaeg, String sugu, String reisiDokLiik, String reisiDokNr, Calendar valjastAeg, String toimik) throws XRoadServiceConsumptionException;
	public TaotluseAndmedVastus taotluseAndmedNrLiikParing(String taotluseLiik, String taotluseNumber) throws XRoadServiceConsumptionException;
}
