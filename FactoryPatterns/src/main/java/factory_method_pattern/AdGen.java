package factory_method_pattern;

/*
 * Nicholas Perez
 * 11/28/2017
 * AdGen.java
 *
 * DESCRIPTION
 */

import java.util.List;
import java.util.Random;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public abstract class AdGen
{
    private List<Advertisements> ads;

    public AdGen()
    {
    }

    protected abstract IRegionalAdGenerator getRegionalGen();

    public Advertisements getAd()
    {
        //lazy init pattern
        if(ads == null)
        {
            //asking the child class for the ad generator
            ads =  getRegionalGen().getAppropriateAds();
        }
        return ads.get(new Random().nextInt(ads.size()));
    }
}
