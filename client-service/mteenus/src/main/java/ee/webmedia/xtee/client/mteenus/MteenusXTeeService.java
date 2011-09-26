package ee.webmedia.xtee.client.mteenus;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.mteenus.types.ee.riik.xtee.mteenus.producers.producer.mteenus.TeavitusVastus;

/**
 * @author Aleksandr.Koltakov
 */
public interface MteenusXTeeService {
  TeavitusVastus send(Sms sms) throws XTeeServiceConsumptionException;
}
