package com.nortal.jroad.client.mteenus;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.mteenus.types.ee.riik.xtee.mteenus.producers.producer.mteenus.TeavitusVastus;

/**
 * @author Aleksandr.Koltakov
 */
public interface MteenusXTeeService {
  TeavitusVastus send(Sms sms) throws XTeeServiceConsumptionException;
}
