package ee.webmedia.xtee.client.koodikeskus;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.koodikeskus.database.KoodikeskusXTeeDatabase;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.ATCKlassifikaator;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.ArrayOfString;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.DateNotRequired;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Haigus;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Hinnakokkulepe;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Myygiluba;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Pakend;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Piirhind;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.PakendidRequest;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.RavimiLiik;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Ravimvorm;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.RetseptinoueLiik;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Soodustus;
import ee.webmedia.xtee.client.koodikeskus.types.ee.riik.xtee.koodikeskus.producers.producer.koodikeskus.Toimeaine;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@webmedia.ee)
 */
@Service("koodikeskusXTeeService")
public class KoodikeskusXTeeServiceImpl extends XTeeDatabaseService implements KoodikeskusXTeeService {

  private static final String ATC_KLASSIFIKAATORID = "ATCKlassifikaatorid";
  private static final String HAIGUSED = "haigused";
  private static final String RAVIMVORMID = "ravimvormid";
  private static final String SOODUSTUSED = "soodustused";
  private static final String TOIMEAINED = "toimeained";
  private static final String PIIRHINNAD = "piirhinnad";
  private static final String HINNAKOKKULEPPED = "hinnakokkulepped";
  private static final String MYYGILOAD = "myygiload";

  @Resource
  private KoodikeskusXTeeDatabase koodikeskusXTeeDatabase;


  @Override
  public List<ATCKlassifikaator> findATCKlassifikaatoridDetailandmedv1(List<String> items)
      throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);

    return koodikeskusXTeeDatabase.atcKlassifikaatoridByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findATCKlassifikaatoridv1(Date date) throws XTeeServiceConsumptionException {
    return makeListRequest(date, ATC_KLASSIFIKAATORID);
  }

  @Override
  public List<Haigus> findHaigusedDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXTeeDatabase.haigusedByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findHaigusedv1(Date date) throws XTeeServiceConsumptionException {
    return makeListRequest(date, HAIGUSED);
  }

  @Override
  public List<Pakend> findPakendidDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXTeeDatabase.pakendidByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findPakendidv1(Date date) throws XTeeServiceConsumptionException {
    PakendidRequest request = PakendidRequest.Factory.newInstance();
    DateNotRequired alatesKp = DateNotRequired.Factory.newInstance();
    setRequestStartDate(date, alatesKp);
    request.setMuudatusedAlates(alatesKp);
    request.setRavimiLiik(RavimiLiik.INIM);
    request.setRetseptinoueLiik(RetseptinoueLiik.KXIK);

    return koodikeskusXTeeDatabase.pakendidV1(request).getItemList();
  }

  @Override
  public List<Ravimvorm> findRavimvormidDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXTeeDatabase.ravimvormidByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findRavimvormidv1(Date date) throws XTeeServiceConsumptionException {
    return makeListRequest(date, RAVIMVORMID);
  }

  @Override
  public List<Soodustus> findSoodustusedDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXTeeDatabase.soodustusedByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findSoodustusedv1(Date date) throws XTeeServiceConsumptionException {
    return makeListRequest(date, SOODUSTUSED);
  }

  @Override
  public List<Toimeaine> findToimeainedDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXTeeDatabase.toimeainedByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findToimeainedv1(Date date) throws XTeeServiceConsumptionException {
    return makeListRequest(date, TOIMEAINED);
  }

  @Override
  public List<String> findPiirhinnadv1(Date date) throws XTeeServiceConsumptionException {
    return makeListRequest(date, PIIRHINNAD);
  }

  @Override
  public List<Piirhind> findPiirhinnadDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXTeeDatabase.piirhinnadByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findHinnakokkuleppedv1(Date date) throws XTeeServiceConsumptionException {
    return makeListRequest(date, HINNAKOKKULEPPED);
  }

  @Override
  public List<Hinnakokkulepe> findHinnakokkuleppedDetailandmedv1(List<String> items)
      throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXTeeDatabase.hinnakokkuleppedByIDArrayV1(request).getItemList();
  }

  @Override
  public List<String> findMyygiloadv1(Date date) throws XTeeServiceConsumptionException {
    return makeListRequest(date, MYYGILOAD);
  }

  @Override
  public List<Myygiluba> findMyygiloadDetailandmedv1(List<String> items) throws XTeeServiceConsumptionException {
    ArrayOfString request = createDetailsRequest(items);
    return koodikeskusXTeeDatabase.myygiloadByIDArrayV1(request).getItemList();
  }

  private ArrayOfString createDetailsRequest(List<String> items) {
    ArrayOfString request = ArrayOfString.Factory.newInstance();
    request.setArrayType("xsd:string[]");
    String[] itemsArray = new String[items.size()];
    request.setItemArray(items.toArray(itemsArray));
    return request;
  }

  private List<String> makeListRequest(Date date, String serviceName) throws XTeeServiceConsumptionException {
    DateNotRequired request = DateNotRequired.Factory.newInstance();
    setRequestStartDate(date, request);
    XTeeMessage<ArrayOfString> response = send(new XmlBeansXTeeMessage<DateNotRequired>(request), serviceName);
    return response.getContent().getItemList();
  }

  private void setRequestStartDate(Date date, DateNotRequired request) {
    if (date != null) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      request.setKuupaev(calendar);
    }
  }


  public void setKoodikeskusXTeeDatabase(KoodikeskusXTeeDatabase koodikeskusXTeeDatabase) {
    this.koodikeskusXTeeDatabase = koodikeskusXTeeDatabase;
  }

}
