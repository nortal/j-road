package com.nortal.jroad.client.rar;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rar.database.RmV6XRoadDatabase;
import com.nortal.jroad.client.rar.types.eu.x_road.rm_v6.KoodType;
import com.nortal.jroad.client.rar.types.eu.x_road.rm_v6.RarVtaResponseType;
import com.nortal.jroad.client.rar.types.eu.x_road.rm_v6.RarVtaType;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
@Service("rarXRoadService")
public class RarXRoadServiceImpl implements RarXRoadService {

    @Resource
    private RmV6XRoadDatabase rmV6XRoadDatabase;

    @Override
    public RarVtaResponseType rarVtaV1(String kood) throws XTeeServiceConsumptionException {
        RarVtaType input = RarVtaType.Factory.newInstance();
        input.addNewKeha();
        KoodType koodType = KoodType.Factory.newInstance();
        koodType.setStringValue(kood);
        input.getKeha().xsetKood(koodType);
        return rmV6XRoadDatabase.rarVtaV1(input);
    }
}
