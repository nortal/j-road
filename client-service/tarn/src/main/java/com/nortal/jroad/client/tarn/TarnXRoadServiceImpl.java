package com.nortal.jroad.client.tarn;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.tarn.database.TarnXRoadDatabase;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.*;
import com.nortal.jroad.model.XRoadAttachment;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service("tarnXRoadService")
public class TarnXRoadServiceImpl extends XRoadDatabaseService implements TarnXRoadService {

    @Resource
    private TarnXRoadDatabase tarnXRoadDatabase;

    public TaitemenetluseMuutmineTaResponseDocument.TaitemenetluseMuutmineTaResponse taitemenetluseMuutmineTaV1(TaitemenetluseMuutmineTaSisend input)
            throws XRoadServiceConsumptionException {

        TaitemenetluseMuutmineTaDocument.TaitemenetluseMuutmineTa taitemenetluseMuutmineTa =
                TaitemenetluseMuutmineTaDocument.TaitemenetluseMuutmineTa.Factory.newInstance();
        taitemenetluseMuutmineTa.setKeha(input);

        return tarnXRoadDatabase.taitemenetluseMuutmineTaV1(taitemenetluseMuutmineTa);
    }

    public TaitmisavalduseEsitamineResponseDocument.TaitmisavalduseEsitamineResponse taitmisavalduseEsitamineV1(TarnToiming input,
                                                                                                                List<XRoadAttachment> attachments)
            throws XRoadServiceConsumptionException {

        TarnToiminguTeavitus teavitus = TarnToiminguTeavitus.Factory.newInstance();
        teavitus.setToiming(input);

        TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine taitmisavalduseEsitamine =
                TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine.Factory.newInstance();
        taitmisavalduseEsitamine.addNewKeha().setTeavitus(teavitus);

        XmlBeansXRoadMessage<TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine> XRoadMessage =
          new XmlBeansXRoadMessage<>(taitmisavalduseEsitamine);

        List<XRoadAttachment> XRoadAttachments = XRoadMessage.getAttachments();
        if (attachments != null) {
            XRoadAttachments.addAll(attachments);
        }

        XRoadMessage<TaitmisavalduseEsitamineResponseDocument> response = send(XRoadMessage, "TaitmisavalduseEsitamine", "v1");
        return (TaitmisavalduseEsitamineResponseDocument.TaitmisavalduseEsitamineResponse)response.getContent();
    }
}
