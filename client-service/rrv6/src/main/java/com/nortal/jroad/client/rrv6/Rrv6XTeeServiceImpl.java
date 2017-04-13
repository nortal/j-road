package com.nortal.jroad.client.rrv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv6.database.RrXRoadDatabase;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR84IsikuSeosedDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR84IsikuSeosedRequestType;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR84IsikuSeosedResponseDocument;

import javax.annotation.Resource;

/**
 * Created by raunor
 * on 11.04.2017.
 */
public class Rrv6XTeeServiceImpl {
    @Resource
    private RrXRoadDatabase rrXTeeDatabase;

    public RR84IsikuSeosedResponseDocument.RR84IsikuSeosedResponse findIsikuSeosedV1(String isikukood) throws XRoadServiceConsumptionException {
        RR84IsikuSeosedDocument.RR84IsikuSeosed paring = RR84IsikuSeosedDocument.RR84IsikuSeosed.Factory.newInstance();
        RR84IsikuSeosedRequestType requestType = RR84IsikuSeosedRequestType.Factory.newInstance();
        requestType.setIsikukood(isikukood);
        paring.setRequest(requestType);
        return rrXTeeDatabase.rr84IsikuSeosedV1(paring);
    }
}
