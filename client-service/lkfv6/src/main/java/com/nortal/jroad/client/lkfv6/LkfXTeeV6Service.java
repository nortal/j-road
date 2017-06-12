package com.nortal.jroad.client.lkfv6;

import java.util.Calendar;
import java.util.List;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.KindlustuskateResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.MntEteenusKlientResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.MntKandepeatamineKindlInfoResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.RomudeOtsingResponseDocument;


/**
 * <code>lkf</code> (Eesti Liikluskindlustuse Fond) database X-tee service.
 */
public interface LkfXTeeV6Service {

    /**
     * <code>lkf.mnt_eteenus_klient.v1</code> service.
     */
    List<MntEteenusKlientResponseDocument.MntEteenusKlientResponse.Keha.VehicleCovers.VehicleCover> mntEteenusKlientV1(String vehicleAuthUserList, String vehicleOwnerList, String vehicleIdCodeList, String vehicleRegnoList, String vehicleTempRemovedList, Calendar vehicleTempRemovedDateList) throws XRoadServiceConsumptionException;
    
    /**
     * <code>lkf.mnt_kandepeatamine_kindl_info.v1</code> service.
     */
    List<MntKandepeatamineKindlInfoResponseDocument.MntKandepeatamineKindlInfoResponse.Keha.Vehicles.Vehicle> mntKandepeatamineKindlInfoV1(String inspectionObligation, Calendar startDate, Calendar endDate) throws XRoadServiceConsumptionException;
    
    /**
     * <code>lkf.kindlustuskate.v3</code> service.
     */
    KindlustuskateResponseDocument.KindlustuskateResponse.Keha findKindlustuskateV3(String registrinumber, String tehasetahis) throws XRoadServiceConsumptionException;
    

    /**
     * <code>lkf.romude_otsing.v1</code> service.
     */
    List<RomudeOtsingResponseDocument.RomudeOtsingResponse.Keha.ClaimBangers.Item> romudeOtsingV1(Calendar startDate, Calendar endDate) throws XRoadServiceConsumptionException;
    
}
