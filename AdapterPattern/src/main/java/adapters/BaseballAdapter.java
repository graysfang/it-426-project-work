package adapters;

/*
 * Nicholas Perez
 * 11/28/2017
 * BaseballAdapter.java
 *
 * DESCRIPTION
 */


import athletes.BaseballAthlete;
import sportNews.IAthlete;

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class BaseballAdapter implements IAthlete
{
    private BaseballAthlete athlete;

    public BaseballAdapter(BaseballAthlete athlete)
    {
        this.athlete = athlete;
    }

    @Override
    public String getFullName()
    {
        return athlete.getFname() + " " + athlete.getMiddle()+ " " + athlete.getLname();
    }

    @Override
    public Map<String, Object> getStats()
    {
        Map< String, Object> results = new HashMap<>();

        //loop over list
        for (String stat : athlete.getStats())
        {
            String[] part = stat.split(" - ");
            results.put(part[0], part[1]);
        }

        return results;
    }
}
