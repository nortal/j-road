package com.nortal.jroad.client.rrv5;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv5.database.Rrv5XRoadDatabase;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR435;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR435Response;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR436;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR436RequestType;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR436Response;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR71FailDownload;
import com.nortal.jroad.client.rrv5.types.ee.x_road.rr_v5.producer.RR71FailDownloadResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.annotation.Resource;

import com.nortal.jroad.client.service.XRoadDatabaseService;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Anti Orgla
 */
@Service("rrv5XTeeService")
public class Rrv5XTeeServiceImpl extends XRoadDatabaseService implements Rrv5XTeeService {

  @Resource
  private Rrv5XRoadDatabase rrV5XRoadDatabase;

  @Override
  public RR435Response findRR435(String legalCode) throws XRoadServiceConsumptionException {
    RR435 paring = RR435.Factory.newInstance();
    paring.addNewRequest().setIsikukood(legalCode);

    return rrV5XRoadDatabase.rr435V1(paring);

  }

  @Override
  public RR436Response findRR436(List<String> idCodes) throws XRoadServiceConsumptionException {

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

    return rrV5XRoadDatabase.rr436V1(paring);
  }
  
  @Override
  public RR71FailDownloadResponse findRR71(String orderNr) throws XRoadServiceConsumptionException {
    RR71FailDownload paring = RR71FailDownload.Factory.newInstance();
    paring.addNewRequest().setCFailiNimi(orderNr);

    RR71FailDownloadResponse response = rrV5XRoadDatabase.rr71FailDownloadV1(paring);
    return response;

  }
}
