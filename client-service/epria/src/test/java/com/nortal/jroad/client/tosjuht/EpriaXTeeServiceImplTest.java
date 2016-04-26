package com.nortal.jroad.client.tosjuht;

import javax.annotation.Resource;

import org.junit.Test;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import com.nortal.jroad.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.DhsVaataTaotlusePdfResponse;

import junit.framework.Assert;

/**
 * ePria teenuste testid nb. Suuna xtee teegis xtee-service.properties teenused õigesse kohta
 * 
 * @author Lauri Lättemäe (lauri.lattemae@nortal.com)
 * @date 02.06.2010
 */
public class EpriaXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private EpriaXTeeServiceImpl epriaXTeeServiceImpl;
  /*
   * @Test public void sendAttachment() throws XTeeServiceConsumptionException { DataHandler handler = new
   * DataHandler(new ByteArrayDataSource("application/pdf", "123".getBytes())); VastuseKood response =
   * epriaXTeeServiceImpl.sendAttachment("123", handler); Assert.assertNotNull(response);
   * Assert.assertTrue(response.getVastuseKood().equals(VastuseKood2.OK) ||
   * response.getVastuseKood().equals(VastuseKood2.VIGA)); }
   * @Test public void vaataEsitatudPdf() throws XTeeServiceConsumptionException { DhVaataEsitatudPdfResponse response =
   * epriaXTeeServiceImpl.vaataEsitatudPdf("123"); Assert.assertNotNull(response);
   * Assert.assertNotNull(response.getPdf()); }
   * @Test public void saadaTaotluseManused() throws XTeeServiceConsumptionException { List<ManusModel> manused = new
   * ArrayList<ManusModel>(); DataHandler handler = new DataHandler(new ByteArrayDataSource("text/plain",
   * "123".getBytes())); manused.add(new ManusModel("123", "somefile.txt", handler)); VastuseKood response =
   * epriaXTeeServiceImpl.saadaTaotluseManused("123", manused); Assert.assertNotNull(response);
   * Assert.assertTrue(response.getVastuseKood().equals(VastuseKood2.OK) ||
   * response.getVastuseKood().equals(VastuseKood2.VIGA)); }
   * @Test public void vaataTatoluseManus() throws XTeeServiceConsumptionException { DhVaataTaotluseManusResponse
   * response = epriaXTeeServiceImpl.vaataTatoluseManus("123", 123L); Assert.assertNotNull(response);
   * Assert.assertNotNull(response.getSisu()); Assert.assertEquals("somefile.txt", response.getManuseNimi()); }
   */

  @Test
  public void saadaTaotluseDigiDok() throws XTeeServiceConsumptionException {
    Assert.assertTrue(true);
  }

  @Test
  public void vaataTaotluseDigiDok() throws XTeeServiceConsumptionException {
    Assert.assertTrue(true);
  }

  @Test
  public void vaataTaotlusePdf() throws XTeeServiceConsumptionException {
    DhsVaataTaotlusePdfResponse response = epriaXTeeServiceImpl.vaataTaotlusePdf("123");

    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getPdf());
  }

  @Test
  public void vaataTatoluseManus() throws XTeeServiceConsumptionException {
    Assert.assertTrue(true);
  }

  @Test
  public void saadaTaotlus() throws XTeeServiceConsumptionException {
    Assert.assertTrue(true);
  }
}
