package adapters;

/*
 * Nicholas Perez
 * 11/28/2017
 * BasketballAdapter.java
 *
 * DESCRIPTION
 */

import athletes.BasketBallAthlete;
import sportNews.IAthlete;

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class BasketballAdapter implements IAthlete
{
    private BasketBallAthlete athlete;

    public BasketballAdapter(BasketBallAthlete athlete)
    {
        this.athlete = athlete;
    }


    @Override
    public String getFullName()
    {
        return athlete.getFname() + athlete.getLname();
    }

    @Override
    public Map<String, Object> getStats()
    {

        Map< String, Object> results = new HashMap<>();

        //loop over list
        for (BasketBallAthlete.Stat stat : athlete.getStats())
        {

            results.put(stat.getType(), stat.getValue());
        }

        return results;
    }
}
