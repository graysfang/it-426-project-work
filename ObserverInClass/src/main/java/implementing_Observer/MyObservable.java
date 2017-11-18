package implementing_Observer;

/*
 * Nicholas Perez
 * 11/17/2017
 * MyObservable.java
 *
 * DESCRIPTION
 */

import java.util.HashSet;
import java.util.Set;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class MyObservable
{
    private Set<MyObserver> observers;

    public MyObservable()
    {
        observers = new HashSet<>();
    }

    public void notifyObserver(Object... arguments)
    {
        for(MyObserver observer: observers)
        {
            observer.update(this, arguments);
        }
    }

    public void addObserver(MyObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(MyObserver observer)
    {
        observers.remove(observer);
    }

}
