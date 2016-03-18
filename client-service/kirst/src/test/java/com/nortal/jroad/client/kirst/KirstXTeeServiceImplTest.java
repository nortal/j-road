package com.nortal.jroad.client.kirst;

import java.util.*;

import javax.annotation.Resource;

import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.TvlLoetelu2ResponseType;
import junit.framework.Assert;

import org.junit.Test;

import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Roman Tekhov
 */
public class KirstXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private KirstXTeeServiceImpl kirstXTeeServiceImpl;

  @Test(expected = IllegalArgumentException.class)
  public void findTvlLoetelu2V1_emptySet() throws Exception {
    kirstXTeeServiceImpl.findTvlLoetelu2V1(Collections.<String>emptySet(), null, null);
  }

  @Test
  public void findTvlLoetelu2V1() throws Exception {
    Set<String> isikukoodid = new HashSet<String>(
          Arrays.asList("46111030234", "38606132730", "48703220267", "48702160305", "48809083723",
                        "47205076025", "38611122787", "48702160305", "37203312721", "46805252737", "47710130255"));
    isikukoodid.clear();
    isikukoodid.add("46111030234");
    Calendar alates = Calendar.getInstance();
    alates.set(2007, Calendar.JANUARY, 1);
    Calendar kuni = Calendar.getInstance();
    kuni.set(2016, Calendar.DECEMBER, 31);
    TvlLoetelu2ResponseType response = kirstXTeeServiceImpl.findTvlLoetelu2V1(isikukoodid, alates.getTime(), kuni.getTime());
    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTvlid());
  }

}
