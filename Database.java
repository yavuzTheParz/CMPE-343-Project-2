import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

<<<<<<< HEAD
/**
 * Provides database connectivity for the application using MySQL.
 * This class loads the MySQL JDBC driver and offers a static method
 * to obtain a {@link Connection} object.
 *
 * The connection parameters (URL, USER, PASS) are defined as constants
 * and should be adjusted based on the environment configuration.
 */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
public class Database
{
    private static final String URL  = "jdbc:mysql://localhost:3306/CMPE343_Project2";
    private static final String USER = "myuser";
    private static final String PASS = "1234";

    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
=======
            //System.out.println("MySQL JDBC Driver loaded successfully.");
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("MySQL JDBC Driver not found. Make sure the .jar is on the classpath.", e);
        }
    }

<<<<<<< HEAD
    /**
     * Establishes and returns a connection to the MySQL database.
     *
     * @return a valid SQL {@link Connection} object
     * @throws SQLException if a database access error occurs or the connection fails
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
