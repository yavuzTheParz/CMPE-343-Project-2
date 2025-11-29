// File: UserDAO.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO
{
    public static User authenticate(String username, String plainPassword)
    {
        String sql = "SELECT user_id, username, password_hash, name, surname, role " +
                     "FROM users WHERE username = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery())
            {
                if (!rs.next())
                {
                    return null; // kullanıcı yok
                }

                String storedHash = rs.getString("password_hash");
                String givenHash  = PasswordUtil.hashPassword(plainPassword);

                if (!storedHash.equalsIgnoreCase(givenHash))
                {
                    return null; // şifre yanlış
                }

                int userId    = rs.getInt("user_id");
                String name   = rs.getString("name");
                String surname = rs.getString("surname");
                String roleStr = rs.getString("role");

                Role role = Role.valueOf(roleStr.toUpperCase());

                return new User(userId, username, storedHash, name, surname, role);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
