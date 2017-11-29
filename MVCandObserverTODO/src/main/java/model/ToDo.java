package model;

/*
 * Nicholas Perez
 * 11/28/2017
 * ToDo.java
 *
 * This is a simple class that holds data for a single task that will be displayed as a list item.
 */

import java.util.UUID;

/**
 * This is a simple class that holds data for a single task that will be displayed as a list item.
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class ToDo
{
    private UUID id = UUID.randomUUID();
    private String message;

    /**
     * Constructor for a to-do object
     * @param message the message/label for the task
     */
    public ToDo(String message)
    {
        this.message = message;
    }

    /**
     * Sets the message for the task
     * @param message the message to be set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * Gets the id from the task
     * @return the id of the task
     */
    public UUID getId()
    {
        return id;
    }

    /**
     * Gets the message from the task
     * @return the message of the task
     */
    public String getMessage()
    {
        return message;
    }
}
