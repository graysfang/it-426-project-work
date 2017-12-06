package abstract_factory_pattern.sales_tax;

/*
 * Nicholas Perez
 * 11/30/2017
 * USSalesTax.java
 *
 * DESCRIPTION
 */


/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class USSalesTax extends SalesTax
{

    public USSalesTax(int zipcode)
    {
        super(zipcode);
    }

    @Override
    public void loadRates()
    {
        //load map - lazy init
        if(regionToRates.isEmpty())
        {
            regionToRates.put(98374, 0.09);
            regionToRates.put(98388, 0.09);
            //...
        }
    }
}
