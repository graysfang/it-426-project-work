package factory_method_pattern;

/*
 * Nicholas Perez
 * 11/28/2017
 * HawaiiAdGenerator.java
 *
 * DESCRIPTION
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class HawaiiAdGenerator implements IRegionalAdGenerator
{

    @Override
    public List<Advertisements> getAppropriateAds()
    {
        return Arrays.asList(
                new Advertisements("hi message 1"),
                new Advertisements("message 2"),
                new Advertisements("message 3"));
    }
}
