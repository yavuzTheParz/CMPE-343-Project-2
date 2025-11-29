import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            //System.out.println("MySQL JDBC Driver loaded successfully.");
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("MySQL JDBC Driver not found. Make sure the .jar is on the classpath.", e);
        }
    }

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
