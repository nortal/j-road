package com.nortal.jroad.client.adsv6;

import com.nortal.jroad.client.adsv6.types.ee.maaamet.ADSnormalVastusType;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

public interface Adsv6XTeeService {

  public ADSnormalVastusType adsNormal(String aadressTekst) throws XRoadServiceConsumptionException;
}
