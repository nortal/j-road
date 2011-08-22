package ee.webmedia.xtee.client.vangis;

import java.util.Calendar;
import java.util.Date;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.KaristuseKohtVastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Oigusnorm;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring16Vastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring2Vastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring5Vastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.Paring8Vastus;
import ee.webmedia.xtee.client.vangis.types.ee.riik.xtee.vangis.producers.producer.vangis.PerLiik;

public interface VangisXTeeService {

	
	/**
	 *  Tagastab karistuse koha (vangla) ja vabanemise kuupäeva.
	 */
	KaristuseKohtVastus karistuse_koht(String isikukood, String eesnimi, String perenimi, Calendar synniKp) throws XTeeServiceConsumptionException;
	
	/**
	 * Vangiregistri koodi otsing
	 */
	Paring2Vastus paring2(String isikukood, String eesnimi, String perenimi, Calendar synniKp) throws XTeeServiceConsumptionException;
	
	/**
	 *	Fotode otsing
	 */
	Paring16Vastus paring16(String isikukood, String eesnimi, String perenimi) throws XTeeServiceConsumptionException;
	
	/**
	 *	Kinnipidamiste ja vabanemiste otsing
	 */
	Paring8Vastus paring8(String perioodiLiik, Calendar algus, Calendar lopp, 
			String oigusnorm, String parag, String loige, String punkt) throws XTeeServiceConsumptionException;
	
	/**
	 * 	Tagastab isiku väljaskäimised vangiregistri koodi ja kuupäevade järgi. Kui koodi pole tagastab kõik isikud kes on antud vahemikus väljas käinud.
	 * 
	 */
	Paring5Vastus paring5(Calendar algus, Calendar lopp, String kood) throws XTeeServiceConsumptionException;
	
}
