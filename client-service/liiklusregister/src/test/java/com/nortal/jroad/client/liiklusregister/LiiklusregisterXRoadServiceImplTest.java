package com.nortal.jroad.client.liiklusregister;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.MuuDokVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolJuhtoigusVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevResponse;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevTunnVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevTunnistus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevVastusLaevaandmed;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Dmitri Danilkin
 */
public class LiiklusregisterXRoadServiceImplTest extends BaseXTeeServiceImplTest {

  private static final String TEST_ISIKUKOOD = "38606282771";

  @Resource
  private LiiklusregisterXRoadServiceImpl liiklusregisterXRoadServiceImpl;

  @Test
  public void getPolJuhtoigus() throws XTeeServiceConsumptionException {
    PolJuhtoigusVastus polJuhtoigus = liiklusregisterXRoadServiceImpl.polJuhtoigus(TEST_ISIKUKOOD);

    Assert.assertNotNull(polJuhtoigus);
    Assert.assertNotNull(polJuhtoigus.getKood());
    Assert.assertNotNull(polJuhtoigus.getJuhtoigus());
    Assert.assertNotNull(polJuhtoigus.getJuhtoigus().getJuhtoigusList());
    Assert.assertFalse(polJuhtoigus.getJuhtoigus().getJuhtoigusList().isEmpty());
  }

  @Test
  public void getVlaev() throws XTeeServiceConsumptionException {
    VlaevResponse response = liiklusregisterXRoadServiceImpl.findVLaevAndmed("VLD-935", null, null, null, null);

    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getItemList());
    Assert.assertNotNull(response.getItemList().get(0));

    VlaevVastusLaevaandmed andmed = response.getItemList().get(0);
    Assert.assertEquals("VLD-935", andmed.getLaevaRegnr());
    Assert.assertEquals("MOOTORPAAT", andmed.getTyypNm());
    Assert.assertEquals("PLASTIK", andmed.getMaterialNm());
    Assert.assertEquals("SOLOVJOVA", andmed.getOmanik());
  }

  @Test
  public void getVlaevTunn() throws XTeeServiceConsumptionException {
    VlaevTunnVastus response = liiklusregisterXRoadServiceImpl.findVlaevTunnistused("004737", null, null, null);

    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getTunnistus());
    Assert.assertNotNull(response.getTunnistus().getTunnistusList());

    VlaevTunnistus tunnistus = response.getTunnistus().getTunnistusArray(0);
    Assert.assertEquals("SOLOVJOVA", tunnistus.getPerenimi());
    Assert.assertEquals("IRINA", tunnistus.getEesnimi());
    Assert.assertEquals("004737", tunnistus.getTunnistusNr());
  }

  @Test
  public void getMuuDokument() throws XTeeServiceConsumptionException {
    MuuDokVastus vastus = liiklusregisterXRoadServiceImpl.findMuuDok(null, "NIKLUS", null, null);
    Assert.assertNotNull(vastus.getDok());
    Assert.assertFalse(vastus.getDok().getDokList().isEmpty());
  }
}
