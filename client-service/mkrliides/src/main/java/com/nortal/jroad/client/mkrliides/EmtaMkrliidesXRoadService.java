package com.nortal.jroad.client.mkrliides;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

import java.util.Date;

/**
 *  mkrliides namespace in wsdl is emta-v6
 *
 *  @author Kauri Kägo <kauri.kago@nortal.com>
 */
public interface EmtaMkrliidesXRoadService {

     /**
     * <code>mkrliides.xteeFIEAK.v1</code> X-road service.
     */
    com.nortal.jroad.client.mkrliides.types.eu.x_road.emta_v6.XteeFIEAKResponseDocument.XteeFIEAKResponse xteeFIEAKV1(String id, Date start, Date end) throws XTeeServiceConsumptionException;

  }
