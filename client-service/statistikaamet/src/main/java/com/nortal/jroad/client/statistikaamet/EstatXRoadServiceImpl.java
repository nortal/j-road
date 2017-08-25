package com.nortal.jroad.client.statistikaamet;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.client.statistikaamet.database.EstatXRoadDatabase;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.ReturnDataRequest;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.ReturnDataRequestDocument;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.ReturnDataResponse;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.ReturnErrorRequest;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.ReturnErrorRequestDocument;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.ReturnErrorResponse;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.SubmitDataRequest;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.SubmitDataRequestDocument;
import com.nortal.jroad.client.statistikaamet.types.ee.riik.xtee.estat.producers.producer.estat.SubmitDataResponse;
import javax.activation.DataHandler;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Kristjan Hendrik Küngas (KristjanHendrik.Kyngas@nortal.com)
 */
@Service("estatXRoadService")
public class EstatXRoadServiceImpl extends XRoadDatabaseService implements EstatXRoadService {

  @Resource
  private EstatXRoadDatabase estatXRoadDatabase;

  @Override
  public SubmitDataResponse submitData(String filename, DataHandler data, boolean validationOnly)
      throws XTeeServiceConsumptionException {
    SubmitDataRequest request = SubmitDataRequestDocument.Factory.newInstance().addNewSubmitDataRequest();

    request.setXSDValidationOnly(validationOnly ? 1 : 0);
    request.setDataFile("cid:".concat(filename));
    request.setDataFileHandler(data);

    return estatXRoadDatabase.submitDataV1(request);
  }

  @Override
  public ReturnDataResponse returnData(String submitId) throws XTeeServiceConsumptionException {
    ReturnDataRequest request = ReturnDataRequestDocument.Factory.newInstance().addNewReturnDataRequest();
    request.setSubmitId(submitId);
    return estatXRoadDatabase.returnDataV1(request);
  }

  @Override
  public ReturnErrorResponse returnError(String submitId) throws XTeeServiceConsumptionException {
    ReturnErrorRequest request = ReturnErrorRequestDocument.Factory.newInstance().addNewReturnErrorRequest();
    request.setSubmitId(submitId);
    return estatXRoadDatabase.returnErrorV1(request);
  }
}
