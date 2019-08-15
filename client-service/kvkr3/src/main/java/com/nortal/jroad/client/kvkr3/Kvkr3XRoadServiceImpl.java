package com.nortal.jroad.client.kvkr3;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;


import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.ServiceInfoV1Document;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.ServiceInfoV1Paring;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.ServiceInfoV1ResponseDocument;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.springframework.stereotype.Service;

@Service("kvkr3XRoadService")
public class Kvkr3XRoadServiceImpl extends XRoadDatabaseService implements Kvkr3XRoadService {

  public ServiceInfoV1ResponseDocument.ServiceInfoV1Response getServiceinfoV1(String nationalIdCode,
                                                                              String queryGrounds) throws XTeeServiceConsumptionException {
    ServiceInfoV1Document.ServiceInfoV1 serviceinfo = ServiceInfoV1Document.ServiceInfoV1.Factory.newInstance();
    ServiceInfoV1Paring request = serviceinfo.addNewRequest();
    request.setNationalId(nationalIdCode);
    request.setQueryGrounds(queryGrounds);
    XTeeMessage<ServiceInfoV1ResponseDocument> response =
            send(new XmlBeansXTeeMessage<ServiceInfoV1Document.ServiceInfoV1>(serviceinfo), "service_info_v1", "v1");
    return response.getContent().getServiceInfoV1Response();
  }
}
