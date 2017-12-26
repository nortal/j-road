package com.nortal.jroad.client.rrv6;


import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.*;

import java.util.List;

public interface RrV6XTeeService {
    
    RR441ResponseDocument.RR441Response findRr441(String isikukood, String userId) throws XRoadServiceConsumptionException;

    RRSIDEAADRESSSideDataResponseDocument.RRSIDEAADRESSSideDataResponse sendRRSIDEAADRESSSideDataV1(RRSIDEAADRESSSideDataDocument.RRSIDEAADRESSSideData request, String userId) throws XRoadServiceConsumptionException;
    
    RRARKJUHILUBAResponseDocument.RRARKJUHILUBAResponse sendRRArkJuhilubaV1(RRARKJUHILUBADocument.RRARKJUHILUBA request, String userId) throws XRoadServiceConsumptionException;
    
    RR50SurnudIsikuteLeidmineResponseDocument.RR50SurnudIsikuteLeidmineResponse findRR50SurnudIsikuteLeidmine(RR50SurnudIsikuteLeidmineDocument.RR50SurnudIsikuteLeidmine request, String userId) throws XRoadServiceConsumptionException;

    RR442ResponseDocument.RR442Response findRr442(String isikukood, String eesnimi, String perenimi, String userId) throws XRoadServiceConsumptionException;

    /**
     * <code>rr.RR84IsikuSeosed.v1</code>
     */
    RR84IsikuSeosedResponseDocument.RR84IsikuSeosedResponse findIsikuSeosedV1(String isikukood) throws XRoadServiceConsumptionException;

    RR84IsikuSeosedResponseDocument.RR84IsikuSeosedResponse findIsikuSeosedV1(String isikukood, String userIdCode) throws XRoadServiceConsumptionException;

    List<RR72IsikResponseType.TtIsik.TtIsikud> findRR72Isik(String... idCodes) throws XRoadServiceConsumptionException;

    List<RR67MuutusResponseType.TtKood.TtKoodid> findRR67MuutusV1(java.util.Date algus, java.util.Date lopp,
                                                                  String... koodid) throws XRoadServiceConsumptionException;

}
