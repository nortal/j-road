package com.nortal.jroad.client.skais2;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusVastusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusVastusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusResponse;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import org.springframework.stereotype.Service;

/**
 * @author Hasso Mehide <hasso.mehide@nortal.com>
 */
@Service("skais2XRoadService")
public class Skais2XRoadServiceImpl extends XRoadDatabaseService implements Skais2XRoadService {

    @Override
    public TVHYhisTaotlusResponse tvhTaotlusYksUksV1(TVHYhisTaotlusRequest request) throws XRoadServiceConsumptionException {
        XRoadMessage<TVHYhisTaotlusResponse> response = send(new XmlBeansXRoadMessage<TVHYhisTaotlusRequest>(request), "TVHTaotlusYksUks", "v1");
        return response.getContent();
    }

    @Override
    public TKToovoimPuueHyvitisedResponse tkToovoimPuueHyvitisedV1(TKToovoimPuueHyvitisedRequest request) throws XRoadServiceConsumptionException {
        XRoadMessage<TKToovoimPuueHyvitisedResponse> response =
                send(new XmlBeansXRoadMessage<TKToovoimPuueHyvitisedRequest>(request), "TKToovoimPuueHyvitised", "v1");
        return response.getContent();
    }


    @Override
    public TKToovoimPuueHyvitisedMassTeenusResponse submitTKToovoimPuueHyvitisedMassTeenusV1(TKToovoimPuueHyvitisedMassTeenusRequest request)
            throws XRoadServiceConsumptionException {
        XRoadMessage<TKToovoimPuueHyvitisedMassTeenusResponse> response =
                send(new XmlBeansXRoadMessage<TKToovoimPuueHyvitisedMassTeenusRequest>(request), "TKToovoimPuueHyvitisedMassTeenus", "v1");

        return response.getContent();
    }

    @Override
    public XRoadMessage<TKToovoimPuueHyvitisedMassTeenusVastusResponse> getTKToovoimPuueHyvitisedMassTeenusVastusV1(long protsessiId)
            throws XRoadServiceConsumptionException {
        TKToovoimPuueHyvitisedMassTeenusVastusRequest request = TKToovoimPuueHyvitisedMassTeenusVastusRequest.Factory.newInstance();
        request.setProtsessID(protsessiId);

        XRoadMessage<TKToovoimPuueHyvitisedMassTeenusVastusResponse> response =
                send(new XmlBeansXRoadMessage<TKToovoimPuueHyvitisedMassTeenusVastusRequest>(request),
                        "TKToovoimPuueHyvitisedMassTeenusVastus",
                        "v1");

        return response;
    }

}
