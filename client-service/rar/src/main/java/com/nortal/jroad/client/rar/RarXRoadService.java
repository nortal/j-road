package com.nortal.jroad.client.rar;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.rar.types.eu.x_road.rm_v6.RarVtaResponseType;

/**
 * @author Kauri Kägo <kauri.kago@nortal.com>
 */
public interface RarXRoadService {

    /**
     * <code>rar.rarVta.v1</code> X-tee service.
     */
    RarVtaResponseType rarVtaV1(String kood) throws XTeeServiceConsumptionException;
}
