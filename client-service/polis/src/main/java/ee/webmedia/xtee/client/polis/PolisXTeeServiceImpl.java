package ee.webmedia.xtee.client.polis;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.polis.types.ee.riik.xtee.polis.producers.producer.polis.JuhtAraParing;
import ee.webmedia.xtee.client.polis.types.ee.riik.xtee.polis.producers.producer.polis.JuhtAraResponse;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

public class PolisXTeeServiceImpl extends XTeeDatabaseService implements PolisXTeeService {

  private static final String JUHT_ARA = "JuhtAra";
  
  @Override
  public JuhtAraResponse juhtimisoiguseKontroll(JuhtAraParing request) throws XTeeServiceConsumptionException {

    XTeeMessage<JuhtAraResponse> response = send(new XmlBeansXTeeMessage<JuhtAraParing>(request), JUHT_ARA);
    return response.getContent();
  }

}
