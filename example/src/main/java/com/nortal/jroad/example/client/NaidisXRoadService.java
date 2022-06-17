package com.nortal.jroad.example.client;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.example.client.types.eu.x_road.naidis.AttachmentEchoResponse;

/**
 * Example X-road service
 *
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com)
 */
public interface NaidisXRoadService {
  String sendEcho(String text) throws XRoadServiceConsumptionException;

  String sendEchoMime(String text) throws XRoadServiceConsumptionException;

  String sendAxisEcho(String text) throws XRoadServiceConsumptionException;
}
