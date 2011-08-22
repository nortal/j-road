package ee.webmedia.xtee.client.kmais;

import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IllegaalVastus;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.AlalineElamislubaKleebisPvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.BlacklistVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.DokNumberSala;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.EestiKodanikuPassPvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdIsikukoodNimiFrag;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdPvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikukoodNimiFragSala;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikutToendavatePvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ToolubaPvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ValismaalasePassPvaVastus;
import ee.webmedia.xtee.client.service.XTeeDatabaseService;
import ee.webmedia.xtee.model.XTeeMessage;
import ee.webmedia.xtee.model.XmlBeansXTeeMessage;

public class KmaisXTeeServiceImpl extends XTeeDatabaseService implements KmaisXTeeService {

  private static final String KMA_KODANIKU19 = "eesti_kodaniku19";
  private static final String KMA_VALISMAALASE12 = "valismaalase_passiandmete12";
  private static final String KMA_ISIKUT_TOENDAVATE6 = "isikut_toendavate6";
  private static final String KMA_SISSESOIDUKEELDU_OMAVATE2 = "sissesoidukeeldu_omavate2";
  private static final String KMA_EBASEADUSLIKULT2 = "eestis_ebaseaduslikult2";
  private static final String EESTI_KODANIKU17 = "eesti_kodaniku17";
  private static final String ISIKUTUNNISTUSE_ANDMETE10 = "isikutunnistuse_andmete10";  
  private static final String VALISMAALASE_PASSIANDMETE10 = "valismaalase_passiandmete10";
  private static final String ALALISE_ELAMISLOA6 = "alalise_elamisloa6";
  private static final String TOOLOA_ANDMETE10 = "tooloa_andmete10";
  
  public EestiKodanikuPassPvaVastus eestiKodaniku19V1(IsikukoodNimiFragSalaCallback callback) throws XTeeServiceConsumptionException {
	  if (callback == null) 
		  throw new IllegalArgumentException("Callback can not be null!");
	  
	  IsikukoodNimiFragSala request = IsikukoodNimiFragSala.Factory.newInstance();
	  callback.populate(request);

	  XTeeMessage<EestiKodanikuPassPvaVastus> response = send(new XmlBeansXTeeMessage<IsikukoodNimiFragSala>(request), KMA_KODANIKU19, "v1", null, null, true);
	  return response.getContent();
  }

  public ValismaalasePassPvaVastus valismaalasePassiandmete12V1(IsikukoodNimiFragSalaCallback callback) throws XTeeServiceConsumptionException {
	  if (callback == null) 
		  throw new IllegalArgumentException("Callback can not be null!");
	  
	  IsikukoodNimiFragSala request = IsikukoodNimiFragSala.Factory.newInstance();
	  callback.populate(request);

	  XTeeMessage<ValismaalasePassPvaVastus> response = send(new XmlBeansXTeeMessage<IsikukoodNimiFragSala>(request), KMA_VALISMAALASE12, "v1", null, null, true);
	  return response.getContent();
  }

  public IsikutToendavatePvaVastus isikutToendavate6V1(String isikukood, String eesnimi, String perenimi, String synniaeg, Integer salastusPaevi) throws XTeeServiceConsumptionException {
	  IsikukoodNimiFragSala request = IsikukoodNimiFragSala.Factory.newInstance();
	  request.setIsikukood(isikukood);
	  request.setEesnimi(eesnimi);
	  request.setPerenimi(perenimi);
	  request.setSynniaeg(synniaeg);
	  if (salastusPaevi != null) request.setSalastusPaevi(salastusPaevi);
		
	  XTeeMessage<IsikutToendavatePvaVastus> vastus = send(new XmlBeansXTeeMessage<IsikukoodNimiFragSala>(request), KMA_ISIKUT_TOENDAVATE6, "v1", null, null, true);
	  return vastus.getContent();
  }
  
  public BlacklistVastus sissesoiduKeelduOmavate2(IdIsikukoodNimiFrag request) throws XTeeServiceConsumptionException {
	  XTeeMessage<BlacklistVastus> response = send(new XmlBeansXTeeMessage<IdIsikukoodNimiFrag>(request), KMA_SISSESOIDUKEELDU_OMAVATE2, "v1", null, null, true);
	  return response.getContent();
  }
  
  public IllegaalVastus ebaseaduslikult2(IdIsikukoodNimiFrag request) throws XTeeServiceConsumptionException {
	  XTeeMessage<IllegaalVastus> response = send(new XmlBeansXTeeMessage<IdIsikukoodNimiFrag>(request), KMA_EBASEADUSLIKULT2, "v1", null, null, true);
	  return response.getContent();
  }
  
  public EestiKodanikuPassPvaVastus eestiKodaniku17(DokNumberSala request) throws XTeeServiceConsumptionException {
	  XTeeMessage<EestiKodanikuPassPvaVastus> response = send(new XmlBeansXTeeMessage<DokNumberSala>(request), EESTI_KODANIKU17, "v1", null, null, true);
	  return response.getContent();
  }
  
  public IdPvaVastus isikutunnistuseAndmete10(DokNumberSala request) throws XTeeServiceConsumptionException {
	  XTeeMessage<IdPvaVastus> response = send(new XmlBeansXTeeMessage<DokNumberSala>(request), ISIKUTUNNISTUSE_ANDMETE10, "v1", null, null, true);
	  return response.getContent();
  }
  
  public ValismaalasePassPvaVastus valismaalasePassiandmete10(DokNumberSala request) throws XTeeServiceConsumptionException {
	  XTeeMessage<ValismaalasePassPvaVastus> response = send(new XmlBeansXTeeMessage<DokNumberSala>(request), VALISMAALASE_PASSIANDMETE10, "v1", null, null, true);
	  return response.getContent();
  }
  
  public AlalineElamislubaKleebisPvaVastus alaliseElamisloa6(IsikukoodNimiFragSala request) throws XTeeServiceConsumptionException {
	  XTeeMessage<AlalineElamislubaKleebisPvaVastus> response = send(new XmlBeansXTeeMessage<IsikukoodNimiFragSala>(request), ALALISE_ELAMISLOA6, "v1", null, null, true);
	  return response.getContent();
  }
  
  public ToolubaPvaVastus tooloaAndmete10(IsikukoodNimiFragSala request) throws XTeeServiceConsumptionException {
	  XTeeMessage<ToolubaPvaVastus> response = send(new XmlBeansXTeeMessage<IsikukoodNimiFragSala>(request), TOOLOA_ANDMETE10, "v1", null, null, true);
	  return response.getContent();
  }
}
