package com.nortal.jroad.client.aar;

import com.nortal.jroad.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.AsutusedVastusManus;
import com.nortal.jroad.client.aar.types.ee.riik.xtee.aar.producers.producer.aar.TaitmisedVastusManus;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * Aar andmekogu xtee teenused
 * 
 * @author Lauri Lättemäe (lauri.lattemaw@webmedia.ee)
 * @date 08.10.2010
 */
public interface AarXTeeService {
	/**
	 * @param regKood
	 * @return
	 * @throws XTeeServiceConsumptionException
	 */
	AsutusedVastusManus asutusedParingRegistriKoodiJargi(String paringuIsikukood, String regKood) throws XTeeServiceConsumptionException;

	/**
	 * @param asutusId
	 * @param isikukood
	 * @param rollid
	 * @return
	 * @throws XTeeServiceConsumptionException
	 */
	TaitmisedVastusManus isikuRollidAsutuses(String paringuIsikukood, Long asutusId, String isikukood, RollEnum... rollid) throws XTeeServiceConsumptionException;

}
