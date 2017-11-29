package factory_method_pattern;
/*
 * Nicholas Perez
 * 11/28/2017
 * IRegionalAdGenerator.java
 *
 * DESCRIPTION
 */

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
