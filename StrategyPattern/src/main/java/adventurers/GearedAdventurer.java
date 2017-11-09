package adventurers;

/*
 * Nicholas Perez
 * 11/7/2017
 * GearedAdventurer.java
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
public class GearedAdventurer extends Adventuter implements ITool
{
    private ITool tool;

    public GearedAdventurer(String name, AdventurerType type, IBehaviors behavior, ITool tool)
    {
        super(name, type, behavior);
        this.tool = tool;
    }

    public ITool getTool()
    {
        return tool;
    }

    @Override
    public void useTool()
    {
        tool.useTool();
    }

    @Override
    public String toString()
    {
        return "GearedAdventurer{" +
                "tool=" + tool +
                '}';
    }


}
