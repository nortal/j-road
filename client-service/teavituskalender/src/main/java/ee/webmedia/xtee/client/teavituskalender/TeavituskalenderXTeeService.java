package ee.webmedia.xtee.client.teavituskalender;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusVastus;

/**
 * @author Aleksandr.Koltakov
 */
public interface TeavituskalenderXTeeService {

  LisaSyndmusVastus lisaSyndmus(Syndmus syndmus) throws XTeeServiceConsumptionException;
}
