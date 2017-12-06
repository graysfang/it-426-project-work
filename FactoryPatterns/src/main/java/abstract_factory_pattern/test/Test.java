package abstract_factory_pattern.test;

/*
 * Nicholas Perez
 * 12/5/2017
 * Test.java
 *
 * DESCRIPTION
 */

import abstract_factory_pattern.factories.EUOrderFactory;
import abstract_factory_pattern.factories.IOrderFactory;
import abstract_factory_pattern.factories.USOrderFactory;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class Test
{
    public static void main(String[] args)
    {
//        String region = "UK";
//
//        double weight = 14;
//
//        double total = 199.98;
//
//        IOrderFactory factory = new EUOrderFactory(region);
//
//        double tax = factory.salesTaxCalculator().tax(total);
//        double shipping = factory.shippingRateCalculator().rate(weight);
//
//        System.out.println("Tax: " + tax);
//        System.out.println("Shipping: " + shipping);

        int zip = 98388;

        double weight = 14;

        double total = 99.98;

        IOrderFactory factory = new USOrderFactory(zip);

        double tax = factory.salesTaxCalculator().tax(total);
        double shipping = factory.shippingRateCalculator().rate(weight);

        System.out.println("Tax: " + tax);
        System.out.println("Shipping: " + shipping);
    }
}
