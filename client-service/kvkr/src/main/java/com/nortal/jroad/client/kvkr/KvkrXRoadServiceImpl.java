package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kvkr.types.eu.x_road.kvkr.ServiceinfoDocument;
import com.nortal.jroad.client.kvkr.types.eu.x_road.kvkr.ServiceinfoResponseDocument;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.springframework.stereotype.Service;

@Service("kvkrXRoadService")
public class KvkrXRoadServiceImpl extends XRoadDatabaseService implements KvkrXRoadService {

    public ServiceinfoResponseDocument.ServiceinfoResponse getServiceinfoV1(String nationalIdCode,
                                                                            String queryGrounds) throws XTeeServiceConsumptionException {
        ServiceinfoDocument.Serviceinfo serviceinfo = ServiceinfoDocument.Serviceinfo.Factory.newInstance();
        ServiceinfoDocument.Serviceinfo.Request request = serviceinfo.addNewRequest();
        request.setNationalId(nationalIdCode);
        request.setQueryGrounds(queryGrounds);

        XTeeMessage<ServiceinfoResponseDocument.ServiceinfoResponse> response =
                send(new XmlBeansXTeeMessage<ServiceinfoDocument.Serviceinfo>(serviceinfo), "serviceinfo", "v1");
        return response.getContent();
    }

}