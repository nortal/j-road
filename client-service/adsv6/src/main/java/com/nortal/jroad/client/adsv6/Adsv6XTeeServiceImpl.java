package com.nortal.jroad.client.adsv6;

import com.nortal.jroad.client.adsv6.database.Adsv6XRoadDatabase;
import com.nortal.jroad.client.adsv6.types.ee.maaamet.ADSnormalRequestType;
import com.nortal.jroad.client.adsv6.types.ee.maaamet.ADSnormalVastusType;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adsv6XTeeService")
public class Adsv6XTeeServiceImpl implements Adsv6XTeeService {

  @Autowired
  private Adsv6XRoadDatabase adsv6XRoadDatabase;

  @Override
  public ADSnormalVastusType adsNormal(String aadressTekst) throws XRoadServiceConsumptionException {
    ADSnormalRequestType request = ADSnormalRequestType.Factory.newInstance();
    ADSnormalRequestType.Aadressid aadressid = request.addNewAadressid();
    ADSnormalRequestType.Aadressid.Aadress aadress = aadressid.addNewAadress();
    aadress.setTekst(aadressTekst);

    return adsv6XRoadDatabase.adSnormalV1(request);
  }
}
