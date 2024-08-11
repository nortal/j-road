package com.nortal.jroad.client.ravimiregister;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.ATCKlassifikaator;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Haigus;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Hinnakokkulepe;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Myygiluba;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Pakend;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Piirhind;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Ravimvorm;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Soodustus;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.ravimiregister.Toimeaine;
import com.nortal.jroad.client.test.BaseXRoadServiceImplTest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public class RavimiregisterXRoadServiceImplTest extends BaseXRoadServiceImplTest {

  @Resource
  private RavimiregisterXRoadServiceImpl ravimiametXRoadServiceImpl;

  @Test
  public void findATCKlassifikaatoridv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -10);
    List<String> items = ravimiametXRoadServiceImpl.findATCKlassifikaatorid(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findATCKlassifikaatoridDetailandmedv1() throws XRoadServiceConsumptionException {
    String ATCKood = "A01AA01";
    List<String> ATCKoodid = new ArrayList<String>();
    ATCKoodid.add(ATCKood);
    List<ATCKlassifikaator> items = ravimiametXRoadServiceImpl.findATCKlassifikaatoridDetailandmed(ATCKoodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
    ATCKlassifikaator klassifikaator = items.get(0);
    Assertions.assertTrue(ATCKood.equals(klassifikaator.getKood()));
    Assertions.assertEquals("naatriumfluoriid", klassifikaator.getNimiEesti());
  }

  @Test
  public void findHaigusedv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -10);
    List<String> items = ravimiametXRoadServiceImpl.findToimeained(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findHaigusedDetailandmedv1() throws XRoadServiceConsumptionException {
    String haiguseKood = "3";
    List<String> haiguseKoodid = new ArrayList<String>();
    haiguseKoodid.add(haiguseKood);
    List<Haigus> items = ravimiametXRoadServiceImpl.findHaigusedDetailandmed(haiguseKoodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
    Haigus haigus = items.get(0);
    Assertions.assertTrue(haiguseKood.equals(haigus.getKood()));
  }

  @Test
  public void findPakendidv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -1);
    List<String> items = ravimiametXRoadServiceImpl.findPakendid(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findPakendidDetailandmedv3() throws XRoadServiceConsumptionException {
    String pakendiKood = "1026177";
    List<String> pakendiKoodid = new ArrayList<String>();
    pakendiKoodid.add(pakendiKood);
    List<Pakend> items = ravimiametXRoadServiceImpl.findPakendidDetailandmed(pakendiKoodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
    Pakend pakend = items.get(0);
    Assertions.assertTrue(pakendiKood.equals(pakend.getKood()));
  }

  @Test
  public void findRavimvormidv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -10);
    List<String> items = ravimiametXRoadServiceImpl.findRavimvormid(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findRavimvormidDetailandmedv1() throws XRoadServiceConsumptionException {
    String ravimvormiKood = "748";
    List<String> ravimvormiKoodid = new ArrayList<String>();
    ravimvormiKoodid.add(ravimvormiKood);
    List<Ravimvorm> items = ravimiametXRoadServiceImpl.findRavimvormidDetailandmed(ravimvormiKoodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
    Ravimvorm ravimvorm = items.get(0);
    Assertions.assertTrue(ravimvormiKood.equals(ravimvorm.getId().toString()));
  }

  @Test
  public void findSoodustusedv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -10);
    List<String> items = ravimiametXRoadServiceImpl.findSoodustused(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findSoodustusedDetailandmedv1() throws XRoadServiceConsumptionException {
    String soodustuseKood = "374435";
    List<String> soodustuseKoodid = new ArrayList<String>();
    soodustuseKoodid.add(soodustuseKood);
    List<Soodustus> items = ravimiametXRoadServiceImpl.findSoodustusedDetailandmed(soodustuseKoodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
    Soodustus soodustus = items.get(0);
    Assertions.assertTrue(soodustuseKood.equals(soodustus.getId().toString()));
  }

  @Test
  public void findToimeainedv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -10);
    List<String> items = ravimiametXRoadServiceImpl.findToimeained(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findToimeainedDetailandmedv1() throws XRoadServiceConsumptionException {
    String toimeaineKood = "8874";
    List<String> toimeaineKoodid = new ArrayList<String>();
    toimeaineKoodid.add(toimeaineKood);
    List<Toimeaine> items = ravimiametXRoadServiceImpl.findToimeainedDetailandmed(toimeaineKoodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
    Toimeaine toimeaine = items.get(0);
    Assertions.assertTrue(toimeaineKood.equals(toimeaine.getId().toString()));
  }

  @Test
  public void findPiirhinnadv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -12);
    List<String> items = ravimiametXRoadServiceImpl.findPiirhinnad(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findPiirhinnadDetailandmedv1() throws XRoadServiceConsumptionException {
    String piirhinnaKood = "32120";
    List<String> koodid = Collections.singletonList(piirhinnaKood);
    List<Piirhind> items = ravimiametXRoadServiceImpl.findPiirhinnadDetailandmed(koodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
  }

  @Test
  public void findHinnakokkuleppedv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -12);
    List<String> items = ravimiametXRoadServiceImpl.findHinnakokkulepped(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findHinnakokkuleppedDetailandmedv1() throws XRoadServiceConsumptionException {
    String kood = "5072";
    List<String> koodid = Collections.singletonList(kood);
    List<Hinnakokkulepe> items = ravimiametXRoadServiceImpl.findHinnakokkuleppedDetailandmed(koodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
  }

  @Test
  public void findMyygiloadv1() throws XRoadServiceConsumptionException {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -12);
    List<String> items = ravimiametXRoadServiceImpl.findMyygiload(calendar.getTime());
    Assertions.assertNotNull(items);
  }

  @Test
  public void findMyygiloadDetailandmedv1() throws XRoadServiceConsumptionException {
    String kood = "697010_24085";
    List<String> koodid = Collections.singletonList(kood);
    List<Myygiluba> items = ravimiametXRoadServiceImpl.findMyygiloadDetailandmed(koodid);
    Assertions.assertNotNull(items);
    Assertions.assertTrue(items.size() == 1);
  }
}
