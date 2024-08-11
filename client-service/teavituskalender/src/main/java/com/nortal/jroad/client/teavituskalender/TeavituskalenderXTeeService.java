package com.nortal.jroad.client.teavituskalender;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusVastus;

/**
 * @author Aleksandr.Koltakov
 */
public interface TeavituskalenderXTeeService {

  LisaSyndmusVastus lisaSyndmus(Syndmus syndmus) throws XRoadServiceConsumptionException;
}
