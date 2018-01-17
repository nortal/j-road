package com.nortal.jroad.client.lkfv6;

import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.KindlustuskateResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.MntEteenusKlientResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.MntKandepeatamineKindlInfoResponseDocument;
import com.nortal.jroad.client.lkfv6.types.ee.riik.xrd.lkf.producers.producer.lkf.RomudeOtsingResponseDocument;

@ContextConfiguration(locations = { "classpath:client-test-lkfv6.xml" })
public class LkfXTeeV6ServiceImplTest extends AbstractJUnit4SpringContextTests {

    @Resource
    private LkfXTeeV6Service lkfXTeeV6Service;

    private static final Calendar START = Calendar.getInstance();
    private static final Calendar END = Calendar.getInstance();

    static {
        START.set(2016, 9, 17, 0, 0);
        END.set(2016, 10, 1, 23, 59);
    }

    @Test
    public void mntEteenusKlientV1Test() throws XRoadServiceConsumptionException {

        List<MntEteenusKlientResponseDocument.MntEteenusKlientResponse.Keha.VehicleCovers.VehicleCover> response = lkfXTeeV6Service.mntEteenusKlientV1(null, "37101010021", "A9151023004", "86ZBF", "false", null);
        Assert.assertTrue(response.get(0).xgetShortMessage().getStringValue().contains("SHORT"));
    }

    @Test
    public void mntKandepeatamineKindlInfoV1Test() throws XRoadServiceConsumptionException {
        List<MntKandepeatamineKindlInfoResponseDocument.MntKandepeatamineKindlInfoResponse.Keha.Vehicles.Vehicle> response = lkfXTeeV6Service.mntKandepeatamineKindlInfoV1(null, START, END);
        Assert.assertEquals("YG31250XIWL004387", response.get(0).getVehicleVin());
        Assert.assertEquals("", response.get(0).getCoverEnd());
    }
    
    @Test
    public void kindlustusKateV3Test() throws XRoadServiceConsumptionException {
        KindlustuskateResponseDocument.KindlustuskateResponse.Keha response = lkfXTeeV6Service.findKindlustuskateV3("111AAA", null);
        Assert.assertEquals(response.getMark(), "BENTLEY");
        Assert.assertEquals(response.getPolNr(), "3K1101001313460");
    }
    
    @Test
    public void romudeOtsingV1Test() throws XRoadServiceConsumptionException {
        List<RomudeOtsingResponseDocument.RomudeOtsingResponse.Keha.ClaimBangers.Item> response = lkfXTeeV6Service.romudeOtsingV1(START, END);
        RomudeOtsingResponseDocument.RomudeOtsingResponse.Keha.ClaimBangers.Item.Vehicle vehicle = response.get(0).getVehicle();
        Assert.assertEquals("441BMZ", vehicle.getVehicleRegNo());
        Assert.assertEquals("WDD2452071J032007", vehicle.getVehicleVin());
    }
}
