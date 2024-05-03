package com.nortal.jroad.client.evkrv6;

import com.nortal.jroad.client.evkrv6.database.EvkrXRoadDatabase;
import com.nortal.jroad.client.evkrv6.types.eu.x_road.evkr.IsikuAndmedNDocument;
import com.nortal.jroad.client.evkrv6.types.eu.x_road.evkr.IsikuAndmedNResponseDocument;
import com.nortal.jroad.client.evkrv6.types.eu.x_road.evkr.IsikuAndmeteParing;
import com.nortal.jroad.client.evkrv6.types.eu.x_road.evkr.IsikuAndmeteVastus;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * Created by raunor
 * on 11.04.2017.
 */
@Service("evkrv6XTeeService")
public class Evkrv6XTeeServiceImpl implements Evkrv6XTeeService{
    @Resource
    private EvkrXRoadDatabase evkrXTeeDatabase;

    public IsikuAndmeteVastus findIsikuAndmednv1(Calendar alguskuupaev, String kood) throws XRoadServiceConsumptionException {
        IsikuAndmedNDocument.IsikuAndmedN andmedN = IsikuAndmedNDocument.IsikuAndmedN.Factory.newInstance();
        IsikuAndmeteParing paring = IsikuAndmeteParing.Factory.newInstance();
        paring.setAlguskuupaev(alguskuupaev);
        IsikuAndmeteParing.Tapne tapne = IsikuAndmeteParing.Tapne.Factory.newInstance();
        String[] koodArray = {kood};
        tapne.setKoodArray(koodArray);
        paring.setTapne(tapne);
        andmedN.setRequest(paring);

        IsikuAndmedNResponseDocument.IsikuAndmedNResponse paringuVastus = evkrXTeeDatabase.isikuAndmedNV1(andmedN);

        return paringuVastus.getResponse();
    }

    public IsikuAndmeteVastus findIsikuAndmednv1(Calendar alguskuupaev, String kood, String userIdCode) throws XRoadServiceConsumptionException {
        IsikuAndmedNDocument.IsikuAndmedN andmedN = IsikuAndmedNDocument.IsikuAndmedN.Factory.newInstance();
        IsikuAndmeteParing paring = IsikuAndmeteParing.Factory.newInstance();
        paring.setAlguskuupaev(alguskuupaev);
        IsikuAndmeteParing.Tapne tapne = IsikuAndmeteParing.Tapne.Factory.newInstance();
        String[] koodArray = {kood};
        tapne.setKoodArray(koodArray);
        paring.setTapne(tapne);
        andmedN.setRequest(paring);

        IsikuAndmedNResponseDocument.IsikuAndmedNResponse paringuVastus = evkrXTeeDatabase.isikuAndmedNV1(andmedN, userIdCode);

        return paringuVastus.getResponse();
    }
}
