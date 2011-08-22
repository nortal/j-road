package ee.webmedia.xtee.client.tosjuht;

import ee.webmedia.xtee.client.tosjuht.EpriaXTeeServiceImpl;
import ee.webmedia.xtee.client.tosjuht.model.ManusModel;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.VastuseKood;
import ee.webmedia.xtee.client.tosjuht.types.ee.riik.xtee.epria.producers.producer.epria.VastuseKood.VastuseKood2;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.test.BaseXTeeServiceImplTest;
import ee.webmedia.xtee.jaxb.ByteArrayDataSource;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.annotation.Resource;
import junit.framework.Assert;
import org.junit.Test;

/**
 * ePria teenuste testid
 * nb. Suuna xtee teegis xtee-service.properties teenused Ãµigesse kohta 
 *  
 * @author Lauri Lättemäe (lauri.lattemae@webmedia.ee)
 * @date 02.06.2010
 */
public class EpriaXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private EpriaXTeeServiceImpl epriaXTeeServiceImpl;
/*
  @Test
  public void sendAttachment() throws XTeeServiceConsumptionException {
  	DataHandler handler = new DataHandler(new ByteArrayDataSource("application/pdf", "123".getBytes()));
  	VastuseKood response = epriaXTeeServiceImpl.sendAttachment("123", handler);

  	Assert.assertNotNull(response);
  	Assert.assertTrue(response.getVastuseKood().equals(VastuseKood2.OK)
  			|| response.getVastuseKood().equals(VastuseKood2.VIGA));
  }
  
  @Test
  public void vaataEsitatudPdf() throws XTeeServiceConsumptionException {
  	DhVaataEsitatudPdfResponse response = epriaXTeeServiceImpl.vaataEsitatudPdf("123");
  	
  	Assert.assertNotNull(response);
  	Assert.assertNotNull(response.getPdf());
  }

  @Test
  public void saadaTaotluseManused() throws XTeeServiceConsumptionException {
  	List<ManusModel> manused = new ArrayList<ManusModel>();
  	DataHandler handler = new DataHandler(new ByteArrayDataSource("text/plain", "123".getBytes()));
  	manused.add(new ManusModel("123", "somefile.txt", handler));
  	VastuseKood response = epriaXTeeServiceImpl.saadaTaotluseManused("123", manused);
  	
  	Assert.assertNotNull(response);
  	Assert.assertTrue(response.getVastuseKood().equals(VastuseKood2.OK)
  			|| response.getVastuseKood().equals(VastuseKood2.VIGA));
  }

  @Test
  public void vaataTatoluseManus() throws XTeeServiceConsumptionException {
  	DhVaataTaotluseManusResponse response = epriaXTeeServiceImpl.vaataTatoluseManus("123", 123L);
  	
  	Assert.assertNotNull(response);
  	Assert.assertNotNull(response.getSisu());
  	Assert.assertEquals("somefile.txt", response.getManuseNimi());
  }*/
  
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
	  Assert.assertTrue(true);
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
