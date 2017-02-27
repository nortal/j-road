package com.nortal.jroad.client.ravimiregister;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.ATCKlassifikaator;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Haigus;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Hinnakokkulepe;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Myygiluba;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Pakend;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Piirhind;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Ravimvorm;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Soodustus;
import com.nortal.jroad.client.ravimiregister.types.eu.x_road.koodikeskus.Toimeaine;
import java.util.Date;
import java.util.List;

/**
 * Ravimiregister database X-Road service.
 *
 * @author Aleksei Bogdanov (aleksei.bogdanov@nortal.com)
 */
public interface RavimiregisterXRoadService {

  /**
   * <code>ravimiregister.toimeained.v1</code> service.
   */
  List<String> findToimeained(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.toimeainedByIDArray.v1</code> service.
   */
  List<Toimeaine> findToimeainedDetailandmed(List<String> items) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.ravimvormid.v1</code> service.
   */
  List<String> findRavimvormid(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.ravimvormidByIDArray.v1</code> service.
   */
  List<Ravimvorm> findRavimvormidDetailandmed(List<String> items) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.ATCKlassifikaatorid.v1</code> service.
   */
  List<String> findATCKlassifikaatorid(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.ATCKlassifikaatoridByIDArray.v1</code> service.
   */
  List<ATCKlassifikaator> findATCKlassifikaatoridDetailandmed(List<String> items)
      throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.pakendid.v1</code> service.
   */
  List<String> findPakendid(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.PakendidByIDArray.v2</code> service.
   */
  List<Pakend> findPakendidDetailandmed(List<String> items) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.haigused.v1</code> service.
   */
  List<String> findHaigused(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.haigusedByIDArray.v1</code> service.
   */
  List<Haigus> findHaigusedDetailandmed(List<String> items) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.soodustused.v1</code> service.
   */
  List<String> findSoodustused(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.soodustusedByIDArray.v1</code> service.
   */
  List<Soodustus> findSoodustusedDetailandmed(List<String> items) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.piirhinnad.v1</code> service.
   */
  List<String> findPiirhinnad(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.soodustusedByIDArray.v1</code> service.
   */
  List<Piirhind> findPiirhinnadDetailandmed(List<String> items) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.hinnakokkulepped.v1</code> service.
   */
  List<String> findHinnakokkulepped(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.hinnakokkuleppedByIDArray.v1</code> service.
   */
  List<Hinnakokkulepe> findHinnakokkuleppedDetailandmed(List<String> items) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.myygiload.v1</code> service.
   */
  List<String> findMyygiload(Date date) throws XRoadServiceConsumptionException;

  /**
   * <code>ravimiregister.myygiloadByIDArray.v1</code> service.
   */
  List<Myygiluba> findMyygiloadDetailandmed(List<String> items) throws XRoadServiceConsumptionException;
}
