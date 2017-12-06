package abstract_factory_pattern.shipping;

/*
 * Nicholas Perez
 * 11/30/2017
 * EUShippingRate.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class EUShippingRate implements IShippingRate
{

    @Override
    public double rate(double weight)
    {
        //0.5 euros per pound
        return 0.5* weight;
    }
}
