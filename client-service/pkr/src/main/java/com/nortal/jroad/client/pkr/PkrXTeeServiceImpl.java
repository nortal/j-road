package com.nortal.jroad.client.pkr;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.xml.transform.TransformerException;

import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.*;
import org.springframework.ws.WebServiceMessage;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis1Paring;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis1Vastus;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusParing;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import com.nortal.jroad.util.SOAPUtil;

/**
 * <code>PKR</code> or <code>TPKR</code> X-tee service<br>
 * This implementation make test or production request. Generated test and production message are the same, except
 * namespace NS5 that will replaces to test or production
 * 
 * @author Margus Hanni
 */
public class PkrXTeeServiceImpl extends XRoadDatabaseService implements PkrXTeeService {

  private static final String TEST_DATABASE = "tpkr";

  private static final String PENSION_TOETUS = "tta_pension_toetus";
  private static final String TKIS1 = "tkis1";
  private static final String TKIS2 = "tkis2";

  private final boolean useTestDatabase;

  public PkrXTeeServiceImpl() {
    this(false);
  }

  public PkrXTeeServiceImpl(boolean useTestDatabase) {
    this.useTestDatabase = useTestDatabase;
  }

  public TtaPensionToetusVastus getPensionToetus(String isikukood) throws XRoadServiceConsumptionException {

    TtaPensionToetusParing paring = TtaPensionToetusParing.Factory.newInstance();
    paring.setIsikukood(isikukood);

    XRoadMessage<TtaPensionToetusVastus> response =
        send(new XmlBeansXRoadMessage<TtaPensionToetusParing>(paring),
             PENSION_TOETUS,
             null,
             new PkrCallback(),
             new PkrExtractor());

    return response.getContent();
  }
  
  public Tkis1Vastus getTkis1(String isikukood, Date algusKuup, Date loppKuup,
      Date kuup) throws XRoadServiceConsumptionException {

    Tkis1Paring paring = Tkis1Paring.Factory.newInstance();
    paring.setIsikukood(isikukood);
    paring.setAlgusKuup(getCalendar(algusKuup));
    paring.setLoppKuup(getCalendar(loppKuup));
    paring.setKuup(getCalendar(kuup));

    XRoadMessage<Tkis1Vastus> response = send(
        new XmlBeansXRoadMessage<Tkis1Paring>(paring), TKIS1, null,
        new PkrCallback(), new PkrExtractor());

    return response.getContent();
  }

  public Tkis2Valjund getTkis2V1(String isikukood, Date algusKuup, Date loppKuup) throws XRoadServiceConsumptionException {
    Tkis2Sisend sisend = Tkis2Sisend.Factory.newInstance();
    sisend.setIsikukood(isikukood);
    sisend.setPerAlgus(getCalendar(algusKuup));
    sisend.setPerLopp(getCalendar(loppKuup));

    XRoadMessage<Tkis2Valjund> response = send(new XmlBeansXRoadMessage<Tkis2Sisend>(sisend), TKIS2, "v1");
    return response.getContent();
  }

  private Calendar getCalendar(Date kuup) {
    if (kuup == null ) {
      return null;
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(kuup);
    return cal;
  }

  private class PkrCallback extends CustomCallback {

    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
      callback.doWithMessage(message);

      if (useTestDatabase) {
        SOAPUtil.substitute(message, getDatabase(), TEST_DATABASE);
      }
    }
  }

  public class PkrExtractor extends CustomExtractor {

    public Object extractData(WebServiceMessage message) throws IOException, TransformerException {
      if (useTestDatabase) {
        SOAPUtil.substitute(message, TEST_DATABASE, getDatabase());
      }

      return extractor.extractData(message);
    }
  }

}