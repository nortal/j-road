package com.nortal.jroad.client.kutseregister;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusVastusDocument.KutsetunnistusVastus;
/**
 * @author Anti Orgla <br/>
 *         <code>Kutseregister</code> database X-tee service.
 */
public interface KutseregisterXRoadService {

  /**
   * <code>kutseregister.kutsetunnistus.v2</code> service.
   */
  KutsetunnistusVastus findKutseTunnistus(String isikukood, String nimi) throws XRoadServiceConsumptionException;
}
