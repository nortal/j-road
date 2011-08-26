package ee.webmedia.xtee.client.arireg;

import ee.webmedia.xtee.client.arireg.database.AriregXTeeDatabase;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV3Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Query;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.Detailandmedv2Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.Detailandmedv2Query;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingarikeeludKeeld;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingarikeeludParing;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

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
                                                          int maksValjundArv)
      throws XTeeServiceConsumptionException {

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
                                                          int maksValjundArv)
      throws XTeeServiceConsumptionException {

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
                                                          int maksValjundArv)
      throws XTeeServiceConsumptionException {

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
                                                          int maksValjundArv)
      throws XTeeServiceConsumptionException {

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

}
