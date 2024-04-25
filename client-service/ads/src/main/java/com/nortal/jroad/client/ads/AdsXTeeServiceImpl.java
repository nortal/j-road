package com.nortal.jroad.client.ads;

import com.nortal.jroad.client.service.v2.XTeeDatabaseService;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nortal.jroad.client.ads.AdsXTeeService;
import com.nortal.jroad.client.ads.database.AdsXTeeDatabase;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2ParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2VastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompklassifParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompklassifVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkomponendidParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkomponendidVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompotsingParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompotsingVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSmuudatusedParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSmuudatusedVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSnormalParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSnormalVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjmuudatusedv2ParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjmuudatusedv2VastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjotsingv2ParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjotsingv2VastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSprobleemidParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSprobleemidVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSteavitusedParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSteavitusedVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADStekstotsingParingType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADStekstotsingVastusType;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2ParingType.AadrMuudatusedParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompklassifParingType.KlassifParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkomponendidParingType.KompParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSkompotsingParingType.AadrKompParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSmuudatusedParingType.MuudatusedParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSnormalParingType.NormalParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedParingType.ObjMuudatusedParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSobjotsingv2ParingType.ObjKompParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSprobleemidParingType.ProbleemidParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADSteavitusedParingType.TeavitusedParam;
import com.nortal.jroad.client.ads.types.ee.maaamet.ADStekstotsingParingType.AadrTekstParam;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

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
