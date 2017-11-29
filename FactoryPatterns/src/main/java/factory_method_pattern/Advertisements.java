package factory_method_pattern;

/*
 * Nicholas Perez
 * 11/28/2017
 * Advertisements.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class Advertisements
{
    private String message;

    public Advertisements(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    @Override
    public String toString()
    {
        return "Advertisements{" +
                "message='" + message + '\'' +
                '}';
    }
}
