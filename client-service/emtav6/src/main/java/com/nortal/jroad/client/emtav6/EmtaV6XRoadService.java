package com.nortal.jroad.client.emtav6;

import java.util.List;

import com.nortal.jroad.client.emtav6.types.eu.x_road.emta_v6.PreRegCheckDocument.PreRegCheck;
import com.nortal.jroad.client.emtav6.types.eu.x_road.emta_v6.PreRegCheckResponseItemType;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

/**
 * <code>emtav6</code> (Maksu- ja Tolliamet) database X-tee v6 service.
 */
public interface EmtaV6XRoadService {

	List<PreRegCheckResponseItemType> preRegCheckV1(PreRegCheck preRegCheck) throws XRoadServiceConsumptionException;

}
