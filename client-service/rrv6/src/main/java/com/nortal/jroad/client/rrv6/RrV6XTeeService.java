package com.nortal.jroad.client.rrv6;


import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR441ResponseDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR442ResponseDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR50SurnudIsikuteLeidmineDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR50SurnudIsikuteLeidmineResponseDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRARKJUHILUBADocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRARKJUHILUBAResponseDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRSIDEAADRESSSideDataDocument;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RRSIDEAADRESSSideDataResponseDocument;

public interface RrV6XTeeService {
    
    RR441ResponseDocument.RR441Response findRr441(String isikukood, String userId) throws XRoadServiceConsumptionException;

    RRSIDEAADRESSSideDataResponseDocument.RRSIDEAADRESSSideDataResponse sendRRSIDEAADRESSSideDataV1(RRSIDEAADRESSSideDataDocument.RRSIDEAADRESSSideData request, String userId) throws XRoadServiceConsumptionException;
    
    RRARKJUHILUBAResponseDocument.RRARKJUHILUBAResponse sendRRArkJuhilubaV1(RRARKJUHILUBADocument.RRARKJUHILUBA request, String userId) throws XRoadServiceConsumptionException;
    
    RR50SurnudIsikuteLeidmineResponseDocument.RR50SurnudIsikuteLeidmineResponse findRR50SurnudIsikuteLeidmine(RR50SurnudIsikuteLeidmineDocument.RR50SurnudIsikuteLeidmine request, String userId) throws XRoadServiceConsumptionException;

    RR442ResponseDocument.RR442Response findRr442(String isikukood, String eesnimi, String perenimi, String userId) throws XRoadServiceConsumptionException;
}
