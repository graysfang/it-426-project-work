package adventurers;

/*
 * Nicholas Perez
 * 11/7/2017
 * Adventuter.java
 *
 * DESCRIPTION
 */

import behaviors.IBehaviors;
import tools.ITool;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class Adventuter implements IBehaviors
{
    private String name;
    private AdventurerType type;

    //store a family of algorithms
    private IBehaviors behavior;

    public Adventuter(String name, AdventurerType type, IBehaviors behavior)
    {
        this.name = name;
        this.type = type;
        this.behavior = behavior;
    }

    public String getName()
    {
        return name;
    }

    public AdventurerType getType()
    {
        return type;
    }



    @Override
    public String toString()
    {
        return "Adventuter{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public void takeAction()
    {
        behavior.takeAction();
    }
}
