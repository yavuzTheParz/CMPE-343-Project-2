// File: ManagerUser.java
public class ManagerUser extends User
{
    public ManagerUser(int userId,
                       String username,
                       String passwordHash,
                       String name,
                       String surname)
    {
        super(userId, username, passwordHash, name, surname, Role.MANAGER);
    }

    @Override
    public void openMenu()
    {
        ManagerMenu.start();
    }
}
