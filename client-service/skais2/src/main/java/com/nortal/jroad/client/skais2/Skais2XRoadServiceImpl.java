package com.nortal.jroad.client.skais2;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusVastusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedMassTeenusVastusResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TKToovoimPuueHyvitisedResponse;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusResponse;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.springframework.stereotype.Service;

/**
 * @author Hasso Mehide <hasso.mehide@nortal.com>
 */
@Service("skais2XRoadService")
public class Skais2XRoadServiceImpl extends XRoadDatabaseService implements Skais2XRoadService {

    @Override
    public TVHYhisTaotlusResponse tvhTaotlusYksUksV1(TVHYhisTaotlusRequest request) throws XTeeServiceConsumptionException {
        XTeeMessage<TVHYhisTaotlusResponse> response = send(new XmlBeansXTeeMessage<TVHYhisTaotlusRequest>(request), "TVHTaotlusYksUks", "v1");
        return response.getContent();
    }
	
    @Override
    public TKToovoimPuueHyvitisedResponse tkToovoimPuueHyvitisedV1(TKToovoimPuueHyvitisedRequest request) throws XTeeServiceConsumptionException {
        XTeeMessage<TKToovoimPuueHyvitisedResponse> response =
                send(new XmlBeansXTeeMessage<TKToovoimPuueHyvitisedRequest>(request), "TKToovoimPuueHyvitised", "v1");
        return response.getContent();
    }


    @Override
    public TKToovoimPuueHyvitisedMassTeenusResponse submitTKToovoimPuueHyvitisedMassTeenusV1(TKToovoimPuueHyvitisedMassTeenusRequest request)
            throws XTeeServiceConsumptionException {
        XTeeMessage<TKToovoimPuueHyvitisedMassTeenusResponse> response =
                send(new XmlBeansXTeeMessage<TKToovoimPuueHyvitisedMassTeenusRequest>(request), "TKToovoimPuueHyvitisedMassTeenus", "v1");

        return response.getContent();
    }

    @Override
    public XTeeMessage<TKToovoimPuueHyvitisedMassTeenusVastusResponse> getTKToovoimPuueHyvitisedMassTeenusVastusV1(long protsessiId)
            throws XTeeServiceConsumptionException {
        TKToovoimPuueHyvitisedMassTeenusVastusRequest request = TKToovoimPuueHyvitisedMassTeenusVastusRequest.Factory.newInstance();
        request.setProtsessID(protsessiId);

        XTeeMessage<TKToovoimPuueHyvitisedMassTeenusVastusResponse> response =
                send(new XmlBeansXTeeMessage<TKToovoimPuueHyvitisedMassTeenusVastusRequest>(request),
                        "TKToovoimPuueHyvitisedMassTeenusVastus",
                        "v1");

        return response;
    }

}
