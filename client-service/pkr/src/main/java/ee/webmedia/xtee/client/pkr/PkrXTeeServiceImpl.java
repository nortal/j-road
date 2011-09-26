package ee.webmedia.xtee.client.pkr;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.springframework.ws.WebServiceMessage;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusParing;
import ee.webmedia.xtee.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.TtaPensionToetusVastus;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.client.service.callback.CustomCallback;
import ee.webmedia.xtee.client.service.extractor.CustomExtractor;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
import ee.webmedia.xtee.util.SOAPUtil;

/**
 * <code>PKR</code> or <code>TPKR</code> X-tee service<br>
 * This implementation make test or production request. Generated test and production message are the same, except
 * namespace NS5 that will replaces to test or production
 * 
 * @author Margus Hanni
 */
public class PkrXTeeServiceImpl extends XTeeDatabaseService implements PkrXTeeService {

  private static final String TEST_DATABASE = "tpkr";

  private static final String PENSION_TOETUS = "tta_pension_toetus";

  private final boolean useTestDatabase;

  public PkrXTeeServiceImpl(boolean useTestDatabase) {
    this.useTestDatabase = useTestDatabase;
  }

  public TtaPensionToetusVastus getPensionToetus(String isikukood) throws XTeeServiceConsumptionException {

    TtaPensionToetusParing paring = TtaPensionToetusParing.Factory.newInstance();
    paring.setIsikukood(isikukood);

    XTeeMessage<TtaPensionToetusVastus> response =
        send(new XmlBeansXTeeMessage<TtaPensionToetusParing>(paring),
             PENSION_TOETUS,
             null,
             new PkrCallback(),
             new PkrExtractor());

    return response.getContent();
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