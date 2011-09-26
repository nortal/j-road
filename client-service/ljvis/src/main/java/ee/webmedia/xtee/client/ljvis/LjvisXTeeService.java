package ee.webmedia.xtee.client.ljvis;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Request;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVconfirmV1Response;
import ee.webmedia.xtee.client.ljvis.types.ee.riik.xtee.ljvis.producers.producer.ljvis.ErakorralineYVqueryV1Response;

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
