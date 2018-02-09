package com.nortal.jroad.client.esis;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSExecuteStandardQueryForXteeDocument.NSExecuteStandardQueryForXtee;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSExecuteStandardQueryForXteeResponseDocument.NSExecuteStandardQueryForXteeResponse;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSExecuteStandardQueryForXteeResponseDocument.NSExecuteStandardQueryForXteeResponse.Response;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.types.alert.*;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.types.alert.StandardQueryHitListType.HitCandidates;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.types.common.HeaderType;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

public class EsisXRoadServiceImplTest extends BaseXRoadServiceImplTest {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

	@Resource
	private EsisXRoadServiceImpl esisXRoadService;

	@Test
	public void nsExecuteStandardQueryForXteeV1() throws XRoadServiceConsumptionException {
		NSExecuteStandardQueryForXtee nxt = NSExecuteStandardQueryForXtee.Factory.newInstance();

		NSExecuteStandardQueryForXtee.Request req = nxt.addNewRequest();

		HeaderType header = req.addNewHeader();
		header.setMessageID(getMessageId());
		header.setLogicalSessionID(getMessageId());
		header.setDateTime(sdf.format(new Date()));
		header.setEndUserID("test");
		header.setUser("0017.02");
		header.setUserRole("0005.01");
		header.setSystemID("16");
		header.setContract("0006.01");
		header.setOperation("0021.01");

		NSExecuteStandardQueryForXtee.Request.NsRequest nsr = req.addNewNsRequest();
		StandardQueryType sqt = nsr.addNewSearchCriteria();
		sqt.setSendWarning(true);
		SingleCategoryQueryType singleCategoryQueryType = sqt.addNewSingleCategoryQueryType();
		StandardVehicleQueryType vehicleQueryType = singleCategoryQueryType.addNewVehicle();
		VINNumberSearchType vinNumberSearchType = vehicleQueryType.addNewVINNumber();
		vinNumberSearchType.setStringValue("WV2ZZZ70ZSH117850");
		NSExecuteStandardQueryForXteeResponse ns = esisXRoadService.nsExecuteStandardQueryForXteeV1(nxt);

		Response response = ns.getResponse();
		Response.CsResponse csResponse = response.getCsResponse();
		StandardQueryHitListType sqh = csResponse.getHitList();
		HitCandidates hc = sqh.getHitCandidates();
	}

	private String getMessageId() {
		return String.format("%017d", System.nanoTime()).substring(0, 17);
	}

}
