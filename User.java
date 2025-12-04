/**
 * Abstract base class representing a User in the system.
 * Contains common attributes like username, password hash, and role.
 * Specific behavior is defined in subclasses implementing {@link #openMenu()}.
 */
public abstract class User
{
    private final int userId;
    private String username;
    private String passwordHash;
    private String name;
    private String surname;
    private Role role;

    /**
     * Constructs a new User.
     *
     * @param userId       The unique identifier for the user.
     * @param username     The login username.
     * @param passwordHash The hashed password for security.
     * @param name         The user's first name.
     * @param surname      The user's last name.
     * @param role         The role assigned to this user (e.g., MANAGER, TESTER).
     */
    public User(int userId,
                String username,
                String passwordHash,
                String name,
                String surname,
                Role role)
    {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    /**
     * Gets the unique user ID.
     * @return The user ID.
     */
    public int getUserId()
    {
        return userId;
    }

    /**
     * Gets the username.
     * @return The username.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Sets a new username.
     * @param username The new username.
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Gets the stored password hash.
     * @return The password hash.
     */
    public String getPasswordHash()
    {
        return passwordHash;
    }

    /**
     * Sets a new password hash.
     * @param passwordHash The new hashed password.
     */
    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }

    /**
     * Gets the user's first name.
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the user's first name.
     * @param name The new name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the user's last name.
     * @return The surname.
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * Sets the user's last name.
     * @param surname The new surname.
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    /**
     * Gets the user's role.
     * @return The {@link Role} enum value.
     */
    public Role getRole()
    {
        return role;
    }

    /**
     * Sets the user's role.
     * @param role The new role.
     */
    public void setRole(Role role)
    {
        this.role = role;
    }

    /**
     * Abstract method to open the specific menu for the user type.
     * Subclasses must implement this to provide role-specific UI or options.
     */
    public abstract void openMenu();
}