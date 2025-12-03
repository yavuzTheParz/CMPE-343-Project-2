/**
 * User type representing a tester with read-only permissions.
 */
public class TesterUser extends User
{
    /**
     * Creates a TesterUser with the given account information.
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
     * Opens the tester menu.
     */
    @Override
    public void openMenu()
    {
        TesterMenu.start();
    }
}
