package ee.webmedia.xtee.client.polis;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.polis.types.ee.riik.xtee.polis.producers.producer.polis.JuhtAraParing;
import ee.webmedia.xtee.client.polis.types.ee.riik.xtee.polis.producers.producer.polis.JuhtAraResponse;

/**
 * <code>polis</code> (Polis client services) database X-tee service.
 * 
 * @author Tatjana Kulikova
 */
public interface PolisXTeeService {
  
  /**
   * <code>polis.juhtAra.v1</code> service.
   */
  JuhtAraResponse juhtimisoiguseKontroll(JuhtAraParing request) throws XTeeServiceConsumptionException;
 
}
