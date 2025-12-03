// File: TesterUser.java
public class TesterUser extends User
{
    public TesterUser(int userId,
                      String username,
                      String passwordHash,
                      String name,
                      String surname)
    {
        super(userId, username, passwordHash, name, surname, Role.TESTER);
    }

    @Override
    public void openMenu()
    {
        TesterMenu.start();
    }
}
