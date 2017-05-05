package com.nortal.jroad.client.mkrliides;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.mkrliides.database.MkrliidesXRoadDatabase;
import com.nortal.jroad.client.mkrliides.database.MkrliidesXRoadDatabaseImpl;
import com.nortal.jroad.client.mkrliides.types.eu.x_road.emta_v6.XteeFIEAKDocument;
import com.nortal.jroad.client.mkrliides.types.eu.x_road.emta_v6.XteeFIEAKResponseDocument;
import com.nortal.jroad.client.service.XroadDatabaseClient;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
public class EmtaMkrliidesXRoadServiceImpl implements EmtaMkrliidesXRoadService {

    @Resource
    private MkrliidesXRoadDatabase mkrliidesXRoadDatabase;

    @PostConstruct
    public void init() {
        mkrliidesXRoadDatabase.setDatabase("emta-v6");
    }

    @Override
    public XteeFIEAKResponseDocument.XteeFIEAKResponse xteeFIEAKV1(String id, Date start, Date end)
        throws XTeeServiceConsumptionException {
        XteeFIEAKDocument.XteeFIEAK input = XteeFIEAKDocument.XteeFIEAK.Factory.newInstance();
        input.addNewRequest();
        input.getRequest().setId(id);
        if (start != null) {
            Calendar calStart = Calendar.getInstance();
            calStart.setTime(start);
            input.getRequest().setStart(calStart);
        }
        if (end != null) {
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(end);
            input.getRequest().setEnd(calEnd);
        }

        return mkrliidesXRoadDatabase.xteeFIEAKV1(input);
    }
}
