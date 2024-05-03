package com.nortal.jroad.client.mkrliides;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.mkrliides.database.MkrliidesXRoadDatabase;
import com.nortal.jroad.client.mkrliides.types.eu.x_road.emta_v6.*;

import java.util.Calendar;
import java.util.Date;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

/**
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
public class EmtaMkrliidesXRoadServiceImpl implements EmtaMkrliidesXRoadService {

    @Resource
    private MkrliidesXRoadDatabase mkrliidesXRoadDatabase;

//    @PostConstruct
//    public void init() {
//        mkrliidesXRoadDatabase.setDatabase("emta-v6");
//    }
//
    @Override
    public XteeFIEAKResponseDocument.XteeFIEAKResponse xteeFIEAKV1(String id, Date start, Date end)
        throws XRoadServiceConsumptionException {
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

    @Override
    public VptResponseDocument.VptResponse vptV1(String id, Date date) throws XRoadServiceConsumptionException {
        VptDocument.Vpt input = VptDocument.Vpt.Factory.newInstance();

        VptRequestType request = input.addNewKeha();
        request.setKood(id);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        request.setMillal(calendar);

        return mkrliidesXRoadDatabase.vptV1(input);
    }
}
