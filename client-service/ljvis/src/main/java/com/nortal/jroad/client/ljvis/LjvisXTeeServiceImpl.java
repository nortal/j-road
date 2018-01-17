package com.nortal.jroad.client.ljvis;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ljvis.database.LjvisXRoadDatabase;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYVconfirmDocument;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYVqueryDocument;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvConfirmRequestType;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvConfirmResponseType;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvQueryResponseType;

@Service("ljvisXTeeService")
public class LjvisXTeeServiceImpl implements LjvisXTeeService {

	@Resource
	private LjvisXRoadDatabase ljvisXRoadDatabase;

	public ErakorralineYvQueryResponseType erakorralineYlevaatused() throws XRoadServiceConsumptionException {
		ErakorralineYVqueryDocument.ErakorralineYVquery request = ErakorralineYVqueryDocument.ErakorralineYVquery.Factory.newInstance();
		return ljvisXRoadDatabase.erakorralineYVqueryV1(request).getResponse();
	}

	public ErakorralineYvConfirmResponseType erakorralineConfirm(ErakorralineYvConfirmRequestType request)
		throws XRoadServiceConsumptionException {
		ErakorralineYVconfirmDocument.ErakorralineYVconfirm erakorralineYVconfirmDocument =
				ErakorralineYVconfirmDocument.ErakorralineYVconfirm.Factory.newInstance();
		erakorralineYVconfirmDocument.setRequest(request);
		return ljvisXRoadDatabase.erakorralineYVconfirmV1(erakorralineYVconfirmDocument).getResponse();
	}

}
