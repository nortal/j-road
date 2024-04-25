package com.nortal.jroad.client.statistikaamet;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.client.statistikaamet.database.StatV6XRoadDatabase;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.*;
import jakarta.activation.DataHandler;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Kristjan Hendrik Küngas (KristjanHendrik.Kyngas@nortal.com)
 */
@Service("estatXRoadService")
public class EstatXRoadServiceImpl extends XRoadDatabaseService implements EstatXRoadService {

  @Resource
  private StatV6XRoadDatabase statV6XRoadDatabase;

  @Override
  public SubmitDataResponse submitData(String filename, DataHandler data, boolean validationOnly)
      throws XTeeServiceConsumptionException {
    SubmitDataRequest request = SubmitDataRequest.Factory.newInstance();

    request.setXSDValidationOnly(validationOnly ? 1 : 0);
    request.setDataFile("cid:" + filename);
    request.setDataFileHandler(data);

    return statV6XRoadDatabase.submitDataV1(request);
  }

  @Override
  public ReturnDataResponse returnData(String submitId) throws XTeeServiceConsumptionException {
    ReturnDataRequest request = ReturnDataRequest.Factory.newInstance();
    request.setSubmitId(submitId);
    return statV6XRoadDatabase.returnDataV1(request);
  }

  @Override
  public ReturnErrorResponse returnError(String submitId) throws XTeeServiceConsumptionException {
    ReturnErrorRequest request = ReturnErrorRequest.Factory.newInstance();
    request.setSubmitId(submitId);
    return statV6XRoadDatabase.returnErrorV1(request);
  }
}
