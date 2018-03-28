package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    private static final String URL = "jdbc:mysql://46.101.114.190:3306/legoWebshop";
    private static final String USERNAME = "lego_crud";
    private static final String PASSWORD = "myPassword";
    
    /*
    private static final String URL = "jdbc:mysql://localhost:3306/legoWebshop";
    private static final String USERNAME = "lego_crud";
    private static final String PASSWORD = "myPassword"; */

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
