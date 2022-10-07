package com.nortal.jroad.client.ravimiregister;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ravimiregister.database.RavimiregisterXRoadDatabase;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.ATCKlassifikaator;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.ATCKlassifikaatoridByIDArrayDocument.ATCKlassifikaatoridByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.ATCKlassifikaatoridDocument.ATCKlassifikaatorid;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.ArrayOfString;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.DateNotRequired;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Haigus;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.HaigusedByIDArrayDocument.HaigusedByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.HaigusedDocument.Haigused;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Hinnakokkulepe;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.HinnakokkuleppedByIDArrayDocument.HinnakokkuleppedByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.HinnakokkuleppedDocument.Hinnakokkulepped;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.MyygiloadByIDArrayDocument.MyygiloadByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.MyygiloadDocument.Myygiload;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Myygiluba;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Pakend;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.PakendidByIDArrayDocument.PakendidByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.PakendidDocument.Pakendid;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Piirhind;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.PiirhinnadByIDArrayDocument.PiirhinnadByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.PiirhinnadDocument.Piirhinnad;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.RavimiLiik;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Ravimvorm;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.RavimvormidByIDArrayDocument.RavimvormidByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.RavimvormidDocument.Ravimvormid;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.RetseptinoueLiik;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Soodustus;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.SoodustusedByIDArrayDocument.SoodustusedByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.SoodustusedDocument.Soodustused;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Toimeaine;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.ToimeainedByIDArrayDocument.ToimeainedByIDArray;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.ToimeainedDocument.Toimeained;
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
  private RavimiregisterXRoadDatabase ravimiregisterXRoadDatabase;

  @Override
  public List<ATCKlassifikaator> findATCKlassifikaatoridDetailandmed(List<String> items)
      throws XRoadServiceConsumptionException {
    ATCKlassifikaatoridByIDArray request = ATCKlassifikaatoridByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.atcKlassifikaatoridByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findATCKlassifikaatorid(Date date) throws XRoadServiceConsumptionException {
    ATCKlassifikaatorid request = ATCKlassifikaatorid.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return ravimiregisterXRoadDatabase.atcKlassifikaatoridV1(request).getKeha().getItemList();
  }

  @Override
  public List<Haigus> findHaigusedDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    HaigusedByIDArray request = HaigusedByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.haigusedByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findHaigused(Date date) throws XRoadServiceConsumptionException {
    Haigused request = Haigused.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return ravimiregisterXRoadDatabase.haigusedV1(request).getKeha().getItemList();
  }

  @Override
  public List<Pakend> findPakendidDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    PakendidByIDArray request = PakendidByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.pakendidByIDArrayV4(request).getKeha().getItemList();
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

    return ravimiregisterXRoadDatabase.pakendidV1(request).getKeha().getItemList();
  }

  @Override
  public List<Ravimvorm> findRavimvormidDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    RavimvormidByIDArray request = RavimvormidByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.ravimvormidByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findRavimvormid(Date date) throws XRoadServiceConsumptionException {
    Ravimvormid request = Ravimvormid.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return ravimiregisterXRoadDatabase.ravimvormidV1(request).getKeha().getItemList();
  }

  @Override
  public List<Soodustus> findSoodustusedDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    SoodustusedByIDArray request = SoodustusedByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.soodustusedByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findSoodustused(Date date) throws XRoadServiceConsumptionException {
    Soodustused request = Soodustused.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return ravimiregisterXRoadDatabase.soodustusedV1(request).getKeha().getItemList();
  }

  @Override
  public List<Toimeaine> findToimeainedDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    ToimeainedByIDArray request = ToimeainedByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.toimeainedByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findToimeained(Date date) throws XRoadServiceConsumptionException {
    Toimeained request = Toimeained.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return ravimiregisterXRoadDatabase.toimeainedV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findPiirhinnad(Date date) throws XRoadServiceConsumptionException {
    Piirhinnad request = Piirhinnad.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return ravimiregisterXRoadDatabase.piirhinnadV1(request).getKeha().getItemList();
  }

  @Override
  public List<Piirhind> findPiirhinnadDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    PiirhinnadByIDArray request = PiirhinnadByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.piirhinnadByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findHinnakokkulepped(Date date) throws XRoadServiceConsumptionException {
    Hinnakokkulepped request = Hinnakokkulepped.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return ravimiregisterXRoadDatabase.hinnakokkuleppedV1(request).getKeha().getItemList();
  }

  @Override
  public List<Hinnakokkulepe> findHinnakokkuleppedDetailandmed(List<String> items)
      throws XRoadServiceConsumptionException {
    HinnakokkuleppedByIDArray request = HinnakokkuleppedByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.hinnakokkuleppedByIDArrayV1(request).getKeha().getItemList();
  }

  @Override
  public List<String> findMyygiload(Date date) throws XRoadServiceConsumptionException {
    Myygiload request = Myygiload.Factory.newInstance();
    request.setKeha(createListRequest(date));
    return ravimiregisterXRoadDatabase.myygiloadV1(request).getKeha().getItemList();
  }

  @Override
  public List<Myygiluba> findMyygiloadDetailandmed(List<String> items) throws XRoadServiceConsumptionException {
    MyygiloadByIDArray request = MyygiloadByIDArray.Factory.newInstance();
    request.setKeha(createDetailsRequest(items));
    return ravimiregisterXRoadDatabase.myygiloadByIDArrayV1(request).getKeha().getItemList();
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

  public void setRavimiregisterXRoadDatabase(RavimiregisterXRoadDatabase ravimiregisterXRoadDatabase) {
    this.ravimiregisterXRoadDatabase = ravimiregisterXRoadDatabase;
  }

}
