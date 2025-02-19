package com.nortal.jroad.client.tarn;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.tarn.types.eu.x_road.etoimik.Toiming;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.TaitemenetluseMuutmineTaResponseDocument
    .TaitemenetluseMuutmineTaResponse;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.TaitemenetluseMuutmineTaSisend;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.TaitmisavalduseEsitamineResponseDocument
    .TaitmisavalduseEsitamineResponse;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.TarnToiming;
import com.nortal.jroad.model.XRoadAttachment;

import java.util.List;

/**
 * <code>TARN</code> database X-tee service<br>
 *
 * @author Kauri Kägo
 */
public interface TarnXRoadService {

  /**
   * <code>tarn.TaitemenetluseMuutmineTa.v1</code> X-road service.
   */
  TaitemenetluseMuutmineTaResponse taitemenetluseMuutmineTaV1(TaitemenetluseMuutmineTaSisend input)
      throws XRoadServiceConsumptionException;

  /**
   * <code>tarn.TaitmisavalduseEsitamine.v1</code> X-road service.
   */
  TaitmisavalduseEsitamineResponse taitmisavalduseEsitamineV1(TarnToiming input,
                                                              List<XRoadAttachment> attachments)
      throws XRoadServiceConsumptionException;

}
