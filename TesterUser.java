// File: TesterUser.java

/**
 * Represents a user with the {@link Role#TESTER} role.
 * <p>
 * Testers have read-only access to the system (list, search, sort)
 * and cannot modify contact information.
 * </p>
 */
public class TesterUser extends User
{
    /**
     * Creates a new TesterUser with the specified account information.
     *
     * @param userId       unique identifier of the user
     * @param username     login username
     * @param passwordHash hashed password
     * @param name         first name of the user
     * @param surname      last name of the user
     */
    public TesterUser(int userId,
                      String username,
                      String passwordHash,
                      String name,
                      String surname)
    {
        super(userId, username, passwordHash, name, surname, Role.TESTER);
    }

    /**
     * Opens the menu interface for the tester user.
     * Delegates control to {@link TesterMenu#start()}.
     */
    @Override
    public void openMenu()
    {
        TesterMenu.start();
    }
}
