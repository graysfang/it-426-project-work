package factory_method_pattern.ads;

/*
 * Nicholas Perez
 * 11/28/2017
 * WashintonAdGenerator.java
 *
 * DESCRIPTION
 */

import factory_method_pattern.ads.Advertisements;
import factory_method_pattern.ads.IRegionalAdGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class WashintonAdGenerator implements IRegionalAdGenerator
{
    @Override
    public List<Advertisements> getAppropriateAds()
    {
        return Arrays.asList(
                new Advertisements("wa message 1"),
                new Advertisements("wa message 2"),
                new Advertisements("wa message 3"));
    }
}
