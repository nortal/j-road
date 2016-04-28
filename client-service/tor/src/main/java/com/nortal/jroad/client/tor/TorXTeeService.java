package com.nortal.jroad.client.tor;

import java.util.Date;

import javax.activation.DataHandler;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKDocument;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.DownloadMimeResponseDocument.DownloadMimeResponse;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.TORIKResponseDocument.TORIKResponse;
import com.nortal.jroad.client.tor.types.ee.x_road.emtav5.producer.UploadMimeResponseDocument.UploadMimeResponse;
import com.nortal.jroad.model.XRoadMessage;
/**
 * <code>TOR</code> database X-tee service<br>
 * 
 * @author Eneli Reimets
 */
public interface TorXTeeService {

  /**
   * <code>emtav5.TORIK</code> service.
   */
  TORIKResponse findTorik(String paringuLiik, Date tootAlgusKp, Date tootLoppKp, String isikukood)
      throws XRoadServiceConsumptionException;
  
  /**
   * <code>emtav5.downloadMime</code> service.
   */
  XRoadMessage<DownloadMimeResponse> downloadMime(String target) throws XRoadServiceConsumptionException;
  
  /**
   * <code>emtav5.uploadMime</code> service.
   */
  UploadMimeResponse uploadMime(String target, String operation, String id, DataHandler fail)
      throws XRoadServiceConsumptionException;
  
  TORIKDocument getTorikRequest(String paringuLiik, Date tootAlgusKp, Date tootLoppKp, String isikukood);

}
