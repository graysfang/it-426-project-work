package Singleton;/*
 * Nicholas Perez
 * 11/2/2017
 * DBConnection.java
 *
 * DESCRIPTION
 */

import java.util.HashMap;
import java.util.Map;

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class DBConnection3
{
    public static final int PORT = 2020;
    private String user;
    private String password;
    private String host;
    private int port;
    private String dbName;
    private DBType dbType;

    //static field
    private static Map<DBType,DBConnection3> instance = new HashMap<>();


    private DBConnection3(String user, String password, String host, int port, String dbName, DBType dbType)
    {
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbType = dbType;
    }

    public static DBConnection3 getInstance(DBType dbType)
    {
        //precondition
        if(dbType == null)
        {
            if(!instance.containsKey(dbType))
            {
                instance.put(dbType, new DBConnection3("fakeUser", "FakePassword?!", "fakeUser.greenriver.net", PORT, "movie", dbType));
            }
        }


        return instance.get(dbType);
    }

    public boolean connect()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return "DBConnection3{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", dbName='" + dbName + '\'' +
                ", dbType='" + dbType + '\'' +
                '}';
    }
}
