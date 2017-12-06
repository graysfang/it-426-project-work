package factory_method_pattern.personality;

/*
 * Nicholas Perez
 * 11/30/2017
 * TestPersonality.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class TestPersonality
{
    public static void main(String[] args)
    {
        ValleyGirl person = new ValleyGirl("Susie");
        person.speak();

        ScoobyDo dog = new ScoobyDo("Doggy");
        dog.speak();
    }
}
