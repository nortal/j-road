// $Id: KmaService.java 545 2008-06-13 11:13:05Z sven $

package ee.webmedia.xtee.client.kmais;

import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.BlacklistVastus;

import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdIsikukoodNimiFrag;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IllegaalVastus;

import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikutToendavatePvaVastus;

import ee.webmedia.xtee.client.exception.XTeeServiceConsumptionException;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.AlalineElamislubaKleebisPvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.DokNumberSala;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.EestiKodanikuPassPvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdPvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikukoodNimiFragSala;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ToolubaPvaVastus;
import ee.webmedia.xtee.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ValismaalasePassPvaVastus;

/**
 * X-Tee KMA (KMAIS) päringud.
 */
public interface KmaisXTeeService {

	/**
	 * Eesti kodaniku passiandmete päring isikukoodi ja nime fragmendi järgi PVA-le salastatusega
	 */
	EestiKodanikuPassPvaVastus eestiKodaniku19V1(IsikukoodNimiFragSalaCallback callback)
    	throws XTeeServiceConsumptionException;
	
	/**
	 * Välismaalase passiandmete päring isikukoodi ja nime fragmendi järgi PVA-le salastatusega
	 */
	ValismaalasePassPvaVastus valismaalasePassiandmete12V1(IsikukoodNimiFragSalaCallback callback)
		throws XTeeServiceConsumptionException;
	
	interface IsikukoodNimiFragSalaCallback {
		void populate(IsikukoodNimiFragSala infs);
	}
	
	/**
	 * Isikut tõendavate dokumentide andmete päring isikukoodi ja nime fragmendi järgi PVA-le salastatusega
	 */
	IsikutToendavatePvaVastus isikutToendavate6V1(String isikukood, String eesnimi, String perenimi, String synniaeg, Integer salastusPaevi) throws XTeeServiceConsumptionException;
	
	/**
	 * Eestis ebaseaduslikult viibivate isikute andmete päring isikukoodi ja nime fragmendi järgi
	 */
	IllegaalVastus ebaseaduslikult2(IdIsikukoodNimiFrag request) throws XTeeServiceConsumptionException;
	
	/**
	 * Sissesõidukeeldu omavate isikute päring isikukoodi ja nime fragmendi järgi
	 */
	BlacklistVastus sissesoiduKeelduOmavate2(IdIsikukoodNimiFrag request) throws XTeeServiceConsumptionException;
	
	/**
	 * Eesti kodaniku passiandmete päring dokumendi numbri järgi PVA-le salastatusega
	 */
	EestiKodanikuPassPvaVastus eestiKodaniku17(DokNumberSala request) throws XTeeServiceConsumptionException;

	/**
	 * Isikutunnistuse andmete päring dokumendi numbri järgi PVA-le salastatusega
	 */
	IdPvaVastus isikutunnistuseAndmete10(DokNumberSala request) throws XTeeServiceConsumptionException;
	
	/**
	 * Välismaalase passiandmete päring dokumendi numbri järgi PVA-le salastatusega
	 */
	ValismaalasePassPvaVastus valismaalasePassiandmete10(DokNumberSala request) throws XTeeServiceConsumptionException;
	
	/**
	 * Elamisloa ja kleebise päring isikukoodi ja nime fragmendi järgi PVA-le salastatusega
	 */
	AlalineElamislubaKleebisPvaVastus alaliseElamisloa6(IsikukoodNimiFragSala request) throws XTeeServiceConsumptionException;
	
	/**
	 * Tööloa andmete päring isikukoodi ja nime järgi PVA-le
	 */
	ToolubaPvaVastus tooloaAndmete10(IsikukoodNimiFragSala request) throws XTeeServiceConsumptionException;
}
