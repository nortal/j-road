package com.nortal.jroad.client.etoimik;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.etoimik.types.ee.riik.xtee.etoimik.producers.producer.etoimik.KARRParinguVastus;
import com.nortal.jroad.client.etoimik.types.ee.riik.xtee.etoimik.producers.producer.etoimik.KARRParinguVastus.KarrIsikuteValjavote;
import com.nortal.jroad.client.etoimik.types.ee.riik.xtee.etoimik.producers.producer.etoimik.LeiaToovoimetuteKaristused;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;

/**
 * @author Romet Piho
 */
@Service("etoimikXTeeService")
public class EtoimikXTeeServiceImpl extends XRoadDatabaseService implements EtoimikXTeeService {
  
  @Override
  public void init() {
    super.init();
    setDatabase("e-toimik");
  }

  public KarrIsikuteValjavote leiaToovoimetuteKaristused(LeiaToovoimetuteKaristused request)
      throws XRoadServiceConsumptionException {
    XRoadMessage<KARRParinguVastus> karrVastus = send(new XmlBeansXRoadMessage<LeiaToovoimetuteKaristused>(request),
                                                     "LeiaToovoimetuteKaristused",
                                                     "v4");

    return karrVastus.getContent().getKarrIsikuteValjavote();
  }
}
