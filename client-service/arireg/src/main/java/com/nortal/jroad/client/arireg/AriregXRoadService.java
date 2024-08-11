package com.nortal.jroad.client.arireg;

import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.*;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <code>arireg</code> (Äriregister) database X-tee service.
 * 
 * @author Roman Tekhov
 */
public interface AriregXRoadService {

  /**
   * <code>arireg.paringarikeelud.v1</code> service.
   */
  List<ParingarikeeludKeeld> findArikeelud(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XRoadServiceConsumptionException;

  /**
   * <code>arireg.detailandmed_v5.v1</code> service.
   */
  List<DetailandmedV5Ettevotja> findDetailandmedV1(String isikukood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   boolean maarused,
                                                   boolean ainultKehtivad,
                                                   long maksValjundArv)
      throws XRoadServiceConsumptionException;

  /**
   * <code>arireg.detailandmed_v5.v1</code> service.
   */
  List<DetailandmedV5Ettevotja> findDetailandmedV1(int ariregistriKood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   boolean maarused,
                                                   boolean ainultKehtivad,
                                                   long maksValjundArv)
      throws XRoadServiceConsumptionException;

  List<DetailandmedV5Ettevotja> findDetailandmedV1(Integer ariregistriKood,
                                                   String arinimi,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   boolean maarused,
                                                   boolean ainultKehtivad,
                                                   long maksValjundArv)
      throws XRoadServiceConsumptionException;

  /**
   * <code>arireg.detailandmed_v5.v1</code> service.
   */
  List<DetailandmedV5Ettevotja> findDetailandmedV1(DetailandmedV1PopulatingCallback callback)
      throws XRoadServiceConsumptionException;

  /**
   * Callback responsible for populating the keha element of <code>arireg.detailandmedv5.v1</code> service.
   */
  interface DetailandmedV1PopulatingCallback {

    void populate(DetailandmedV1 detailandmedV1);
  }

  /**
   * {@link DetailandmedV1PopulatingCallback} implementation concerned with setting the data to be returned by
   * <code>arireg.detailandmedv5.v1</code> service.
   */
  public abstract class DetailandmedV1ReturnedDataSettingCallback implements DetailandmedV1PopulatingCallback {

    private boolean yldandmed;
    private boolean isikuandmed;
    private boolean menetlusesAvaldused;
    private boolean kommertspandiandmed;
    private boolean maarused;
    private boolean ainultKehtivad;
    private long maksValjundArv;

    public DetailandmedV1ReturnedDataSettingCallback(boolean yldandmed,
                                                     boolean isikuandmed,
                                                     boolean menetlusesAvaldused,
                                                     boolean kommertspandiandmed,
                                                     boolean maarused,
                                                     boolean ainultKehtivad,
                                                     long maksValjundArv) {
      this.yldandmed = yldandmed;
      this.isikuandmed = isikuandmed;
      this.menetlusesAvaldused = menetlusesAvaldused;
      this.kommertspandiandmed = kommertspandiandmed;
      this.maarused = maarused;
      this.ainultKehtivad = ainultKehtivad;
      this.maksValjundArv = maksValjundArv;
    }

    public void populate(DetailandmedV1 detailandmedV1) {
      DetailandmedV5Query query = detailandmedV1.addNewKeha();
      query.setYandmed(yldandmed);
      query.setIandmed(isikuandmed);
      query.setDandmed(menetlusesAvaldused);
      query.setKandmed(kommertspandiandmed);
      query.setMaarused(maarused);
      query.setEvarv(BigInteger.valueOf(maksValjundArv));
      query.setAinultKehtivad(ainultKehtivad);
      doPopulate(query);
    }

    protected abstract void doPopulate(DetailandmedV5Query query);
  }

  /**
   * Callback responsible for populating the keha element of <code>arireg.ettevotja_muudatused_tasuta.v1</code> service.
   */
  interface EttevotjaMuudatusedTasutaPopulatingCallback {

    void populate(EttevotjaMuudatusedTasutaV1 ettevotjaMuudatusedTasutaV1);
  }

  /**
   * {@link DetailandmedV1PopulatingCallback} implementation concerned with setting the data to be returned by
   * <code>arireg.detailandmedv5.v1</code> service.
   */
  public abstract class EttevotjaMuudatusedTasutaReturnedDataSettingCallback
      implements EttevotjaMuudatusedTasutaPopulatingCallback {
    private Date kuupaev;
    private String[] muudatusteValik;
    private String[] kandevalisedValik;
    private int[] kandeKandeliigid;
    private String[] kandeKandeosad;
    private String kandeEelmineStaatus;
    private String kandeUusStaatus;
    private int tulemusteLk;

    public EttevotjaMuudatusedTasutaReturnedDataSettingCallback(Date kuupaev,
                                                                String[] muudatusteValik,
                                                                String[] kandevalisedValik,
                                                                int[] kandeKandeliigid,
                                                                String[] kandeKandeosad,
                                                                String kandeEelmineStaatus,
                                                                String kandeUusStaatus,
                                                                int tulemusteLk) {
      this.kuupaev = kuupaev;
      this.muudatusteValik = muudatusteValik;
      this.kandevalisedValik = kandevalisedValik;
      this.kandeKandeliigid = kandeKandeliigid;
      this.kandeKandeosad = kandeKandeosad;
      this.kandeEelmineStaatus = kandeEelmineStaatus;
      this.kandeUusStaatus = kandeUusStaatus;
      this.tulemusteLk = tulemusteLk;
    }

    public void populate(EttevotjaMuudatusedTasutaV1 ettevotjaMuudatusedTasutaV1) {
      EttevotjaMuudatusedTasutaParing query = ettevotjaMuudatusedTasutaV1.addNewKeha();
      if (kuupaev != null) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(kuupaev);
        query.setKuupaev(cal);
      }
      if (muudatusteValik != null) {
        query.setMuudatusteValikArray(muudatusteValik);
      }
      if (kandevalisedValik != null) {
        query.setKandevalisedValikArray(kandevalisedValik);
      }
      if (kandeKandeliigid != null) {
        query.setKandeKandeliigidArray(kandeKandeliigid);
      }
      if (kandeKandeosad != null) {
        query.setKandeKandeosadArray(kandeKandeosad);
      }
      if (kandeEelmineStaatus != null) {
        query.setKandeEelmineStaatus(kandeEelmineStaatus);
      }
      if (kandeUusStaatus != null) {
        query.setKandeUusStaatus(kandeUusStaatus);
      }
      if (tulemusteLk > 0) {
        query.setTulemusteLk(tulemusteLk);
      }
      doPopulate(query);
    }

    protected abstract void doPopulate(EttevotjaMuudatusedTasutaParing query);
  }

  /**
   * <code>arireg.ettevotja_muudatused_tasuta.v1</code> X-tee service.
   */
  EttevotjaMuudatusedTasutaV1Response findEttevotjaMuudatusedTasutaV1(EttevotjaMuudatusedTasutaReturnedDataSettingCallback callback)
      throws XRoadServiceConsumptionException;

  /**
   * <code>arireg.ettevotja_muudatused_tasuta_tootukassa.v1</code> X-tee service.
   */
  EttevotjaMuudatusedTasutaTootukassaV1Response findEttevotjaMuudatusedTasutaTootukassaV1(Date algusKp,
                                                                                          Date loppKp,
                                                                                          String[] kandesIsikudRollid,
                                                                                          Integer tulemusteLk)
      throws XRoadServiceConsumptionException;

  /**
   * <code>arireg.ettevottegaSeotudIsikud_v1.v1</code> X-road service.
   */
  List<Seos> findEttevottegaSeotudIsikudV1(Long ariregistriKood, String isikukood, Boolean vastupidi) throws XRoadServiceConsumptionException;

}
