// File: ManagerUser.java

/**
 * Represents a user with the MANAGER role. This class extends the {@link User}
 * base class and automatically assigns the role {@link Role#MANAGER} upon creation.
 *
 * Managers have access to the ManagerMenu, which contains administration-level
 * operations not available to other user roles.
 */
public class ManagerUser extends User
{
    /**
     * Creates a new ManagerUser with the given user information.
     *
     * @param userId       the unique ID of the user
     * @param username     the login username
     * @param passwordHash the hashed password
     * @param name         the first name of the user
     * @param surname      the last name of the user
     */
    public ManagerUser(int userId,
                       String username,
                       String passwordHash,
                       String name,
                       String surname)
    {
        super(userId, username, passwordHash, name, surname, Role.MANAGER);
    }

    /**
     * Opens the menu interface specific to managers.
     * This method overrides the corresponding method from {@link User}.
     */
    @Override
    public void openMenu()
    {
        ManagerMenu.start();
    }
}
