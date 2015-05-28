package com.nortal.jroad.client.treasury;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.treasury.types.ee.riik.xtee.treasury.producers.producer.treasury.SendDocumentResponseType;

/**
 * Estonian treasury service for sending payment documents. Note, that you must also implement their response WSDL on
 * your side if you want to receive any feedback for your system.
 * 
 * @author Dmitri Danilkin
 * @author Lauri Lättemäe <lauri.lattemae@nortal.com>
 */
public interface TreasuryXTeeService {
  /**
   * Send a document to the treasury.
   * 
   * @param uniqueId A unique identifier for the document
   * @param type Type specified by their service analysis document
   * @param document A signed digidoc container containing the document
   * @return
   * @throws XTeeServiceConsumptionException
   */
  SendDocumentResponseType sendDocument(String uniqueId, String type, byte[] document)
      throws XTeeServiceConsumptionException;
}
