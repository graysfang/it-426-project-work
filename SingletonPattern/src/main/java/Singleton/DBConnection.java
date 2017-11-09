package Singleton;/*
 * Nicholas Perez
 * 11/2/2017
 * DBConnection.java
 *
 * DESCRIPTION
 */

/**
 * DESCRIPTION
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class DBConnection
{
    public static final int PORT = 2020;
    private String user;
    private String password;
    private String host;
    private int port;
    private String dbName;
    private String dbType;

    //static field
    private static DBConnection instance;


    private DBConnection(String user, String password, String host, int port, String dbName, String dbType)
    {
        this.user = user;
        this.password = password;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.dbType = dbType;
    }

    public static DBConnection getInstance()
    {
        //lazy initialization
        if(instance == null)
        {
            instance = new DBConnection("fakeUser", "FakePassword?!", "fakeUser.greenriver.net", PORT, "movie", "mysql");
        }
        return instance;
    }

    public boolean connect()
    {
     return false;
    }

    @Override
    public String toString()
    {
        return "DBConnection{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", dbName='" + dbName + '\'' +
                ", dbType='" + dbType + '\'' +
                '}';
    }
}
