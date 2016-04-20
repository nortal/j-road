package com.nortal.jroad.client.etoimik;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.etoimik.types.ee.riik.xtee.etoimik.producers.producer.etoimik.KARRParinguVastus;
import com.nortal.jroad.client.etoimik.types.ee.riik.xtee.etoimik.producers.producer.etoimik.KARRParinguVastus.KarrIsikuteValjavote;
import com.nortal.jroad.client.etoimik.types.ee.riik.xtee.etoimik.producers.producer.etoimik.LeiaToovoimetuteKaristused;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.v2.XTeeDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;

/**
 * @author Romet Piho
 */
@Service("etoimikXTeeService")
public class EtoimikXTeeServiceImpl extends XTeeDatabaseService implements EtoimikXTeeService {
  
  @Override
  public void init() {
    super.init();
    setDatabase("e-toimik");
  }

  public KarrIsikuteValjavote leiaToovoimetuteKaristused(LeiaToovoimetuteKaristused request)
      throws XTeeServiceConsumptionException {
    XTeeMessage<KARRParinguVastus> karrVastus = send(new XmlBeansXTeeMessage<LeiaToovoimetuteKaristused>(request),
                                                     "LeiaToovoimetuteKaristused",
                                                     "v4");

    return karrVastus.getContent().getKarrIsikuteValjavote();
  }
}
