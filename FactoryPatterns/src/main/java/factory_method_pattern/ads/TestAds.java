package factory_method_pattern.ads;

/*
 * Nicholas Perez
 * 11/28/2017
 * TestAds.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class TestAds
{
    public static void main(String[] args)
    {
        HawaiiAds generator = new HawaiiAds();

        Advertisements advertisements = generator.getAd();

        System.out.println(advertisements.getMessage());
    }

}
