package com.nortal.jroad.client.etoimik;

import java.util.Date;

import com.nortal.jroad.client.etoimik.types.ee.riik.xtee.etoimik.producers.producer.etoimik.LeiaToovoimetuteKaristused;
import com.nortal.jroad.client.etoimik.types.ee.riik.xtee.etoimik.producers.producer.etoimik.KARRParinguVastus.KarrIsikuteValjavote;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * @author Romet Piho
 */
public interface EtoimikXTeeService {

  KarrIsikuteValjavote leiaToovoimetuteKaristused(LeiaToovoimetuteKaristused request)
      throws XTeeServiceConsumptionException;
}
