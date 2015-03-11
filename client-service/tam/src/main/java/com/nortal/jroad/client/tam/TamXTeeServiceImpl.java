package com.nortal.jroad.client.tam;

//import com.nortal.jroad.client.ehis.database.EhisXTeeDatabase;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.service.XTeeDatabaseService;
import com.nortal.jroad.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.MuudatusKoodVastus;
import com.nortal.jroad.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.MuudatuseType;
import com.nortal.jroad.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.Registriisik;
import com.nortal.jroad.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.RegistriisikParing;
import com.nortal.jroad.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.RegistriisikVastus;
import com.nortal.jroad.client.tam.types.ee.riik.xtee.tam.producers.producer.tam.TervishoiutootajaMuudatusParing;
import com.nortal.jroad.model.XTeeMessage;
import com.nortal.jroad.model.XmlBeansXTeeMessage;


/**
 * Queries to Health Board (Terviseamet -- TAM)
 * 
 * @author Klaus-Eduard Runnel
 */
@Service("tamXTeeService")
public class TamXTeeServiceImpl extends XTeeDatabaseService implements TamXTeeService {

  /**
   * <code>tam.registriisik</code> service.
   */
  public List<Registriisik> findRegistriisik(String kood) throws XTeeServiceConsumptionException {
    RegistriisikParing request = RegistriisikParing.Factory.newInstance();
    request.setIsikukood(kood);

    XTeeMessage<RegistriisikVastus> response =    
      send(new XmlBeansXTeeMessage<RegistriisikParing>(request), "registriisik");
    RegistriisikVastus vastus = response.getContent();
    return vastus.getRegistriisikud().getRegistriisikList();
  }

  /**
   * <code>tam.tervishoiutootajamuudatuskood</code> service.
   */
  // TODO: types are integers, should use enum map?
  public List<String> findTervishoiutootajamuudatuskood(Calendar startDate, Calendar endDate, int... types) throws XTeeServiceConsumptionException {
    TervishoiutootajaMuudatusParing request = TervishoiutootajaMuudatusParing.Factory.newInstance();
    request.setMuudatusedAlates(startDate);
    request.setMuudatusedKuni(endDate);
    MuudatuseType changeType = request.addNewMuudatuseTyybid();
    
    for (int type : types) {
      changeType.addMuudatus(type);
    }
    
    XTeeMessage<MuudatusKoodVastus> response =    
        send(new XmlBeansXTeeMessage<TervishoiutootajaMuudatusParing>(request), "tervishoiutootajamuudatuskood");
    MuudatusKoodVastus vastus = response.getContent();
    return vastus.getKoodid().getRegistriKoodList();
  }
}
