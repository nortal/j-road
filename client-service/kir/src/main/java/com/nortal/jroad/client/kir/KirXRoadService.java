package com.nortal.jroad.client.kir;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.AnnaArvelolekuAndmedResponseDocument.AnnaArvelolekuAndmedResponse;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.ArvelolekuSisendTaiendavOlek;
import com.nortal.jroad.client.kir.types.eu.x_road.kir.LeiaMuudetudAndmetegaKinnipeetavadResponseDocument.LeiaMuudetudAndmetegaKinnipeetavadResponse;

import java.util.Date;
import java.util.Set;

/**
 * <code>kir</code> (Vangide ja kriminaalhooldusaluste register) X-tee service.
 *
 * @author Marti Laast
 */
public interface KirXRoadService {

    AnnaArvelolekuAndmedResponse annaArvelolekuAndmedV1(Date start, Date end, Set<ArvelolekuSisendTaiendavOlek.Enum> requestTypes, Set<String> idCodes) throws XRoadServiceConsumptionException;

    LeiaMuudetudAndmetegaKinnipeetavadResponse leiaMuudetudAndmetegaKinnipeetavadV1(Date start, Date end) throws XRoadServiceConsumptionException;

}
