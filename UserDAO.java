// File: UserDAO.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for managing {@link User} persistence.
 * Handles database operations such as authentication, querying, insertion,
 * updating, and deletion. It also integrates with {@link UndoLogDAO} to log
 * changes for undo functionality.
 */
public class UserDAO
{
    // -------- AUTH --------

    /**
     * Authenticates a user by checking the username and password against the database.
     *
     * @param username      The username to check.
     * @param plainPassword The plain text password provided by the user.
     * @return A {@link User} object if credentials match; <code>null</code> if user not found or password incorrect.
     */
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
                    return null; // User not found
                }

                String storedHash = rs.getString("password_hash");
                String givenHash = PasswordUtil.hashPassword(plainPassword);

                if (!storedHash.equalsIgnoreCase(givenHash))
                {
                    return null; // Password mismatch
                }

                int userId = rs.getInt("user_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String roleStr = rs.getString("role");
                Role role = Role.valueOf(roleStr.toUpperCase());
                return UserFactory.createUser(userId, username, storedHash, name, surname, role);

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    // -------- QUERY HELPERS --------

    /**
     * Retrieves all users from the database.
     *
     * @return A list of all User objects ordered by user_id.
     */
    public static List<User> getAllUsers()
    {
        List<User> list = new ArrayList<>();

        String sql = "SELECT user_id, username, password_hash, name, surname, role " +
                     "FROM users ORDER BY user_id";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                int userId = rs.getInt("user_id");
                String username = rs.getString("username");
                String passwordHash = rs.getString("password_hash");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String roleStr = rs.getString("role");
                Role role = Role.valueOf(roleStr.toUpperCase());
                User u = UserFactory.createUser(userId, username, passwordHash, name, surname, role);
                list.add(u);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Finds a user by their unique ID.
     *
     * @param userId The ID of the user.
     * @return The User object if found, otherwise <code>null</code>.
     */
    public static User getUserById(int userId)
    {
        String sql = "SELECT user_id, username, password_hash, name, surname, role " +
                     "FROM users WHERE user_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    String username = rs.getString("username");
                    String passwordHash = rs.getString("password_hash");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String roleStr = rs.getString("role");
                    Role role = Role.valueOf(roleStr.toUpperCase());
                    return UserFactory.createUser(userId, username, passwordHash, name, surname, role);

                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for.
     * @return The User object if found, otherwise <code>null</code>.
     */
    public static User getUserByUsername(String username)
    {
        String sql = "SELECT user_id, username, password_hash, name, surname, role " +
                     "FROM users WHERE username = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    int userId = rs.getInt("user_id");
                    String passwordHash = rs.getString("password_hash");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String roleStr = rs.getString("role");
                    Role role = Role.valueOf(roleStr.toUpperCase());
                    return UserFactory.createUser(userId, username, passwordHash, name, surname, role);

                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Counts the total number of users with the MANAGER role.
     *
     * @return The count of managers.
     */
    public static int countManagers()
    {
        String sql = "SELECT COUNT(*) AS cnt FROM users WHERE role = 'MANAGER'";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            if (rs.next())
            {
                return rs.getInt("cnt");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return 0;
    }

    // -------- MUTATIONS + LOGGING --------

    /**
     * Inserts a new user into the database and logs the operation for Undo.
     *
     * @param username      The username.
     * @param plainPassword The plain text password (will be hashed).
     * @param name          The first name.
     * @param surname       The last name.
     * @param role          The user role.
     * @return <code>true</code> if insertion is successful, <code>false</code> otherwise.
     */
    public static boolean insertUser(String username,
                                     String plainPassword,
                                     String name,
                                     String surname,
                                     Role role)
    {
        String sql = "INSERT INTO users (username, password_hash, name, surname, role) " +
                     "VALUES (?, ?, ?, ?, ?)";

        String hash = PasswordUtil.hashPassword(plainPassword);

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1, username);
            ps.setString(2, hash);
            ps.setString(3, name);
            ps.setString(4, surname);
            ps.setString(5, role.name());

            int affected = ps.executeUpdate();

            if (affected > 0)
            {
                int newId = 0;
                try (ResultSet keys = ps.getGeneratedKeys())
                {
                    if (keys.next())
                    {
                        newId = keys.getInt(1);
                    }
                }

                User newUser = UserFactory.createUser(newId, username, hash, name, surname, role);

                // Undo log (INSERT USER)
                UndoLogDAO.logUserOperation(
                    UndoOperationType.INSERT,
                    null,
                    newUser
                );

                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates an existing user and logs the operation for Undo.
     * Retrieves the old state before update to support logging.
     *
     * @param user             The user object containing updated fields.
     * @param changePassword   Flag indicating if the password should also be updated.
     * @param newPlainPassword The new plain text password (if changePassword is true).
     * @return <code>true</code> if update is successful, <code>false</code> otherwise.
     */
    public static boolean updateUser(User user,
                                     boolean changePassword,
                                     String newPlainPassword)
    {
        // 1) Fetch old state
        User before = getUserById(user.getUserId());
        if (before == null)
        {
            System.out.println("User not found with id: " + user.getUserId());
            return false;
        }

        String sql;
        String newHash = before.getPasswordHash();

        if (changePassword)
        {
            sql = "UPDATE users SET username = ?, password_hash = ?, name = ?, surname = ?, role = ? " +
                  "WHERE user_id = ?";
            newHash = PasswordUtil.hashPassword(newPlainPassword);
        }
        else
        {
            sql = "UPDATE users SET username = ?, name = ?, surname = ?, role = ? " +
                  "WHERE user_id = ?";
        }

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, user.getUsername());

            int index = 2;

            if (changePassword)
            {
                ps.setString(index++, newHash);
            }

            ps.setString(index++, user.getName());
            ps.setString(index++, user.getSurname());
            ps.setString(index++, user.getRole().name());
            ps.setInt(index, user.getUserId());

            int affected = ps.executeUpdate();

            if (affected > 0)
            {
                User after = UserFactory.createUser(
                    user.getUserId(),
                    user.getUsername(),
                    newHash,
                    user.getName(),
                    user.getSurname(),
                    user.getRole()
                );

                // Undo log (UPDATE USER)
                UndoLogDAO.logUserOperation(
                    UndoOperationType.UPDATE,
                    before,
                    after
                );

                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a user by ID and logs the operation for Undo.
     *
     * @param userId The ID of the user to delete.
     * @return <code>true</code> if deletion is successful, <code>false</code> otherwise.
     */
    public static boolean deleteUser(int userId)
    {
        // Fetch old state before deletion
        User before = getUserById(userId);
        if (before == null)
        {
            System.out.println("User not found with id: " + userId);
            return false;
        }

        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, userId);
            int affected = ps.executeUpdate();

            if (affected > 0)
            {
                // Undo log (DELETE USER)
                UndoLogDAO.logUserOperation(
                    UndoOperationType.DELETE,
                    before,
                    null
                );
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    // -------- SPECIAL METHODS FOR UNDO (NO LOGGING) --------

    /**
     * Inserts a user with a specific ID.
     * <p>
     * <b>Warning:</b> This method does NOT create an undo log entry.
     * It is intended primarily for use by {@link UndoService} to restore deleted users.
     * </p>
     *
     * @param user The user object to insert.
     * @return <code>true</code> if successful.
     */
    public static boolean insertUserWithId(User user)
    {
        String sql = "INSERT INTO users (user_id, username, password_hash, name, surname, role) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, user.getName());
            ps.setString(5, user.getSurname());
            ps.setString(6, user.getRole().name());

            int affected = ps.executeUpdate();
            return affected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a user without logging the operation.
     * <p>
     * <b>Warning:</b> This method is intended for {@link UndoService} to reverse an INSERT operation.
     * </p>
     *
     * @param userId The ID of the user to delete.
     * @return <code>true</code> if successful.
     */
    public static boolean deleteUserWithoutLogging(int userId)
    {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, userId);
            int affected = ps.executeUpdate();
            return affected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates a user directly without logging.
     * <p>
     * <b>Warning:</b> This method is intended for {@link UndoService} to revert an UPDATE operation.
     * </p>
     *
     * @param user The user object with data to restore.
     * @return <code>true</code> if successful.
     */
    public static boolean updateUserRaw(User user)
    {
        String sql = "UPDATE users SET username = ?, password_hash = ?, name = ?, surname = ?, role = ? " +
                     "WHERE user_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getName());
            ps.setString(4, user.getSurname());
            ps.setString(5, user.getRole().name());
            ps.setInt(6, user.getUserId());

            int affected = ps.executeUpdate();
            return affected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}