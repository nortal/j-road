package com.nortal.jroad.client.kirst;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kirst.KirstXTeeService;
import com.nortal.jroad.client.kirst.KirstXTeeServiceImpl;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.EeIsikLihtType;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.JurIsikLihtType;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.KindlustusalusKandeTyyp;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.KindlustusalusKanne;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTKehaKindlustusalus;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTKehaKindlustused;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTParingKindlustused;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTParingKindlustusalus.KanneJada;
import com.nortal.jroad.client.test.BaseXTeeServiceImplTest;

/**
 * @author Roman Tekhov
 */
public class KirstXTeeServiceImplTest extends BaseXTeeServiceImplTest {

  @Resource
  private KirstXTeeServiceImpl kirstXTeeServiceImpl;

  @Test
  public void findKindlustusV1() throws XTeeServiceConsumptionException {
    KirstXTeeService.XTParingKindlustusedCallback cb = new KirstXTeeService.XTParingKindlustusedCallback() {
      public void populate(XTParingKindlustused paring) {
        XTParingKindlustused.Kindlustatudisikud isikud = paring.addNewKindlustatudisikud();
        isikud.addItem("38802070254");
        paring.setTyyp(XTParingKindlustused.Tyyp.T_1);
      }
    };

    XTKehaKindlustused response = kirstXTeeServiceImpl.findKindlustusV1(cb);

    Assert.assertNotNull(response);
    Assert.assertTrue(response.getKindlustused() != null);
  }

  @Test
  public void findKindlustusalusV2() throws XTeeServiceConsumptionException {
    KirstXTeeService.KindlustusalusKanneJadaCallback callback = new KirstXTeeService.KindlustusalusKanneJadaCallback() {

      public void populate(KanneJada kanneJada) {
        try {
          DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

          KindlustusalusKanne kanne1 = kanneJada.addNewItem();

          EeIsikLihtType isik1 = kanne1.addNewIsik();
          isik1.setEesnimi("SIIM");
          isik1.setPerenimi("REINSALU");
          isik1.setIsikukood("38706160237");

          Calendar aluseAlgus1 = Calendar.getInstance();
          aluseAlgus1.setTime(dateFormat.parse("15.04.2009"));
          kanne1.setAluseAlgus(aluseAlgus1);

          Calendar kandeAeg1 = Calendar.getInstance();
          kandeAeg1.setTime(dateFormat.parse("24.04.2009"));
          kanne1.setKandeAeg(kandeAeg1);

          kanne1.setLiik(BigInteger.valueOf(1));

          JurIsikLihtType kindlustaja1 = kanne1.addNewKindlustaja();
          kindlustaja1.setKood("ee");
          kindlustaja1.setNimi("Eesti");

          kanne1.setTyyp(KindlustusalusKandeTyyp.K);

          Calendar perAlgus1 = Calendar.getInstance();
          perAlgus1.setTime(dateFormat.parse("15.04.2009"));
          kanne1.setPerAlgus(perAlgus1);

          Calendar perLopp1 = Calendar.getInstance();
          perLopp1.setTime(dateFormat.parse("11.10.2009"));
          kanne1.setPerLopp(perLopp1);

          KindlustusalusKanne kanne2 = kanneJada.addNewItem();

          EeIsikLihtType isik2 = kanne2.addNewIsik();
          isik2.setEesnimi("ALEKSANDR");
          isik2.setPerenimi("SAFRONOV");
          isik2.setIsikukood("38802070254");

          Calendar aluseAlgus2 = Calendar.getInstance();
          aluseAlgus2.setTime(dateFormat.parse("15.04.2009"));
          kanne2.setAluseAlgus(aluseAlgus2);

          Calendar kandeAeg2 = Calendar.getInstance();
          kandeAeg2.setTime(dateFormat.parse("24.04.2009"));
          kanne2.setKandeAeg(kandeAeg2);

          kanne2.setLiik(BigInteger.valueOf(1));

          JurIsikLihtType kindlustaja2 = kanne2.addNewKindlustaja();
          kindlustaja2.setKood("ee");
          kindlustaja2.setNimi("Eesti");

          kanne2.setTyyp(KindlustusalusKandeTyyp.K);

          Calendar perAlgus2 = Calendar.getInstance();
          perAlgus2.setTime(dateFormat.parse("15.04.2009"));
          kanne2.setPerAlgus(perAlgus2);

          Calendar perLopp2 = Calendar.getInstance();
          perLopp2.setTime(dateFormat.parse("11.10.2009"));
          kanne2.setPerLopp(perLopp2);

        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

    };

    XTKehaKindlustusalus response = kirstXTeeServiceImpl.findKindlustusalusV2(callback);

    Assert.assertNotNull(response);
    Assert.assertNotNull(response.getKood());
  }
}
