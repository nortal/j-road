package com.nortal.jroad.client.tarn;

import javax.activation.DataHandler;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitemenetluseMuutmineTaSisend;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitemenetluseMuutmineTaVastus;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitmisavalduseEsitamineParing;
import com.nortal.jroad.client.tarn.types.ee.riik.xtee.tarn.producers.producer.tarn.TaitmisavalduseEsitamineVastus;

/**
 * <code>PKR</code> or <code>TPKR</code> X-tee service
 * 
 * @author Romet Piho
 */
public interface TarnXTeeService {

  /**
   * <code>tarn.taitemenetluseMuutmineTa.v1</code> service.
   */
  TaitemenetluseMuutmineTaVastus taitemenetluseMuutmine(
      TaitemenetluseMuutmineTaSisend paring)
      throws XTeeServiceConsumptionException;

  /**
   * <code>tarn.taitmisavalduseEsitamine.v1</code> service.
   */
  TaitmisavalduseEsitamineVastus taitmisavalduseEsitamine(
      TaitmisavalduseEsitamineParing input, DataHandler toimingudFail,
      DataHandler seotudToimingudFail) throws XTeeServiceConsumptionException;
}