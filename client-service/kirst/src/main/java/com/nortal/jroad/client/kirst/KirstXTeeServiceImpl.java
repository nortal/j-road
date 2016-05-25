package com.nortal.jroad.client.kirst;

import com.nortal.jroad.client.exception.NonTechnicalFaultException;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kirst.types.ee.x_road.kirst.producer.*;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * @author Roman Tekhov
 */
@Service("kirstXTeeService")
public class KirstXTeeServiceImpl extends XRoadDatabaseService implements KirstXTeeService {

  public TvlLoetelu2ResponseType findTvlLoetelu2V1(Set<String> isikukoodid, Date alates, Date kuni) throws XRoadServiceConsumptionException {
    if (CollectionUtils.isEmpty(isikukoodid)) {
      throw new IllegalArgumentException("At least one 'isikukood' must be provided");
    }
    TvlLoetelu2RequestType request = createTvlLoetelu2V1Request(isikukoodid, alates, kuni);
    XRoadMessage<XmlObject> response = send(new XmlBeansXRoadMessage<TvlLoetelu2RequestType>(request), "tvl_loetelu2", "v1");
    try {
      return TvlLoetelu2ResponseType.Factory.parse(response.getContent().xmlText());
    } catch (XmlException e) {
      throw new XRoadServiceConsumptionException(new NonTechnicalFaultException("", "Unable to parse response"), "kirst", "tvl_loetelu2", "v1");
    }
  }

  private TvlLoetelu2RequestType createTvlLoetelu2V1Request(Set<String> isikukoodid, Date alates, Date kuni) {
    TvlLoetelu2RequestType request = TvlLoetelu2RequestType.Factory.newInstance();
    TvlOtsingType isikud = request.addNewIsikud();
    int count = 0;
    TvlOtsingItemType[] items = new TvlOtsingItemType[isikukoodid.size()];
    for (String isikukood : isikukoodid) {
      TvlOtsingItemType item = TvlOtsingItemType.Factory.newInstance();
      item.setTvpAlates(toCalendar(alates));
      item.setTvpKuni(toCalendar(kuni));
      item.setIsikukood(isikukood);
      items[count++] = item;
    }
    isikud.setItemArray(items);
    return request;
  }

  private Calendar toCalendar(Date date) {
    if (date == null) {
      return null;
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal;
  }

}
