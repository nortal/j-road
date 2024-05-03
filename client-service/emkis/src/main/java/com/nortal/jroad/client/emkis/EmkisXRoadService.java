package com.nortal.jroad.client.emkis;

import java.util.Date;

import com.nortal.jroad.client.emkis.types.ee.riik.xtee.emkis.producers.producer.emkis.NaturaApplicationSearchResponse;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

public interface EmkisXRoadService {
  NaturaApplicationSearchResponse naturaApplicationSearch(Date andmedAlates, Long taotluseId)
      throws XRoadServiceConsumptionException;
}
