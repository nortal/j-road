package com.nortal.jroad.client.lrv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.lrv6.database.LiiklusregisterXRoadDatabase;
import com.nortal.jroad.client.lrv6.types.eu.x_road.liiklusregister.Paring2Paring;
import com.nortal.jroad.client.lrv6.types.eu.x_road.liiklusregister.Paring2Vastus;
import com.nortal.jroad.client.lrv6.types.eu.x_road.liiklusregister.VlaevRequest;
import com.nortal.jroad.client.lrv6.types.eu.x_road.liiklusregister.VlaevResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by raunor
 * on 18.04.2017.
 */
@Service("lrv6XTeeService")
public class Lrv6XTeeServiceImpl implements Lrv6XTeeService{
    @Resource
    private LiiklusregisterXRoadDatabase liiklusregisterXTeeDatabase;

    public VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi) throws XRoadServiceConsumptionException {
        VlaevRequest paring = VlaevRequest.Factory.newInstance();
        if (regNr != null)
            paring.setLaevaRegnr(regNr);
        if (hinKood != null)
            paring.setHinKood(hinKood);
        if (omaKood != null || omaNimi != null || omaEesnimi != null) {
            VlaevRequest.OmaAndmed oma = paring.addNewOmaAndmed();
            if (omaKood != null)
                oma.setOmaKood(omaKood);
            if (omaNimi != null)
                oma.setOmaNimi(omaNimi);
            if (omaEesnimi != null)
                oma.setOmaEesnimi(omaEesnimi);
        }

        return liiklusregisterXTeeDatabase.vlaevV1(paring);
    }

    public VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi, String userIdCode) throws XRoadServiceConsumptionException {
        VlaevRequest paring = VlaevRequest.Factory.newInstance();
        if (regNr != null)
            paring.setLaevaRegnr(regNr);
        if (hinKood != null)
            paring.setHinKood(hinKood);
        if (omaKood != null || omaNimi != null || omaEesnimi != null) {
            VlaevRequest.OmaAndmed oma = paring.addNewOmaAndmed();
            if (omaKood != null)
                oma.setOmaKood(omaKood);
            if (omaNimi != null)
                oma.setOmaNimi(omaNimi);
            if (omaEesnimi != null)
                oma.setOmaEesnimi(omaEesnimi);
        }

        return liiklusregisterXTeeDatabase.vlaevV1(paring, userIdCode);
    }

    public Paring2Vastus findSoidukiAndmedParing2(String isikukood) throws XRoadServiceConsumptionException {

        Paring2Paring paring = Paring2Paring.Factory.newInstance();
        if(isikukood != null)
        {
            Paring2Paring.OmaAndmed omaAndmed = Paring2Paring.OmaAndmed.Factory.newInstance();
            omaAndmed.setOmaKood(isikukood);
            paring.setOmaAndmed(omaAndmed);
        }
        return liiklusregisterXTeeDatabase.paring2V2(paring);
    }

    public Paring2Vastus findSoidukiAndmedParing2(String isikukood, String userIdCode) throws XRoadServiceConsumptionException {

        Paring2Paring paring = Paring2Paring.Factory.newInstance();
        if(isikukood != null)
        {
            Paring2Paring.OmaAndmed omaAndmed = Paring2Paring.OmaAndmed.Factory.newInstance();
            omaAndmed.setOmaKood(isikukood);
            paring.setOmaAndmed(omaAndmed);
        }
        return liiklusregisterXTeeDatabase.paring2V2(paring, userIdCode);
    }

}
