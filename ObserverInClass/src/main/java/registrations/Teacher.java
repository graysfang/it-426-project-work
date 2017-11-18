package registrations;

/*
 * Nicholas Perez
 * 11/14/2017
 * Teacher.java
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
public class Teacher implements Observer
{

    @Override
    public void update(Observable observable, Object arguments)
    {
        if(observable instanceof Student)
        {
            Student student = (Student)observable;

            //takes the incoming object and casts to object array
            Object[] part = (Object[])arguments;

            System.out.println(student.getName() + ": Signed up for "+ part[0].toString() + " at "+ part[1].toString());
        }
        if(observable instanceof Classroom)
        {
            System.out.println(arguments.toString());
        }


    }
}
