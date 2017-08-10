package com.nortal.jroad.client.statistikaamet;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.client.statistikaamet.database.StatV6XRoadDatabase;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.ReturnDataDocument;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.ReturnDataRequest;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.ReturnDataResponse;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.ReturnErrorDocument;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.ReturnErrorRequest;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.ReturnErrorResponse;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.SubmitDataDocument;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.SubmitDataRequest;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.SubmitDataResponse;
import javax.activation.DataHandler;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Kristjan Hendrik Küngas (KristjanHendrik.Kyngas@nortal.com)
 */
@Service("statV6XRoadService")
public class StatV6XRoadServiceImpl extends XRoadDatabaseService implements StatV6XRoadService {

  @Resource
  private StatV6XRoadDatabase statV6XRoadDatabase;

  @Override
  public SubmitDataResponse submitData(String filename, DataHandler data, int validationOnly)
      throws XTeeServiceConsumptionException {
    SubmitDataDocument.SubmitData submitData = SubmitDataDocument.SubmitData.Factory.newInstance();
    SubmitDataRequest body = submitData.addNewKeha();

    body.setXSDValidationOnly(validationOnly);
    body.setDataFile("cid:".concat(filename));
    body.setDataFileHandler(data);

    return statV6XRoadDatabase.submitDataV1(submitData);
  }

  @Override
  public ReturnDataResponse returnData(String submitId) throws XTeeServiceConsumptionException {
    ReturnDataDocument.ReturnData returnData = ReturnDataDocument.ReturnData.Factory.newInstance();
    ReturnDataRequest body = returnData.addNewKeha();
    body.setSubmitId(submitId);
    return statV6XRoadDatabase.returnDataV1(returnData);
  }

  @Override
  public ReturnErrorResponse returnError(String submitId) throws XTeeServiceConsumptionException {
    ReturnErrorDocument.ReturnError returnError = ReturnErrorDocument.ReturnError.Factory.newInstance();
    ReturnErrorRequest body = returnError.addNewKeha();
    body.setSubmitId(submitId);
    return statV6XRoadDatabase.returnErrorV1(returnError);
  }
}
