package com.nortal.jroad.client.trelvaregister;

import java.math.BigInteger;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Paring;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Vastus;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR05Vastus;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Paring;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Vastus;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR07Vastus;
import com.nortal.jroad.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR08Vastus;



/**
 * <code>trelvaregister</code> (Relva registri teenused) database X-tee service.
 *
 */
public interface TrelvaregisterXTeeService {

	/**
	 * <code>trelvaregister.isikud_aadressi_alusel.v1</code> service.
	 */
	TTRR05Vastus findIsikuAadressiAlusel(String ehakKood,
			String tanavTalu, String maja, String korter) throws XRoadServiceConsumptionException;

	/**
	 * <code>trelvaregister.isikud_isikuandmete_alusel.v1</code> service.
	 */
	@Deprecated
	TTRR04Vastus findIsikudIsikuandmeteAlusel(String eesnimi,
			String perenimi, String isikukood) throws XRoadServiceConsumptionException;
	
	TTRR04Vastus findIsikudIsikuandmeteAlusel(TTRR04Paring paring) throws XRoadServiceConsumptionException;

	/**
	 * <code>trelvaregister.isik_relvaload_relvad.v1</code> service.
	 */
	@Deprecated
	TTRR06Vastus findIsikRelvaloadRelvad(BigInteger isikId,
			String isikukood, String kood) throws XRoadServiceConsumptionException;

	TTRR06Vastus findIsikRelvaloadRelvad(TTRR06Paring paring) throws XRoadServiceConsumptionException;
	
	TTRR07Vastus findRelvadNimekiri(String kaliiber, BigInteger liik, String mark, String mudel, BigInteger olek, BigInteger staatus, String tehasenr) throws XRoadServiceConsumptionException;
	
	TTRR08Vastus findRelvAjalugu(BigInteger relvId) throws XRoadServiceConsumptionException;
}
