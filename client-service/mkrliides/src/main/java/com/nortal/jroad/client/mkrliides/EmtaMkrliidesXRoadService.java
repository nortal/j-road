package com.nortal.jroad.client.mkrliides;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.mkrliides.types.eu.x_road.emta_v6.VptResponseDocument;
import com.nortal.jroad.client.mkrliides.types.eu.x_road.emta_v6.XteeFIEAKResponseDocument;

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
    XteeFIEAKResponseDocument.XteeFIEAKResponse xteeFIEAKV1(String id, Date start, Date end)
        throws XRoadServiceConsumptionException;

    /**
     * <code>mkrliides.vpt.v1</code> X-road service.
     */
    VptResponseDocument.VptResponse vptV1(String id, Date date) throws XRoadServiceConsumptionException;

}
