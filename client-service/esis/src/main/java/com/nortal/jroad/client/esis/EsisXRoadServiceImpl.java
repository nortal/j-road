package com.nortal.jroad.client.esis;

import javax.annotation.Resource;

import com.nortal.jroad.client.esis.database.EsisXRoadDatabase;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSCreateAlertForXteeDocument.NSCreateAlertForXtee;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSCreateAlertForXteeResponseDocument.NSCreateAlertForXteeResponse;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.SSGetStatusForXteeDocument.SSGetStatusForXtee;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.SSGetStatusForXteeResponseDocument.SSGetStatusForXteeResponse;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSExecuteStandardQueryForXteeDocument.NSExecuteStandardQueryForXtee;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSExecuteStandardQueryForXteeResponseDocument.NSExecuteStandardQueryForXteeResponse;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;

@Service("esisXRoadService")
public class EsisXRoadServiceImpl extends XRoadDatabaseService implements EsisXRoadService {

	@Resource
	private EsisXRoadDatabase esisXRoadDatabase;

	@Override
	public NSExecuteStandardQueryForXteeResponse nsExecuteStandardQueryForXteeV1(NSExecuteStandardQueryForXtee nsExecuteStandardQueryForXtee)
		throws XRoadServiceConsumptionException {
		return esisXRoadDatabase.nsExecuteStandardQueryForXteeV1(nsExecuteStandardQueryForXtee);
	}

	@Override
	public SSGetStatusForXteeResponse sSGetStatusForXteeResponse(SSGetStatusForXtee getStatusForXtee)
		throws XRoadServiceConsumptionException {
		return esisXRoadDatabase.ssGetStatusForXteeV1(getStatusForXtee);
	}
	
	@Override
	public NSCreateAlertForXteeResponse nSCreateAlertForXteeResponse(NSCreateAlertForXtee createAlertForXtee)
		throws XRoadServiceConsumptionException {
		return esisXRoadDatabase.nsCreateAlertForXteeV1(createAlertForXtee);
	}

}
