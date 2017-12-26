package com.nortal.jroad.client.rrv6;


import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.*;
import com.nortal.jroad.client.util.XmlBeansUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Service("Rrv6XTeeServiceImpl")
public class RrV6XTeeServiceImpl implements RrV6XTeeService {

    @Autowired
    private com.nortal.jroad.client.rrv6.database.RrXRoadDatabase rrXRoadDatabase;
    
    @Override
    public com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR441ResponseDocument.RR441Response findRr441(String isikukood, String userId) throws XRoadServiceConsumptionException {

        if (isikukood == null) {
            throw new IllegalArgumentException("Parameter 'isikukood' must not be null!");
        }

        RR441RequestType rr441RequestType = RR441RequestType.Factory.newInstance();
        rr441RequestType.setCIsikukoodid(isikukood);

        RR441Document.RR441 paring = RR441Document.RR441.Factory.newInstance();
        paring.setRequest(rr441RequestType);

        return rrXRoadDatabase.rr441V1(paring, userId);
    }
    
    
    @Override
    public RRSIDEAADRESSSideDataResponseDocument.RRSIDEAADRESSSideDataResponse sendRRSIDEAADRESSSideDataV1(RRSIDEAADRESSSideDataDocument.RRSIDEAADRESSSideData request, String userId) throws XRoadServiceConsumptionException {
        return rrXRoadDatabase.rrsideaadressSideDataV1(request, userId);
    }
    
    @Override
    public RRARKJUHILUBAResponseDocument.RRARKJUHILUBAResponse sendRRArkJuhilubaV1(RRARKJUHILUBADocument.RRARKJUHILUBA request, String userId) throws XRoadServiceConsumptionException {
        return rrXRoadDatabase.rrarkjuhilubaV1(request, userId);
    }
    
    @Override
    public RR50SurnudIsikuteLeidmineResponseDocument.RR50SurnudIsikuteLeidmineResponse findRR50SurnudIsikuteLeidmine(RR50SurnudIsikuteLeidmineDocument.RR50SurnudIsikuteLeidmine request, String userId) throws XRoadServiceConsumptionException {
        return rrXRoadDatabase.rr50SurnudIsikuteLeidmineV1(request, userId);
    }

    @Override
    public RR442ResponseDocument.RR442Response findRr442(String isikukood, String eesnimi, String perenimi, String userId) throws XRoadServiceConsumptionException {

        RR442RequestType rr442RequestType = RR442RequestType.Factory.newInstance();
        rr442RequestType.setEesnimi(eesnimi);
        rr442RequestType.setPerenimi(perenimi);
        rr442RequestType.setIsikukood(isikukood);

        RR442Document.RR442 paring = RR442Document.RR442.Factory.newInstance();
        paring.setRequest(rr442RequestType);
        return rrXRoadDatabase.rr442V3(paring, userId);
    }

    public RR84IsikuSeosedResponseDocument.RR84IsikuSeosedResponse findIsikuSeosedV1(String isikukood) throws XRoadServiceConsumptionException {
        RR84IsikuSeosedDocument.RR84IsikuSeosed paring = RR84IsikuSeosedDocument.RR84IsikuSeosed.Factory.newInstance();
        RR84IsikuSeosedRequestType requestType = RR84IsikuSeosedRequestType.Factory.newInstance();
        requestType.setIsikukood(isikukood);
        paring.setRequest(requestType);
        return rrXRoadDatabase.rr84IsikuSeosedV1(paring);
    }

    public RR84IsikuSeosedResponseDocument.RR84IsikuSeosedResponse findIsikuSeosedV1(String isikukood, String userIdCode) throws XRoadServiceConsumptionException {
        RR84IsikuSeosedDocument.RR84IsikuSeosed paring = RR84IsikuSeosedDocument.RR84IsikuSeosed.Factory.newInstance();
        RR84IsikuSeosedRequestType requestType = RR84IsikuSeosedRequestType.Factory.newInstance();
        requestType.setIsikukood(isikukood);
        paring.setRequest(requestType);
        return rrXRoadDatabase.rr84IsikuSeosedV1(paring, userIdCode);
    }

    @Override
    public List<RR72IsikResponseType.TtIsik.TtIsikud> findRR72Isik(String... idCodes) throws XRoadServiceConsumptionException {
        RR72IsikDocument.RR72Isik rr72Isik = RR72IsikDocument.RR72Isik.Factory.newInstance();
        RR72IsikRequestType rr72IsikRequestType = RR72IsikRequestType.Factory.newInstance();
        String isikukoodid = StringUtils.join(idCodes, ",");
        XmlString isikukoodidElement = XmlBeansUtil
            .getAttributedXmlString(isikukoodid);
        rr72IsikRequestType.xsetCIsikukoodid(isikukoodidElement);
        rr72Isik.setRequest(rr72IsikRequestType);

        RR72IsikResponseType.TtIsik ttIsik = rrXRoadDatabase.rr72IsikV1(rr72Isik).getResponse().getTtIsik();
        return ttIsik != null ? ttIsik.getTtIsikudList() : new ArrayList<RR72IsikResponseType.TtIsik.TtIsikud>(0);
    }

    public List<RR67MuutusResponseType.TtKood.TtKoodid> findRR67MuutusV1(java.util.Date algus, java.util.Date lopp,
                                                                         String... koodid) throws XRoadServiceConsumptionException {
        RR67MuutusDocument.RR67Muutus rr67Muutus = RR67MuutusDocument.RR67Muutus.Factory.newInstance();
        RR67MuutusRequestType rr67MuutusRequestType = RR67MuutusRequestType.Factory.newInstance();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        if (koodid != null) {
            String codes = StringUtils.join(koodid);
            rr67MuutusRequestType.setCMuutused(codes);
        }
        if (algus != null) {
            rr67MuutusRequestType.setCAlgKpv(dateFormat.format(algus));
            rr67MuutusRequestType.setCAlgKell(timeFormat.format(algus));
        }
        if (lopp != null) {
            rr67MuutusRequestType.setCLoppKpv(dateFormat.format(lopp));
            rr67MuutusRequestType.setCLoppKell(timeFormat.format(lopp));
        }

        rr67Muutus.setRequest(rr67MuutusRequestType);
        RR67MuutusResponseType.TtKood ttKood = rrXRoadDatabase.rr67MuutusV1(rr67Muutus).getResponse().getTtKood();
        return ttKood != null ? ttKood.getTtKoodidList() : new ArrayList<RR67MuutusResponseType.TtKood.TtKoodid>();
    }

}
