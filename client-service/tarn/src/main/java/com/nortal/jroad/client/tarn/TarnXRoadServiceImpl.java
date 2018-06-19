package com.nortal.jroad.client.tarn;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tarn.database.TarnXRoadDatabase;
import com.nortal.jroad.client.tarn.types.eu.x_road.etoimik.Toiming;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("tarnXRoadService")
public class TarnXRoadServiceImpl implements TarnXRoadService {

  @Resource
  private TarnXRoadDatabase tarnXRoadDatabase;

  public TaitemenetluseMuutmineTaResponseDocument.TaitemenetluseMuutmineTaResponse taitemenetluseMuutmineTaV1(TaitemenetluseMuutmineTaSisend input)
      throws XTeeServiceConsumptionException {

    TaitemenetluseMuutmineTaDocument.TaitemenetluseMuutmineTa taitemenetluseMuutmineTa =
        TaitemenetluseMuutmineTaDocument.TaitemenetluseMuutmineTa.Factory.newInstance();
    taitemenetluseMuutmineTa.setKeha(input);

    return tarnXRoadDatabase.taitemenetluseMuutmineTaV1(taitemenetluseMuutmineTa);
  }

  public TaitmisavalduseEsitamineResponseDocument.TaitmisavalduseEsitamineResponse taitmisavalduseEsitamineV1(Toiming input)
      throws XTeeServiceConsumptionException {

    TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine taitmisavalduseEsitamine =
        TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine.Factory.newInstance();
    taitmisavalduseEsitamine.addNewKeha().setMuudatused(input);

    return tarnXRoadDatabase.taitmisavalduseEsitamineV1(taitmisavalduseEsitamine);
  }
}
