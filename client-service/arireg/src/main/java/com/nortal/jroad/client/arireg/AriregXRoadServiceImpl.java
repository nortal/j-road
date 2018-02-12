package com.nortal.jroad.client.arireg;

import com.nortal.jroad.client.arireg.database.AriregXRoadDatabase;
import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.*;
import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;

import com.nortal.jroad.client.service.extractor.CustomExtractor;
import com.nortal.jroad.client.service.v4.XRoadDatabaseService;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;
import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;

/**
 * @author Roman Tekhov
 */
@Service("ariregXRoadService")
public class AriregXRoadServiceImpl extends XRoadDatabaseService implements AriregXRoadService {
  private static final String ARIREG_NAMESPACE = "http://arireg.x-road.eu/producer/";

  @Resource
  private AriregXRoadDatabase ariregXRoadDatabase;

  public List<ParingarikeeludKeeld> findArikeelud(String isikukood, String eesnimi, String perenimi, Date synniaeg)
      throws XTeeServiceConsumptionException {
    ArikeeludV1 arikeelud = ArikeeludV1.Factory.newInstance();
    ParingarikeeludParing paring = arikeelud.addNewKeha();
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

    XTeeMessage<ArikeeludV1Response> response =
        send(new XmlBeansXTeeMessage<ArikeeludV1>(arikeelud), "arikeelud_v1", "v1", null, new AriregExtractor());
    return response.getContent().getKeha().getArikeelud().getItemList();
  }

  public List<DetailandmedV5Ettevotja> findDetailandmedV1(final String isikukood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          boolean ainultKehtivad,
                                                          long maksValjundArv)
      throws XTeeServiceConsumptionException {
    return findDetailandmedV1(new DetailandmedV1ReturnedDataSettingCallback(yldandmed,
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

  public List<DetailandmedV5Ettevotja> findDetailandmedV1(final int ariregistriKood,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          boolean ainultKehtivad,
                                                          long maksValjundArv)
      throws XTeeServiceConsumptionException {
    return findDetailandmedV1(new DetailandmedV1ReturnedDataSettingCallback(yldandmed,
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
  public List<DetailandmedV5Ettevotja> findDetailandmedV1(final Integer ariregistriKood,
                                                          final String arinimi,
                                                          boolean yldandmed,
                                                          boolean isikuandmed,
                                                          boolean menetlusesAvaldused,
                                                          boolean kommertspandiandmed,
                                                          boolean maarused,
                                                          boolean ainultKehtivad,
                                                          long maksValjundArv)
      throws XTeeServiceConsumptionException {
    return findDetailandmedV1(new DetailandmedV1ReturnedDataSettingCallback(yldandmed,
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

  public List<DetailandmedV5Ettevotja> findDetailandmedV1(DetailandmedV1PopulatingCallback callback)
      throws XTeeServiceConsumptionException {

    DetailandmedV1Document requestDocument = DetailandmedV1Document.Factory.newInstance();
    DetailandmedV1 detailandmedV1 = requestDocument.addNewDetailandmedV1();

    callback.populate(detailandmedV1);

    XTeeMessage<DetailandmedV1Response> response = send(new XmlBeansXTeeMessage<DetailandmedV1>(detailandmedV1),
                                                        "detailandmed_v1",
                                                        "v1",
                                                        null,
                                                        new AriregExtractor());
    return response.getContent().getKeha().getEttevotjad().getItemList();
  }

  public EttevotjaMuudatusedTasutaV1Response findEttevotjaMuudatusedTasutaV1(EttevotjaMuudatusedTasutaReturnedDataSettingCallback callback)
      throws XTeeServiceConsumptionException {
    EttevotjaMuudatusedTasutaV1Document query = EttevotjaMuudatusedTasutaV1Document.Factory.newInstance();
    EttevotjaMuudatusedTasutaV1 ettevotjaMuudatusedTasutaV1 = query.addNewEttevotjaMuudatusedTasutaV1();

    callback.populate(ettevotjaMuudatusedTasutaV1);

    XTeeMessage<EttevotjaMuudatusedTasutaV1Response> response =
        send(new XmlBeansXTeeMessage<EttevotjaMuudatusedTasutaV1>(ettevotjaMuudatusedTasutaV1),
             "ettevotjaMuudatusedTasuta_v1",
             "v1",
             null,
             new AriregExtractor());
    return response.getContent();
  }

  public EttevotjaMuudatusedTasutaTootukassaV1Response findEttevotjaMuudatusedTasutaTootukassaV1(Date algusKp,
                                                                                                 Date loppKp,
                                                                                                 String[] kandesIsikudRollid,
                                                                                                 Integer tulemusteLk)
      throws XTeeServiceConsumptionException {

    Calendar algus = Calendar.getInstance();
    Calendar lopp = Calendar.getInstance();
    algus.setTime(algusKp);
    lopp.setTime(loppKp);

    EttevotjaMuudatusedTasutaTootukassaV1Document element =
        EttevotjaMuudatusedTasutaTootukassaV1Document.Factory.newInstance();
    EttevotjaMuudatusedTasutaTootukassaV1 request = element.addNewEttevotjaMuudatusedTasutaTootukassaV1();
    EttevotjaMuudatusedTasutaTootukassaParing query = request.addNewKeha();
    query.setAlguskuupaev(algus);
    query.setLoppkuupaev(lopp);
    query.setKandesIsikudRollidArray(kandesIsikudRollid);
    if (tulemusteLk != null) {
      query.setTulemusteLk(tulemusteLk);
    }

    XTeeMessage<EttevotjaMuudatusedTasutaTootukassaV1Response> response =
        send(new XmlBeansXTeeMessage<EttevotjaMuudatusedTasutaTootukassaV1>(request),
             "ettevotjaMuudatusedTasutaTootukassa_v1",
             "v1",
             null,
             new AriregExtractor());

    return response.getContent();
  }

  public class AriregExtractor extends CustomExtractor<XTeeMessage<XmlObject>> {

    @Override
    public XTeeMessage<XmlObject> extractData(WebServiceMessage webServiceMessage)
        throws IOException, TransformerException {
      XTeeMessage<XmlObject> response = extractor.extractData(webServiceMessage);
      XmlObject content = response.getContent();
      XmlCursor cursor = content.newCursor();
      while (cursor.hasNextToken()) {
        cursor.toNextToken();
        if (cursor.isStart()) {
          QName name = cursor.getName();
          if (StringUtils.isBlank(name.getNamespaceURI())) {
            cursor.setName(new QName(ARIREG_NAMESPACE, name.getLocalPart()));
          }
        }
      }
      cursor.dispose();
      return response;
    }
  }
}
