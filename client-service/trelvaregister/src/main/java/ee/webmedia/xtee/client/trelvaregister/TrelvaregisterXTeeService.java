package ee.webmedia.xtee.client.trelvaregister;

import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Paring;

import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Paring;

import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR08Vastus;

import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR07Vastus;

import java.math.BigInteger;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR04Vastus;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR05Vastus;
import ee.webmedia.xtee.client.trelvaregister.types.ee.riik.xtee.trelvaregister.producers.producer.trelvaregister.TTRR06Vastus;



/**
 * <code>trelvaregister</code> (Relva registri teenused) database X-tee service.
 *
 */
public interface TrelvaregisterXTeeService {

	/**
	 * <code>trelvaregister.isikud_aadressi_alusel.v1</code> service.
	 */
	TTRR05Vastus findIsikuAadressiAlusel(String ehakKood,
			String tanavTalu, String maja, String korter) throws XTeeServiceConsumptionException;

	/**
	 * <code>trelvaregister.isikud_isikuandmete_alusel.v1</code> service.
	 */
	@Deprecated
	TTRR04Vastus findIsikudIsikuandmeteAlusel(String eesnimi,
			String perenimi, String isikukood) throws XTeeServiceConsumptionException;
	
	TTRR04Vastus findIsikudIsikuandmeteAlusel(TTRR04Paring paring) throws XTeeServiceConsumptionException;

	/**
	 * <code>trelvaregister.isik_relvaload_relvad.v1</code> service.
	 */
	@Deprecated
	TTRR06Vastus findIsikRelvaloadRelvad(BigInteger isikId,
			String isikukood, String kood) throws XTeeServiceConsumptionException;

	TTRR06Vastus findIsikRelvaloadRelvad(TTRR06Paring paring) throws XTeeServiceConsumptionException;
	
	TTRR07Vastus findRelvadNimekiri(String kaliiber, BigInteger liik, String mark, String mudel, BigInteger olek, BigInteger staatus, String tehasenr) throws XTeeServiceConsumptionException;
	
	TTRR08Vastus findRelvAjalugu(BigInteger relvId) throws XTeeServiceConsumptionException;
}
