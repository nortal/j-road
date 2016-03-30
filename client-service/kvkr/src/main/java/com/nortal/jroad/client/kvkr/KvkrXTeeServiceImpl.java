package com.nortal.jroad.client.kvkr;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kvkr.types.ee.x_road.kvkr.producer.ServiceinfoDocument.Serviceinfo;
import com.nortal.jroad.client.kvkr.types.ee.x_road.kvkr.producer.ServiceinfoResponseDocument.ServiceinfoResponse;
import com.nortal.jroad.client.service.v3.XRoadDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.springframework.stereotype.Service;

@Service("kvkrXTeeService")
public class KvkrXTeeServiceImpl extends XRoadDatabaseService implements KvkrXTeeService {

  public ServiceinfoResponse getServiceinfoV1(String nationalIdCode, String queryGrounds) throws XTeeServiceConsumptionException {
    Serviceinfo serviceinfo = Serviceinfo.Factory.newInstance();
    Serviceinfo.Request request = serviceinfo.addNewRequest();
    request.setNationalId(nationalIdCode);
    request.setQueryGrounds(queryGrounds);

    XTeeMessage<ServiceinfoResponse> response = send(new XmlBeansXTeeMessage<Serviceinfo>(serviceinfo), "serviceinfo", "v1");
    return response.getContent();
  }

}