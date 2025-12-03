// File: JuniorDevUser.java
<<<<<<< HEAD

/**
 * Represents a user with the JUNIOR_DEV role. This class extends the {@link User}
 * base class and automatically assigns the role {@link Role#JUNIOR_DEV} upon creation.
 * 
 * Junior developers have access to the JuniorDevMenu, which is opened when the menu 
 * system requests the user to navigate through their available options.
 */
public class JuniorDevUser extends User
{
    /**
     * Creates a new JuniorDevUser with the given user information.
     *
     * @param userId       the unique ID of the user
     * @param username     the login username
     * @param passwordHash the hashed password
     * @param name         the first name of the user
     * @param surname      the last name of the user
     */
=======
public class JuniorDevUser extends User
{
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public JuniorDevUser(int userId,
                         String username,
                         String passwordHash,
                         String name,
                         String surname)
    {
        super(userId, username, passwordHash, name, surname, Role.JUNIOR_DEV);
    }

<<<<<<< HEAD
    /**
     * Opens the menu interface specific to junior developers.
     * This method overrides the abstract or inherited method from {@link User}.
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    @Override
    public void openMenu()
    {
        JuniorDevMenu.start();
    }
}
