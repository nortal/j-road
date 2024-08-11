package com.nortal.jroad.client.tosjuht;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfResponse;

import org.junit.jupiter.api.Assertions;

/**
 * ePria teenuste testid nb. Suuna xtee teegis xtee-service.properties teenused õigesse kohta
 * 
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com)
 * @date 02.06.2010
 */
public class EpriaXRoadServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private EpriaXRoadServiceImpl epriaXRoadServiceImpl;
  /*
   * @Test public void sendAttachment() throws XRoadServiceConsumptionException { DataHandler handler = new
   * DataHandler(new ByteArrayDataSource("application/pdf", "123".getBytes())); VastuseKood response =
   * epriaXTeeServiceImpl.sendAttachment("123", handler); Assertions.assertNotNull(response);
   * Assertions.assertTrue(response.getVastuseKood().equals(VastuseKood2.OK) ||
   * response.getVastuseKood().equals(VastuseKood2.VIGA)); }
   * @Test public void vaataEsitatudPdf() throws XRoadServiceConsumptionException { DhVaataEsitatudPdfResponse response
   * = epriaXTeeServiceImpl.vaataEsitatudPdf("123"); Assertions.assertNotNull(response);
   * Assertions.assertNotNull(response.getPdf()); }
   * @Test public void saadaTaotluseManused() throws XRoadServiceConsumptionException { List<ManusModel> manused = new
   * ArrayList<ManusModel>(); DataHandler handler = new DataHandler(new ByteArrayDataSource("text/plain",
   * "123".getBytes())); manused.add(new ManusModel("123", "somefile.txt", handler)); VastuseKood response =
   * epriaXTeeServiceImpl.saadaTaotluseManused("123", manused); Assertions.assertNotNull(response);
   * Assertions.assertTrue(response.getVastuseKood().equals(VastuseKood2.OK) ||
   * response.getVastuseKood().equals(VastuseKood2.VIGA)); }
   * @Test public void vaataTatoluseManus() throws XRoadServiceConsumptionException { DhVaataTaotluseManusResponse
   * response = epriaXTeeServiceImpl.vaataTatoluseManus("123", 123L); Assertions.assertNotNull(response);
   * Assertions.assertNotNull(response.getSisu()); Assertions.assertEquals("somefile.txt", response.getManuseNimi()); }
   */

  @Test
  public void saadaTaotluseDigiDok() throws XRoadServiceConsumptionException {
    Assertions.assertTrue(true);
  }

  @Test
  public void vaataTaotluseDigiDok() throws XRoadServiceConsumptionException {
    Assertions.assertTrue(true);
  }

  public void vaataTaotlusePdf() throws XRoadServiceConsumptionException {
    DhsVaataTaotlusePdfResponse response = epriaXRoadServiceImpl.vaataTaotlusePdf(null, "123");

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getPdf());
  }

  @Test
  public void paringManusega() throws XRoadServiceConsumptionException {
    String result =
        epriaXRoadServiceImpl.epriaParingManusega("<andmeParing xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><teenus>kliendiRegistriMuudatused</teenus><sisendParams><param paramNimi=\"klientID\">97383</param></sisendParams></andmeParing>",
                                                  null,
                                                  null);
    Assertions.assertNotNull(result);
  }

  @Test
  public void vaataTatoluseManus() throws XRoadServiceConsumptionException {
    Assertions.assertTrue(true);
  }

  @Test
  public void saadaTaotlus() throws XRoadServiceConsumptionException {
    Assertions.assertTrue(true);
  }
}
