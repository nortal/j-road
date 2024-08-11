package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kvkr.types.eu.x_road.kvkr.ServiceinfoResponseDocument;

public interface KvkrXRoadService {

    /**
     * <code>kvkr.serviceinfo.v1</code> service.
     *
     * @param nationalIdCode Isikukood
     * @param queryGrounds   Päringu sooritamise põhjus
     */
    ServiceinfoResponseDocument.ServiceinfoResponse getServiceinfoV1(String nationalIdCode, String queryGrounds) throws XRoadServiceConsumptionException;

}
