package com.nortal.jroad.client.arireg;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.nortal.jroad.client.arireg.database.AriregXRoadDatabase;
import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.*;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

/**
 * @author Roman Tekhov
 */
@Service("ariregXTeeService")
public class AriregXTeeServiceImpl implements AriregXTeeService {

  @Resource
  private AriregXRoadDatabase ariregXRoadDatabase;

  @Deprecated
  public List<Detailandmedv2Ettevotja> findDetailandmedv2(final int ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          int maksValjundArv) throws XRoadServiceConsumptionException {

    return findDetailandmedv2(new Detailandmedv2ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maksValjundArv) {
      @Override
      protected void doPopulate(Detailandmedv2Query keha) {
        keha.setAriregistriKood(ariregistriKood);
      }
    });
  }

  @Deprecated
  public List<Detailandmedv2Ettevotja> findDetailandmedv2(final String isikukood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          int maksValjundArv) throws XRoadServiceConsumptionException {

    return findDetailandmedv2(new Detailandmedv2ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maksValjundArv) {
      @Override
      protected void doPopulate(Detailandmedv2Query keha) {
        keha.setFyysiliseIsikuKood(isikukood);
      }
    });
  }

  @Deprecated
  public List<Detailandmedv2Ettevotja> findDetailandmedv2(Detailandmedv2KehaPopulatingCallback callback)
      throws XRoadServiceConsumptionException {

    Detailandmedv2Query requestDocument = Detailandmedv2Query.Factory.newInstance();

    callback.populate(requestDocument);

    return ariregXRoadDatabase.detailandmedv2V1(requestDocument).getEttevotjad().getItemList();
  }

  public List<DetailandmedV3Ettevotja> findDetailandmedv3(final int ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          int maksValjundArv) throws XRoadServiceConsumptionException {

    return findDetailandmedv3(new Detailandmedv2ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maksValjundArv) {
      @Override
      protected void doPopulate(Detailandmedv2Query keha) {
        keha.setAriregistriKood(ariregistriKood);
      }
    });
  }

  public List<DetailandmedV3Ettevotja> findDetailandmedv3(final String isikukood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          int maksValjundArv) throws XRoadServiceConsumptionException {

    return findDetailandmedv3(new Detailandmedv2ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maksValjundArv) {
      @Override
      protected void doPopulate(Detailandmedv2Query keha) {
        keha.setFyysiliseIsikuKood(isikukood);
      }
    });
  }

  public List<DetailandmedV3Ettevotja> findDetailandmedv3(Detailandmedv2KehaPopulatingCallback callback)
      throws XRoadServiceConsumptionException {

    Detailandmedv2Query requestDocument = Detailandmedv2Query.Factory.newInstance();

    callback.populate(requestDocument);

    return ariregXRoadDatabase.detailandmedV3V1(requestDocument).getEttevotjad().getItemList();
  }

  public List<ParingarikeeludKeeld> findArikeelud(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XRoadServiceConsumptionException {
    ParingarikeeludParing paring = ParingarikeeludParing.Factory.newInstance();
    paring.setFyysiliseIsikuKood(isikukood);
    paring.setFyysiliseIsikuEesnimi(eesnimi);
    paring.setFyysiliseIsikuPerenimi(perenimi);
    if (synniaeg == null) {
      paring.setFyysiliseIsikuSynniaeg(null);
    } else {
      Calendar cal = Calendar.getInstance();
      cal.setTime(synniaeg);
      paring.setFyysiliseIsikuSynniaeg(cal);
    }

    return ariregXRoadDatabase.paringarikeeludV1(paring).getArikeelud().getItemList();
  }

  public List<DetailandmedV4Ettevotja> findDetailandmedv4(final int ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          int maksValjundArv) throws XRoadServiceConsumptionException {
    return findDetailandmedv4(new Detailandmedv4ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maarused,
                                                                            maksValjundArv) {
      @Override
      protected void doPopulate(DetailandmedV4Query keha) {
        keha.setAriregistriKood(ariregistriKood);
      }
    });
  }

  public List<DetailandmedV4Ettevotja> findDetailandmedv4(final String isikukood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          int maksValjundArv) throws XRoadServiceConsumptionException {
    return findDetailandmedv4(new Detailandmedv4ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maarused,
                                                                            maksValjundArv) {
      @Override
      protected void doPopulate(DetailandmedV4Query keha) {
        keha.setFyysiliseIsikuKood(isikukood);
      }
    });
  }

  public List<DetailandmedV4Ettevotja> findDetailandmedv4(Detailandmedv4KehaPopulatingCallback callback)
      throws XRoadServiceConsumptionException {

    DetailandmedV4Query requestDocument = DetailandmedV4Query.Factory.newInstance();

    callback.populate(requestDocument);

    return ariregXRoadDatabase.detailandmedV4V1(requestDocument).getEttevotjad().getItemList();
  }

  public List<DetailandmedV5Ettevotja> findDetailandmedV5(final String isikukood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          boolean ainultKehtivad,
                                                          long maksValjundArv)
      throws XRoadServiceConsumptionException {
    return findDetailandmedV5(new DetailandmedV5ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maarused,
                                                                            ainultKehtivad,
                                                                            maksValjundArv) {

      @Override
      protected void doPopulate(DetailandmedV5Query query) {
        query.setFyysiliseIsikuKood(isikukood);
      }
    });
  }
  
  public List<DetailandmedV5Ettevotja> findDetailandmedV5(final long ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          boolean ainultKehtivad,
                                                          long maksValjundArv) throws XRoadServiceConsumptionException {
    return findDetailandmedV5(new DetailandmedV5ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maarused,
                                                                            ainultKehtivad,
                                                                            maksValjundArv) {

      @Override
      protected void doPopulate(DetailandmedV5Query query) {
        query.setAriregistriKood(BigInteger.valueOf(ariregistriKood));
      }
    });
  }

  public List<DetailandmedV5Ettevotja> findDetailandmedV5(DetailandmedV5KehaPopulatingCallback callback)
      throws XRoadServiceConsumptionException {

    DetailandmedV5Query requestDocument = DetailandmedV5Query.Factory.newInstance();

    callback.populate(requestDocument);

    return ariregXRoadDatabase.detailandmedV5V1(requestDocument).getEttevotjad().getItemList();
  }

  public List<ParingesindusEttevote> findParingesindusV1(Integer ariregistriKood,
                                                         String fyysiliseIsikuKood,
                                                         String fyysiliseIsikuEesnimi,
                                                         String fyysiliseIsikuPerenimi)
      throws XRoadServiceConsumptionException {
    ParingesindusParing paring = ParingesindusParing.Factory.newInstance();
    if (ariregistriKood != null) {
      paring.setAriregistriKood(ariregistriKood);
    }
    if (fyysiliseIsikuKood != null) {
      paring.setFyysiliseIsikuKood(fyysiliseIsikuKood);
    }
    if (fyysiliseIsikuEesnimi != null) {
      paring.setFyysiliseIsikuEesnimi(fyysiliseIsikuEesnimi);
    }
    if (fyysiliseIsikuPerenimi != null) {
      paring.setFyysiliseIsikuPerenimi(fyysiliseIsikuPerenimi);
    }
    return ariregXRoadDatabase.paringesindusV1(paring).getEttevotjad().getItemList();
  }

  public List<ParingesindusV2Ettevote> findParingesindusV2(Integer ariregistriKood,
                                                           String fyysiliseIsikuKood,
                                                           String fyysiliseIsikuEesnimi,
                                                           String fyysiliseIsikuPerenimi)
      throws XRoadServiceConsumptionException {

    ParingesindusV2Paring paring = ParingesindusV2Paring.Factory.newInstance();
    if (ariregistriKood != null) {
      paring.setAriregistriKood(ariregistriKood);
    }
    if (fyysiliseIsikuKood != null) {
      paring.setFyysiliseIsikuKood(fyysiliseIsikuKood);
    }
    if (fyysiliseIsikuEesnimi != null) {
      paring.setFyysiliseIsikuEesnimi(fyysiliseIsikuEesnimi);
    }
    if (fyysiliseIsikuPerenimi != null) {
      paring.setFyysiliseIsikuPerenimi(fyysiliseIsikuPerenimi);
    }
    return ariregXRoadDatabase.paringesindusV2V1(paring).getEttevotjad().getItemList();
  }

  public List<ParingesindusV3Ettevote> findParingesindusV3(Integer ariregistriKood,
                                                           String fyysiliseIsikuKood,
                                                           String fyysiliseIsikuEesnimi,
                                                           String fyysiliseIsikuPerenimi,
                                                           String ariregisterValjundiFormaat)
      throws XRoadServiceConsumptionException {
    ParingesindusV3Paring paring = ParingesindusV3Paring.Factory.newInstance();

    if (ariregistriKood != null) {
      paring.setAriregistriKood(ariregistriKood);
    }
    if (fyysiliseIsikuKood != null) {
      paring.setFyysiliseIsikuKood(fyysiliseIsikuKood);
    }
    if (fyysiliseIsikuEesnimi != null) {
      paring.setFyysiliseIsikuEesnimi(fyysiliseIsikuEesnimi);
    }
    if (fyysiliseIsikuPerenimi != null) {
      paring.setFyysiliseIsikuPerenimi(fyysiliseIsikuPerenimi);
    }
    if (ariregisterValjundiFormaat != null) {
      paring.setAriregisterValjundiFormaat(ariregisterValjundiFormaat);
    }
    return ariregXRoadDatabase.paringesindusV3V1(paring).getEttevotjad().getItemList();
  }

  public EttevotjaMuudatusedTasutaVastus findEttevotjaMuudatusedTasutaV1(EttevotjaMuudatusedTasutaReturnedDataSettingCallback callback)
      throws XRoadServiceConsumptionException {
    EttevotjaMuudatusedTasutaParing query = EttevotjaMuudatusedTasutaParing.Factory.newInstance();

    callback.populate(query);

    return ariregXRoadDatabase.ettevotjaMuudatusedTasutaV1(query);
  }

  public EttevotjaMuudatusedTasutaTootukassaVastus findEttevotjaMuudatusedTasutaTootukassaV1(
          Date algusKp,
          Date loppKp,
          String[] kandesIsikudRollid,
          Integer tulemusteLk) throws XRoadServiceConsumptionException {

    Calendar algus = Calendar.getInstance();
    Calendar lopp = Calendar.getInstance();
    algus.setTime(algusKp);
    lopp.setTime(loppKp);

    EttevotjaMuudatusedTasutaTootukassaParing query = EttevotjaMuudatusedTasutaTootukassaParing.Factory.newInstance();
    query.setAlguskuupaev(algus);
    query.setLoppkuupaev(lopp);
    query.setKandesIsikudRollidArray(kandesIsikudRollid);
    if (tulemusteLk != null) {
      query.setTulemusteLk(tulemusteLk);
    }

    return ariregXRoadDatabase.ettevotjaMuudatusedTasutaTootukassaV1(query);
  }
}
