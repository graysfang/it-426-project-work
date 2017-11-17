package strategies;

/*
 * Nicholas Perez
 * 11/14/2017
 * WeightedTotalStrategy.java
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
public class WeightedTotalStrategy implements IStrategy
{

    @Override
    public int getScore(int year, Iterator<Review> reviews)
    {
        int weightedSum = 0;

        while (reviews.hasNext())
        {
            Review review = reviews.next();

            if (review.getYear() == year)
            {
                int[] kpis = review.getKpis();

                for (int i = 0; i < kpis.length; i++)
                {
                    if(i ==1){
                        weightedSum += kpis[i] * 2;
                    }
                    else if(i==3)
                    {
                        weightedSum += kpis[i] *3;
                    }else
                    {
                        weightedSum += kpis[i];
                    }

                }

                return weightedSum;
            }

        }
        return 0;
    }
}
