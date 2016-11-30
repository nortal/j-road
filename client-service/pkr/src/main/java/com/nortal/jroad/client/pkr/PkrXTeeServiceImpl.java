package com.nortal.jroad.client.pkr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.ERIHK1Document;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.ERIHK1ResponseDocument;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Sisend;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Valjund;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.client.service.v2.XTeeDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import com.nortal.jroad.util.SOAPUtil;
import org.springframework.ws.WebServiceMessage;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <code>PKR</code> or <code>TPKR</code> X-tee service<br>
 * This implementation make test or production request. Generated test and production message are the same, except
 * namespace NS5 that will replaces to test or production
 *
 * @author Margus Hanni
 */
public class PkrXTeeServiceImpl extends XTeeDatabaseService implements PkrXTeeService {

  private static final String TEST_DATABASE = "tpkr";

  private static final String TKIS2 = "tkis2";
  private static final String ERIHK1 = "ERIHK1";

  private final boolean useTestDatabase;

  public PkrXTeeServiceImpl() {
    this(false);
  }

  public PkrXTeeServiceImpl(boolean useTestDatabase) {
    this.useTestDatabase = useTestDatabase;
  }

  public Tkis2Valjund getTkis2V1(String isikukood, Date algusKuup, Date loppKuup) throws XTeeServiceConsumptionException {
    Tkis2Sisend sisend = Tkis2Sisend.Factory.newInstance();
    sisend.setIsikukood(isikukood);
    sisend.setPerAlgus(getCalendar(algusKuup));
    sisend.setPerLopp(getCalendar(loppKuup));

    XTeeMessage<Tkis2Valjund> response = send(new XmlBeansXTeeMessage<Tkis2Sisend>(sisend), TKIS2, "v1");
    return response.getContent();
}

  @Override
  public ERIHK1ResponseDocument getTkisErihkVastus(List<String> isikukoodid, Date algusKuup, Date loppKuup) throws XTeeServiceConsumptionException {
      ERIHK1Document.ERIHK1 erihk1 = ERIHK1Document.ERIHK1.Factory.newInstance();
      ERIHK1Document.ERIHK1.IsikukoodJada isikukoodJada = ERIHK1Document.ERIHK1.IsikukoodJada.Factory.newInstance();
      isikukoodJada.setIsikukoodArray(isikukoodid.toArray(new String[isikukoodid.size()]));
      erihk1.setIsikukoodJada(isikukoodJada);
      erihk1.setPerAlgus(getCalendar(algusKuup));
      erihk1.setPerLopp(getCalendar(loppKuup));

      XTeeMessage<ERIHK1ResponseDocument> response = send(new XmlBeansXTeeMessage<ERIHK1Document.ERIHK1>(erihk1), ERIHK1, "v1");
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