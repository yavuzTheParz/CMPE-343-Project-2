// File: RoleRouter.java

public class RoleRouter
{
    public static void start()
    {
        User user = Session.getCurrentUser();

        switch (user.getRole())
        {
            case TESTER:
                TesterMenu.start();
                break;

            case JUNIOR_DEV:
                JuniorDevMenu.start();
                break;

            case SENIOR_DEV:
                SeniorDevMenu.start();
                break;

            case MANAGER:
                ManagerMenu.start();
                break;

            default:
                System.out.println("Unknown role.");
        }
    }
}
