package factory_method_pattern.personality;

/*
 * Nicholas Perez
 * 11/30/2017
 * AbstractPerson.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public abstract class AbstractPerson
{
    private String name;

    public AbstractPerson(String name)
    {
        this.name = name;
    }

    //force child class to provide a personality
    //so this class can speak
    public abstract IPersonality getPersonality();

    public void speak()
    {
        IPersonality thisPersonality = getPersonality();

        thisPersonality.say("Hi my name is " + name);
        thisPersonality.endSentence();

        thisPersonality.say("Welcome to my program");
        thisPersonality.endSentence();
    }
}
