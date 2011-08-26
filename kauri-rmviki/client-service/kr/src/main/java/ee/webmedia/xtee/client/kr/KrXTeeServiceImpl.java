package ee.webmedia.xtee.client.kr;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.kr.database.KrXTeeDatabase;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuDetailMaParing;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuDetailMaVastus;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuParing;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KinnistuVastus;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KpijIsikType;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KpijParing;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.KpijVastus;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.PolitseiEhakParing;
import ee.webmedia.xtee.client.kr.types.ee.riik.xtee.kr.producers.producer.kr.PolitseiEhakVastus;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Allar Saarnak
 */
@Service("krXTeeService")
public class KrXTeeServiceImpl implements KrXTeeService {

  @Resource
  private KrXTeeDatabase krXTeeDatabase;


  public KinnistuVastus findKinnistuV2(String katastritunnus)
      throws XTeeServiceConsumptionException, IllegalArgumentException {
    if(katastritunnus == null){
    	throw new IllegalArgumentException("Katastritunnus can't be null");
    }
    KinnistuParing paring = KinnistuParing.Factory.newInstance();

    paring.setKatastritunnus(katastritunnus);

    return krXTeeDatabase.kinnistuV2(paring);
  }

  public List<KpijIsikType> findKpijV2(String eesnimi, String perenimiJuriidilinenimi, String isikukood, Calendar synniaeg)
  		throws XTeeServiceConsumptionException, IllegalArgumentException {

	  return findKpijVastusV2(eesnimi, perenimiJuriidilinenimi, isikukood, synniaeg).getIsikud().getItemList();
  }

  public KpijVastus findKpijVastusV2(String eesnimi, String perenimiJuriidilinenimi, String isikukood, Calendar synniaeg)
      throws XTeeServiceConsumptionException, IllegalArgumentException {

  	if(perenimiJuriidilinenimi == null && isikukood == null){
  			throw new IllegalArgumentException("Perenimi and Isikukood can't be null");
  	}
  	KpijParing paring = KpijParing.Factory.newInstance();
  	paring.setEesnimi(eesnimi);
  	paring.setPerenimiJuriidilinenimi(perenimiJuriidilinenimi);
  	paring.setIsikukood(isikukood);
  	paring.setSynniaeg(synniaeg);

  	return krXTeeDatabase.kinnistuParingIsikuJargiV2(paring);
  }

  public PolitseiEhakVastus findPolitseiEhakV2(Long maakond, Long vald, Long kyla, String aadress, String korter, String koodaadress, BigInteger adrId)
      throws XTeeServiceConsumptionException {

		PolitseiEhakParing paring = PolitseiEhakParing.Factory.newInstance();
		paring.setMaakond(maakond != null ? maakond.toString() : null);
		paring.setVald(vald != null ? vald.toString() : null);
		paring.setKyla(kyla != null ? kyla.toString() : null);
		paring.setAadress(aadress);
		paring.setKorter(korter);
		paring.setKoodaadress(koodaadress);
		paring.setADRID(adrId);

		return krXTeeDatabase.politseiEhakV2(paring);
  }

  public KinnistuDetailMaVastus findKinnstuDetailMa(String registriosaNr, Boolean kehtivus)
      throws XTeeServiceConsumptionException {

  	KinnistuDetailMaParing paring = KinnistuDetailMaParing.Factory.newInstance();
  	paring.setRegistriosaNr(registriosaNr);
  	paring.setKehtivus(kehtivus);

  	return krXTeeDatabase.kinnistuDetailMaV2(paring);
  }


  public void setKrXTeeDatabase(KrXTeeDatabase krXTeeDatabase) {
    this.krXTeeDatabase = krXTeeDatabase;
  }
}