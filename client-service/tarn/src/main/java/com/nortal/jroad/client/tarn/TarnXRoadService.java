package com.nortal.jroad.client.tarn;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tarn.types.eu.x_road.etoimik.Toiming;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.TaitemenetluseMuutmineTaResponseDocument
    .TaitemenetluseMuutmineTaResponse;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.TaitemenetluseMuutmineTaSisend;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.TaitmisavalduseEsitamineResponseDocument
    .TaitmisavalduseEsitamineResponse;

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
      throws XTeeServiceConsumptionException;

  /**
   * <code>tarn.TaitmisavalduseEsitamine.v1</code> X-road service.
   */
  TaitmisavalduseEsitamineResponse taitmisavalduseEsitamineV1(Toiming input)
      throws XTeeServiceConsumptionException;

}