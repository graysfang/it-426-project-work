package registrations;

/*
 * Nicholas Perez
 * 11/14/2017
 * Registrar.java
 *
 * DESCRIPTION
 */

import java.util.Observable;
import java.util.Observer;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class Registrar implements Observer
{

    @Override
    public void update(Observable observable, Object args)
    {
        System.out.println("Hey, a student reg. for a class!");
    }
}
