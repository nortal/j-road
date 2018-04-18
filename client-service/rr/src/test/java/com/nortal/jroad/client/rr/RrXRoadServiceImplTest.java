package com.nortal.jroad.client.rr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rr.RrXRoadService.RR42RequestCallback;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR40IsikTaielikIsikukoodResponseDocument.RR40IsikTaielikIsikukoodResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR42IsikAadressKoodDocument.RR42IsikAadressKood;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR42IsikAadressKoodRequestType;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR42IsikAadressKoodResponseDocument.RR42IsikAadressKoodResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR52ResponseDocument.RR52Response;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR52ResponseType;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR52ResponseType.Dokumendid.Dok;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR63IsikAadrDokResponseDocument.RR63IsikAadrDokResponse;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR67MuutusResponseType.TtKood.TtKoodid;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR72IsikResponseType.TtIsik.TtIsikud;
import com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR96IsikDokElukSuheResponseDocument.RR96IsikDokElukSuheResponse;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;
import com.nortal.jroad.client.util.XmlBeansUtil;
import junit.framework.Assert;
import org.apache.xmlbeans.XmlString;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Roman Tekhov
 */
public class RrXRoadServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private RrXRoadServiceImpl rrXRoadServiceImpl;

  @Test
  public void findRR72Isik() throws XTeeServiceConsumptionException {
    List<TtIsikud> items = rrXRoadServiceImpl.findRR72Isik("37109046017", "47702037790");

    Assert.assertNotNull(items);
    Assert.assertTrue("Person not found!", !items.isEmpty());

    TtIsikud isik1 = items.get(0);
    Assert.assertEquals("\u017D\u0160\u017E\u0161", isik1.getTtIsikudCEesnimi());
    Assert.assertEquals("\u00C4\u00D5\u00D6\u00DC\u00E4\u00F5\u00F6\u00FC", isik1.getTtIsikudCPerenimi());

    TtIsikud isik2 = items.get(1);
    Assert.assertEquals("KATI", isik2.getTtIsikudCEesnimi());
    Assert.assertEquals("\u00D6\u00D6VIIUL", isik2.getTtIsikudCPerenimi());
  }

  @Test
  public void RR63ResponseV1() throws XTeeServiceConsumptionException {
    String idCode = "38307070013";
    RR63IsikAadrDokResponse response = rrXRoadServiceImpl.findRR63IsikAadrDok("Tamm*", "A*", idCode, null);

    Assert.assertNotNull(response.getResponse());
    Assert.assertTrue(response.getResponse().getIsikud().sizeOfIsikuandmedArray() > 0);
  }

  @Test
  public void findRR40isikTaielikIsikukoodV1() throws XTeeServiceConsumptionException {
    RR40IsikTaielikIsikukoodResponse response = rrXRoadServiceImpl.findRR40isikTaielikIsikukood("37707010014");
    Assert.assertNotNull(response.getResponse());
    Assert.assertEquals("SOOME", response.getResponse().getIsikud().getIsikArray(0).getIsikEmakeel());
    Assert.assertEquals("01.07.1977", response.getResponse().getIsikud().getIsikArray(0).getIsikSynniaeg());

  }

  @Test
  public void findRR42isikAadressKoodV1() throws XTeeServiceConsumptionException {
    RR42IsikAadressKoodResponse response = rrXRoadServiceImpl.findRR42isikAadressKood(new RR42RequestCallback() {
      public void populate(RR42IsikAadressKood paring) {
        RR42IsikAadressKoodRequestType request = RR42IsikAadressKoodRequestType.Factory.newInstance();
        XmlString isikukoodElement = XmlBeansUtil.getAttributedXmlString("37707010014");
        request.xsetIsikukoodFragment(isikukoodElement);
        paring.setRequest(request);
      }
    });

    Assert.assertNotNull(response.getResponse());
    Assert.assertEquals("SOOMLANE", response.getResponse().getIsikud().getIsikArray(0).getIsikPerekonnanimi());
    Assert.assertEquals("JOKKA", response.getResponse().getIsikud().getIsikArray(0).getIsikIsanimi());
  }

  @Test
  public void getRR52() throws XTeeServiceConsumptionException {
    RR52Response response = rrXRoadServiceImpl.getRR52("47707178682", "Olga", "Sidorova");

    Assert.assertNotNull(response.getResponse());

    List<Dok> dokList = response.getResponse().getDokumendid().getDokList();
    Assert.assertTrue(!dokList.isEmpty());
    Assert.assertEquals("ELAMISLUBA", dokList.get(0).getDokDokTyyp());

    List<RR52ResponseType.Isikud.Isik> isikList = response.getResponse().getIsikud().getIsikList();
    Assert.assertTrue(!isikList.isEmpty());
    Assert.assertEquals("OLGA", isikList.get(0).getIsikEesnimi());
  }

  @Test
  public void getRR96isikDokElukSuhe() throws XTeeServiceConsumptionException {
    RR96IsikDokElukSuheResponse response =
        rrXRoadServiceImpl.getRR96isikDokElukSuhe("KAAREL", "METSAMEES", "32105258875", 5L);

    Assert.assertNotNull(response.getResponse());
    Assert.assertNotNull(response.getResponse().getIsikud());
    Assert.assertTrue(response.getResponse().getIsikud().getIsikuandmedList().size() > 0);
    Assert.assertTrue(response.getResponse().getIsikud().getIsikuandmedArray(0).getIsikuandmedPerenimi().equalsIgnoreCase("METSAMEES"));

    checkXteeAnnotation(com.nortal.jroad.client.rr.types.eu.x_road.rr.producer.RR96IsikDokElukSuheResponseType.Isikud.Isikuandmed.class);
  }

  @Test
  public void getRR67MuutusV1() throws XTeeServiceConsumptionException {
    try {
      SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
      List<TtKoodid> ttKoodid = rrXRoadServiceImpl.findRR67MuutusV1(df.parse("01.05.2013"), df.parse("01.06.2013"));
      Assert.assertTrue(!ttKoodid.isEmpty());
    } catch (Exception e) {
      Assert.fail();
    }
  }
}
