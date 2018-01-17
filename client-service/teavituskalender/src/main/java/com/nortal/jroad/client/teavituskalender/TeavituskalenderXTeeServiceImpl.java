package com.nortal.jroad.client.teavituskalender;

import javax.annotation.Resource;

import org.apache.xmlbeans.XmlOptions;
import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.client.teavituskalender.database.TeavituskalenderXRoadDatabase;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusVastus;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.Lugejad;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.Lugejad.Item;

/**
 * @author Aleksandr.Koltakov
 */
@Service("teavituskalenderXTeeService")
public class TeavituskalenderXTeeServiceImpl extends XRoadDatabaseService implements TeavituskalenderXTeeService {

  private static final String TYPE = "xsd:anyType[1]";
  private static final String OFFSET = "[0]";

  @Resource
  private TeavituskalenderXRoadDatabase teavituskalenderXRoadDatabase;

  public LisaSyndmusVastus lisaSyndmus(Syndmus syndmus) throws XRoadServiceConsumptionException {

    LisaSyndmusParing paring = LisaSyndmusParing.Factory.newInstance();
    paring.setNahtavOmanikule(syndmus.isNahtavOmanikule());
    paring.setKirjeldus(syndmus.getKirjeldus());
    paring.setAegunudTeavitus(syndmus.getAegunudTeavitus());
    paring.setAktiivneTeavitus(syndmus.getAktivineTeavitus());
    paring.setTahtsus(syndmus.getTahtsus());
    paring.setSyndmuseTyyp(syndmus.getSyndmuseTyyp());
    paring.setLiik(syndmus.getLiik());

    paring.setAlgus(Parser.parseDateTime(syndmus.getAlgus()));
    paring.setLopp(Parser.parseDateTime(syndmus.getLopp()));
    paring.setTeavitusAlgus(Parser.parseDate(syndmus.getTeavitusAlgus()));
    paring.setTeavitusLopp(Parser.parseDate(syndmus.getTeavitusLopp()));
    paring.setAegumine(Parser.parseDate(syndmus.getAegumine()));

    Item kasutaja = Item.Factory.newInstance();

    kasutaja.setKasutajaTyyp(syndmus.getKasutajaTyyp());
    kasutaja.setKood(syndmus.getIsikukood());
    Item[] kasutajad = new Item[1];
    kasutajad[0] = kasutaja;

    XmlOptions options = new XmlOptions();
    Lugejad lugejad = Lugejad.Factory.newInstance(options);
    lugejad.addNewItem();
    lugejad.setArrayType(TYPE);
    lugejad.setOffset(OFFSET);
    lugejad.setItemArray(kasutajad);
    paring.setLugejad(lugejad);

    return teavituskalenderXRoadDatabase.lisaSyndmusV1(paring);
  }


  public void setTeavituskalenderXRoadDatabase(TeavituskalenderXRoadDatabase teavituskalenderXRoadDatabase) {
    this.teavituskalenderXRoadDatabase = teavituskalenderXRoadDatabase;
  }
}
