package ee.webmedia.xtee.client.ads;

import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2ParingType.AadrMuudatusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSaadrmuudatusedv2VastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifParingType.KlassifParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompklassifVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkomponendidParingType.KompParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkomponendidVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompotsingParingType.AadrKompParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSkompotsingVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedParingType.MuudatusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSmuudatusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSnormalParingType.NormalParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSnormalVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedParingType.ObjMuudatusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjaadrmuudatusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjmuudatusedv2ParingType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjmuudatusedv2VastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjotsingv2ParingType.ObjKompParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSobjotsingv2VastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSprobleemidParingType.ProbleemidParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSprobleemidVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSteavitusedParingType.TeavitusedParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADSteavitusedVastusType;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADStekstotsingParingType.AadrTekstParam;
import ee.webmedia.xtee.client.ads.types.ee.maaamet.ADStekstotsingVastusType;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

/**
 * <code>ads</code> (Maaameti teenused) database X-tee service.
 */
public interface AdsXTeeService {

  /**
   * aadresskomponentide klassifikaatori muudatuste päring <br>
   * <code>ads.kompklassif.v1</code> service.
   */
  ADSkompklassifVastusType kompklassifV1(KlassifParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * aadresside muudatuste päring <br>
   * <code>ads.muudatused.v1</code> service.
   */
  ADSmuudatusedVastusType muudatusedV1(MuudatusedParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * aadresside otsing komponentide alusel <br>
   * <code>ads.kompotsing.v1</code> service.
   */
  ADSkompotsingVastusType kompotsingV1(AadrKompParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * aadressobjektide otsing <br>
   * <code>ads.objotsing.v2</code> service.
   */
  ADSobjotsingv2VastusType objotsingV2(ObjKompParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * aadresside otsing teksti alusel <br>
   * <code>ads.tekstotsing.v1</code> service.
   */
  ADStekstotsingVastusType tekstotsingV1(AadrTekstParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * aadresskomponentide kehtiva seisu päring <br>
   * <code>ads.komponendid.v1</code> service.
   */
  ADSkomponendidVastusType komponendidV1(KompParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * aadressteksti normaliseerimine<br>
   * <code>ads.normal.v1</code> service.
   */
  ADSnormalVastusType normalV1(NormalParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * teavitusteenus aadresside muudatusvajaduste kohta<br>
   * <code>ads.teavitused.v1</code> service.
   */
  ADSteavitusedVastusType teavitusedV1(TeavitusedParamCallback callback) throws XTeeServiceConsumptionException;

  /**
   * adressi muudatuste päring<br>
   * <code>ads.aadrmuudatused.v2</code> service.
   */
  ADSaadrmuudatusedv2VastusType aadrmuudatusedV2(AadrMuudatusedParamCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * objekti aadresside muudatuste päring<br>
   * <code>ads.objaadrmuudatused.v1</code> service.
   */
  ADSobjaadrmuudatusedVastusType objaadrmuudatusedV1(ObjAadrMuudatusedParamCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * aadresside muudatuste päring <br>
   * <code>ads.objmuudatused.v2</code> service.
   */
  ADSobjmuudatusedv2VastusType objmuudatusedV2(ObjMuudatusedParamCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * teavitusteenus aadressi probleemide kohta <br>
   * <code>ads.probleemid.v1</code> service.
   */
  ADSprobleemidVastusType probleemidV1(ProbleemidParamCallback callback)
      throws XTeeServiceConsumptionException;

  interface KlassifParamCallback {
    void populate(KlassifParam klassifParam);
  }

  interface MuudatusedParamCallback {
    void populate(MuudatusedParam muudatusedParam);
  }

  interface AadrKompParamCallback {
    void populate(AadrKompParam aadrKompParam);
  }

  interface ObjKompParamCallback {
    void populate(ObjKompParam objKompParam);
  }

  interface AadrTekstParamCallback {
    void populate(AadrTekstParam aadrTekstParam);
  }

  interface KompParamCallback {
    void populate(KompParam kompParam);
  }

  interface NormalParamCallback {
    void populate(NormalParam normalParam);
  }

  interface TeavitusedParamCallback {
    void populate(TeavitusedParam teavitusedParam);
  }

  interface AadrMuudatusedParamCallback {
    void populate(AadrMuudatusedParam aadrMuudatusedParam);
  }

  interface AarObjMuudatusedParamCallback {
    void populate(ObjMuudatusedParam objMuudatusedParam);
  }

  interface ObjAadrMuudatusedParamCallback {
    void populate(ADSobjaadrmuudatusedParingType.ObjMuudatusedParam objMuudatusedParam);
  }

  interface ObjMuudatusedParamCallback {
    void populate(ADSobjmuudatusedv2ParingType.ObjMuudatusedParam objMuudatusedParam);
  }

  interface ProbleemidParamCallback {
    void populate(ProbleemidParam probleemidParam);
  }

}
