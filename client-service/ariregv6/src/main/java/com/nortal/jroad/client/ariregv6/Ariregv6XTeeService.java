package com.nortal.jroad.client.ariregv6;
import com.nortal.jroad.client.ariregv6.types.eu.x_road.arireg.producer.DetailandmedV5Ettevotja;
import com.nortal.jroad.client.exception.XRoadServiceConsumptionException;
import java.util.List;

/**
 * Created by raunor
 * on 11.04.2017.
 */
public interface Ariregv6XTeeService {
    public List<DetailandmedV5Ettevotja> findDetailandmedV1Step2(final String jurisikArk,
                                                                 final String[] jurisikRollJadaArray,
                                                                 boolean yldandmed,
                                                                 boolean isikuandmed,
                                                                 boolean menetlusesAvaldused,
                                                                 boolean kommertspandiandmed,
                                                                 boolean maarused,
                                                                 boolean ainultKehtivad,
                                                                 long maksValjundArv) throws XRoadServiceConsumptionException;

    public List<DetailandmedV5Ettevotja> findDetailandmedV1Step2(final String jurisikArk,
                                                                 final String[] jurisikRollJadaArray,
                                                                 boolean yldandmed,
                                                                 boolean isikuandmed,
                                                                 boolean menetlusesAvaldused,
                                                                 boolean kommertspandiandmed,
                                                                 boolean maarused,
                                                                 boolean ainultKehtivad,
                                                                 long maksValjundArv,
                                                                 String userIdCode) throws XRoadServiceConsumptionException;

    public List<DetailandmedV5Ettevotja> findDetailandmedV1(final long ariregistriKood,
                                                            final String[] fyysIsikuRollideJada,
                                                            boolean yldandmed,
                                                            boolean isikuandmed,
                                                            boolean menetlusesAvaldused,
                                                            boolean kommertspandiandmed,
                                                            boolean maarused,
                                                            boolean ainultKehtivad,
                                                            long maksValjundArv) throws XRoadServiceConsumptionException;

    public List<DetailandmedV5Ettevotja> findDetailandmedV1(final long ariregistriKood,
                                                            final String[] fyysIsikuRollideJada,
                                                            boolean yldandmed,
                                                            boolean isikuandmed,
                                                            boolean menetlusesAvaldused,
                                                            boolean kommertspandiandmed,
                                                            boolean maarused,
                                                            boolean ainultKehtivad,
                                                            long maksValjundArv,
                                                            String userIdCode) throws XRoadServiceConsumptionException;

    public List<DetailandmedV5Ettevotja> findDetailandmedV5(final String fyysiliseIsikuKood,
                                                            final String[] fyysIsikuRollideJada,
                                                            boolean yldandmed,
                                                            boolean isikuandmed,
                                                            boolean menetlusesAvaldused,
                                                            boolean kommertspandiandmed,
                                                            boolean maarused,
                                                            boolean ainultKehtivad,
                                                            long maksValjundArv) throws XRoadServiceConsumptionException;

    public List<DetailandmedV5Ettevotja> findDetailandmedV5(final String fyysiliseIsikuKood,
                                                            final String[] fyysIsikuRollideJada,
                                                            boolean yldandmed,
                                                            boolean isikuandmed,
                                                            boolean menetlusesAvaldused,
                                                            boolean kommertspandiandmed,
                                                            boolean maarused,
                                                            boolean ainultKehtivad,
                                                            long maksValjundArv,
                                                            String userIdCode) throws XRoadServiceConsumptionException;
}

