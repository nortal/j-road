package com.nortal.jroad.client.tarn;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.tarn.database.TarnXRoadDatabase;
import com.nortal.jroad.client.tarn.types.eu.x_road.tarn.*;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("tarnXRoadService")
public class TarnXRoadServiceImpl implements TarnXRoadService {

    @Resource
    private TarnXRoadDatabase tarnXRoadDatabase;

    public TaitemenetluseMuutmineTaResponseDocument.TaitemenetluseMuutmineTaResponse taitemenetluseMuutmineTaV1(TaitemenetluseMuutmineTaSisend input)
            throws XTeeServiceConsumptionException {

        TaitemenetluseMuutmineTaDocument.TaitemenetluseMuutmineTa taitemenetluseMuutmineTa =
                TaitemenetluseMuutmineTaDocument.TaitemenetluseMuutmineTa.Factory.newInstance();
        taitemenetluseMuutmineTa.setKeha(input);

        return tarnXRoadDatabase.taitemenetluseMuutmineTaV1(taitemenetluseMuutmineTa);
    }

    public TaitmisavalduseEsitamineResponseDocument.TaitmisavalduseEsitamineResponse taitmisavalduseEsitamineV1(TarnToiming input,
                                                                                                                List<XTeeAttachment> attachments)
            throws XTeeServiceConsumptionException {

        TarnToiminguTeavitus teavitus = TarnToiminguTeavitus.Factory.newInstance();
        teavitus.setToiming(input);

        TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine taitmisavalduseEsitamine =
                TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine.Factory.newInstance();
        taitmisavalduseEsitamine.addNewKeha().setTeavitus(teavitus);

        XmlBeansXTeeMessage<TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine> xteeMessage =
                new XmlBeansXTeeMessage<TaitmisavalduseEsitamineDocument.TaitmisavalduseEsitamine>(taitmisavalduseEsitamine);

        List<XTeeAttachment> xteeAttachments = xteeMessage.getAttachments();
        if (attachments != null) {
            xteeAttachments.addAll(attachments);
        }

        XTeeMessage<TaitmisavalduseEsitamineResponseDocument> response =
                this.tarnXRoadDatabase.send(xteeMessage, "TaitmisavalduseEsitamine", "v1");
        return (TaitmisavalduseEsitamineResponseDocument.TaitmisavalduseEsitamineResponse)response.getContent();
    }
}
