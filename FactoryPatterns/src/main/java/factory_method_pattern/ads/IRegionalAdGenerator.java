package factory_method_pattern.ads;
/*
 * Nicholas Perez
 * 11/28/2017
 * IRegionalAdGenerator.java
 *
 * DESCRIPTION
 */

import factory_method_pattern.ads.Advertisements;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public interface IRegionalAdGenerator
{
    public List<Advertisements> getAppropriateAds();
}
