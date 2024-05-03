package com.nortal.jroad.client.mkrliidesuploader;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.mkrliidesuploader.database.MkrliidesuploaderXRoadDatabase;
import com.nortal.jroad.client.mkrliidesuploader.types.eu.x_road.emta_v6.*;
import com.nortal.jroad.client.mkrliidesuploader.types.eu.x_road.emta_v6.DownloadMimeResponseDocument
.DownloadMimeResponse;
import com.nortal.jroad.client.mkrliidesuploader.types.eu.x_road.emta_v6.UploadMimeResponseDocument.UploadMimeResponse;
import com.nortal.jroad.client.service.BaseXRoadDatabaseService;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadAttachment;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import com.nortal.jroad.util.AttachmentUtil;

import java.util.List;
import jakarta.activation.DataHandler;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

/**
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
public class MkrliidesuploaderXRoadServiceImpl extends XRoadDatabaseService implements MkrliidesuploaderXRoadService {

  private static final String UPLOAD_ID = "UPLOAD_ID";
  private static final String METHOD_DOWNLOAD_MIME = "downloadMime";
  private static final String METHOD_UPLOAD_MIME = "uploadMime";
  private static final String V1 = "v1";

  @Resource
  private MkrliidesuploaderXRoadDatabase mkrliidesuploaderXRoadDatabase;

/*  @PostConstruct
  public void init() {
    mkrliidesuploaderXRoadDatabase.setDatabase("emta-v6");
  }*/

  @Override
  public XRoadMessage<DownloadMimeResponse> downloadMime(String target)
      throws XRoadServiceConsumptionException {
    DownloadMimeDocument.DownloadMime downloadMimeDocument = DownloadMimeDocument.DownloadMime.Factory.newInstance();

    DownloadMimeRequestType request = downloadMimeDocument.addNewRequest();
    request.setTarget(target);

    return send(new XmlBeansXRoadMessage<>(downloadMimeDocument), METHOD_DOWNLOAD_MIME, V1);
  }

  @Override
  public UploadMimeResponse uploadMime(String target,
                                                                  String operation,
                                                                  String id,
                                                                  DataHandler fail)
      throws XRoadServiceConsumptionException {
    UploadMimeDocument.UploadMime uploadMimeDocument = UploadMimeDocument.UploadMime.Factory.newInstance();

    UploadMimeRequestType request = uploadMimeDocument.addNewRequest();
    request.setTarget(target);
    request.setOperation(operation);
    Properties props = request.addNewProps();
    Properties.Prop prop = props.addNewProp();
    prop.setKey(UPLOAD_ID);
    prop.setStringValue(id);

    XmlBeansXRoadMessage<UploadMimeDocument.UploadMime> XRoadMessage =
      new XmlBeansXRoadMessage<>(uploadMimeDocument);
    List<XRoadAttachment> attachments = XRoadMessage.getAttachments();

    String failCid = AttachmentUtil.getUniqueCid();
    request.addNewFile().setHref("cid:" + failCid);
    attachments.add(new XRoadAttachment(failCid, fail));

    XRoadMessage<UploadMimeResponse> response = send(XRoadMessage, METHOD_UPLOAD_MIME, V1);
    return response.getContent();
  }

}
