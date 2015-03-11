package com.nortal.jroad.client.teavituskalender;

import java.util.Calendar;

import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.SyndmuseTyyp;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.Tahtsus;
import com.nortal.jroad.client.teavituskalender.types.ee.riik.xtee.teavituskalender.producers.producer.teavituskalender.LisaSyndmusParing.Lugejad.Item.KasutajaTyyp;

/**
 * @author Aleksandr.Koltakov
 */
public class Syndmus {
  private boolean nahtavOmanikule;
  private String kirjeldus;
  private String aktivineTeavitus;
  private String aegunudTeavitus;
  private Tahtsus.Enum tahtsus;
  private SyndmuseTyyp.Enum syndmuseTyyp;
  private String liik;
  private Calendar algus;
  private Calendar lopp;
  private Calendar teavitusAlgus;
  private Calendar teavitusLopp;
  private Calendar aegumine;
  private String isikukood;
  private KasutajaTyyp.Enum kasutajaTyyp;

  public boolean isNahtavOmanikule() {
    return nahtavOmanikule;
  }

  public void setNahtavOmanikule(boolean nahtavOmanikule) {
    this.nahtavOmanikule = nahtavOmanikule;
  }

  public String getKirjeldus() {
    return kirjeldus;
  }

  public void setKirjeldus(String kirjeldus) {
    this.kirjeldus = kirjeldus;
  }

  public String getAktivineTeavitus() {
    return aktivineTeavitus;
  }

  public void setAktivineTeavitus(String aktivineTeavitus) {
    this.aktivineTeavitus = aktivineTeavitus;
  }

  public String getAegunudTeavitus() {
    return aegunudTeavitus;
  }

  public void setAegunudTeavitus(String aegunudTeavitus) {
    this.aegunudTeavitus = aegunudTeavitus;
  }

  public Tahtsus.Enum getTahtsus() {
    return tahtsus;
  }

  public void setTahtsus(Tahtsus.Enum tahtsus) {
    this.tahtsus = tahtsus;
  }

  public SyndmuseTyyp.Enum getSyndmuseTyyp() {
    return syndmuseTyyp;
  }

  public void setSyndmuseTyyp(SyndmuseTyyp.Enum syndmuseTyyp) {
    this.syndmuseTyyp = syndmuseTyyp;
  }

  public String getLiik() {
    return liik;
  }

  public void setLiik(String liik) {
    this.liik = liik;
  }

  public Calendar getAlgus() {
    return algus;
  }

  public void setAlgus(Calendar algus) {
    this.algus = algus;
  }

  public Calendar getLopp() {
    return lopp;
  }

  public void setLopp(Calendar lopp) {
    this.lopp = lopp;
  }

  public Calendar getTeavitusAlgus() {
    return teavitusAlgus;
  }

  public void setTeavitusAlgus(Calendar teavitusAlgus) {
    this.teavitusAlgus = teavitusAlgus;
  }

  public Calendar getTeavitusLopp() {
    return teavitusLopp;
  }

  public void setTeavitusLopp(Calendar teavitusLopp) {
    this.teavitusLopp = teavitusLopp;
  }

  public Calendar getAegumine() {
    return aegumine;
  }

  public void setAegumine(Calendar aegumine) {
    this.aegumine = aegumine;
  }

  public String getIsikukood() {
    return isikukood;
  }

  public void setIsikukood(String isikukood) {
    this.isikukood = isikukood;
  }

  public KasutajaTyyp.Enum getKasutajaTyyp() {
    return kasutajaTyyp;
  }

  public void setKasutajaTyyp(KasutajaTyyp.Enum kasutajaTyyp) {
    this.kasutajaTyyp = kasutajaTyyp;
  }
}
