package abstract_factory_pattern.sales_tax;

/*
 * Nicholas Perez
 * 11/30/2017
 * SalesTax.java
 *
 * DESCRIPTION
 */

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public abstract class SalesTax implements ISalesTax
{
    protected Map<Object, Double> regionToRates = new HashMap<>();
    private Object regionID;

    public SalesTax(Object regionID)
    {
        this.regionID = regionID;

        //load map
        loadRates();
    }

    public abstract void loadRates();

    @Override
    public double tax(double total)
    {
        return regionToRates.get(regionID)* total;
    }
}

