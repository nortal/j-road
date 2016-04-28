package com.nortal.jroad.client.koodikeskus;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.koodikeskus.database.KoodikeskusXRoadDatabase;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.ATCKlassifikaator;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.ArrayOfString;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.DateNotRequired;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Haigus;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Hinnakokkulepe;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Myygiluba;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Pakend;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.PakendidRequest;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Piirhind;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.RavimiLiik;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Ravimvorm;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.RetseptinoueLiik;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Soodustus;
import com.nortal.jroad.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Toimeaine;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
@Service("koodikeskusXTeeService")
public class KoodikeskusXTeeServiceImpl extends XRoadDatabaseService implements KoodikeskusXTeeService {

  private static final String ATC_KLASSIFIKAATORID = "ATCKlassifikaatorid";
  private static final String HAIGUSED = "haigused";
  private static final String RAVIMVORMID = "ravimvormid";
  private static final String SOODUSTUSED = "soodustused";
  private static final String TOIMEAINED = "toimeained";
  private static final String PIIRHINNAD = "piirhinnad";
  private static final String HINNAKOKKULEPPED = "hinnakokkulepped";
  private static final String MYYGILOAD = "myygiload";

  @Resource
  private KoodikeskusXRoadDatabase koodikeskusXRoadDatabase;


  @Override
  public List<ATCKlassifikaator> findATCKlassifikaatoridDetailandmedv1(List<String> items)
      throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);

    return koodikeskusXRoadDatabase.atcKlassifikaatoridByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findATCKlassifikaatoridv1(Date date) throws XRoadServiceConsumptionException {
    return makeListRequest(date, ATC_KLASSIFIKAATORID);
  }

  @Override
  public List<Haigus> findHaigusedDetailandmedv1(List<String> items) throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXRoadDatabase.haigusedByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findHaigusedv1(Date date) throws XRoadServiceConsumptionException {
    return makeListRequest(date, HAIGUSED);
  }

  @Override
  public List<Pakend> findPakendidDetailandmedv1(List<String> items) throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXRoadDatabase.pakendidByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findPakendidv1(Date date) throws XRoadServiceConsumptionException {
    PakendidRequest request = PakendidRequest.Factory.newInstance();
    DateNotRequired alatesKp = DateNotRequired.Factory.newInstance();
    setRequestStartDate(date, alatesKp);
    request.setMuudatusedAlates(alatesKp);
    request.setRavimiLiik(RavimiLiik.INIM);
    request.setRetseptinoueLiik(RetseptinoueLiik.KXIK);

    return koodikeskusXRoadDatabase.pakendidV1(request).getItemList();
  }

  @Override
  public List<Ravimvorm> findRavimvormidDetailandmedv1(List<String> items) throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXRoadDatabase.ravimvormidByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findRavimvormidv1(Date date) throws XRoadServiceConsumptionException {
    return makeListRequest(date, RAVIMVORMID);
  }

  @Override
  public List<Soodustus> findSoodustusedDetailandmedv1(List<String> items) throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXRoadDatabase.soodustusedByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findSoodustusedv1(Date date) throws XRoadServiceConsumptionException {
    return makeListRequest(date, SOODUSTUSED);
  }

  @Override
  public List<Toimeaine> findToimeainedDetailandmedv1(List<String> items) throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXRoadDatabase.toimeainedByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findToimeainedv1(Date date) throws XRoadServiceConsumptionException {
    return makeListRequest(date, TOIMEAINED);
  }

  @Override
  public List<String> findPiirhinnadv1(Date date) throws XRoadServiceConsumptionException {
    return makeListRequest(date, PIIRHINNAD);
  }

  @Override
  public List<Piirhind> findPiirhinnadDetailandmedv1(List<String> items) throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXRoadDatabase.piirhinnadByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findHinnakokkuleppedv1(Date date) throws XRoadServiceConsumptionException {
    return makeListRequest(date, HINNAKOKKULEPPED);
  }

  @Override
  public List<Hinnakokkulepe> findHinnakokkuleppedDetailandmedv1(List<String> items)
      throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXRoadDatabase.hinnakokkuleppedByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findMyygiloadv1(Date date) throws XRoadServiceConsumptionException {
    return makeListRequest(date, MYYGILOAD);
  }

  @Override
  public List<Myygiluba> findMyygiloadDetailandmedv1(List<String> items) throws XRoadServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXRoadDatabase.myygiloadByIDArrayV1(request).getItemList();
  }

  private ArrayOfString createDetailsRequest(List<String> items) {
    ArrayOfString request = ArrayOfString.Factory.newInstance();
    request.setArrayType("xsd:string[]");
    String[] itemsArray = new String[items.size()];
    request.setItemArray(items.toArray(itemsArray));
    return request;
  }

  private List<String> makeListRequest(Date date, String serviceName) throws XRoadServiceConsumptionException {
    DateNotRequired request = DateNotRequired.Factory.newInstance();
    setRequestStartDate(date, request);
    XRoadMessage<ArrayOfString> response = send(new XmlBeansXRoadMessage<DateNotRequired>(request), serviceName);
    return response.getContent().getItemList();
  }

  private void setRequestStartDate(Date date, DateNotRequired request) {
    if (date != null) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      request.setKuupaev(calendar);
    }
  }


  public void setKoodikeskusXRoadDatabase(KoodikeskusXRoadDatabase koodikeskusXRoadDatabase) {
    this.koodikeskusXRoadDatabase = koodikeskusXRoadDatabase;
  }

}
