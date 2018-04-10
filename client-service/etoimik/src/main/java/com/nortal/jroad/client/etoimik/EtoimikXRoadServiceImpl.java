package com.nortal.jroad.client.etoimik;

import com.nortal.jroad.client.etoimik.types.eu.x_road.etoimik.KARRParinguVastus.KarrIsikuteValjavote;
import com.nortal.jroad.client.etoimik.types.eu.x_road.etoimik.LeiaToovoimetuteKaristusedDocument;
import com.nortal.jroad.client.etoimik.types.eu.x_road.etoimik.LeiaToovoimetuteKaristusedResponseDocument;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.callback.CustomCallback;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * @author Romet Piho
 */
@Service("etoimikXRoadService")
public class EtoimikXRoadServiceImpl extends XRoadDatabaseService implements EtoimikXRoadService {


    @Override
    public void init() {
        super.init();
    }

    public KarrIsikuteValjavote leiaToovoimetuteKaristused(LeiaToovoimetuteKaristusedDocument.LeiaToovoimetuteKaristused request)
            throws XTeeServiceConsumptionException {
        Etoimikv6Callback callback = new Etoimikv6Callback();
        callback.setName(request.getRequest().getKasutaja().getKoosnimi());
        XTeeMessage<LeiaToovoimetuteKaristusedResponseDocument.LeiaToovoimetuteKaristusedResponse> karrVastus =
                send(new XmlBeansXTeeMessage<LeiaToovoimetuteKaristusedDocument.LeiaToovoimetuteKaristused>(request),
                        "LeiaToovoimetuteKaristused", "v5", callback, null);

        return karrVastus.getContent().getResponse().getKarrIsikuteValjavote();
    }

    private class Etoimikv6Callback extends CustomCallback {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
            callback.doWithMessage(message);
            try {
                SaajSoapMessage saajMessage = (SaajSoapMessage) message;
                SOAPMessage soapmess = saajMessage.getSaajMessage();
                SOAPEnvelope env = soapmess.getSOAPPart().getEnvelope();
                env.getHeader().addChildElement("userName", "ns5", "http://etoimik.x-road.eu/").addTextNode(getName());
            } catch (SOAPException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
