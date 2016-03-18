package com.nortal.jroad.client.kir;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kir.database.KirXRoadDatabase;
import com.nortal.jroad.client.kir.types.ee.x_road.kir.producer.*;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * @author Marti Laast
 */
@Service("kirXTeeService")
public class KirXTeeServiceImpl extends XRoadDatabaseService implements KirXTeeService {

    @Resource
    private KirXRoadDatabase kirXRoadDatabase;

    public AnnaArvelolekuAndmedResponse annaArvelolekuAndmedV1(Date start, Date end, Set<IsikuStaatus.Enum> requestTypes, Set<String> idCodes) throws XTeeServiceConsumptionException {
        AnnaArvelolekuAndmedRequest requestWrapper = AnnaArvelolekuAndmedRequest.Factory.newInstance();
        AnnaArvelolekuAndmedRequest.Request request = requestWrapper.addNewRequest();

        request.setPerioodiAlgusKP(toCalendar(start));
        request.setPerioodiLoppKP(toCalendar(end));
        AnnaArvelolekuAndmedRequest.Request.Paring p = request.addNewParing();
        p.setParinguLiikArray(requestTypes.toArray(new IsikuStaatus.Enum[requestTypes.size()]));
        p.setIsikukoodArray(idCodes.toArray(new String[idCodes.size()]));

        return kirXRoadDatabase.annaArvelolekuAndmedV1(requestWrapper);
    }

    public LeiaMuudetudAndmetegaKinnipeetavadResponse leiaMuudetudAndmetegaKinnipeetavadV1(Date start, Date end) throws XTeeServiceConsumptionException {
        LeiaMuudetudAndmetegaKinnipeetavadRequest requestWrapper = LeiaMuudetudAndmetegaKinnipeetavadRequest.Factory.newInstance();
        LeiaMuudetudAndmetegaKinnipeetavadRequest.Request request = requestWrapper.addNewRequest();

        request.setPerioodiAlgusKP(toCalendar(start));
        request.setPerioodiLoppKP(toCalendar(end));

        return kirXRoadDatabase.leiaMuudetudAndmetegaKinnipeetavadV1(requestWrapper);
    }

    private Calendar toCalendar(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

}