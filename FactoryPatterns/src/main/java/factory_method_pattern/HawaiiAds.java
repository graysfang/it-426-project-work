package factory_method_pattern;

/*
 * Nicholas Perez
 * 11/28/2017
 * HawaiiAds.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class HawaiiAds extends AdGen
{

    @Override
    protected IRegionalAdGenerator getRegionalGen()
    {
        return new HawaiiAdGenerator();
    }
}
