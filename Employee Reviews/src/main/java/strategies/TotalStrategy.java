package strategies;

/*
 * Nicholas Perez
 * 11/9/2017
 * TotalStrategy.java
 *
 * DESCRIPTION
 */

import reviews.Review;

import java.util.Iterator;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class TotalStrategy implements IStrategy
{

    @Override
    public int getScore(int year, Iterator<Review> reviews)
    {
        int total = 0;

        while (reviews.hasNext())
        {
            Review review = reviews.next();

            if(review.getYear()== year)
            {
                int[] kpis = review.getKpis();

                for (int i = 0; i< kpis.length; i++)
                {
                    total += kpis[i];
                }

                return total;
            }

        }

        return 0;
    }
}
