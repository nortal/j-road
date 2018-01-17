package com.nortal.jroad.client.evkrv6;

import com.nortal.jroad.client.evkrv6.types.eu.x_road.evkr.IsikuAndmeteVastus;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

import java.util.Calendar;

/**
 * Created by raunor
 * on 11.04.2017.
 */
public interface Evkrv6XTeeService {
    /**
    * <code>evkr.isiku_andmed_n.v1</code> service.
    */
    public IsikuAndmeteVastus findIsikuAndmednv1(Calendar alguskuupaev, String kood) throws XRoadServiceConsumptionException;

    /**
     * <code>evkr.isiku_andmed_n.v1</code> service.
     */
    public IsikuAndmeteVastus findIsikuAndmednv1(Calendar alguskuupaev, String kood, String userIdCode) throws XRoadServiceConsumptionException;
}
