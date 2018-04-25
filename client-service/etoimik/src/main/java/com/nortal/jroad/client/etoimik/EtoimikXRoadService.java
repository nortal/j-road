package com.nortal.jroad.client.etoimik;

import com.nortal.jroad.client.etoimik.types.eu.x_road.etoimik.LeiaToovoimetuteKaristusedDocument;
import com.nortal.jroad.client.etoimik.types.eu.x_road.etoimik.LeiaToovoimetuteKaristusedResponseDocument;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * @author Romet Piho
 */
public interface EtoimikXRoadService {

  LeiaToovoimetuteKaristusedResponseDocument.LeiaToovoimetuteKaristusedResponse leiaToovoimetuteKaristused(LeiaToovoimetuteKaristusedDocument.LeiaToovoimetuteKaristused request)
      throws XTeeServiceConsumptionException;
}
