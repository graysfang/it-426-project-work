package abstract_factory_pattern.shipping;

/*
 * Nicholas Perez
 * 11/30/2017
 * USShippingRate.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class USShippingRate implements IShippingRate
{

    @Override
    public double rate(double weight)
    {
        //less than 1 pound, $1
        if(weight < 1.0)
        {
            return 1.0;
        }
        //between 1 and 5 pounds, $5
        else if(weight >= 1 && weight <=5)
        {
            return 5.0;
        }
        //other, $10
        else
        {
            return 10.0;
        }
    }
}
