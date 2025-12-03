// File: RoleRouter.java

<<<<<<< HEAD
/**
 * Routes the currently logged-in user to the correct menu
 * based on their assigned {@link Role}. This class centralizes
 * role-based navigation logic and ensures each user is directed
 * to the appropriate interface.
 */
public class RoleRouter
{
    /**
     * Starts the routing process by checking the current user's role
     * and opening the corresponding menu.
     */
=======
public class RoleRouter
{
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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
