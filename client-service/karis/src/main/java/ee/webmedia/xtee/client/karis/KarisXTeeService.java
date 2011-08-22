package ee.webmedia.xtee.client.karis;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdVastus;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikVastus;
import ee.webmedia.xtee.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudVastus;

/**
 * <code>karis</code> (Karistusregistri teenused) database X-tee service.
 */
public interface KarisXTeeService {
	
	/**
	  * <code>karis.krIsikud.v2</code> service.
	  */
	KrIsikudVastus findKrIsikud(String isikukood, String eesnimi, String perenimi, String synnikuupaev) throws XTeeServiceConsumptionException;
	
	/**
	  * <code>karis.krIsik_id.v2</code> service.
	  */
	KrIsikIdVastus findKrIsikId(String isikId) throws XTeeServiceConsumptionException;
	
	/**
	  * <code>karis.krIsik.v2</code> service.
	  */
	KrIsikVastus findKrIsik(String isikukood) throws XTeeServiceConsumptionException;
	
	
	
}