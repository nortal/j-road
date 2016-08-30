package com.nortal.jroad.client.rrv5;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rrv5.database.RrV5XRoadDatabase;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.*;
import com.nortal.jroad.client.service.MetaserviceOperations;
import com.nortal.jroad.client.service.callback.v3.XroadMessageNamespaceStrategyV3_1;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Anti Orgla
 */
@Service("rrv5XTeeService")
public class Rrv5XTeeServiceImpl extends XRoadDatabaseService implements Rrv5XTeeService {

  @Resource
  private RrV5XRoadDatabase rrV5XTeeDatabase;
  private MetaserviceOperations metaserviceOperations;

  @PostConstruct public void setUpCollaborators() {
    metaserviceOperations = new MetaserviceOperations(rrV5XTeeDatabase);
  }

  @Override
  public RR435Response findRR435(String legalCode) throws XTeeServiceConsumptionException {
    RR435 paring = RR435.Factory.newInstance();
    paring.addNewRequest().setIsikukood(legalCode);

    return rrV5XTeeDatabase.rr435V1(paring);
  }

  @Override
  public RR436Response findRR436(List<String> idCodes) throws XTeeServiceConsumptionException {

    String base64 = null;
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ZipOutputStream zipStream = new ZipOutputStream(outputStream);
    ZipEntry entry = new ZipEntry("rr436_idcodes.txt");
    try {
      zipStream.putNextEntry(entry);
      for (String isikukood : idCodes) {
        zipStream.write(isikukood.getBytes("UTF-8"));
        zipStream.write(System.getProperty("line.separator").getBytes("UTF-8"));
      }
      
      zipStream.closeEntry();
      zipStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    byte[] bytes = outputStream.toByteArray();
    base64 = Base64.encodeBase64String(bytes);

    RR436 paring = RR436.Factory.newInstance();
    RR436RequestType request = paring.addNewRequest();
    request.setIsikukoodideArv(String.valueOf(idCodes.size()));
    request.setCFailiSisu(base64);

    return rrV5XTeeDatabase.rr436V1(paring);
  }
  
  @Override
  public RR71FailDownloadResponse findRR71(String orderNr) throws XTeeServiceConsumptionException {
    RR71FailDownload paring = RR71FailDownload.Factory.newInstance();
    paring.addNewRequest().setCFailiNimi(orderNr);

    RR71FailDownloadResponse response = rrV5XTeeDatabase.rr71FailDownloadV1(paring);
    return response;
  }

  @Override
  public Integer getState() throws XTeeServiceConsumptionException {
       return metaserviceOperations.getState(new XroadMessageNamespaceStrategyV3_1());
  }
}
