package com.nortal.jroad.client.krv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.krv6.database.KrXRoadDatabase;
import com.nortal.jroad.client.krv6.types.eu.x_road.kr.KinnistuLihtandmedDocument;
import com.nortal.jroad.client.krv6.types.eu.x_road.kr.KinnistuLihtandmedResponseDocument;
import com.nortal.jroad.client.krv6.types.org.datacontract.schemas.x2004.x07.kinnistuService.KinnistuLihtandmedRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * Created by raunor
 * on 11.04.2017.
 */
@Service("krv6XTeeService")
public class Krv6XTeeServiceImpl implements Krv6XTeeService {
    @Resource
    private KrXRoadDatabase krv6XTeeDatabase;

    public KinnistuLihtandmedResponseDocument.KinnistuLihtandmedResponse findKinnistuLihtandmed(
            String eesnimi, String perenimiJuriidilinenimi, String isikukood, Calendar synniaeg,
            Integer pageNr, Integer pageMaxRows)
            throws XRoadServiceConsumptionException {
        KinnistuLihtandmedDocument.KinnistuLihtandmed lihtandmed = KinnistuLihtandmedDocument.KinnistuLihtandmed.Factory.newInstance();
        KinnistuLihtandmedRequest request = KinnistuLihtandmedRequest.Factory.newInstance();
        request.setEesnimi(eesnimi);
        request.setNimi(perenimiJuriidilinenimi);
        request.setKood(isikukood);
        request.setSynniaeg(synniaeg);
        request.setLehekyljeNr(pageNr);
        request.setKinnistuteArvLehel(pageMaxRows);
        lihtandmed.setRequest(request);
        KinnistuLihtandmedResponseDocument.KinnistuLihtandmedResponse
                paringuVastus = krv6XTeeDatabase.kinnistuLihtandmed(lihtandmed);

        return paringuVastus;
    }

    public KinnistuLihtandmedResponseDocument.KinnistuLihtandmedResponse findKinnistuLihtandmed(
            String eesnimi, String perenimiJuriidilinenimi, String isikukood, Calendar synniaeg,
            Integer pageNr, Integer pageMaxRows, String userIdCode)
            throws XRoadServiceConsumptionException {
        KinnistuLihtandmedDocument.KinnistuLihtandmed lihtandmed = KinnistuLihtandmedDocument.KinnistuLihtandmed.Factory.newInstance();
        KinnistuLihtandmedRequest request = KinnistuLihtandmedRequest.Factory.newInstance();
        request.setEesnimi(eesnimi);
        request.setNimi(perenimiJuriidilinenimi);
        request.setKood(isikukood);
        request.setSynniaeg(synniaeg);
        request.setLehekyljeNr(pageNr);
        request.setKinnistuteArvLehel(pageMaxRows);
        lihtandmed.setRequest(request);
        KinnistuLihtandmedResponseDocument.KinnistuLihtandmedResponse
                paringuVastus = krv6XTeeDatabase.kinnistuLihtandmed(lihtandmed, userIdCode);

        return paringuVastus;
    }

}
