package com.nortal.jroad.client.kirst;

import com.nortal.jroad.client.kirst.types.eu.x_road.kirst.TvlLoetelu2ResponseDocument;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import junit.framework.Assert;
import org.junit.Test;

import jakarta.annotation.Resource;
import java.util.*;

/**
 * @author Roman Tekhov
 */
public class KirstXRoadServiceImplTest extends BaseXTeeServiceImplTest {

    @Resource
    private KirstXRoadServiceImpl kirstXRoadServiceImpl;

    @Test(expected = IllegalArgumentException.class)
    public void findTvlLoetelu2V1_emptySet() throws Exception {
        kirstXRoadServiceImpl.findTvlLoetelu2V1(Collections.<String>emptySet(), null, null);
    }

    @Test
    public void findTvlLoetelu2V1() throws Exception {
        Set<String> isikukoodid = new HashSet<String>(
                Arrays.asList("46111030234", "38606132730", "48703220267", "48702160305", "48809083723",
                        "47205076025", "38611122787", "48702160305", "37203312721", "46805252737", "47710130255"));
        Calendar alates = Calendar.getInstance();
        alates.set(2007, Calendar.JANUARY, 1);
        Calendar kuni = Calendar.getInstance();
        kuni.set(2016, Calendar.DECEMBER, 31);
        TvlLoetelu2ResponseDocument.TvlLoetelu2Response response = kirstXRoadServiceImpl.findTvlLoetelu2V1
                (isikukoodid, alates.getTime(), kuni.getTime());
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResponse().getTvlid());
    }

}
