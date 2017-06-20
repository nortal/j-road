package com.nortal.jroad.client.lkfv6;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.lkfv6.database.Lkfv6XRoadDatabase;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.KindlustuskateDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.KindlustuskateResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.MntEteenusKlientDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.MntEteenusKlientResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.MntKandepeatamineKindlInfoDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.MntKandepeatamineKindlInfoResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.RomudeOtsingDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.RomudeOtsingResponseDocument;


@ImportResource("classpath:client-lkfv6.xml")
@Service("lkfXTeeV6ServiceImpl")
public class LkfXTeeV6ServiceImpl implements LkfXTeeV6Service {

    @Resource(name = "lkfv6XRoadDatabase")
    private Lkfv6XRoadDatabase lkfv6XRoadDatabase;

    @Override
    public List<MntEteenusKlientResponseDocument.MntEteenusKlientResponse.Keha.VehicleCovers.VehicleCover> mntEteenusKlientV1(String vehicleAuthUserList, String vehicleOwnerList, String vehicleIdCodeList, String vehicleRegnoList, String vehicleTempRemovedList, Calendar vehicleTempRemovedDateList) throws XRoadServiceConsumptionException {

        MntEteenusKlientDocument.MntEteenusKlient paring = MntEteenusKlientDocument.MntEteenusKlient.Factory.newInstance();
        
        if(vehicleAuthUserList != null) {
            paring.setVehicleAuthUserList(vehicleAuthUserList);
        }
        if(vehicleOwnerList != null) {
            paring.setVehicleOwnerList(vehicleOwnerList);
        }
        if(vehicleIdCodeList != null) {
            paring.setVehicleIdCodeList(vehicleIdCodeList);
        }
        if(vehicleRegnoList != null) {
            paring.setVehicleRegnoList(vehicleRegnoList);
        }
        if(vehicleTempRemovedList != null) {
            paring.setVehicleTempRemovedList(vehicleTempRemovedList);
        }
        if(vehicleTempRemovedDateList != null) {
            paring.setVehicleTempRemovedDateList(Parser.parseDateTime(vehicleTempRemovedDateList));
        }
        
        return lkfv6XRoadDatabase.mntEteenusKlientV1(paring).getKeha().getVehicleCovers().getVehicleCoverList();
    }

    @Override
    public List<MntKandepeatamineKindlInfoResponseDocument.MntKandepeatamineKindlInfoResponse.Keha.Vehicles.Vehicle> mntKandepeatamineKindlInfoV1(String inspectionObligation, Calendar startDate, Calendar endDate) throws XRoadServiceConsumptionException {

        MntKandepeatamineKindlInfoDocument.MntKandepeatamineKindlInfo paring = MntKandepeatamineKindlInfoDocument.MntKandepeatamineKindlInfo.Factory.newInstance();
        
        if(inspectionObligation != null) {
            paring.setInspectionObligation(inspectionObligation);
        }
        if(startDate != null) {
            paring.setPeriodStart(Parser.parseDateTimeWithouthSeconds(startDate));
        }
        if(endDate != null) {
            paring.setPeriodEnd(Parser.parseDateTimeWithouthSeconds(endDate));
        }
        
        return lkfv6XRoadDatabase.mntKandepeatamineKindlInfoV1(paring).getKeha().getVehicles().getVehicleList();
    }

    @Override
    public KindlustuskateResponseDocument.KindlustuskateResponse.Keha findKindlustuskateV3(String registrinumber, String tehasetahis) throws XRoadServiceConsumptionException {

        KindlustuskateDocument.Kindlustuskate paring = KindlustuskateDocument.Kindlustuskate.Factory.newInstance();
        if(registrinumber != null) {
            paring.setRegistreerimismark(registrinumber);
        }
        if(tehasetahis != null) {
            paring.setTehasetahis(tehasetahis);
        }
        return lkfv6XRoadDatabase.kindlustuskateV3(paring).getKeha();
    }

    @Override
    public List<RomudeOtsingResponseDocument.RomudeOtsingResponse.Keha.ClaimBangers.Item> romudeOtsingV1(Calendar startDate, Calendar endDate) throws XRoadServiceConsumptionException {
        RomudeOtsingDocument.RomudeOtsing paring = RomudeOtsingDocument.RomudeOtsing.Factory.newInstance();
        
        paring.setStartDate(Parser.parseDateTime(startDate));
        paring.setEndDate(Parser.parseDateTime(endDate));
        return lkfv6XRoadDatabase.romudeOtsingV1(paring).getKeha().getClaimBangers().getItemList();
    }
}
