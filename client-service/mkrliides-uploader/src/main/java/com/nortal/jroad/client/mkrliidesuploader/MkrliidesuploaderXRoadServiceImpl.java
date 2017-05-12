package com.nortal.jroad.client.mkrliidesuploader;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.mkrliidesuploader.database.MkrliidesuploaderXRoadDatabase;
import com.nortal.jroad.client.mkrliidesuploader.types.eu.x_road.emta_v6.*;
import com.nortal.jroad.client.mkrliidesuploader.types.eu.x_road.emta_v6.DownloadMimeResponseDocument
.DownloadMimeResponse;
import com.nortal.jroad.client.mkrliidesuploader.types.eu.x_road.emta_v6.UploadMimeResponseDocument.UploadMimeResponse;
import com.nortal.jroad.model.XTeeAttachment;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import com.nortal.jroad.util.AttachmentUtil;

import java.util.List;
import javax.activation.DataHandler;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
public class MkrliidesuploaderXRoadServiceImpl implements MkrliidesuploaderXRoadService {

  private static final String UPLOAD_ID = "UPLOAD_ID";
  private static final String METHOD_DOWNLOAD_MIME = "downloadMime";
  private static final String METHOD_UPLOAD_MIME = "uploadMime";
  private static final String V1 = "v1";

  @Resource
  private MkrliidesuploaderXRoadDatabase mkrliidesuploaderXRoadDatabase;

  @PostConstruct
  public void init() {
    mkrliidesuploaderXRoadDatabase.setDatabase("emta-v6");
  }

  @Override
  public XTeeMessage<DownloadMimeResponse> downloadMime(String target)
      throws XTeeServiceConsumptionException {
    DownloadMimeDocument.DownloadMime downloadMimeDocument = DownloadMimeDocument.DownloadMime.Factory.newInstance();

    DownloadMimeRequestType request = downloadMimeDocument.addNewRequest();
    request.setTarget(target);

    XTeeMessage<DownloadMimeResponse> response =
        mkrliidesuploaderXRoadDatabase.send(new XmlBeansXTeeMessage<DownloadMimeDocument.DownloadMime>(downloadMimeDocument),
                                            METHOD_DOWNLOAD_MIME,
                                            V1);

    return response;
  }

  @Override
  public UploadMimeResponse uploadMime(String target,
                                                                  String operation,
                                                                  String id,
                                                                  DataHandler fail)
      throws XTeeServiceConsumptionException {
    UploadMimeDocument.UploadMime uploadMimeDocument = UploadMimeDocument.UploadMime.Factory.newInstance();

    UploadMimeRequestType request = uploadMimeDocument.addNewRequest();
    request.setTarget(target);
    request.setOperation(operation);
    Properties props = request.addNewProps();
    Properties.Prop prop = props.addNewProp();
    prop.setKey(UPLOAD_ID);
    prop.setStringValue(id);

    XmlBeansXTeeMessage<UploadMimeDocument.UploadMime> xteeMessage =
        new XmlBeansXTeeMessage<UploadMimeDocument.UploadMime>(uploadMimeDocument);
    List<XTeeAttachment> attachments = xteeMessage.getAttachments();

    String failCid = AttachmentUtil.getUniqueCid();
    request.addNewFile().setHref("cid:" + failCid);
    attachments.add(new XTeeAttachment(failCid, fail));

    XTeeMessage<UploadMimeResponse> response = mkrliidesuploaderXRoadDatabase.send(xteeMessage, METHOD_UPLOAD_MIME, V1);

    return response.getContent();
  }

}
