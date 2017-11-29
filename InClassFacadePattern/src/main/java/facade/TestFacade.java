package facade;

/*
 * Nicholas Perez
 * 11/21/2017
 * TestFacade.java
 *
 * DESCRIPTION
 */

import java.util.Arrays;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class TestFacade
{
    public static void main(String[] args)
    {
        System.out.println(StringFacade.isValid("e@E@EE@@E.com", StringFacade.ValidationType.EMAIL));

        Operation op = StringFacade.getStringOperations(new String[]{
                "money",
                "money",
                "mitochondria",
                "turkey",
                "turkey",
                "turkey",
                "mashed potatoes"
        });

        op.filter("lunch").removeDuplicates().resize(4);

        System.out.println(Arrays.toString(op.getSubject()));
    }
}
