package strategies;
/*
 * Nicholas Perez
 * 11/9/2017
 * IStrategy.java
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
public interface IStrategy
{
    public int getScore(int year, Iterator<Review> reviews);
}
