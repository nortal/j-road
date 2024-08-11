package com.nortal.jroad.client.arireg;

import com.nortal.jroad.client.arireg.database.AriregXRoadDatabase;
import com.nortal.jroad.client.arireg.types.eu.x_road.arireg.producer.*;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;
import jakarta.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;

import com.nortal.jroad.client.service.extractor.CustomExtractor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
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
      throws XRoadServiceConsumptionException {
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

    XRoadMessage<ArikeeludV1Response> response =
        send(new XmlBeansXRoadMessage<>(arikeelud), "arikeelud_v1", "v1", null, new AriregExtractor());
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
      throws XRoadServiceConsumptionException {
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
      throws XRoadServiceConsumptionException {
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
      throws XRoadServiceConsumptionException {
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
      throws XRoadServiceConsumptionException {

    DetailandmedV1Document requestDocument = DetailandmedV1Document.Factory.newInstance();
    DetailandmedV1 detailandmedV1 = requestDocument.addNewDetailandmedV1();

    callback.populate(detailandmedV1);

    XRoadMessage<DetailandmedV1Response> response = send(new XmlBeansXRoadMessage<DetailandmedV1>(detailandmedV1),
                                                        "detailandmed_v1",
                                                        "v1",
                                                        null,
                                                        new AriregExtractor());
    return response.getContent().getKeha().getEttevotjad().getItemList();
  }

  public EttevotjaMuudatusedTasutaV1Response findEttevotjaMuudatusedTasutaV1(EttevotjaMuudatusedTasutaReturnedDataSettingCallback callback)
      throws XRoadServiceConsumptionException {
    EttevotjaMuudatusedTasutaV1Document query = EttevotjaMuudatusedTasutaV1Document.Factory.newInstance();
    EttevotjaMuudatusedTasutaV1 ettevotjaMuudatusedTasutaV1 = query.addNewEttevotjaMuudatusedTasutaV1();

    callback.populate(ettevotjaMuudatusedTasutaV1);

    XRoadMessage<EttevotjaMuudatusedTasutaV1Response> response =
        send(new XmlBeansXRoadMessage<EttevotjaMuudatusedTasutaV1>(ettevotjaMuudatusedTasutaV1),
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
      throws XRoadServiceConsumptionException {

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

    XRoadMessage<EttevotjaMuudatusedTasutaTootukassaV1Response> response =
        send(new XmlBeansXRoadMessage<EttevotjaMuudatusedTasutaTootukassaV1>(request),
             "ettevotjaMuudatusedTasutaTootukassa_v1",
             "v1",
             null,
             new AriregExtractor());

    return response.getContent();
  }

  @Override
  public List<Seos> findEttevottegaSeotudIsikudV1(Long ariregistriKood, String isikukood, Boolean vastupidi) throws XRoadServiceConsumptionException {
    EttevottegaSeotudIsikudV1 query = EttevottegaSeotudIsikudV1.Factory.newInstance();
    EttevottegaSeotudIsikudParing keha = EttevottegaSeotudIsikudParing.Factory.newInstance();
    if (isikukood != null) {
      keha.setFyysiliseIsikuKood(isikukood);
    }
    if (ariregistriKood != null) {
      keha.setAriregistriKood(BigInteger.valueOf(ariregistriKood));
    }
    keha.setVastupidi(BooleanUtils.isTrue(vastupidi));
    query.setKeha(keha);

    XRoadMessage<EttevottegaSeotudIsikudV1Response> response =
            send(new XmlBeansXRoadMessage<EttevottegaSeotudIsikudV1>(query), "ettevottegaSeotudIsikud_v1", "v1", null, new AriregExtractor());
    return response.getContent().getKeha().getSeosedList();
  }

  public class AriregExtractor extends CustomExtractor<XRoadMessage<XmlObject>> {

    @Override
    public XRoadMessage<XmlObject> extractData(WebServiceMessage webServiceMessage)
        throws IOException, TransformerException {
      XRoadMessage<XmlObject> response = extractor.extractData(webServiceMessage);
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
