/**
 * Utility class responsible for serializing and deserializing {@link User} objects.
 * Uses a custom semicolon-separated format for string representation.
 */
public class UserSerializer
{
    /**
     * Serializes a User object into a string format.
     * <p>
     * Format: <code>id;username;passwordHash;name;surname;role</code>
     * </p>
     * Special characters within fields are escaped to ensure integrity.
     *
     * @param user The User object to serialize.
     * @return A semicolon-separated string representation of the user, or an empty string if the user is null.
     */
    public static String serialize(User user)
    {
        if (user == null)
        {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(user.getUserId()).append(";");
        sb.append(escape(user.getUsername())).append(";");
        sb.append(escape(user.getPasswordHash())).append(";");
        sb.append(escape(user.getName())).append(";");
        sb.append(escape(user.getSurname())).append(";");
        sb.append(user.getRole().name());

        return sb.toString();
    }

    /**
     * Deserializes a string back into a User object.
     * <p>
     * <b>Important:</b> This method utilizes {@link UserFactory} to ensure polymorphic
     * User creation (instantiating the correct subclass based on the role).
     * </p>
     *
     * @param data The string data to deserialize.
     * @return The reconstructed User object, or <code>null</code> if data is invalid or empty.
     */
    public static User deserialize(String data)
    {
        if (data == null || data.isEmpty())
        {
            return null;
        }

        String[] parts = data.split(";", -1);
        if (parts.length < 6)
        {
            return null;
        }

        int userId = Integer.parseInt(parts[0]);
        String username = unescape(parts[1]);
        String passwordHash = unescape(parts[2]);
        String name = unescape(parts[3]);
        String surname = unescape(parts[4]);
        Role role = Role.valueOf(parts[5]);

        // Uses the Factory to create the correct subclass type.
        return UserFactory.createUser(userId, username, passwordHash, name, surname, role);
    }

    /**
     * Escapes special characters (backslashes and semicolons) in the string.
     *
     * @param s The input string.
     * @return The escaped string suitable for the custom format.
     */
    private static String escape(String s)
    {
        if (s == null)
        {
            return "";
        }
        return s.replace("\\", "\\\\").replace(";", "\\;");
    }

    /**
     * Unescapes special characters to restore the original string content.
     *
     * @param s The escaped string.
     * @return The original raw string.
     */
    private static String unescape(String s)
    {
        return s.replace("\\;", ";").replace("\\\\", "\\");
    }
}