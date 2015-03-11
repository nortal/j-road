package com.nortal.jroad.client.rets;

import java.util.List;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rets.types.ee.riik.xtee.rets.producers.producer.rets.VeadType;

/**
 * <code>rets</code> (Retseptikeskus) database X-tee service.
 * 
 * @author Tanel Käär (tanelk@nortal.com)
 */
public interface RetsXTeeService {

  /**
   * <code>rets.hl7document.v1</code> service.
   */
  String sendHl7Document(String hl7Xml, String idCode, List<VeadType> veadOut) throws XTeeServiceConsumptionException;

}
