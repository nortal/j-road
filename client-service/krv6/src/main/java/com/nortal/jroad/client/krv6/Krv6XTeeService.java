package com.nortal.jroad.client.krv6;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.krv6.types.eu.x_road.kr.KinnistuLihtandmedResponseDocument;

import java.util.Calendar;

/**
 * Created by raunor
 * on 11.04.2017.
 */
public interface Krv6XTeeService {
    /**
     * <code>kr.kinnistu_lihtandmed_paring.v1</code> service
     */
    KinnistuLihtandmedResponseDocument.KinnistuLihtandmedResponse findKinnistuLihtandmed(
            String eesnimi, String perenimiJuriidilinenimi, String isikukood, Calendar synniaeg,
            Integer pageNr, Integer pageMaxRows)
            throws XRoadServiceConsumptionException;

    /**
     * <code>kr.kinnistu_lihtandmed_paring.v1</code> service
     */
    KinnistuLihtandmedResponseDocument.KinnistuLihtandmedResponse findKinnistuLihtandmed(
            String eesnimi, String perenimiJuriidilinenimi, String isikukood, Calendar synniaeg,
            Integer pageNr, Integer pageMaxRows, String userIdCode)
            throws XRoadServiceConsumptionException;
}
