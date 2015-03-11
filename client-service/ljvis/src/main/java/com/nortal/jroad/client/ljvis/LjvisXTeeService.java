package com.nortal.jroad.client.ljvis;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Response;
import com.nortal.jroad.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVqueryV1Response;

/**
 * <code>ljvis</code> (Liiklusjärelvalve client services) database X-tee service.
 * 
 * @author Tatjana Kulikova
 */
public interface LjvisXTeeService {

  /**
   * <code>ljvis.ErakorralineYVquery.v1</code> service.
   */
  ErakorralineYVqueryV1Response erakorralineYlevaatused() throws XTeeServiceConsumptionException;

  /**
   * <code>ljvis.ErakorralineYVconfirm.v1</code> service.
   */
  ErakorralineYVconfirmV1Response erakorralineConfirm(ErakorralineYVconfirmV1Request paring)
      throws XTeeServiceConsumptionException;
}
