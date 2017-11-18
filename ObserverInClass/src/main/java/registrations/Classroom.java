package registrations;

/*
 * Nicholas Perez
 * 11/17/2017
 * Classroom.java
 *
 * DESCRIPTION
 */

import java.util.Observable;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class Classroom extends Observable
{
    public void startClass()
    {
        //start up the class
        //let others know the class has started

        this.setChanged();
        this.notifyObservers("Class has started!");
    }
}
