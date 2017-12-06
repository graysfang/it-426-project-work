package abstract_factory_pattern.factories;
/*
 * Nicholas Perez
 * 11/30/2017
 * IOrderFactory.java
 *
 * DESCRIPTION
 */

import abstract_factory_pattern.sales_tax.ISalesTax;
import abstract_factory_pattern.shipping.IShippingRate;

/**
 * This interface provides access to a family of factory classes
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public interface IOrderFactory
{
    public ISalesTax salesTaxCalculator();

    public IShippingRate shippingRateCalculator();
}
