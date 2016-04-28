package com.nortal.jroad.example.client;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.AttachmentEchoResponse;
import com.nortal.jroad.example.client.types.ee.riik.xtee.naidis.producers.producer.naidis.EchoResponse;

/**
 * Example X-road service
 * 
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com)
 */
public interface NaidisXRoadService {
  AttachmentEchoResponse sendAttachment(String contentType, byte[] content) throws XRoadServiceConsumptionException;

  EchoResponse sendEcho(String text) throws XRoadServiceConsumptionException;

  EchoResponse sendAxisEcho(String text) throws XRoadServiceConsumptionException;
}
