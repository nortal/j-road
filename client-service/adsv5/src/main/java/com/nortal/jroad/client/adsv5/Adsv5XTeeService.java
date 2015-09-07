package com.nortal.jroad.client.adsv5;

import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalRequestType.NormalParam;
import com.nortal.jroad.client.adsv5.types.ee.x_road.adsv5.producer.ADSnormalVastusType;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

public interface Adsv5XTeeService {
  public ADSnormalVastusType adsNormal(NormalParamCallback callback) throws XTeeServiceConsumptionException;
  
  interface NormalParamCallback {
    void populate(NormalParam normalParam);
  }
}
