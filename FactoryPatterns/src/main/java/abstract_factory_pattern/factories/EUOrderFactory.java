package abstract_factory_pattern.factories;

/*
 * Nicholas Perez
 * 12/5/2017
 * EUOrderFactory.java
 *
 * DESCRIPTION
 */

import abstract_factory_pattern.sales_tax.EUSalesTax;
import abstract_factory_pattern.sales_tax.ISalesTax;
import abstract_factory_pattern.shipping.EUShippingRate;
import abstract_factory_pattern.shipping.IShippingRate;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class EUOrderFactory implements IOrderFactory
{
    private String region;

    public EUOrderFactory(String region)
    {
        this.region = region;
    }

    @Override
    public ISalesTax salesTaxCalculator()
    {
        return new EUSalesTax(region);
    }

    @Override
    public IShippingRate shippingRateCalculator()
    {
        return new EUShippingRate();
    }
}
