package com.nortal.jroad.client.kir;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.kir.types.ee.x_road.kir.producer.AnnaArvelolekuAndmedResponse;
import com.nortal.jroad.client.kir.types.ee.x_road.kir.producer.IsikuStaatus;
import com.nortal.jroad.client.kir.types.ee.x_road.kir.producer.LeiaMuudetudAndmetegaKinnipeetavadResponse;

import java.util.Date;
import java.util.Set;

/**
 * <code>kir</code> (Vangide ja kriminaalhooldusaluste register) X-tee service.
 *
 * @author Marti Laast
 */
public interface KirXTeeService {

    AnnaArvelolekuAndmedResponse annaArvelolekuAndmedV1(Date start, Date end, Set<IsikuStaatus.Enum> requestTypes, Set<String> idCodes) throws XTeeServiceConsumptionException;

    LeiaMuudetudAndmetegaKinnipeetavadResponse leiaMuudetudAndmetegaKinnipeetavadV1(Date start, Date end) throws XTeeServiceConsumptionException;

}
