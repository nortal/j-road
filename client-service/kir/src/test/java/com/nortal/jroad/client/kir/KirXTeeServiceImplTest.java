package com.nortal.jroad.client.kir;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kir.types.ee.x_road.kir.producer.AnnaArvelolekuAndmedResponse;
import com.nortal.jroad.client.kir.types.ee.x_road.kir.producer.AnnaArvelolekuAndmedResponse.Response.Arvelolek;
import com.nortal.jroad.client.kir.types.ee.x_road.kir.producer.IsikuStaatus.Enum;
import com.nortal.jroad.client.kir.types.ee.x_road.kir.producer.LeiaMuudetudAndmetegaKinnipeetavadResponse;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import junit.framework.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author Marti Laast
 */
public class KirXTeeServiceImplTest extends BaseXTeeServiceImplTest {

    @Resource
    private KirXTeeServiceImpl kirXTeeService;

    @Test
    public void annaArvelolekuAndmedV1() throws XTeeServiceConsumptionException {
        Date start = createDate(2014, Calendar.JANUARY, 1);
        Date end = createDate(2016, Calendar.JANUARY, 1);
        Set<String> ids = new HashSet<String>(Arrays.asList("38812192729", "12345678"));
        AnnaArvelolekuAndmedResponse response = kirXTeeService.annaArvelolekuAndmedV1(start, end, getAllTypes(), ids);

        List<Arvelolek> records = response.getResponse().getArvelolekList();
        Assert.assertNotNull(records);
    }

    private Set<Enum> getAllTypes() {
        Set<Enum> enums = new HashSet<Enum>();
        for (int i = 1; i <= Enum.table.lastInt(); i++) {
            enums.add(Enum.forInt(i));
        }
        return enums;
    }

    public void leiaMuudetudAndmetegaKinnipeetavadV1() throws XTeeServiceConsumptionException {
        Date start = createDate(2014, Calendar.JANUARY, 1);
        Date end = createDate(2016, Calendar.JANUARY, 1);
        LeiaMuudetudAndmetegaKinnipeetavadResponse response = kirXTeeService.leiaMuudetudAndmetegaKinnipeetavadV1(start, end);

        List<String> idCodesList = response.getResponse().getIsikukoodList();
        Assert.assertNotNull(idCodesList);
    }

    private Date createDate(int year, int month, int date) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, date);
        return c.getTime();
    }

}
