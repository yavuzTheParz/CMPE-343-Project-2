// File: JuniorDevUser.java
public class JuniorDevUser extends User
{
    public JuniorDevUser(int userId,
                         String username,
                         String passwordHash,
                         String name,
                         String surname)
    {
        super(userId, username, passwordHash, name, surname, Role.JUNIOR_DEV);
    }

    @Override
    public void openMenu()
    {
        JuniorDevMenu.start();
    }
}
