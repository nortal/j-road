package com.nortal.jroad.client.rr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlString;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rr.database.RrXRoadDatabase;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.DokumendiTyyp;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.IsikuStaatus;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR40Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR40Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR41Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR41RequestV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR41ResponseV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR42Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR42Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR43Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR43Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR52Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR52Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR63RequestV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR63ResponseV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR67Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR67Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR72Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR81Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR81RequestV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR81Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR81ResponseV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR84Request;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR84Response;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR96RequestV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR96ResponseV1;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RRExtDocumentDataRequest;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RRExtDocumentDataResponse;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR67Response.TtKoodid;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RR72Response.TtIsikud;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RRPORTTEOVOIMERequest;
import com.nortal.jroad.client.rr.types.ee.riik.xtee.rr.producers.producer.rr.RRPORTTEOVOIMEResponse;
import com.nortal.jroad.client.util.XmlBeansUtil;

/**
 * @author Roman Tekhov
 */
@Service("rrXTeeService")
public class RrXTeeServiceImpl implements RrXTeeService {

	@Resource
	private RrXRoadDatabase rrXRoadDatabase;

	public RR42Response findRR42isikAadressKood(RR42RequestCallback callback)
			throws XRoadServiceConsumptionException {
		RR42Request paring = RR42Request.Factory.newInstance();

		callback.populate(paring);

		return rrXRoadDatabase.rr42IsikAadressKoodV1(paring);
	}

	public RR40Response findRR40isikTaielikIsikukood(String isikukood)
			throws XRoadServiceConsumptionException {
		RR40Request paring = RR40Request.Factory.newInstance();

		XmlString isikukoodElement = XmlBeansUtil
				.getAttributedXmlString(isikukood);
		paring.xsetIsikukood(isikukoodElement);

		return rrXRoadDatabase.rr40IsikTaielikIsikukoodV1(paring);
	}

	public List<TtIsikud.Item> findRR72Isik(String... idCodes)
			throws XRoadServiceConsumptionException {
		RR72Request request = RR72Request.Factory.newInstance();

		String isikukoodid = StringUtils.join(idCodes, ",");
		XmlString isikukoodidElement = XmlBeansUtil
				.getAttributedXmlString(isikukoodid);
		request.xsetCIsikukoodid(isikukoodidElement);

		TtIsikud ttIsikud = rrXRoadDatabase.rr72IsikV1(request).getTtIsikud();

		return ttIsikud != null ? ttIsikud.getItemList()
				: new ArrayList<TtIsikud.Item>(0);
	}

	public RR63ResponseV1 findRR63IsikAadrDok(String surname, String firstName,
			String idCode, String birthDate)
			throws XRoadServiceConsumptionException {

		RR63RequestV1 request = RR63RequestV1.Factory.newInstance();
		XmlString eesnimiElement = XmlBeansUtil
				.getAttributedXmlString(firstName);
		request.xsetIsikueesnimi(eesnimiElement);
		XmlString perenimiElement = XmlBeansUtil
				.getAttributedXmlString(surname);
		request.xsetIsikuperenimi(perenimiElement);
		XmlString isikukoodElement = XmlBeansUtil
				.getAttributedXmlString(idCode);
		request.xsetIsikukood(isikukoodElement);
		XmlString synnikpElement = XmlBeansUtil
				.getAttributedXmlString(birthDate);
		request.xsetIsikuSynnikuupaev(synnikpElement);

		return rrXRoadDatabase.rr63IsikAadrDokV1V1(request);
	}
	
	public RR81Response getRR81KMAisikkontroll(String idCode)
			throws XRoadServiceConsumptionException {
		RR81Request request = RR81Request.Factory.newInstance();

		XmlString isikukoodElement = XmlBeansUtil
				.getAttributedXmlString(idCode);
		request.xsetIsikukood(isikukoodElement);

		return rrXRoadDatabase.rr81KMAisikkontrollV1(request);
	}

	public RR81ResponseV1 getRR81KMAisikkontrollv1(String idCode)
			throws XRoadServiceConsumptionException {
		RR81RequestV1 request = RR81RequestV1.Factory.newInstance();

		XmlString isikukoodElement = XmlBeansUtil
				.getAttributedXmlString(idCode);
		request.xsetIsikukood(isikukoodElement);

		return rrXRoadDatabase.rr81KMAisikkontrollV1V1(request);
	}

	public RR52Response getRR52(String idCode, String forename, String surname)
			throws XRoadServiceConsumptionException {
		RR52Request request = RR52Request.Factory.newInstance();

		XmlString isikukoodElement = XmlBeansUtil
				.getAttributedXmlString(idCode);
		request.xsetIsikukood(isikukoodElement);

		XmlString forenameElement = XmlBeansUtil
				.getAttributedXmlString(forename);
		request.xsetIsikueesnimi(forenameElement);

		XmlString surnameElement = XmlBeansUtil.getAttributedXmlString(surname);
		request.xsetIsikuperenimi(surnameElement);

		return rrXRoadDatabase.rr52V1(request);
	}

	public RR43Response getRR43dokument(final String dokumendiKood,
			final String dokumendiSeeria, DokumendiTyyp.Enum dokumendiTyyp)
			throws XRoadServiceConsumptionException {
		RR43Request request = RR43Request.Factory.newInstance();

		request.setDokumendiKood(dokumendiKood);
		request.setDokumendiSeeria(dokumendiSeeria);
		request.setDokumendiTyyp(dokumendiTyyp);

		return rrXRoadDatabase.rr43DokumentV1(request);
	}

	public RR96ResponseV1 getRR96isikDokElukSuhe(final String isikueesnimi,
			final String isikuperenimi, final String isikukood,
			final Long vastusteArv) throws XRoadServiceConsumptionException {
		RR96RequestV1 request = RR96RequestV1.Factory.newInstance();

		request.setIsikueesnimi(isikueesnimi);
		request.setIsikuperenimi(isikuperenimi);
		request.setIsikukood(isikukood);
		request.setVastusteArv(String.valueOf(vastusteArv));

		return rrXRoadDatabase.rr96IsikDokElukSuheV1V1(request);
	}

	public RRExtDocumentDataResponse sendRRExtDocumentDataArkLuba(
			RRExtDocumentDataRequest request)
			throws XRoadServiceConsumptionException {
		return rrXRoadDatabase.rrExtDocumentDataArkLubaV1(request);
	}

	public List<TtKoodid.Item> findRR67MuutusV1(Date algus, Date lopp,
			String... koodid) throws XRoadServiceConsumptionException {
		RR67Request request = RR67Request.Factory.newInstance();

		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
		if (koodid != null) {
			String codes = "";
			for (String item : koodid) {
				codes += codes.length() > 0 ? "," : "";
				codes += item;
			}
			request.setCMuutused(codes);
		}
		if (algus != null) {
			request.setCAlgKpv(df.format(algus));
			request.setCAlgKell(tf.format(algus));
		}

		if (lopp != null) {
			request.setCLoppKpv(df.format(lopp));
			request.setCLoppKell(tf.format(lopp));
		}
		RR67Response rsp = rrXRoadDatabase.rr67MuutusV1(request);
		return rsp.getTtKoodid() != null ? rsp.getTtKoodid().getItemList()
				: new ArrayList<TtKoodid.Item>();
	}

	public RR84Response findRR84IsikuSeosed(String isikukood)
	    throws XRoadServiceConsumptionException {
	  RR84Request request = RR84Request.Factory.newInstance();
	  request.setIsikukood(isikukood);
	  return rrXRoadDatabase.rr84IsikuSeosedV1(request);
	}
	
	public RR41ResponseV1 findRR41isikPohiandmedV1(String perenimi, String eesnimi, String isikukood,
			String vald, IsikuStaatus staatus, Long vastusteArv)
			throws XRoadServiceConsumptionException {
		RR41RequestV1 request = RR41RequestV1.Factory.newInstance();

		request.setIsikuperenimi(perenimi);
		request.setIsikueesnimi(eesnimi);
		request.setIsikukood(isikukood);
		request.setVald(vald);
		request.xsetStaatus(staatus);
		request.setMitu(String.valueOf(vastusteArv));

		return rrXRoadDatabase.rr41IsikPohiandmedV1V1(request);
	}

	public RRPORTTEOVOIMEResponse getRRPortTeovoimeV1(String isikukood)
			throws XRoadServiceConsumptionException {
		RRPORTTEOVOIMERequest request = RRPORTTEOVOIMERequest.Factory.newInstance();
		request.setIsikukood(isikukood);

		return rrXRoadDatabase.rrportteovoimeV1(request);
	}
}
