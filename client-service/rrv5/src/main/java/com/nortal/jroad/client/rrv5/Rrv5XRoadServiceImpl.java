package com.nortal.jroad.client.rrv5;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv5.database.Rrv5XRoadDatabase;
import com.nortal.jroad.client.rrv5.types.eu.x_road.rr.producer.RR81KMAisikkontrollDocument.RR81KMAisikkontroll;
import com.nortal.jroad.client.rrv5.types.eu.x_road.rr.producer.RR81KMAisikkontrollRequestType;
import com.nortal.jroad.client.rrv5.types.eu.x_road.rr.producer.RR81KMAisikkontrollResponseDocument.RR81KMAisikkontrollResponse;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.util.XmlBeansUtil;
import org.apache.xmlbeans.XmlString;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * @author Anti Orgla
 */
@Service("rrv5XRoadService")
public class Rrv5XRoadServiceImpl extends XRoadDatabaseService implements Rrv5XRoadService {

  @Resource
  private Rrv5XRoadDatabase rrv5XRoadDatabase;

  @Override
  public RR81KMAisikkontrollResponse getRR81KMAisikkontrollV2(String idCode) throws XRoadServiceConsumptionException {
    RR81KMAisikkontroll rr81KMAisikkontroll = RR81KMAisikkontroll.Factory.newInstance();

    RR81KMAisikkontrollRequestType request = rr81KMAisikkontroll.addNewRequest();

    XmlString isikukoodElement = XmlBeansUtil.getAttributedXmlString(idCode);
    request.xsetIsikukood(isikukoodElement);

    return rrv5XRoadDatabase.rr81KMAisikkontrollV2(rr81KMAisikkontroll);
  }

}
