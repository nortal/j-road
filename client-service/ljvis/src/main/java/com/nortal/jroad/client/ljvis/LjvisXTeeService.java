package com.nortal.jroad.client.ljvis;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvConfirmRequestType;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvConfirmResponseType;
import com.nortal.jroad.client.ljvis.types.eu.x_road.ljvis.ErakorralineYvQueryResponseType;

public interface LjvisXTeeService {

	ErakorralineYvQueryResponseType erakorralineYlevaatused() throws XRoadServiceConsumptionException;

	ErakorralineYvConfirmResponseType erakorralineConfirm(ErakorralineYvConfirmRequestType request) throws XRoadServiceConsumptionException;
}
