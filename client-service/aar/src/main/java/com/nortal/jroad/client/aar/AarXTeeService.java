package com.nortal.jroad.client.aar;

import com.nortal.jroad.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.AsutusedVastusManus;
import com.nortal.jroad.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.TaitmisedVastusManus;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

/**
 * Aar andmekogu xtee teenused
 * 
 * @author Lauri Lättemäe 
 * @date 08.10.2010
 */
public interface AarXTeeService {
	/**
	 * @param regKood
	 * @return
	 * @throws XRoadServiceConsumptionException
	 */
	AsutusedVastusManus asutusedParingRegistriKoodiJargi(String paringuIsikukood, String regKood) throws XRoadServiceConsumptionException;

	/**
	 * @param asutusId
	 * @param isikukood
	 * @param rollid
	 * @return
	 * @throws XRoadServiceConsumptionException
	 */
	TaitmisedVastusManus isikuRollidAsutuses(String paringuIsikukood, Long asutusId, String isikukood, RollEnum... rollid) throws XRoadServiceConsumptionException;

}
