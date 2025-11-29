// File: SeniorDevUser.java
public class SeniorDevUser extends User
{
    public SeniorDevUser(int userId,
                         String username,
                         String passwordHash,
                         String name,
                         String surname)
    {
        super(userId, username, passwordHash, name, surname, Role.SENIOR_DEV);
    }

    @Override
    public void openMenu()
    {
        SeniorDevMenu.start();
    }
}
