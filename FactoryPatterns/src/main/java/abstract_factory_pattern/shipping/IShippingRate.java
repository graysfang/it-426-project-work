package abstract_factory_pattern.shipping;
/*
 * Nicholas Perez
 * 11/30/2017
 * IShippingRate.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public interface IShippingRate
{
    public double rate(double weight);
}
