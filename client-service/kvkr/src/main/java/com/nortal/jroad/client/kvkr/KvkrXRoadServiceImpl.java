package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kvkr.types.eu.x_road.kvkr.ServiceinfoDocument;
import com.nortal.jroad.client.kvkr.types.eu.x_road.kvkr.ServiceinfoResponseDocument;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import org.springframework.stereotype.Service;

@Service("kvkrXRoadService")
public class KvkrXRoadServiceImpl extends XRoadDatabaseService implements KvkrXRoadService {

    public ServiceinfoResponseDocument.ServiceinfoResponse getServiceinfoV1(String nationalIdCode,
                                                                            String queryGrounds) throws XRoadServiceConsumptionException {
        ServiceinfoDocument.Serviceinfo serviceinfo = ServiceinfoDocument.Serviceinfo.Factory.newInstance();
        ServiceinfoDocument.Serviceinfo.Request request = serviceinfo.addNewRequest();
        request.setNationalId(nationalIdCode);
        request.setQueryGrounds(queryGrounds);

        XRoadMessage<ServiceinfoResponseDocument.ServiceinfoResponse> response =
                send(new XmlBeansXRoadMessage<ServiceinfoDocument.Serviceinfo>(serviceinfo), "serviceinfo", "v1");
        return response.getContent();
    }

}
