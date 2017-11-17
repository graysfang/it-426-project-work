package registrations;

/*
 * Nicholas Perez
 * 11/14/2017
 * Student.java
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
public class Student extends Observable
{
    private String name;

    public Student(String name)
    {
        this.name = name;
    }

    //do somehitng of intrest

    public  void  registerForClass(String classname)
    {
        //register for classes
        //assume a few steps occurred here

        //inform obvserver of change
        this.setChanged();
        this.notifyObservers();
    }
}
