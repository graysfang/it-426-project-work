package abstract_factory_pattern.factories;

/*
 * Nicholas Perez
 * 12/5/2017
 * USOrderFactory.java
 *
 * DESCRIPTION
 */

import abstract_factory_pattern.sales_tax.ISalesTax;
import abstract_factory_pattern.sales_tax.USSalesTax;
import abstract_factory_pattern.shipping.IShippingRate;
import abstract_factory_pattern.shipping.USShippingRate;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class USOrderFactory implements IOrderFactory
{
    private int zipcode;

    public USOrderFactory(int zipcode)
    {
        this.zipcode = zipcode;
    }

    @Override
    public ISalesTax salesTaxCalculator()
    {
        return new USSalesTax(zipcode);
    }

    @Override
    public IShippingRate shippingRateCalculator()
    {
        return new USShippingRate();
    }
}
