import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides database connectivity for the application using MySQL.
 * This class loads the MySQL JDBC driver and offers a static method
 * to obtain a {@link Connection} object.
 *
 * The connection parameters (URL, USER, PASS) are defined as constants
 * and should be adjusted based on the environment configuration.
 */
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
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("MySQL JDBC Driver not found. Make sure the .jar is on the classpath.", e);
        }
    }

    /**
     * Establishes and returns a connection to the MySQL database.
     *
     * @return a valid SQL {@link Connection} object
     * @throws SQLException if a database access error occurs or the connection fails
     */
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
