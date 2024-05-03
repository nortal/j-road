package com.nortal.jroad.client.kirstv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kirstv6.database.KirstXRoadDatabase;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2RequestType;
import com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2ResponseType;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.nortal.jroad.client.kirstv6.types.eu.x_road.kirst.Kindlustused2Document.Kindlustused2;

/**
 * @author Merilyn Renser
 */
@Service("kirstv6XTeeService")
public class Kirstv6XTeeServiceImpl extends XRoadDatabaseService implements Kirstv6XTeeService {

  @Resource
  private KirstXRoadDatabase kirstXRoadDatabase;

  @Override
  public Kindlustused2ResponseType findKindlustused2(String isikukood, String userId) throws XRoadServiceConsumptionException {
    Kindlustused2 request = createKindlustused2Request(isikukood);
    return kirstXRoadDatabase.kindlustused2V1(request, userId).getResponse();
  }

  private Kindlustused2 createKindlustused2Request(String isikukood) {
    Kindlustused2RequestType requestType = Kindlustused2RequestType.Factory.newInstance();
    requestType.setIsikukood(isikukood);

    Kindlustused2 request = Kindlustused2.Factory.newInstance();
    request.setRequest(requestType);
    return request;
  }
}
