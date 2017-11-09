package Singleton;/*
 * Nicholas Perez
 * 11/2/2017
 * TestSingleton.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class TestSingleton
{
    public static void main(String[] args)
    {
        //this doesnt work...
        //DBConnection connection = new DBConnection();


//        DBConnection connection2 = DBConnection.getInstance();
//
//        System.out.println(connection2);

        DBConnection3 mysql = DBConnection3.getInstance(DBType.MYSQL);

        System.out.println(mysql);
    }

}
