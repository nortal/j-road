package com.nortal.jroad.client.ravimiregister;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ravimiregister.database.KoodikeskusXRoadDatabase;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.ATCKlassifikaator;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.ATCKlassifikaatoridByIDArrayDocument.ATCKlassifikaatoridByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.ATCKlassifikaatoridDocument.ATCKlassifikaatorid;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.ArrayOfString;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.DateNotRequired;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Haigus;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.HaigusedByIDArrayDocument.HaigusedByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.HaigusedDocument.Haigused;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Hinnakokkulepe;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.HinnakokkuleppedByIDArrayDocument.HinnakokkuleppedByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.HinnakokkuleppedDocument.Hinnakokkulepped;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.MyygiloadByIDArrayDocument.MyygiloadByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.MyygiloadDocument.Myygiload;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Myygiluba;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Pakend;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.PakendidByIDArrayDocument.PakendidByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.PakendidDocument.Pakendid;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Piirhind;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.PiirhinnadByIDArrayDocument.PiirhinnadByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.PiirhinnadDocument.Piirhinnad;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.RavimiLiik;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Ravimvorm;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.RavimvormidByIDArrayDocument.RavimvormidByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.RavimvormidDocument.Ravimvormid;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.RetseptinoueLiik;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Soodustus;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.SoodustusedByIDArrayDocument.SoodustusedByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.SoodustusedDocument.Soodustused;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Toimeaine;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.ToimeainedByIDArrayDocument.ToimeainedByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.ToimeainedDocument.Toimeained;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
@Service("ravimiregisterXRoadService")
public class RavimiregisterXRoadServiceImpl extends XRoadDatabaseService implements RavimiregisterXRoadService {

  @Resource
  private KoodikeskusXRoadDatabase koodikeskusXRoadDatabase;

  @Override
  public List<ATCKlassifikaator> findATCKlassifikaatoridDetailandmed(List<String> items)
      throws XRoadServiceConsumptionException {
    ATCKlassifikaatoridByIDArray request = ATCKlassifikaatoridByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.atcKlassifikaatoridByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findATCKlassifikaatorid(Date date) throws XRoadServiceConsumptionException {
    ATCKlassifikaatorid request = ATCKlassifikaatorid.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return koodikeskusXRoadDatabase.atcKlassifikaatoridV1(request).getKeha().getItemList();
  }

  @Override
  public List<Haigus> findHaigusedDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    HaigusedByIDArray request = HaigusedByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.haigusedByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findHaigused(Date date) throws XRoadServiceConsumptionException {
    Haigused request = Haigused.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return koodikeskusXRoadDatabase.haigusedV1(request).getKeha().getItemList();
  }

  @Override
  public List<Pakend> findPakendidDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    PakendidByIDArray request = PakendidByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.pakendidByIDArrayV2(request).getKeha().getItemList();
  }

  @Override
  public List<String> findPakendid(Date date) throws XRoadServiceConsumptionException {
    Pakendid request = Pakendid.Factory.newInstance();
    DateNotRequired alatesKp = DateNotRequired.Factory.newInstance();
    request.addNewKeha();
    setRequestStartDate(date, alatesKp);
    request.getKeha().setMuudatusedAlates(alatesKp);
    request.getKeha().setRavimiLiik(RavimiLiik.INIM);
    request.getKeha().setRetseptinoueLiik(RetseptinoueLiik.KXIK);

    return koodikeskusXRoadDatabase.pakendidV1(request).getKeha().getItemList();
  }

  @Override
  public List<Ravimvorm> findRavimvormidDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    RavimvormidByIDArray request = RavimvormidByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.ravimvormidByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findRavimvormid(Date date) throws XRoadServiceConsumptionException {
    Ravimvormid request = Ravimvormid.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return koodikeskusXRoadDatabase.ravimvormidV1(request).getKeha().getItemList();
  }

  @Override
  public List<Soodustus> findSoodustusedDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    SoodustusedByIDArray request = SoodustusedByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.soodustusedByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findSoodustused(Date date) throws XRoadServiceConsumptionException {
    Soodustused request = Soodustused.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return koodikeskusXRoadDatabase.soodustusedV1(request).getKeha().getItemList();
  }

  @Override
  public List<Toimeaine> findToimeainedDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    ToimeainedByIDArray request = ToimeainedByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.toimeainedByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findToimeained(Date date) throws XRoadServiceConsumptionException {
    Toimeained request = Toimeained.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return koodikeskusXRoadDatabase.toimeainedV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findPiirhinnad(Date date) throws XRoadServiceConsumptionException {
    Piirhinnad request = Piirhinnad.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return koodikeskusXRoadDatabase.piirhinnadV1(request).getKeha().getItemList();
  }

  @Override
  public List<Piirhind> findPiirhinnadDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    PiirhinnadByIDArray request = PiirhinnadByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.piirhinnadByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findHinnakokkulepped(Date date) throws XRoadServiceConsumptionException {
    Hinnakokkulepped request = Hinnakokkulepped.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return koodikeskusXRoadDatabase.hinnakokkuleppedV1(request).getKeha().getItemList();
  }

  @Override
  public List<Hinnakokkulepe> findHinnakokkuleppedDetailandmed(List<String> items)
      throws XRoadServiceConsumptionException {
    HinnakokkuleppedByIDArray request = HinnakokkuleppedByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.hinnakokkuleppedByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findMyygiload(Date date) throws XRoadServiceConsumptionException {
    Myygiload request = Myygiload.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return koodikeskusXRoadDatabase.myygiloadV1(request).getKeha().getItemList();
  }

  @Override
  public List<Myygiluba> findMyygiloadDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    MyygiloadByIDArray request = MyygiloadByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return koodikeskusXRoadDatabase.myygiloadByIDArrayV1(request).getKeha().getItemList();
  }

  private ArrayOfString createDetailsRequest(List<String> items) {
    ArrayOfString request = ArrayOfString.Factory.newInstance();
    String[] itemsArray = new String[items.size()];
    request.setItemArray(items.toArray(itemsArray));
    return request;
  }

  private DateNotRequired createListRequest(Date date) {
    DateNotRequired request = DateNotRequired.Factory.newInstance();
    setRequestStartDate(date, request);
    return request;
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
