package com.nortal.jroad.client.lrv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.lrv6.types.eu.x_road.liiklusregister.Paring2Vastus;
import com.nortal.jroad.client.lrv6.types.eu.x_road.liiklusregister.VlaevResponse;

/**
 * Created by raunor
 * on 18.04.2017.
 */
public interface Lrv6XTeeService {

    /**
     * <code>liiklusregister.vlaev.v1</code>
     */
    VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi) throws XRoadServiceConsumptionException;

    /**
     * <code>liiklusregister.vlaev.v1</code>
     */
    VlaevResponse findVLaevAndmed(String regNr, String hinKood, String omaKood, String omaNimi, String omaEesnimi, String userIdCode) throws XRoadServiceConsumptionException;


    /**
     * <code>liiklusregister.soidukiandmed2.v1</code> X-tee service.
     * @return Soidukiandmed2Vastus
     */
    public Paring2Vastus findSoidukiAndmedParing2(String isikukood) throws XRoadServiceConsumptionException;

    /**
     * <code>liiklusregister.soidukiandmed2.v1</code> X-tee service.
     * @return Soidukiandmed2Vastus
     */
    public Paring2Vastus findSoidukiAndmedParing2(String isikukood, String userIdCode) throws XRoadServiceConsumptionException;
}
