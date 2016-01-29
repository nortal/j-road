package com.nortal.jroad.client.kirst;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kirst.database.KirstXTeeDatabase;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTKehaKindlustusalus;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTKehaKindlustused;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTKehaKindlustused2;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTParingKindlustusalus;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTParingKindlustused;
import com.nortal.jroad.client.kirst.types.ee.riik.xtee.kirst.producers.producer.kirst.XTParingKindlustused2;
import com.nortal.jroad.client.service.v2.XTeeDatabaseService;

/**
 * @author Roman Tekhov
 */
@Service("kirstXTeeService")
public class KirstXTeeServiceImpl extends XTeeDatabaseService implements KirstXTeeService {

  @Resource
  private KirstXTeeDatabase kirstXTeeDatabase;


  public XTKehaKindlustused findKindlustusV1(XTParingKindlustusedCallback callback)
      throws XTeeServiceConsumptionException {
    if (callback == null) {
      throw new IllegalArgumentException("Callback can not be null!");
    }
    XTParingKindlustused paring = XTParingKindlustused.Factory.newInstance();

    callback.populate(paring);

    return kirstXTeeDatabase.kindlustusedV1(paring);
  }

  public XTKehaKindlustused2 findKindlustus2(XTParingKindlustused2 paring) throws XTeeServiceConsumptionException {
    return kirstXTeeDatabase.kindlustused2V1(paring);
  }

  public XTKehaKindlustusalus findKindlustusalusV2(KindlustusalusKanneJadaCallback callback)
      throws XTeeServiceConsumptionException {

    if (callback == null) {
      throw new IllegalArgumentException("Callback can not be null!");
    }

    XTParingKindlustusalus keha = XTParingKindlustusalus.Factory.newInstance();
    XTParingKindlustusalus.KanneJada kanneJada = keha.addNewKanneJada();

    callback.populate(kanneJada);

    return kirstXTeeDatabase.kindlustusalusV2(keha);
  }


  public void setKirstXTeeDatabase(KirstXTeeDatabase kirstXTeeDatabase) {
    this.kirstXTeeDatabase = kirstXTeeDatabase;
  }

}
