package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kvkr.types.ee.x_road.kvkr.producer.ServiceinfoDocument.Serviceinfo;
import com.nortal.jroad.client.kvkr.types.ee.x_road.kvkr.producer.ServiceinfoResponseDocument.ServiceinfoResponse;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import org.springframework.stereotype.Service;

@Service("kvkrXTeeService")
public class KvkrXTeeServiceImpl extends XRoadDatabaseService implements KvkrXTeeService {

  public ServiceinfoResponse getServiceinfoV1(String nationalIdCode, String queryGrounds) throws XRoadServiceConsumptionException {
    Serviceinfo serviceinfo = Serviceinfo.Factory.newInstance();
    Serviceinfo.Request request = serviceinfo.addNewRequest();
    request.setNationalId(nationalIdCode);
    request.setQueryGrounds(queryGrounds);

    XRoadMessage<ServiceinfoResponse> response = send(new XmlBeansXRoadMessage<Serviceinfo>(serviceinfo), "serviceinfo", "v1");
    return response.getContent();
  }

}