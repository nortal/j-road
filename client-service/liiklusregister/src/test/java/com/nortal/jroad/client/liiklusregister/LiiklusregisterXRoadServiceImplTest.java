package com.nortal.jroad.client.liiklusregister;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.MuuDokVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.PolJuhtoigusVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevResponse;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevTunnVastus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevTunnistus;
import com.nortal.jroad.client.liiklusregister.types.eu.x_road.liiklusregister.VlaevVastusLaevaandmed;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;

/**
 * @author Dmitri Danilkin
 */
public class LiiklusregisterXRoadServiceImplTest extends BaseXRoadServiceImplTest {

  private static final String TEST_ISIKUKOOD = "38606282771";

  @Resource
  private LiiklusregisterXRoadServiceImpl liiklusregisterXRoadServiceImpl;

  @Test
  public void getPolJuhtoigus() throws XRoadServiceConsumptionException {
    PolJuhtoigusVastus polJuhtoigus = liiklusregisterXRoadServiceImpl.polJuhtoigus(TEST_ISIKUKOOD);

    Assertions.assertNotNull(polJuhtoigus);
    Assertions.assertNotNull(polJuhtoigus.getKood());
    Assertions.assertNotNull(polJuhtoigus.getJuhtoigus());
    Assertions.assertNotNull(polJuhtoigus.getJuhtoigus().getJuhtoigusList());
    Assertions.assertFalse(polJuhtoigus.getJuhtoigus().getJuhtoigusList().isEmpty());
  }

  @Test
  public void getVlaev() throws XRoadServiceConsumptionException {
    VlaevResponse response = liiklusregisterXRoadServiceImpl.findVLaevAndmed("VLD-935", null, null, null, null);

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getItemList());
    Assertions.assertNotNull(response.getItemList().get(0));

    VlaevVastusLaevaandmed andmed = response.getItemList().get(0);
    Assertions.assertEquals("VLD-935", andmed.getLaevaRegnr());
    Assertions.assertEquals("MOOTORPAAT", andmed.getTyypNm());
    Assertions.assertEquals("PLASTIK", andmed.getMaterialNm());
    Assertions.assertEquals("SOLOVJOVA", andmed.getOmanik());
  }

  @Test
  public void getVlaevTunn() throws XRoadServiceConsumptionException {
    VlaevTunnVastus response = liiklusregisterXRoadServiceImpl.findVlaevTunnistused("004737", null, null, null);

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getTunnistus());
    Assertions.assertNotNull(response.getTunnistus().getTunnistusList());

    VlaevTunnistus tunnistus = response.getTunnistus().getTunnistusArray(0);
    Assertions.assertEquals("SOLOVJOVA", tunnistus.getPerenimi());
    Assertions.assertEquals("IRINA", tunnistus.getEesnimi());
    Assertions.assertEquals("004737", tunnistus.getTunnistusNr());
  }

  @Test
  public void getMuuDokument() throws XRoadServiceConsumptionException {
    MuuDokVastus vastus = liiklusregisterXRoadServiceImpl.findMuuDok(null, "NIKLUS", null, null);
    Assertions.assertNotNull(vastus.getDok());
    Assertions.assertFalse(vastus.getDok().getDokList().isEmpty());
  }
}
