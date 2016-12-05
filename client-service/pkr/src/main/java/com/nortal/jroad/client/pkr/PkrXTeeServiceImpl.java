package com.nortal.jroad.client.pkr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.*;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import com.nortal.jroad.util.SOAPUtil;
import org.apache.xmlbeans.XmlString;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * <code>PKR</code> or <code>TPKR</code> X-tee service<br>
 * This implementation make test or production request. Generated test and production message are the same, except
 * namespace NS5 that will replaces to test or production
 *
 * @author Margus Hanni
 */
public class PkrXTeeServiceImpl extends XRoadDatabaseService implements PkrXTeeService {

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
        Tkis2Document.Tkis2 tkis2 = Tkis2Document.Tkis2.Factory.newInstance();
        Tkis2Sisend sisend = tkis2.addNewKeha();

        sisend.setIsikukood(isikukood);
        sisend.setPerAlgus(getCalendar(algusKuup));
        sisend.setPerLopp(getCalendar(loppKuup));


        XTeeMessage<Tkis2ResponseDocument.Tkis2Response> response = send(new XmlBeansXTeeMessage<Tkis2Document.Tkis2>(tkis2), TKIS2, "v1");
        Tkis2Valjund content = response.getContent().getKeha();
        return content;
    }

    @Override
    public ERIHK1ResponseDocument.ERIHK1Response getTkisErihkVastus(List<String> isikukoodid, Date algusKuup, Date loppKuup) throws XTeeServiceConsumptionException {
        ERIHK1Document erihk1Document = ERIHK1Document.Factory.newInstance();
        ERIHK1Document.ERIHK1 erihk1 = erihk1Document.addNewERIHK1();
        ERIHK1Document.ERIHK1.IsikukoodJada isikukoodJada = erihk1.addNewIsikukoodJada();
        for (String isikukood : isikukoodid) {
            XmlString isikukoodElement = isikukoodJada.addNewIsikukood();
            isikukoodElement.setStringValue(isikukood);
        }
        erihk1.setPerAlgus(getCalendar(algusKuup));
        erihk1.setPerLopp(getCalendar(loppKuup));

        XTeeMessage<ERIHK1ResponseDocument.ERIHK1Response> response = send(new XmlBeansXTeeMessage<ERIHK1Document>(erihk1Document), ERIHK1, "v1", new PkrCallback(), null);
        return response.getContent();
    }

    private Calendar getCalendar(Date kuup) {
        if (kuup == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(kuup);
        return cal;
    }

    private class PkrCallback extends CustomCallback {

        public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
            callback.doWithMessage(message);
            try {
                // ERIHK1 service expects the request params directly inside the message element,
                // but StandardXTeeConsumerCallback generates a structure 1 level too deep.
                replaceContentWithFirstDescendant((SaajSoapMessage) message);
            } catch (SOAPException e) {
                throw new RuntimeException(e);
            }
            if (useTestDatabase) {
                SOAPUtil.substitute(message, getDatabase(), TEST_DATABASE);
            }
        }

        private void replaceContentWithFirstDescendant(SaajSoapMessage message) throws SOAPException {
            SOAPEnvelope env = message.getSaajMessage().getSOAPPart().getEnvelope();
            SOAPBody body = env.getBody();
            Iterator elements = body.getChildElements();
            SOAPElement descendant = null;
            while (elements.hasNext()) {
                SOAPElement element = (SOAPElement) elements.next();
                descendant = (SOAPElement) element.getChildElements().next();
            }
            body.removeContents();
            body.addChildElement(descendant);
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