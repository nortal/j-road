package ee.webmedia.xtee.client.kutseregister;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.kutseregister.database.KutseregisterXTeeDatabase;
import ee.webmedia.xtee.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusParing;
import ee.webmedia.xtee.client.kutseregister.types.ee.riik.xtee.kutseregister.producers.producer.kutseregister.KutsetunnistusVastus;
import java.util.Calendar;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Anti Orgla
 */
@Service("kutseregisterXTeeServiceImpl")
public class KutseregisterXTeeServiceImpl implements KutseregisterXTeeService {

  @Resource
  private KutseregisterXTeeDatabase kutseregisterXTeeDatabase;

  @Override
  public KutsetunnistusVastus findKutseTunnistus(String isikukood, String nimi) throws XTeeServiceConsumptionException {
    KutsetunnistusParing paring = KutsetunnistusParing.Factory.newInstance();
	if(isikukood != null){
    	paring.setIsikukood(isikukood);
	}
	if(nimi != null){
		paring.setNimi(nimi);
	}
    return kutseregisterXTeeDatabase.kutsetunnistusV2(paring);

  }
}
