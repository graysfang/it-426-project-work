package facade;

/*
 * Nicholas Perez
 * 11/21/2017
 * Operation.java
 *
 * DESCRIPTION
 */

import string_manipulation.StringOperations;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class Operation
{
    private String[] subject;

    public Operation(String[] subject)
    {
        this.subject = subject;
    }

    public String[] getSubject()
    {
        return subject;
    }

    //method chaining
    public Operation filter(String find)
    {
        subject = StringOperations.filter(subject, find);
        return this;
    }

    public Operation removeDuplicates()
    {
        subject = StringOperations.removeDuplicates(subject);

        return this;
    }

    public Operation resize(int newSize)
    {
        subject = StringOperations.resize(subject, newSize);
        return this;
    }
}
