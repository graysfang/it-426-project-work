package test;

/*
 * Nicholas Perez
 * 11/7/2017
 * testAdventurers.java
 *
 * DESCRIPTION
 */

import adventurers.AdventurerType;
import adventurers.Adventuter;
import adventurers.GearedAdventurer;
import behaviors.NobleBehavior;
import behaviors.TimidBehavior;
import tools.TrowelTool;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class testAdventurers
{
    public static void main(String[] args)
    {
        //squire
        Adventuter squire = new Adventuter("Jeff", AdventurerType.SQUIRE, new TimidBehavior());

        squire.takeAction();

        squire = new Adventuter("Lydia", AdventurerType.SQUIRE, new NobleBehavior());

        squire.takeAction();

        GearedAdventurer knight = new GearedAdventurer("Phill", AdventurerType.KNIGHT, new TimidBehavior(), new TrowelTool());

        knight.takeAction();
        knight.useTool();

    }
}
