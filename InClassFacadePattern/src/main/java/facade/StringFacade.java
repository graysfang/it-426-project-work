package facade;

/*
 * Nicholas Perez
 * 11/21/2017
 * StringFacade.java
 *
 * DESCRIPTION
 */

import string_manipulation.StringRegex;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class StringFacade
{
    public static boolean isValid(String subject, ValidationType type)
    {
        switch (type)
        {
            case EMAIL:
                return StringRegex.isEmail(subject);
            case PHONE:
                return StringRegex.isPhoneNumber(subject);
            case URL:
                return StringRegex.isUrl(subject);
            case ZIP_CODE:
                return StringRegex.isZipCode(subject);
        }
        throw new IllegalStateException("Missing enum value: "+ type.toString());
    }

    public static Operation getStringOperations(String[] subject)
    {
        return new Operation(subject);
    }
    public enum ValidationType
    {
        EMAIL,
        PHONE,
        URL,
        ZIP_CODE
    }
}
