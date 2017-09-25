package com.nortal.jroad.client.skais2;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedResponse;

/**
 * @author Hasso Mehide <hasso.mehide@nortal.com>
 */
public interface Skais2XRoadService {

    /**
     * Skais2.TVHTaotlusYksUks.v1
     */
    TVHYhisTaotlusResponse tvhTaotlusYksUksV1(TVHYhisTaotlusRequest request) throws XTeeServiceConsumptionException;
	
	/**
     * Skais2.TKToovoimPuueHyvitised.v1
     */
	TKToovoimPuueHyvitisedResponse tkToovoimPuueHyvitisedV1(TKToovoimPuueHyvitisedRequest request) throws XTeeServiceConsumptionException;
}
