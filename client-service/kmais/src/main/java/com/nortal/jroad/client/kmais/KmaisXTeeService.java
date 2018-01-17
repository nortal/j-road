// $Id: KmaService.java 545 2008-06-13 11:13:05Z sven $

package com.nortal.jroad.client.kmais;

import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.BlacklistVastus;

import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdIsikukoodNimiFrag;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IllegaalVastus;

import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikutToendavatePvaVastus;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.AlalineElamislubaKleebisPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.DokNumberSala;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.EestiKodanikuPassPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IdPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.IsikukoodNimiFragSala;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ToolubaPvaVastus;
import com.nortal.jroad.client.kmais.types.ee.riik.xtee.kmais.producers.producer.kmais.ValismaalasePassPvaVastus;

/**
 * X-Tee KMA (KMAIS) päringud.
 */
public interface KmaisXTeeService {

	/**
	 * Eesti kodaniku passiandmete päring isikukoodi ja nime fragmendi järgi PVA-le salastatusega
	 */
	EestiKodanikuPassPvaVastus eestiKodaniku19V1(IsikukoodNimiFragSalaCallback callback)
    	throws XRoadServiceConsumptionException;
	
	/**
	 * Välismaalase passiandmete päring isikukoodi ja nime fragmendi järgi PVA-le salastatusega
	 */
	ValismaalasePassPvaVastus valismaalasePassiandmete12V1(IsikukoodNimiFragSalaCallback callback)
		throws XRoadServiceConsumptionException;
	
	interface IsikukoodNimiFragSalaCallback {
		void populate(IsikukoodNimiFragSala infs);
	}
	
	/**
	 * Isikut tõendavate dokumentide andmete päring isikukoodi ja nime fragmendi järgi PVA-le salastatusega
	 */
	IsikutToendavatePvaVastus isikutToendavate6V1(String isikukood, String eesnimi, String perenimi, String synniaeg, Integer salastusPaevi) throws XRoadServiceConsumptionException;
	
	/**
	 * Eestis ebaseaduslikult viibivate isikute andmete päring isikukoodi ja nime fragmendi järgi
	 */
	IllegaalVastus ebaseaduslikult2(IdIsikukoodNimiFrag request) throws XRoadServiceConsumptionException;
	
	/**
	 * Sissesõidukeeldu omavate isikute päring isikukoodi ja nime fragmendi järgi
	 */
	BlacklistVastus sissesoiduKeelduOmavate2(IdIsikukoodNimiFrag request) throws XRoadServiceConsumptionException;
	
	/**
	 * Eesti kodaniku passiandmete päring dokumendi numbri järgi PVA-le salastatusega
	 */
	EestiKodanikuPassPvaVastus eestiKodaniku17(DokNumberSala request) throws XRoadServiceConsumptionException;

	/**
	 * Isikutunnistuse andmete päring dokumendi numbri järgi PVA-le salastatusega
	 */
	IdPvaVastus isikutunnistuseAndmete10(DokNumberSala request) throws XRoadServiceConsumptionException;
	
	/**
	 * Välismaalase passiandmete päring dokumendi numbri järgi PVA-le salastatusega
	 */
	ValismaalasePassPvaVastus valismaalasePassiandmete10(DokNumberSala request) throws XRoadServiceConsumptionException;
	
	/**
	 * Elamisloa ja kleebise päring isikukoodi ja nime fragmendi järgi PVA-le salastatusega
	 */
	AlalineElamislubaKleebisPvaVastus alaliseElamisloa6(IsikukoodNimiFragSala request) throws XRoadServiceConsumptionException;
	
	/**
	 * Tööloa andmete päring isikukoodi ja nime järgi PVA-le
	 */
	ToolubaPvaVastus tooloaAndmete10(IsikukoodNimiFragSala request) throws XRoadServiceConsumptionException;
}
