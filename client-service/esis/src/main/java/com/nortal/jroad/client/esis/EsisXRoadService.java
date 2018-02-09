package com.nortal.jroad.client.esis;

import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSCreateAlertForXteeDocument.NSCreateAlertForXtee;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSCreateAlertForXteeResponseDocument.NSCreateAlertForXteeResponse;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSExecuteStandardQueryForXteeDocument.NSExecuteStandardQueryForXtee;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.NSExecuteStandardQueryForXteeResponseDocument.NSExecuteStandardQueryForXteeResponse;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.SSGetStatusForXteeDocument.SSGetStatusForXtee;
import com.nortal.jroad.client.esis.types.eu.europa.schengen.sis.xsd.v1.nsmessages.SSGetStatusForXteeResponseDocument.SSGetStatusForXteeResponse;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

public interface EsisXRoadService {

	NSExecuteStandardQueryForXteeResponse nsExecuteStandardQueryForXteeV1(NSExecuteStandardQueryForXtee nsExecuteStandardQueryForXtee)
		throws XRoadServiceConsumptionException;

	SSGetStatusForXteeResponse sSGetStatusForXteeResponse(SSGetStatusForXtee getStatusForXtee)
		throws XRoadServiceConsumptionException;

	NSCreateAlertForXteeResponse nSCreateAlertForXteeResponse(NSCreateAlertForXtee createAlertForXtee)
		throws XRoadServiceConsumptionException;
}
