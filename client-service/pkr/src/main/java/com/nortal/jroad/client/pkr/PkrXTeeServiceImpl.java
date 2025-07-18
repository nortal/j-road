package com.nortal.jroad.client.pkr;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.ERIHK1Document;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.ERIHK1ResponseDocument;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Document;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2ResponseDocument;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Sisend;
import com.nortal.jroad.client.pkr.types.ee.riik.xtee.pkr.producers.producer.pkr.Tkis2Valjund;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import com.nortal.jroad.util.SOAPUtil;
import org.apache.xmlbeans.XmlString;
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

    public Tkis2Valjund getTkis2V1(String isikukood, Date algusKuup, Date loppKuup) throws XRoadServiceConsumptionException {
        Tkis2Document.Tkis2 tkis2 = Tkis2Document.Tkis2.Factory.newInstance();
        Tkis2Sisend sisend = tkis2.addNewKeha();

        sisend.setIsikukood(isikukood);
        sisend.setPerAlgus(getCalendar(algusKuup));
        sisend.setPerLopp(getCalendar(loppKuup));


        XRoadMessage<Tkis2ResponseDocument.Tkis2Response> response = send(new XmlBeansXRoadMessage<Tkis2Document.Tkis2>(tkis2), TKIS2, "v1");
        Tkis2Valjund content = response.getContent().getKeha();
        return content;
    }

    @Override
    public ERIHK1ResponseDocument.ERIHK1Response getTkisErihkVastus(List<String> isikukoodid, Date algusKuup, Date loppKuup) throws XRoadServiceConsumptionException {
        ERIHK1Document erihk1Document = ERIHK1Document.Factory.newInstance();
        ERIHK1Document.ERIHK1 erihk1 = erihk1Document.addNewERIHK1();
        ERIHK1Document.ERIHK1.IsikukoodJada isikukoodJada = erihk1.addNewIsikukoodJada();
        for (String isikukood : isikukoodid) {
            XmlString isikukoodElement = isikukoodJada.addNewIsikukood();
            isikukoodElement.setStringValue(isikukood);
        }
        erihk1.setPerAlgus(getCalendar(algusKuup));
        erihk1.setPerLopp(getCalendar(loppKuup));

        XRoadMessage<ERIHK1ResponseDocument.ERIHK1Response> response = send(new XmlBeansXRoadMessage<ERIHK1Document.ERIHK1>(erihk1), ERIHK1, "v1");
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

    public class PkrExtractor extends CustomExtractor {

        public Object extractData(WebServiceMessage message) throws IOException, TransformerException {
            if (useTestDatabase) {
                SOAPUtil.substitute(message, TEST_DATABASE, getDatabase());
            }

            return extractor.extractData(message);
        }
    }

}
