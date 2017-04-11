package ee.icefire.xtee.client.rr;

import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import com.nortal.jroad.client.rrv6.types.eu.x_road.rr.producer.RR84IsikuSeosedResponseDocument;

/**
 * Created by raunor
 * on 11.04.2017.
 */
public interface Rrv6XTeeService {
    /**
     * <code>rr.RR84IsikuSeosed.v1</code>
     */
    public RR84IsikuSeosedResponseDocument.RR84IsikuSeosedResponse findIsikuSeosedV1(String isikukood) throws XRoadServiceConsumptionException;
}
