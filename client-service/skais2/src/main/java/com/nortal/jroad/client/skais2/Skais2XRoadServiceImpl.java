package com.nortal.jroad.client.skais2;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.skais2.database.Skais2XRoadDatabase;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hasso Mehide <hasso.mehide@nortal.com>
 */
@Service("skais2XRoadService")
public class Skais2XRoadServiceImpl implements Skais2XRoadService {

    @Resource
    private Skais2XRoadDatabase skais2XRoadDatabase;

    @Override
    public TVHYhisTaotlusResponse tvhTaotlusYksUksV1(TVHYhisTaotlusRequest request) throws XTeeServiceConsumptionException {
        return skais2XRoadDatabase.tvhTaotlusYksUksV1(request);
    }

}
