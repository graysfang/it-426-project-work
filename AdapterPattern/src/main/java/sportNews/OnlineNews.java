package sportNews;

/*
 * Nicholas Perez
 * 11/21/2017
 * OnlineNews.java
 *
 * DESCRIPTION
 */

import java.util.Arrays;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class OnlineNews
{
    private String newsOutletName;
    private List<IAthlete> athleteList;

    public OnlineNews(String newsOutletName, IAthlete... athletes)
    {
        this.newsOutletName = newsOutletName;
        athleteList = Arrays.asList(athletes);
    }

    public void printNews()
    {
        System.out.println("Welcome to " + newsOutletName);
        System.out.println();

        for (IAthlete athlete : athleteList)
        {
            printAthlete(athlete);
        }
    }

    private void printAthlete(IAthlete athlete)
    {
        //print the name
        System.out.println(athlete.getFullName());

        //print the stats
        for (String stat : athlete.getStats().keySet())
        {
            System.out.println(stat + ": " + athlete.getStats().get(stat));
        }
        System.out.println();
    }
}
