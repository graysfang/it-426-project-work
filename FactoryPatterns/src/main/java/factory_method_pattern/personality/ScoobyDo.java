package factory_method_pattern.personality;

/*
 * Nicholas Perez
 * 11/30/2017
 * ScoobyDo.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class ScoobyDo extends AbstractPerson
{
    public ScoobyDo(String name)
    {
        super(name);
    }

    @Override
    public IPersonality getPersonality()
    {
        return new IPersonality()
        {
            @Override
            public void say(String msg)
            {
                System.out.print("Ruh, roh, " + msg);
            }

            @Override
            public void endSentence()
            {
                System.out.println("!!!");
            }
        };
    }
}
