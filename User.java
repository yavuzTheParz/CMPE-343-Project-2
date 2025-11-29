
public class User
{
    private int userId;
    private String username;
    private String passwordHash;
    private String name;
    private String surname;
    private Role role;

    public User(int userId, String username, String passwordHash, String name, String surname, Role role)
    {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public int getUserId()
    {
        return userId;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public Role getRole()
    {
        return role;
    }
}
