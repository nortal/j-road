package com.nortal.jroad.client.karis;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikIdVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikVastus;
import com.nortal.jroad.client.karis.types.ee.riik.xtee.karis.producers.producer.karis.KrIsikudVastus;

/**
 * <code>karis</code> (Karistusregistri teenused) database X-tee service.
 */
public interface KarisXTeeService {
	
	/**
	  * <code>karis.krIsikud.v2</code> service.
	  */
	KrIsikudVastus findKrIsikud(String isikukood, String eesnimi, String perenimi, String synnikuupaev) throws XRoadServiceConsumptionException;
	
	/**
	  * <code>karis.krIsik_id.v2</code> service.
	  */
	KrIsikIdVastus findKrIsikId(String isikId) throws XRoadServiceConsumptionException;
	
	/**
	  * <code>karis.krIsik.v2</code> service.
	  */
	KrIsikVastus findKrIsik(String isikukood) throws XRoadServiceConsumptionException;
	
	
	
}