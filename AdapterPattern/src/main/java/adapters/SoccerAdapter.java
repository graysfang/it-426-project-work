package adapters;

/*
 * Nicholas Perez
 * 11/28/2017
 * SoccerAdapter.java
 *
 * DESCRIPTION
 */

import athletes.SoccerAthlete;
import sportNews.IAthlete;

import java.util.Map;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class SoccerAdapter implements IAthlete
{
    private SoccerAthlete athlete;

    public SoccerAdapter(SoccerAthlete athlete)
    {
        this.athlete = athlete;
    }

    @Override
    public String getFullName()
    {
        return athlete.getFullName();
    }

    @Override
    public Map<String, Object> getStats()
    {
        return athlete.getStats();
    }
}
