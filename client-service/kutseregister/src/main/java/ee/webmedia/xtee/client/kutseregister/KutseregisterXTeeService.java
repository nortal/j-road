package ee.webmedia.xtee.client.kutseregister;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusVastus;

/**
 * @author Anti Orgla <br/>
 *         <code>Kutseregister</code> database X-tee service.
 */
public interface KutseregisterXTeeService {

  /**
   * <code>kutseregister.kutsetunnistus.v2</code> service.
   */
  KutsetunnistusVastus findKutseTunnistus(String isikukood, String nimi) throws XTeeServiceConsumptionException;
}
