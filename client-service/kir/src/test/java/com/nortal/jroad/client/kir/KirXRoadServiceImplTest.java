package com.nortal.jroad.client.kir;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.AnnaArvelolekuAndmedResponseDocument.AnnaArvelolekuAndmedResponse;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.LeiaMuudetudAndmetegaKinnipeetavadResponseDocument.LeiaMuudetudAndmetegaKinnipeetavadResponse;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.ArvelolekuSisendTaiendavOlek.Enum;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Marti Laast
 */
public class KirXRoadServiceImplTest extends BaseXTeeServiceImplTest {

    @Resource
    private KirXRoadServiceImpl kirXRoadService;

    @Test
    public void annaArvelolekuAndmedV1() throws XTeeServiceConsumptionException {
        Date start = createDate(2014, Calendar.JANUARY, 1);
        Date end = createDate(2016, Calendar.JANUARY, 1);
        Set<String> ids = new HashSet<String>(Arrays.asList("12345678", "23456789"));
        AnnaArvelolekuAndmedResponse response = kirXRoadService.annaArvelolekuAndmedV1(start, end, getAllTypes(), ids);

        List<AnnaArvelolekuAndmedResponse.Response.Arvelolek> records = response.getResponse().getArvelolekList();
        Assert.assertNotNull(records);
    }

    private Set<Enum> getAllTypes() {
        Set<Enum> enums = new HashSet<Enum>();
        for (int i = 1; i <= Enum.table.lastInt(); i++) {
            enums.add(Enum.forInt(i));
        }
        return enums;
    }

    @Test
    public void leiaMuudetudAndmetegaKinnipeetavadV1() throws XTeeServiceConsumptionException {
        Date start = createDate(2014, Calendar.JANUARY, 1);
        Date end = createDate(2016, Calendar.JANUARY, 1);
        LeiaMuudetudAndmetegaKinnipeetavadResponse response = kirXRoadService.leiaMuudetudAndmetegaKinnipeetavadV1(start, end);

        List<String> idCodesList = response.getResponse().getIsikukoodList();
        Assert.assertNotNull(idCodesList);
    }

    private Date createDate(int year, int month, int date) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, date);
        return c.getTime();
    }

}
