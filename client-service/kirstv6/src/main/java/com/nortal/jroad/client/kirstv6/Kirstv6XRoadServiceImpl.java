package com.nortal.jroad.client.kirstv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kirstv6.database.KirstXRoadDatabase;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.KindlustusParingType;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2RequestType;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2ResponseType;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2Document.Kindlustused2;

/**
 * @author Merilyn Renser
 */
@Service("kirstv6XRoadService")
public class Kirstv6XRoadServiceImpl extends XRoadDatabaseService implements Kirstv6XRoadService {

  @Resource
  private KirstXRoadDatabase kirstXRoadDatabase;

  @Override
  public Kindlustused2ResponseType findKindlustused2V1(String isikukood, String userId,
                                                       KindlustusParingType.Enum paringType)
      throws XRoadServiceConsumptionException {
    Kindlustused2 request = createKindlustused2Request(isikukood, paringType);
    return kirstXRoadDatabase.kindlustused2V1(request, userId).getResponse();
  }

  private Kindlustused2 createKindlustused2Request(String isikukood, KindlustusParingType.Enum paringType) {
    Kindlustused2RequestType requestType = Kindlustused2RequestType.Factory.newInstance();
    requestType.setIsikukood(isikukood);
    requestType.setTyyp(paringType);

    Kindlustused2 request = Kindlustused2.Factory.newInstance();
    request.setRequest(requestType);
    return request;
  }
}
