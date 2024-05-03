package com.nortal.jroad.client.kir;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.AnnaArvelolekuAndmedResponseDocument.AnnaArvelolekuAndmedResponse;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.ArvelolekuSisendTaiendavOlek;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.LeiaMuudetudAndmetegaKinnipeetavadResponseDocument.LeiaMuudetudAndmetegaKinnipeetavadResponse;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.annotation.Resource;
import java.util.*;

import static com.nortal.jroad.client.kir.types.eu.x_road.kir.ArvelolekuSisendTaiendavOlek.Enum.*;

/**
 * @author Marti Laast
 */
public class KirXRoadServiceImplTest extends BaseXRoadServiceImplTest {

    @Resource
    private KirXRoadServiceImpl kirXRoadService;

    @Test
    public void annaArvelolekuAndmedV1() throws XRoadServiceConsumptionException {
        Date start = createDate(2014, Calendar.JANUARY, 1);
        Date end = createDate(2016, Calendar.JANUARY, 1);
        Set<String> ids = new HashSet<>(Arrays.asList("12345678", "23456789"));
        AnnaArvelolekuAndmedResponse response = kirXRoadService.annaArvelolekuAndmedV1(start, end, getAllTypes(), ids);

        List<AnnaArvelolekuAndmedResponse.Response.Arvelolek> records = response.getResponse().getArvelolekList();
        Assertions.assertNotNull(records);
    }

    private Set<ArvelolekuSisendTaiendavOlek.Enum> getAllTypes() {
        Set<ArvelolekuSisendTaiendavOlek.Enum> enums = new HashSet<>();
        for (int i = 1; i <= table.lastInt(); i++) {
            enums.add(forInt(i));
        }
        return enums;
    }

    @Test
    public void leiaMuudetudAndmetegaKinnipeetavadV1() throws XRoadServiceConsumptionException {
        Date start = createDate(2014, Calendar.JANUARY, 1);
        Date end = createDate(2016, Calendar.JANUARY, 1);
        LeiaMuudetudAndmetegaKinnipeetavadResponse response = kirXRoadService.leiaMuudetudAndmetegaKinnipeetavadV1(start, end);

        List<String> idCodesList = response.getResponse().getIsikukoodList();
        Assertions.assertNotNull(idCodesList);
    }

    private Date createDate(int year, int month, int date) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, date);
        return c.getTime();
    }

}
