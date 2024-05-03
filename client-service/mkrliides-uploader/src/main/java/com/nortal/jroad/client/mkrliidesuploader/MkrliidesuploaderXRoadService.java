package com.nortal.jroad.client.mkrliidesuploader;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.mkrliidesuploader.types.eu.x_road.emta_v6.DownloadMimeResponseDocument
.DownloadMimeResponse;
import com.nortal.jroad.client.mkrliidesuploader.types.eu.x_road.emta_v6.UploadMimeResponseDocument.UploadMimeResponse;
import com.nortal.jroad.model.XRoadMessage;

import jakarta.activation.DataHandler;

/**
 * mkrliides-uploader namespace in wsdl is emta-v6
 *
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
public interface MkrliidesuploaderXRoadService {

  /**
   * <code>mkrliides.downloadMime.v1</code> service.
   */
  XRoadMessage<DownloadMimeResponse> downloadMime(String target)
      throws XRoadServiceConsumptionException;

  /**
   * <code>mkrliides.uploadMime.v1</code> service.
   */
  UploadMimeResponse uploadMime(String target, String operation, String id, DataHandler fail)
      throws XRoadServiceConsumptionException;

}
