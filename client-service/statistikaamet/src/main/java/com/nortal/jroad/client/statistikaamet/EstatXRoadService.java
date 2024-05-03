package com.nortal.jroad.client.statistikaamet;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.ReturnDataResponse;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.ReturnErrorResponse;
import com.nortal.jroad.client.statistikaamet.types.eu.x_road.stat_v6.SubmitDataResponse;
import jakarta.activation.DataHandler;

/**
 * @author Kristjan Hendrik Küngas (KristjanHendrik.Kyngas@nortal.com)
 */
public interface EstatXRoadService {

  SubmitDataResponse submitData(String filename, DataHandler data, boolean validationOnly)
      throws XRoadServiceConsumptionException;

  ReturnDataResponse returnData(String submitId) throws XRoadServiceConsumptionException;

  ReturnErrorResponse returnError(String submitId) throws XRoadServiceConsumptionException;

}
