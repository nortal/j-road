package com.nortal.jroad.client.skais2;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusVastusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusResponse;
import com.nortal.jroad.model.XRoadMessage;

/**
 * @author Hasso Mehide <hasso.mehide@nortal.com>
 */
public interface Skais2XRoadService {

    /**
     * Skais2.TVHTaotlusYksUks.v1
     */
    TVHYhisTaotlusResponse tvhTaotlusYksUksV1(TVHYhisTaotlusRequest request) throws XRoadServiceConsumptionException;
	
	/**
     * Skais2.TKToovoimPuueHyvitised.v1
     */
	TKToovoimPuueHyvitisedResponse tkToovoimPuueHyvitisedV1(TKToovoimPuueHyvitisedRequest request) throws XRoadServiceConsumptionException;

  /**
   * Skais2.TKToovoimPuueHyvitisedMassTeenus.v1
   */
  TKToovoimPuueHyvitisedMassTeenusResponse submitTKToovoimPuueHyvitisedMassTeenusV1(TKToovoimPuueHyvitisedMassTeenusRequest request) throws XRoadServiceConsumptionException;

  /**
   * Skais2.TKToovoimPuueHyvitisedMassTeenusVastus.v1
   */
  XRoadMessage<TKToovoimPuueHyvitisedMassTeenusVastusResponse> getTKToovoimPuueHyvitisedMassTeenusVastusV1(long protsessiId) throws XRoadServiceConsumptionException;

}
