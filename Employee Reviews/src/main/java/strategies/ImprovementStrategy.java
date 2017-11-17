package strategies;

/*
 * Nicholas Perez
 * 11/14/2017
 * ImprovementStrategy.java
 *
 * DESCRIPTION
 */

import reviews.Review;

import java.time.chrono.IsoChronology;
import java.util.Iterator;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class ImprovementStrategy implements IStrategy
{
    @Override
    public int getScore(int year, Iterator<Review> reviews)
    {
        int total = 0;

        boolean yearIsFound = false;
        boolean pastYearIsFound = false;
        int[] kpis = {};
        int[] pastKpis = {};

        while (reviews.hasNext())
        {
            Review review = reviews.next();

            if(review.getYear()== year)
            {
                yearIsFound = true;


                kpis = review.getKpis();

            }
            else if(review.getYear()== year -1)
            {
                pastYearIsFound = true;

                pastKpis = review.getKpis();

            }

        }

        if (yearIsFound == pastYearIsFound)
        {
            for (int i = 0; i< kpis.length; i++)
            {
                total += pastKpis[i]-kpis[i];
            }
            return total;
        }

        return 0;
    }
}
