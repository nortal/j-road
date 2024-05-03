package com.nortal.jroad.client.kmais;

import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IllegaalVastus;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.AlalineElamislubaKleebisPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.BlacklistVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.DokNumberSala;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.EestiKodanikuPassPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdIsikukoodNimiFrag;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikukoodNimiFragSala;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikutToendavatePvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ToolubaPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ValismaalasePassPvaVastus;
import com.nortal.jroad.client.service.XRoadDatabaseService;
import com.nortal.jroad.model.XRoadMessage;
import com.nortal.jroad.model.XmlBeansXRoadMessage;

public class KmaisXTeeServiceImpl extends XRoadDatabaseService implements KmaisXTeeService {

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
  
  public EestiKodanikuPassPvaVastus eestiKodaniku19V1(IsikukoodNimiFragSalaCallback callback) throws XRoadServiceConsumptionException {
	  if (callback == null) 
		  throw new IllegalArgumentException("Callback can not be null!");
	  
	  IsikukoodNimiFragSala request = IsikukoodNimiFragSala.Factory.newInstance();
	  callback.populate(request);

	  XRoadMessage<EestiKodanikuPassPvaVastus> response = send(new XmlBeansXRoadMessage<IsikukoodNimiFragSala>(request), KMA_KODANIKU19, "v1", null, null, true);
	  return response.getContent();
  }

  public ValismaalasePassPvaVastus valismaalasePassiandmete12V1(IsikukoodNimiFragSalaCallback callback) throws XRoadServiceConsumptionException {
	  if (callback == null) 
		  throw new IllegalArgumentException("Callback can not be null!");
	  
	  IsikukoodNimiFragSala request = IsikukoodNimiFragSala.Factory.newInstance();
	  callback.populate(request);

	  XRoadMessage<ValismaalasePassPvaVastus> response = send(new XmlBeansXRoadMessage<IsikukoodNimiFragSala>(request), KMA_VALISMAALASE12, "v1", null, null, true);
	  return response.getContent();
  }

  public IsikutToendavatePvaVastus isikutToendavate6V1(String isikukood, String eesnimi, String perenimi, String synniaeg, Integer salastusPaevi) throws XRoadServiceConsumptionException {
	  IsikukoodNimiFragSala request = IsikukoodNimiFragSala.Factory.newInstance();
	  request.setIsikukood(isikukood);
	  request.setEesnimi(eesnimi);
	  request.setPerenimi(perenimi);
	  request.setSynniaeg(synniaeg);
	  if (salastusPaevi != null) request.setSalastusPaevi(salastusPaevi);
		
	  XRoadMessage<IsikutToendavatePvaVastus> vastus = send(new XmlBeansXRoadMessage<IsikukoodNimiFragSala>(request), KMA_ISIKUT_TOENDAVATE6, "v1", null, null, true);
	  return vastus.getContent();
  }
  
  public BlacklistVastus sissesoiduKeelduOmavate2(IdIsikukoodNimiFrag request) throws XRoadServiceConsumptionException {
	  XRoadMessage<BlacklistVastus> response = send(new XmlBeansXRoadMessage<IdIsikukoodNimiFrag>(request), KMA_SISSESOIDUKEELDU_OMAVATE2, "v1", null, null, true);
	  return response.getContent();
  }
  
  public IllegaalVastus ebaseaduslikult2(IdIsikukoodNimiFrag request) throws XRoadServiceConsumptionException {
	  XRoadMessage<IllegaalVastus> response = send(new XmlBeansXRoadMessage<IdIsikukoodNimiFrag>(request), KMA_EBASEADUSLIKULT2, "v1", null, null, true);
	  return response.getContent();
  }
  
  public EestiKodanikuPassPvaVastus eestiKodaniku17(DokNumberSala request) throws XRoadServiceConsumptionException {
	  XRoadMessage<EestiKodanikuPassPvaVastus> response = send(new XmlBeansXRoadMessage<DokNumberSala>(request), EESTI_KODANIKU17, "v1", null, null, true);
	  return response.getContent();
  }
  
  public IdPvaVastus isikutunnistuseAndmete10(DokNumberSala request) throws XRoadServiceConsumptionException {
	  XRoadMessage<IdPvaVastus> response = send(new XmlBeansXRoadMessage<DokNumberSala>(request), ISIKUTUNNISTUSE_ANDMETE10, "v1", null, null, true);
	  return response.getContent();
  }
  
  public ValismaalasePassPvaVastus valismaalasePassiandmete10(DokNumberSala request) throws XRoadServiceConsumptionException {
	  XRoadMessage<ValismaalasePassPvaVastus> response = send(new XmlBeansXRoadMessage<DokNumberSala>(request), VALISMAALASE_PASSIANDMETE10, "v1", null, null, true);
	  return response.getContent();
  }
  
  public AlalineElamislubaKleebisPvaVastus alaliseElamisloa6(IsikukoodNimiFragSala request) throws XRoadServiceConsumptionException {
	  XRoadMessage<AlalineElamislubaKleebisPvaVastus> response = send(new XmlBeansXRoadMessage<IsikukoodNimiFragSala>(request), ALALISE_ELAMISLOA6, "v1", null, null, true);
	  return response.getContent();
  }
  
  public ToolubaPvaVastus tooloaAndmete10(IsikukoodNimiFragSala request) throws XRoadServiceConsumptionException {
	  XRoadMessage<ToolubaPvaVastus> response = send(new XmlBeansXRoadMessage<IsikukoodNimiFragSala>(request), TOOLOA_ANDMETE10, "v1", null, null, true);
	  return response.getContent();
  }
}
