package ee.webmedia.xtee.client.rmviki.database;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
import org.springframework.stereotype.Service;

/**
 * <code>rmviki</code> X-tee database implementation.
 */
@Service("rmvikiXTeeDatabase")
public class RmvikiXTeeDatabaseImpl extends XTeeDatabaseService  implements RmvikiXTeeDatabase {

  /**
   * <code>rmviki.Z_RKOVAR.v1</code> X-tee service implementation.
   */
  public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse zRKOVARV1(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest input) throws XTeeServiceConsumptionException {
    XTeeMessage<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARResponse> response = send(new XmlBeansXTeeMessage<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.ZRKOVARRequest>(input), "Z_RKOVAR", "v1");

    return response.getContent();
  }

  /**
   * <code>rmviki.rarVta.v1</code> X-tee service implementation.
   */
  public ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaResponseType rarVtaV1(ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaRequestType input) throws XTeeServiceConsumptionException {
    XTeeMessage<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaResponseType> response = send(new XmlBeansXTeeMessage<ee.webmedia.xtee.client.rmviki.types.ee.riik.xtee.rmviki.producers.producer.rmviki.RarVtaRequestType>(input), "rarVta", "v1");

    return response.getContent();
  }

}