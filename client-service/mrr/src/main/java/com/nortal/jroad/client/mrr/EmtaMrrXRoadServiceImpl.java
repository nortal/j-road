package com.nortal.jroad.client.mrr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.mrr.database.MrrXRoadDatabase;
import com.nortal.jroad.client.mrr.types.eu.x_road.emta_v6.SkaMitteresidentDocument;
import com.nortal.jroad.client.mrr.types.eu.x_road.emta_v6.SkaMitteresidentResponseDocument;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
public class EmtaMrrXRoadServiceImpl implements EmtaMrrXRoadService {

    @Resource
    private MrrXRoadDatabase mrrXRoadDatabase;

    @PostConstruct
    public void init() {
        mrrXRoadDatabase.setDatabase("emta-v6");
    }

    @Override
    public SkaMitteresidentResponseDocument.SkaMitteresidentResponse skaMitteresident(String registreerimiskood)
        throws XTeeServiceConsumptionException {
        SkaMitteresidentDocument.SkaMitteresident input = SkaMitteresidentDocument.SkaMitteresident.Factory.newInstance();
        input.addNewRequest().setRegistreerimiskood(registreerimiskood);

        return mrrXRoadDatabase.skaMitteresidentV1(input);
    }

}
