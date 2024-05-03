package com.nortal.jroad.client.kvkr3;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kvkr3.database.Kvkr3XRoadDatabase;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.producer.ServiceInfoV1;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.producer.ServiceInfoV1Paring;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.producer.ServiceInfoV1Response;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;

import jakarta.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Service("kvkr3XRoadService")
public class Kvkr3XRoadServiceImpl extends XRoadDatabaseService implements Kvkr3XRoadService {

  private static final String KVKR_NAMESPACE = "http://kvkr3.x-road.eu/producer/";


  @Resource
  private Kvkr3XRoadDatabase kvkr3XRoadDatabase;

  public ServiceInfoV1Response getServiceinfoV1(String nationalIdCode,
                                                String queryGrounds) throws XRoadServiceConsumptionException {
    ServiceInfoV1 request = ServiceInfoV1.Factory.newInstance();
    ServiceInfoV1Paring serviceInfoV1Paring = ServiceInfoV1Paring.Factory.newInstance();
    serviceInfoV1Paring.setNationalId(nationalIdCode);
    serviceInfoV1Paring.setQueryGrounds(queryGrounds);
    request.setRequest(serviceInfoV1Paring);

    XRoadMessage<ServiceInfoV1Response> response =
            send(new XmlBeansXRoadMessage<>(request),
                    "service_info_v1", "v1",
                    null,
              new KvkrExtractor());
    return response.getContent();
  }

  public static class KvkrExtractor extends CustomExtractor<XRoadMessage<XmlObject>> {

    @Override
    public XRoadMessage<XmlObject> extractData(WebServiceMessage webServiceMessage)
            throws IOException, TransformerException {
      XRoadMessage<XmlObject> response = extractor.extractData(webServiceMessage);
      XmlObject content = response.getContent();
      XmlCursor cursor = content.newCursor();
      while (cursor.hasNextToken()) {
        cursor.toNextToken();
        if (cursor.isStart()) {
          QName name = cursor.getName();
          if (StringUtils.isBlank(name.getNamespaceURI())) {
            cursor.setName(new QName(KVKR_NAMESPACE, name.getLocalPart()));
          }
        }
      }
      cursor.dispose();
      return response;
    }
  }

}
