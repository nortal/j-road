package com.nortal.jroad.client.rr;

import java.util.Date;
import java.util.List;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.DokumendiTyyp;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.IsikuStaatus;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR40Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR41ResponseV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR42Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR42Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR43Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR52Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR63ResponseV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR81Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR81ResponseV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR84Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR84Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR96ResponseV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RRExtDocumentDataRequest;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RRExtDocumentDataResponse;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RRPORTTEOVOIMEResponse;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR67Response.TtKoodid;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR72Response.TtIsikud;

/**
 * <code>rr</code> (Rahvastikuregister) database X-tee service.
 * 
 * @author Roman Tekhov
 */
public interface RrXTeeService {

	/**
	 * <code>rr.RR72_isik.v1</code> service.
	 */
	List<TtIsikud.Item> findRR72Isik(String... idCodes)
			throws XTeeServiceConsumptionException;

	/**
	 * <code>rr.RR63isikAadrDok.v1</code> service.
	 */
	RR63ResponseV1 findRR63IsikAadrDok(String surname, String firstName,
			String idCode, String birthDate)
			throws XTeeServiceConsumptionException;
	
	/**
	 * <code>rr.RR81KMAisikkontroll.v1</code> service.
	 */
	RR81Response getRR81KMAisikkontroll(String idCode)
			throws XTeeServiceConsumptionException;

	/**
	 * <code>rr.RR81KMAisikkontroll_V1.v1</code> service.
	 */
	RR81ResponseV1 getRR81KMAisikkontrollv1(String idCode)
			throws XTeeServiceConsumptionException;

	/**
	 * <code>rr.RR40isikTaielikIsikukood.v1</code> service.
	 */
	RR40Response findRR40isikTaielikIsikukood(String isikukood)
			throws XTeeServiceConsumptionException;
	
	/**
	 * <code>rr.RR42isikAadressKood.v1</code> service.
	 */
	RR42Response findRR42isikAadressKood(RR42RequestCallback cb)
			throws XTeeServiceConsumptionException;

	interface RR42RequestCallback {
		void populate(RR42Request paring);
	}

	/**
	 * <code>rr.RR52.v1</code> service.
	 */
	RR52Response getRR52(String idCode, String forename, String surname)
			throws XTeeServiceConsumptionException;

	/**
	 * <code>rr.RR43dokument.v1</code> service.
	 */
	RR43Response getRR43dokument(String dokumendiKood, String dokumendiSeeria,
			DokumendiTyyp.Enum dokumendiTyyp)
			throws XTeeServiceConsumptionException;

	/**
	 * <code>rr.RR96IsikDokElukSuhe_v1.v1</code> service.
	 */
	RR96ResponseV1 getRR96isikDokElukSuhe(String isikueesnimi,
			String isikuperenimi, String isikukood, Long vastusteArv)
			throws XTeeServiceConsumptionException;

	/**
	 * <code>rr.RRExtDocumentDataArkLuba.v1</code> service.
	 */
	RRExtDocumentDataResponse sendRRExtDocumentDataArkLuba(
			RRExtDocumentDataRequest request)
			throws XTeeServiceConsumptionException;

	/**
	 * <code>rr.RR67MuutusV1.v1</code> service.
	 */
	List<TtKoodid.Item> findRR67MuutusV1(Date algus, Date lopp,
			String... koodid) throws XTeeServiceConsumptionException;

	 /**
   * <code>rr.RR84IsikuSeosed.v1</code> service.
   */
  RR84Response findRR84IsikuSeosed(String isikukood) throws XTeeServiceConsumptionException;
  
	/**
	 * <code>rr.RR41isikPohiandmedV1.v1</code> service.
	 */
  RR41ResponseV1 findRR41isikPohiandmedV1(String perenimi, String eesnimi, String isikukood,
			String vald, IsikuStaatus staatus, Long vastusteArv)
			throws XTeeServiceConsumptionException;

  /**
   * <code>rr.RRPORTTEOVOIME.v1</code> service.
   */
  RRPORTTEOVOIMEResponse getRRPortTeovoimeV1(String isikukood)
			throws XTeeServiceConsumptionException;
}
