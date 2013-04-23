package ee.webmedia.xtee.client.arireg;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV3Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV4Query;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV5Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.DetailandmedV5Query;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.Detailandmedv2Ettevotja;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.Detailandmedv2Query;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingarikeeludKeeld;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingesindusEttevote;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingesindusV2Ettevote;
import ee.webmedia.xtee.client.arireg.types.ee.riik.xtee.arireg.producers.producer.arireg.ParingesindusV3Ettevote;
import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;

/**
 * <code>arireg</code> (Äriregister) database X-tee service.
 * 
 * @author Roman Tekhov
 */
public interface AriregXTeeService {

  /**
   * <code>arireg.detailandmedv2.v1</code> service.
   * 
   * @Deprecated use {@link #findDetailandmedv3(int, boolean, boolean, boolean, boolean)}
   */
  @Deprecated
  List<Detailandmedv2Ettevotja> findDetailandmedv2(int ariregistriKood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   int maksValjundArv) throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.detailandmedv2.v1</code> service.
   * 
   * @Deprecated use {@link #findDetailandmedv3(String, boolean, boolean, boolean, boolean)}
   */
  @Deprecated
  List<Detailandmedv2Ettevotja> findDetailandmedv2(String isikukood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   int maksValjundArv) throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.detailandmedv2.v1</code> service.
   * 
   * @Deprecated use {@link #findDetailandmedv3(Detailandmedv2KehaPopulatingCallback)}
   */
  @Deprecated
  List<Detailandmedv2Ettevotja> findDetailandmedv2(Detailandmedv2KehaPopulatingCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.detailandmedv3.v1</code> service.
   */
  List<DetailandmedV3Ettevotja> findDetailandmedv3(int ariregistriKood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   int maksValjundArv) throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.detailandmedv3.v1</code> service.
   */
  List<DetailandmedV3Ettevotja> findDetailandmedv3(String isikukood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   int maksValjundArv) throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.detailandmedv3.v1</code> service.
   */
  List<DetailandmedV3Ettevotja> findDetailandmedv3(Detailandmedv2KehaPopulatingCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.paringarikeelud.v1</code> service.
   */
  List<ParingarikeeludKeeld> findArikeelud(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XTeeServiceConsumptionException;

  /**
   * Callback responsible for populating the keha element of <code>arireg.detailandmedv2.v1</code> service.
   */
  interface Detailandmedv2KehaPopulatingCallback {

    void populate(Detailandmedv2Query query);
  }

  /**
   * {@link Detailandmedv2KehaPopulatingCallback} implementation concerned with setting the data to be returned by
   * <code>arireg.detailandmedv2.v1</code> service.
   */
  public abstract class Detailandmedv2ReturnedDataSettingCallback implements Detailandmedv2KehaPopulatingCallback {

    private boolean yldandmed;
    private boolean isikuandmed;
    private boolean menetlusesAvaldused;
    private boolean kommertspandiandmed;
    private int maksValjundArv;

    public Detailandmedv2ReturnedDataSettingCallback(boolean yldandmed,
                                                     boolean isikuandmed,
                                                     boolean menetlusesAvaldused,
                                                     boolean kommertspandiandmed,
                                                     int maksValjundArv) {
      this.yldandmed = yldandmed;
      this.isikuandmed = isikuandmed;
      this.menetlusesAvaldused = menetlusesAvaldused;
      this.kommertspandiandmed = kommertspandiandmed;
      this.maksValjundArv = maksValjundArv;
    }

    public void populate(Detailandmedv2Query query) {
      query.setYandmed(yldandmed);
      query.setIandmed(isikuandmed);
      query.setDandmed(menetlusesAvaldused);
      query.setKandmed(kommertspandiandmed);
      query.setEvarv(maksValjundArv);

      doPopulate(query);
    }

    protected abstract void doPopulate(Detailandmedv2Query query);

  }

  /**
   * <code>arireg.detailandmed_v4.v1</code> service.
   */
  List<DetailandmedV4Ettevotja> findDetailandmedv4(int ariregistriKood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   boolean maarused,
                                                   int maksValjundArv) throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.detailandmed_v4.v1</code> service.
   */
  List<DetailandmedV4Ettevotja> findDetailandmedv4(final String isikukood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   boolean maarused,
                                                   int maksValjundArv) throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.detailandmed_v4.v1</code> service.
   */
  List<DetailandmedV4Ettevotja> findDetailandmedv4(Detailandmedv4KehaPopulatingCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * Callback responsible for populating the keha element of <code>arireg.detailandmedv4.v1</code> service.
   */
  interface Detailandmedv4KehaPopulatingCallback {

    void populate(DetailandmedV4Query query);
  }

  /**
   * {@link Detailandmedv4KehaPopulatingCallback} implementation concerned with setting the data to be returned by
   * <code>arireg.detailandmedv4.v1</code> service.
   */
  public abstract class Detailandmedv4ReturnedDataSettingCallback implements Detailandmedv4KehaPopulatingCallback {

    private boolean yldandmed;
    private boolean isikuandmed;
    private boolean menetlusesAvaldused;
    private boolean kommertspandiandmed;
    private boolean maarused;
    private int maksValjundArv;

    public Detailandmedv4ReturnedDataSettingCallback(boolean yldandmed,
                                                     boolean isikuandmed,
                                                     boolean menetlusesAvaldused,
                                                     boolean kommertspandiandmed,
                                                     boolean maarused,
                                                     int maksValjundArv) {
      this.yldandmed = yldandmed;
      this.isikuandmed = isikuandmed;
      this.menetlusesAvaldused = menetlusesAvaldused;
      this.kommertspandiandmed = kommertspandiandmed;
      this.maarused = maarused;
      this.maksValjundArv = maksValjundArv;
    }

    public void populate(DetailandmedV4Query query) {
      query.setYandmed(yldandmed);
      query.setIandmed(isikuandmed);
      query.setDandmed(menetlusesAvaldused);
      query.setKandmed(kommertspandiandmed);
      query.setEvarv(maksValjundArv);
      query.setMaarused(maarused);
      doPopulate(query);
    }

    protected abstract void doPopulate(DetailandmedV4Query query);
  }

  /**
   * <code>arireg.detailandmed_v5.v1</code> service.
   */
  List<DetailandmedV5Ettevotja> findDetailandmedV5(long ariregistriKood,
                                                   boolean yldandmed,
                                                   boolean isikuandmed,
                                                   boolean menetlusesAvaldused,
                                                   boolean kommertspandiandmed,
                                                   boolean maarused,
                                                   boolean ainultKehtivad,
                                                   long maksValjundArv) throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.detailandmed_v5.v1</code> service.
   */
  List<DetailandmedV5Ettevotja> findDetailandmedV5(DetailandmedV5KehaPopulatingCallback callback)
      throws XTeeServiceConsumptionException;

  /**
   * Callback responsible for populating the keha element of <code>arireg.detailandmedv5.v1</code> service.
   */
  interface DetailandmedV5KehaPopulatingCallback {

    void populate(DetailandmedV5Query query);
  }

  /**
   * {@link DetailandmedV5KehaPopulatingCallback} implementation concerned with setting the data to be returned by
   * <code>arireg.detailandmedv5.v1</code> service.
   */
  public abstract class DetailandmedV5ReturnedDataSettingCallback implements DetailandmedV5KehaPopulatingCallback {

    private boolean yldandmed;
    private boolean isikuandmed;
    private boolean menetlusesAvaldused;
    private boolean kommertspandiandmed;
    private boolean maarused;
    private boolean ainultKehtivad;
    private long maksValjundArv;

    public DetailandmedV5ReturnedDataSettingCallback(boolean yldandmed,
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

    public void populate(DetailandmedV5Query query) {
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
   * <code>arireg.paringesindus_v1.v1</code> service.
   */
  List<ParingesindusEttevote> findParingesindusV1(Integer ariregistriKood,
                                                  String fyysiliseIsikuKood,
                                                  String fyysiliseIsikuEesnimi,
                                                  String fyysiliseIsikuPerenimi) throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.paringesindus_v2.v1</code> service.
   */
  List<ParingesindusV2Ettevote> findParingesindusV2(Integer ariregistriKood,
                                                    String fyysiliseIsikuKood,
                                                    String fyysiliseIsikuEesnimi,
                                                    String fyysiliseIsikuPerenimi)
      throws XTeeServiceConsumptionException;

  /**
   * <code>arireg.paringesindus_v3.v1</code> service.
   */
  List<ParingesindusV3Ettevote> findParingesindusV3(Integer ariregistriKood,
                                                    String fyysiliseIsikuKood,
                                                    String fyysiliseIsikuEesnimi,
                                                    String fyysiliseIsikuPerenimi,
                                                    String ariregisterValjundiFormaat)
      throws XTeeServiceConsumptionException;
}
