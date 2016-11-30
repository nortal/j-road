package com.nortal.jroad.client.emkis;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.emkis.database.EmkisXRoadDatabase;
import com.nortal.jroad.client.emkis.types.ee.riik.xtee.emkis.producers.producer.emkis.NaturaApplicationSearchRequest;
import com.nortal.jroad.client.emkis.types.ee.riik.xtee.emkis.producers.producer.emkis.NaturaApplicationSearchResponse;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;

@Service("emkisXRoadService")
public class EmkisXRoadServiceImpl extends XRoadDatabaseService implements EmkisXRoadService {
  @Resource
  private EmkisXRoadDatabase emkisXRoadDatabase;

  @Override
  public NaturaApplicationSearchResponse naturaApplicationSearch(Date andmedAlates, Long taotluseId)
      throws XRoadServiceConsumptionException {
    Calendar cal = Calendar.getInstance();
    cal.setTime(andmedAlates);

    NaturaApplicationSearchRequest req = NaturaApplicationSearchRequest.Factory.newInstance();
    req.setAndmedAlates(cal);
    if (taotluseId != null) {
      req.setTaotluseId(taotluseId);
    }
    return emkisXRoadDatabase.naturaApplicationSearchV1(req);
  }
}
