package com.nortal.jroad.client.arireg;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.nortal.jroad.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.*;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.arireg.database.AriregXTeeDatabase;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

/**
 * @author Roman Tekhov
 */
@Service("ariregXTeeService")
public class AriregXTeeServiceImpl implements AriregXTeeService {

  @Resource
  private AriregXTeeDatabase ariregXTeeDatabase;

  @Deprecated
  public List<Detailandmedv2Ettevotja> findDetailandmedv2(final int ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          int maksValjundArv) throws XTeeServiceConsumptionException {

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
                                                          int maksValjundArv) throws XTeeServiceConsumptionException {

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
      throws XTeeServiceConsumptionException {

    Detailandmedv2Query requestDocument = Detailandmedv2Query.Factory.newInstance();

    callback.populate(requestDocument);

    return ariregXTeeDatabase.detailandmedv2V1(requestDocument).getEttevotjad().getItemList();
  }

  public List<DetailandmedV3Ettevotja> findDetailandmedv3(final int ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          int maksValjundArv) throws XTeeServiceConsumptionException {

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
                                                          int maksValjundArv) throws XTeeServiceConsumptionException {

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
      throws XTeeServiceConsumptionException {

    Detailandmedv2Query requestDocument = Detailandmedv2Query.Factory.newInstance();

    callback.populate(requestDocument);

    return ariregXTeeDatabase.detailandmedV3V1(requestDocument).getEttevotjad().getItemList();
  }

  public List<ParingarikeeludKeeld> findArikeelud(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XTeeServiceConsumptionException {
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

    return ariregXTeeDatabase.paringarikeeludV1(paring).getArikeelud().getItemList();
  }

  public List<DetailandmedV4Ettevotja> findDetailandmedv4(final int ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          int maksValjundArv) throws XTeeServiceConsumptionException {
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
                                                          int maksValjundArv) throws XTeeServiceConsumptionException {
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
      throws XTeeServiceConsumptionException {

    DetailandmedV4Query requestDocument = DetailandmedV4Query.Factory.newInstance();

    callback.populate(requestDocument);

    return ariregXTeeDatabase.detailandmedV4V1(requestDocument).getEttevotjad().getItemList();
  }

  public List<DetailandmedV5Ettevotja> findDetailandmedV5(final String isikukood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          boolean ainultKehtivad,
                                                          long maksValjundArv)
      throws XTeeServiceConsumptionException {
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
  
  public List<DetailandmedV5Ettevotja> findDetailandmedV5(final int ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          boolean ainultKehtivad,
                                                          long maksValjundArv) throws XTeeServiceConsumptionException {
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

  @Override
  public List<DetailandmedV5Ettevotja> findDetailandmedV5(final Integer ariregistriKood,
                                                          final String arinimi,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          boolean ainultKehtivad,
                                                          long maksValjundArv)
      throws XTeeServiceConsumptionException {
    return findDetailandmedV5(new DetailandmedV5ReturnedDataSettingCallback(yldandmed,
                                                                            isikuandmed,
                                                                            menetlusesAvaldused,
                                                                            kommertspandiandmed,
                                                                            maarused,
                                                                            ainultKehtivad,
                                                                            maksValjundArv) {
      @Override
      protected void doPopulate(DetailandmedV5Query query) {
        if (ariregistriKood != null) {
          query.setAriregistriKood(BigInteger.valueOf(ariregistriKood));
        }
        if (arinimi != null) {
          query.setArinimi(arinimi);
        }
      }
    });
  }

  public List<DetailandmedV5Ettevotja> findDetailandmedV5(DetailandmedV5KehaPopulatingCallback callback)
      throws XTeeServiceConsumptionException {

    DetailandmedV5Query requestDocument = DetailandmedV5Query.Factory.newInstance();

    callback.populate(requestDocument);

    return ariregXTeeDatabase.detailandmedV5V1(requestDocument).getEttevotjad().getItemList();
  }

  public List<ParingesindusEttevote> findParingesindusV1(Integer ariregistriKood,
                                                         String fyysiliseIsikuKood,
                                                         String fyysiliseIsikuEesnimi,
                                                         String fyysiliseIsikuPerenimi)
      throws XTeeServiceConsumptionException {
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
    return ariregXTeeDatabase.paringesindusV1(paring).getEttevotjad().getItemList();
  }

  public List<ParingesindusV2Ettevote> findParingesindusV2(Integer ariregistriKood,
                                                           String fyysiliseIsikuKood,
                                                           String fyysiliseIsikuEesnimi,
                                                           String fyysiliseIsikuPerenimi)
      throws XTeeServiceConsumptionException {

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
    return ariregXTeeDatabase.paringesindusV2V1(paring).getEttevotjad().getItemList();
  }

  public List<ParingesindusV3Ettevote> findParingesindusV3(Integer ariregistriKood,
                                                           String fyysiliseIsikuKood,
                                                           String fyysiliseIsikuEesnimi,
                                                           String fyysiliseIsikuPerenimi,
                                                           String ariregisterValjundiFormaat)
      throws XTeeServiceConsumptionException {
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
    return ariregXTeeDatabase.paringesindusV3V1(paring).getEttevotjad().getItemList();
  }

  public EttevotjaMuudatusedTasutaVastus findEttevotjaMuudatusedTasutaV1(EttevotjaMuudatusedTasutaReturnedDataSettingCallback callback)
      throws XTeeServiceConsumptionException {
    EttevotjaMuudatusedTasutaParing query = EttevotjaMuudatusedTasutaParing.Factory.newInstance();

    callback.populate(query);

    return ariregXTeeDatabase.ettevotjaMuudatusedTasutaV1(query);
  }

  public EttevotjaMuudatusedTasutaTootukassaVastus findEttevotjaMuudatusedTasutaTootukassaV1(
          Date algusKp,
          Date loppKp,
          String[] kandesIsikudRollid,
          Integer tulemusteLk) throws XTeeServiceConsumptionException {

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

    return ariregXTeeDatabase.ettevotjaMuudatusedTasutaTootukassaV1(query);
  }
}
