package factory_method_pattern.ads;

/*
 * Nicholas Perez
 * 11/28/2017
 * WashingtonAds.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class WashingtonAds extends AdGen
{

    @Override
    protected IRegionalAdGenerator getRegionalGen()
    {
        return new WashintonAdGenerator();
    }
}
