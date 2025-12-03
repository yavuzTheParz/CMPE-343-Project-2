// File: SeniorDevUser.java

/**
 * Represents a system user with the {@link Role#SENIOR_DEV} role.
 * <p>
 * Senior developers have full access to the system’s contact management
 * features, including adding, updating, deleting, listing, searching,
 * sorting, and undo operations.
 * </p>
 * This class extends {@link User} and only customizes the assigned role
 * and the menu that is displayed upon login.
 */
public class SeniorDevUser extends User
{
    /**
     * Constructs a new {@code SeniorDevUser} with the specified user details.
     *
     * @param userId       the unique identifier of the user
     * @param username     the username used for login
     * @param passwordHash the hashed password of the user
     * @param name         the user's first name
     * @param surname      the user's last name
     */
    public SeniorDevUser(int userId,
                         String username,
                         String passwordHash,
                         String name,
                         String surname)
    {
        super(userId, username, passwordHash, name, surname, Role.SENIOR_DEV);
    }

    /**
     * Opens the menu associated with the {@link Role#SENIOR_DEV} user.
     * <p>
     * This method delegates control to {@link SeniorDevMenu#start()},
     * which launches the senior developer interface.
     * </p>
     */
    @Override
    public void openMenu()
    {
        SeniorDevMenu.start();
    }
}
