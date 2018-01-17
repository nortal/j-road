package com.nortal.jroad.client.rrv6;


import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}
