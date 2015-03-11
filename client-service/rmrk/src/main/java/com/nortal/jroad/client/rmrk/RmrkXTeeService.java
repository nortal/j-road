package com.nortal.jroad.client.rmrk;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * Estonian treasury service for sending payment documents. Note, that you must also implement their response WSDL on
 * your side if you want to receive any feedback for your system.
 * 
 * @author Dmitri Danilkin
 */
public interface RmrkXTeeService {
  /**
   * Send a document to the treasury.
   * 
   * @param uniqueId A unique identifier for the document
   * @param type Type specified by their service analysis document
   * @param manus A signed digidoc container containing the document
   * @return
   * @throws XTeeServiceConsumptionException
   */
  String sendDocument(String uniqueId, String type, byte[] document) throws XTeeServiceConsumptionException;
}
