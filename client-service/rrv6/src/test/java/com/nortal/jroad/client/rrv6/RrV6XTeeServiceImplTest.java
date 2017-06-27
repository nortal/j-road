package com.nortal.jroad.client.rrv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.Kodif1;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.Kodif2;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR441ResponseDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR442ResponseDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR50SurnudIsikuteLeidmineDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR50SurnudIsikuteLeidmineRequestType;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR50SurnudIsikuteLeidmineResponseDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRARKJUHILUBADocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRARKJUHILUBARequestType;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRARKJUHILUBAResponseDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRExtDocumentDataRequest;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRExtSideData1Request;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRSIDEAADRESSSideDataDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRSIDEAADRESSSideDataRequestType;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRSIDEAADRESSSideDataResponseDocument;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Calendar;

public class RrV6XTeeServiceImplTest extends BaseXRoadServiceImplTest {

    @Resource
    private RrV6XTeeServiceImpl rrXTeeService;

    @Test
    public void findRr441Test() throws XRoadServiceConsumptionException {

        RR441ResponseDocument.RR441Response response = rrXTeeService.findRr441("47101010033", "EE12345678");

        Assert.assertNull(response.getResponse().getFaultCode());
    }

    @Test
    public void findRr442Test() throws XRoadServiceConsumptionException {

        RR442ResponseDocument.RR442Response response = rrXTeeService.findRr442("37709200040", "JOOSEP", "ÖÖVIIUL","EE12345678");
        
        Assert.assertNull(response.getResponse().getFaultCode());
        Assert.assertTrue(response.getResponse().getIsikuAadressid().sizeOfIsikuAadressArray() > 0);
    }
    
    @Test
    public void sendRRSIDEAADRESSSideDataV1Test() throws XRoadServiceConsumptionException {

        RRExtSideData1Request rrExtSideData1Request = RRExtSideData1Request.Factory.newInstance();

        RRExtSideData1Request.Isikud isikud = RRExtSideData1Request.Isikud.Factory.newInstance();
        RRExtSideData1Request.Isikud.Isik isik = isikud.addNewIsik();
        isik.setEesnimi("MARI-LIIS");
        isik.setPerenimi("MÄNNIK");
        isik.setIsikukood("47101010033");
        
        rrExtSideData1Request.setIsikud(isikud);

        RRExtSideData1Request.Dokument dokument = RRExtSideData1Request.Dokument.Factory.newInstance();
        dokument.setDokumendiNumber("YY000199911");
        dokument.setAmetnikuIsikukood("47101010033");
        dokument.setAmetnikuNimed("MARI-LIIS MÄNNIK");

        RRExtSideData1Request.Dokument.KoostanudAsutus koostanudAsutus = RRExtSideData1Request.Dokument.KoostanudAsutus.Factory.newInstance();
        
        koostanudAsutus.setAsutuseNimi("MAANTEEAMET");
        koostanudAsutus.setRegistrikood("70001490");

        Kodif1 kodif1AsutusRiik = Kodif1.Factory.newInstance();
        kodif1AsutusRiik.setKood("EST");
        koostanudAsutus.setRiik(kodif1AsutusRiik);
        
        dokument.setKoostanudAsutus(koostanudAsutus);

        Kodif1 kodif1Liik = Kodif1.Factory.newInstance();
        kodif1Liik.setNimi("Muu asutuse sideandmete teade");
        kodif1Liik.setKood("E90");
        dokument.setLiik(kodif1Liik);
        rrExtSideData1Request.setDokument(dokument);

        RRExtSideData1Request.Sideandmed sideandmed = RRExtSideData1Request.Sideandmed.Factory.newInstance();
        RRExtSideData1Request.Sideandmed.Kontakt kontakt = sideandmed.addNewKontakt();
        kontakt.setRiigiKood("233");
        kontakt.setKontaktiTekst("56666667");
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 2, 1);
        kontakt.setAlatesKP(cal);

        Kodif1 kodif1 = Kodif1.Factory.newInstance();
        kodif1.setKood("K7");
        kodif1.setNimi("TELEFON");
        kontakt.setLiik(kodif1);
        rrExtSideData1Request.setSideandmed(sideandmed);
        rrExtSideData1Request.setTegevus(RRExtSideData1Request.Tegevus.V);

        RRSIDEAADRESSSideDataRequestType rrsideaadressSideDataRequestType = RRSIDEAADRESSSideDataRequestType.Factory.newInstance();
        rrsideaadressSideDataRequestType.setRRSIDEAADRESSSideData(rrExtSideData1Request);

        RRSIDEAADRESSSideDataDocument.RRSIDEAADRESSSideData request = RRSIDEAADRESSSideDataDocument.RRSIDEAADRESSSideData.Factory.newInstance();
        request.setRequest(rrsideaadressSideDataRequestType);

        RRSIDEAADRESSSideDataResponseDocument.RRSIDEAADRESSSideDataResponse response = rrXTeeService.sendRRSIDEAADRESSSideDataV1(request, "EE12345678");
        
        Assert.assertTrue(response.getResponse().getIsikud().getIsikList().isEmpty());
    }

    @Test
    public void sendRRARKJUHILUBATest() throws XRoadServiceConsumptionException {

        RRExtDocumentDataRequest requestData = RRExtDocumentDataRequest.Factory.newInstance();
        requestData.setTegevus(RRExtDocumentDataRequest.Tegevus.V);

        RRExtDocumentDataRequest.Dokument document = RRExtDocumentDataRequest.Dokument.Factory.newInstance();

        Kodif2 kodif2 = Kodif2.Factory.newInstance();
        kodif2.setKood("D48");
        kodif2.setNimi("juhiluba");
        document.setLiik(kodif2);
        document.setDokumendiNumber("ET727382");
        Calendar cal = Calendar.getInstance();
        cal.set(2017, 1, 1);
        document.setValjaandmiseKP(cal);
        document.setJoustumiseKP(cal);

        RRExtDocumentDataRequest.Dokument.KoostanudAsutus koostanudAsutus = RRExtDocumentDataRequest.Dokument.KoostanudAsutus.Factory.newInstance();
        koostanudAsutus.setAsutuseRegNumber("70001490");
        koostanudAsutus.setAsutuseNimi("Maanteeamet");
        Kodif2 kodif2Riik = Kodif2.Factory.newInstance();
        kodif2Riik.setKood("EST");
        koostanudAsutus.setRiik(kodif2Riik);
        document.setKoostanudAsutus(koostanudAsutus);
        document.setAmetnikuIsikukood("35802028876");
        document.setAmetnikuNimed("JANIC LLIIMA");
        requestData.setDokument(document);

        RRExtDocumentDataRequest.Isikud isikud = RRExtDocumentDataRequest.Isikud.Factory.newInstance();
        RRExtDocumentDataRequest.Isikud.Isik isik = isikud.addNewIsik();
        isik.setEesnimi("Juta");
        isik.setEesnimiRR("Juta");
        isik.setPerenimi("Maantee");
        isik.setPerenimiRR("Maantee");
        isik.setIsikukood("48305090291");
        requestData.setIsikud(isikud);

        RRARKJUHILUBARequestType rrarkjuhilubaRequestType = RRARKJUHILUBARequestType.Factory.newInstance();
        rrarkjuhilubaRequestType.setRRARKJUHILUBA(requestData);

        RRARKJUHILUBADocument.RRARKJUHILUBA request = RRARKJUHILUBADocument.RRARKJUHILUBA.Factory.newInstance();
        request.setRequest(rrarkjuhilubaRequestType);

        RRARKJUHILUBAResponseDocument.RRARKJUHILUBAResponse response = rrXTeeService.sendRRArkJuhilubaV1(request, "EE12345678");

        System.out.println("response: " + response.getResponse());
        System.out.println("isikud: " + response.getResponse().getIsikud());
        
        Assert.assertTrue(response.getResponse().getIsikud().getIsikList().isEmpty());
    }

    @Test
    public void findRR50SurnudIsikuteLeidmineTest() throws XRoadServiceConsumptionException {

        RR50SurnudIsikuteLeidmineRequestType rr50SurnudIsikuteLeidmineRequestType = RR50SurnudIsikuteLeidmineRequestType.Factory.newInstance();
        Calendar cal = Calendar.getInstance();
        cal.set(2016, 8, 29);
        rr50SurnudIsikuteLeidmineRequestType.setKuupaev(cal);

        RR50SurnudIsikuteLeidmineDocument.RR50SurnudIsikuteLeidmine request = RR50SurnudIsikuteLeidmineDocument.RR50SurnudIsikuteLeidmine.Factory.newInstance();
        request.setRequest(rr50SurnudIsikuteLeidmineRequestType);

        RR50SurnudIsikuteLeidmineResponseDocument.RR50SurnudIsikuteLeidmineResponse response = rrXTeeService.findRR50SurnudIsikuteLeidmine(request, "EE12345678");

        Assert.assertNull(response.getResponse().getFaultCode());
        Assert.assertEquals("33002020011", response.getResponse().getSurnu().getItemList().get(0).getSurnuIsikukood());
    }
}