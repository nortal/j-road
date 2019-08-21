package com.nortal.jroad.client.kvkr3;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kvkr3.database.Kvkr3XRoadDatabase;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.producer.ServiceInfoV1;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.producer.ServiceInfoV1Paring;
import com.nortal.jroad.client.kvkr3.types.eu.x_road.kvkr3.producer.ServiceInfoV1Response;
import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Service("kvkr3XRoadService")
public class Kvkr3XRoadServiceImpl implements Kvkr3XRoadService {

  private static final String KVKR_NAMESPACE = "http://kvkr3.x-road.eu/producer/";


  @Resource
  private Kvkr3XRoadDatabase kvkr3XRoadDatabase;

  public ServiceInfoV1Response getServiceinfoV1(String nationalIdCode,
                                                String queryGrounds) throws XTeeServiceConsumptionException {
    ServiceInfoV1 request = ServiceInfoV1.Factory.newInstance();
    ServiceInfoV1Paring serviceInfoV1Paring = ServiceInfoV1Paring.Factory.newInstance();
    serviceInfoV1Paring.setNationalId(nationalIdCode);
    serviceInfoV1Paring.setQueryGrounds(queryGrounds);
    request.setRequest(serviceInfoV1Paring);

    XTeeMessage<ServiceInfoV1Response> response =
            kvkr3XRoadDatabase.send(new XmlBeansXTeeMessage<ServiceInfoV1>(request),
                    "service_info_v1", "v1",
                    null,
                    new KvkrExtractor());
    return response.getContent();
  }

  public class KvkrExtractor extends CustomExtractor<XTeeMessage<XmlObject>> {

    @Override
    public XTeeMessage<XmlObject> extractData(WebServiceMessage webServiceMessage)
            throws IOException, TransformerException {
      XTeeMessage<XmlObject> response = extractor.extractData(webServiceMessage);
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
