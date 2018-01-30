package com.nortal.jroad.client.skais2;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusVastusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusResponse;
import com.nortal.jroad.model.XTeeMessage;

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

  /**
   * Skais2.TKToovoimPuueHyvitisedMassTeenus.v1
   */
  TKToovoimPuueHyvitisedMassTeenusResponse submitTKToovoimPuueHyvitisedMassTeenusV1(TKToovoimPuueHyvitisedMassTeenusRequest request) throws XTeeServiceConsumptionException;

  /**
   * Skais2.TKToovoimPuueHyvitisedMassTeenusVastus.v1
   */
  XTeeMessage<TKToovoimPuueHyvitisedMassTeenusVastusResponse> getTKToovoimPuueHyvitisedMassTeenusVastusV1(long protsessiId) throws XTeeServiceConsumptionException;

}
