package abstract_factory_pattern.sales_tax;

/*
 * Nicholas Perez
 * 11/30/2017
 * EUSalesTax.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class EUSalesTax extends SalesTax
{

    public EUSalesTax(String region)
    {
        super(region);
    }

    @Override
    public void loadRates()
    {
        //load map - lazy init
        if(regionToRates.isEmpty())
        {
            regionToRates.put("UK", 0.9);
            regionToRates.put("Spain", 0.85);
            //...
        }
    }
}
