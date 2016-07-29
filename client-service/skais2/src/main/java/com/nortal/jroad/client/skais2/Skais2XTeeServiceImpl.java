package com.nortal.jroad.client.skais2;

import com.nortal.jroad.client.exception.XTeeServiceConsumptionException;
import com.nortal.jroad.client.skais2.database.Skais2XTeeDatabase;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusRequest;
import com.nortal.jroad.client.skais2.types.ee.som.skais2.producer.skais2.TVHYhisTaotlusResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hasso Mehide <hasso.mehide@nortal.com>
 */
@Service("skais2XTeeService")
public class Skais2XTeeServiceImpl implements Skais2XTeeService {

    @Resource
    private Skais2XTeeDatabase skais2XTeeDatabase;

    @Override
    public TVHYhisTaotlusResponse tvhTaotlusYksUksV1(TVHYhisTaotlusRequest request) throws XTeeServiceConsumptionException {
        return skais2XTeeDatabase.tvhTaotlusYksUksV1(request);
    }

}
