package adapter_pat;

/*
 * Nicholas Perez
 * 11/28/2017
 * TestAthlete.java
 *
 * DESCRIPTION
 */

import adapters.BaseballAdapter;
import adapters.BasketballAdapter;
import adapters.SoccerAdapter;
import athletes.BaseballAthlete;
import athletes.BasketBallAthlete;
import athletes.SoccerAthlete;
import sportNews.OnlineNews;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class TestAthlete
{
    public static void main(String[] args)
    {
        //create a few athletes
        SoccerAthlete mia = new SoccerAthlete("Mia Hamm");

        mia.addStatLine("goals", 4);
        mia.addStatLine("assists", 3);

        BaseballAthlete ken = new BaseballAthlete("George", "Kenneth", "Griffey");
        ken.addStat("Home runs - 30");
        ken.addStat("Batting Avg - .350");

        BasketBallAthlete shawn = new BasketBallAthlete("Shawn", "Kemp");

        shawn.addANewStat(new BasketBallAthlete.Stat("avg. rebounds", 3));
        shawn.addANewStat(new BasketBallAthlete.Stat("points per game", 21));

        //create a news object and try to use the athletes

        OnlineNews news = new OnlineNews("ESPN",
                new SoccerAdapter(mia),
                new BaseballAdapter(ken),
                new BasketballAdapter(shawn));

        news.printNews();
    }
}
