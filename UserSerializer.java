// File: UserSerializer.java
public class UserSerializer
{
    // Örnek format: id;username;passwordHash;name;surname;role
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

        // BURASI ÖNEMLİ: Polymorphic User üretimi
        return UserFactory.createUser(userId, username, passwordHash, name, surname, role);
    }

    private static String escape(String s)
    {
        if (s == null)
        {
            return "";
        }
        return s.replace("\\", "\\\\").replace(";", "\\;");
    }

    private static String unescape(String s)
    {
        return s.replace("\\;", ";").replace("\\\\", "\\");
    }
}
