package com.nortal.jroad.client.kir;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.AnnaArvelolekuAndmedDocument.AnnaArvelolekuAndmed;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.AnnaArvelolekuAndmedRequest;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.AnnaArvelolekuAndmedResponseDocument.AnnaArvelolekuAndmedResponse;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.ArvelolekuSisendTaiendavOlek;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.LeiaMuudetudAndmetegaKinnipeetavadDocument.LeiaMuudetudAndmetegaKinnipeetavad;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.LeiaMuudetudAndmetegaKinnipeetavadRequest;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.LeiaMuudetudAndmetegaKinnipeetavadResponseDocument.LeiaMuudetudAndmetegaKinnipeetavadResponse;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.enums.XRoadProtocolVersion;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Marti Laast
 */
@Service("kirXRoadService")
public class KirXRoadServiceImpl extends XRoadDatabaseService implements KirXRoadService {

    public AnnaArvelolekuAndmedResponse annaArvelolekuAndmedV1(Date start,
                                                               Date end,
                                                               Set<ArvelolekuSisendTaiendavOlek.Enum> requestTypes,
                                                               Set<String> idCodes)
        throws XTeeServiceConsumptionException {
        AnnaArvelolekuAndmed requestWrapper = AnnaArvelolekuAndmed.Factory.newInstance();
        AnnaArvelolekuAndmedRequest request = requestWrapper.addNewRequest();
        request.setPerioodiAlgusKp(toCalendar(start));
        request.setPerioodiLoppKp(toCalendar(end));
        request.setTaiendavOlekArray(requestTypes.toArray(new ArvelolekuSisendTaiendavOlek.Enum[requestTypes.size()]));
        request.setIsikukoodArray(idCodes.toArray(new String[idCodes.size()]));

        XmlBeansXTeeMessage<AnnaArvelolekuAndmed> xRoadMsg =
                new XmlBeansXTeeMessage<AnnaArvelolekuAndmed>(requestWrapper);
        XTeeMessage<AnnaArvelolekuAndmedResponse> response =
                send(xRoadMsg, "AnnaArvelolekuAndmed", "v1", new KirCallback(start, end), null);
        return response.getContent();
    }

    public LeiaMuudetudAndmetegaKinnipeetavadResponse leiaMuudetudAndmetegaKinnipeetavadV1(Date start, Date end) throws XTeeServiceConsumptionException {
        LeiaMuudetudAndmetegaKinnipeetavad requestWrapper = LeiaMuudetudAndmetegaKinnipeetavad.Factory.newInstance();
        LeiaMuudetudAndmetegaKinnipeetavadRequest request = requestWrapper.addNewRequest();

        request.setPerioodiAlgusKp(toCalendar(start));
        request.setPerioodiLoppKp(toCalendar(end));

        XmlBeansXTeeMessage<LeiaMuudetudAndmetegaKinnipeetavadRequest> xRoadMsg =
                new XmlBeansXTeeMessage<LeiaMuudetudAndmetegaKinnipeetavadRequest>(request);
        XTeeMessage<LeiaMuudetudAndmetegaKinnipeetavadResponse> response =
                send(xRoadMsg, "LeiaMuudetudAndmetegaKinnipeetavad", "v1", new KirCallback(), null);

        return response.getContent();
    }

    private Calendar toCalendar(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private static class KirCallback extends CustomCallback {

        private static final String ns = "xro";
        private static final String nsV30Uri = XRoadProtocolVersion.V3_0.getNamespaceUri();
        private static final String nsV31Uri = XRoadProtocolVersion.V3_1.getNamespaceUri();

        private final Date startDate;
        private final Date endDate;
        private SimpleDateFormat dateWithTimezone = new SimpleDateFormat("yyyy-MM-ddXXX");
        private SimpleDateFormat dateWithoutTimezone = new SimpleDateFormat("yyyy-MM-dd");

        private KirCallback() {
            this(null, null);
        }

        private KirCallback(Date startDate, Date endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
            callback.doWithMessage(message);
            try {
                SaajSoapMessage saajMsg = (SaajSoapMessage) message;
                SOAPMessage soapMsg = saajMsg.getSaajMessage();
                SOAPEnvelope env = soapMsg.getSOAPPart().getEnvelope();
                env.addNamespaceDeclaration(ns, nsV31Uri);

                Iterator headers = env.getHeader().getChildElements();
                while (headers.hasNext()) {
                    SOAPElement header = (SOAPElement) headers.next();
                    if (header.getNamespaceURI().equalsIgnoreCase(nsV30Uri)) {
                        QName qName = new QName(nsV31Uri, header.getLocalName(), ns);
                        header.setElementQName(qName);
                    }
                }

                formatDate(saajMsg, startDate);
                formatDate(saajMsg, endDate);
            } catch (SOAPException e) {
                throw new RuntimeException(e);
            }
        }

        private void formatDate(SaajSoapMessage saajMsg, Date date) throws TransformerException {
            if (date == null) {
                return;
            }
            SOAPPart soapPart = saajMsg.getSaajMessage().getSOAPPart();
            Source source = new DOMSource(soapPart);
            StringResult stringResult = new StringResult();
            TransformerFactory.newInstance().newTransformer().transform(source, stringResult);
            try {
                String from = dateWithTimezone.format(date);
                String to = dateWithoutTimezone.format(date);
                String content = StringUtils.replace(stringResult.toString(), from, to);
                soapPart.setContent(new StringSource(content));
            } catch (Exception e) {
                throw new TransformerException(e);
            }
        }

    }

}