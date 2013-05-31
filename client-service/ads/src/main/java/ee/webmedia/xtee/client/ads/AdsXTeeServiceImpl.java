package ee.webmedia.xtee.client.ads;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ee.webmedia.xtee.client.ads.AdsXTeeService;
import ee.webmedia.xtee.client.ads.database.AdsXTeeDatabase;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2ParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2ParingType.AadrMuudatusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2VastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType.KlassifParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkomponendidParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkomponendidParingType.KompParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkomponendidVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompotsingParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompotsingParingType.AadrKompParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompotsingVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType.MuudatusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSnormalParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSnormalParingType.NormalParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSnormalVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedParingType.ObjMuudatusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjmuudatusedv2ParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjmuudatusedv2VastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjotsingv2ParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjotsingv2ParingType.ObjKompParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjotsingv2VastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSprobleemidParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSprobleemidParingType.ProbleemidParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSprobleemidVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSteavitusedParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSteavitusedParingType.TeavitusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSteavitusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADStekstotsingParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADStekstotsingParingType.AadrTekstParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADStekstotsingVastusType;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;

@Service("adsXTeeService")
public class AdsXTeeServiceImpl extends XTeeDatabaseService implements AdsXTeeService {

  @Resource
  private AdsXTeeDatabase adsXTeeDatabase;

  public ADSkompklassifVastusType kompklassifV1(KlassifParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");

    ADSkompklassifParingType request = ADSkompklassifParingType.Factory.newInstance();
    KlassifParam kp = KlassifParam.Factory.newInstance();

    callback.populate(kp);
    request.setKlassifParam(kp);

    return adsXTeeDatabase.adSkompklassifV1(request);
  }

  public ADSmuudatusedVastusType muudatusedV1(MuudatusedParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");

    ADSmuudatusedParingType request = ADSmuudatusedParingType.Factory.newInstance();
    MuudatusedParam mp = MuudatusedParam.Factory.newInstance();

    callback.populate(mp);
    request.setMuudatusedParam(mp);

    return adsXTeeDatabase.adSmuudatusedV1(request);
  }

  public ADSkompotsingVastusType kompotsingV1(AadrKompParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");

    ADSkompotsingParingType request = ADSkompotsingParingType.Factory.newInstance();
    AadrKompParam mp = AadrKompParam.Factory.newInstance();

    callback.populate(mp);
    request.setAadrKompParam(mp);

    return adsXTeeDatabase.adSkompotsingV1(request);
  }

  @Override
  public ADSobjotsingv2VastusType objotsingV2(ObjKompParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");

    ADSobjotsingv2ParingType request = ADSobjotsingv2ParingType.Factory.newInstance();
    ObjKompParam mp = ObjKompParam.Factory.newInstance();

    callback.populate(mp);
    request.setObjKompParam(mp);

    return adsXTeeDatabase.adSobjotsingv2V1(request);
  }

  @Override
  public ADStekstotsingVastusType tekstotsingV1(AadrTekstParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");
    ADStekstotsingParingType request = ADStekstotsingParingType.Factory.newInstance();
    AadrTekstParam mp = AadrTekstParam.Factory.newInstance();

    callback.populate(mp);
    request.setAadrTekstParam(mp);

    return adsXTeeDatabase.adStekstotsingV1(request);
  }

  @Override
  public ADSkomponendidVastusType komponendidV1(KompParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");
    ADSkomponendidParingType request = ADSkomponendidParingType.Factory.newInstance();
    KompParam mp = KompParam.Factory.newInstance();

    callback.populate(mp);
    request.setKompParam(mp);

    return adsXTeeDatabase.adSkomponendidV1(request);
  }


  @Override
  public ADSnormalVastusType normalV1(NormalParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");
    ADSnormalParingType request = ADSnormalParingType.Factory.newInstance();
    NormalParam mp = NormalParam.Factory.newInstance();

    callback.populate(mp);
    request.setNormalParam(mp);

    return adsXTeeDatabase.adSnormalV1(request);
  }

  @Override
  public ADSteavitusedVastusType teavitusedV1(TeavitusedParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");
    ADSteavitusedParingType request = ADSteavitusedParingType.Factory.newInstance();
    TeavitusedParam mp = TeavitusedParam.Factory.newInstance();

    callback.populate(mp);
    request.setTeavitusedParam(mp);

    return adsXTeeDatabase.adSteavitusedV1(request);
  }

  @Override
  public ADSaadrmuudatusedv2VastusType aadrmuudatusedV2(AadrMuudatusedParamCallback callback)
      throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");
    ADSaadrmuudatusedv2ParingType request = ADSaadrmuudatusedv2ParingType.Factory.newInstance();
    AadrMuudatusedParam mp = AadrMuudatusedParam.Factory.newInstance();

    callback.populate(mp);
    request.setAadrMuudatusedParam(mp);

    return adsXTeeDatabase.adSaadrmuudatusedv2V1(request);
  }

  @Override
  public ADSobjaadrmuudatusedVastusType objaadrmuudatusedV1(ObjAadrMuudatusedParamCallback callback)
      throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");
    ADSobjaadrmuudatusedParingType request = ADSobjaadrmuudatusedParingType.Factory.newInstance();
    ObjMuudatusedParam mp = ObjMuudatusedParam.Factory.newInstance();

    callback.populate(mp);
    request.setObjMuudatusedParam(mp);

    return adsXTeeDatabase.adSobjaadrmuudatusedV1(request);
  }

  @Override
  public ADSobjmuudatusedv2VastusType objmuudatusedV2(ObjMuudatusedParamCallback callback)
      throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");
    ADSobjmuudatusedv2ParingType request = ADSobjmuudatusedv2ParingType.Factory.newInstance();
    ADSobjmuudatusedv2ParingType.ObjMuudatusedParam mp =
        ADSobjmuudatusedv2ParingType.ObjMuudatusedParam.Factory.newInstance();

    callback.populate(mp);
    request.setObjMuudatusedParam(mp);

    return adsXTeeDatabase.adSobjmuudatusedv2V1(request);
  }

  public ADSprobleemidVastusType probleemidV1(ProbleemidParamCallback callback) throws XTeeServiceConsumptionException {
    if (callback == null)
      throw new IllegalArgumentException("Callback can not be null!");
    ADSprobleemidParingType request = ADSprobleemidParingType.Factory.newInstance();
    ProbleemidParam mp = ProbleemidParam.Factory.newInstance();

    callback.populate(mp);
    request.setProbleemidParam(mp);

    return adsXTeeDatabase.adSprobleemidV1(request);
  }

  public void setAdsXTeeDatabase(AdsXTeeDatabase adsXTeeDatabase) {
    this.adsXTeeDatabase = adsXTeeDatabase;
  }
}
