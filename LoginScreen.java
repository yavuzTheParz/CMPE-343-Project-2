// File: LoginScreen.java

/**
 * Represents the login interface of the Contact Management System.
 * <p>
 * This class prompts the user for username and password, authenticates via UserDAO,
 * and starts the correct user menu based on the authenticated user's role.
 * </p>
 */
public class LoginScreen
{
    /**
     * Starts the login screen loop.
     * <p>
     * Reads username & password, authenticates the user,
     * and loads the correct menu using polymorphism (user.openMenu()).
     * If authentication fails, the method repeats until success.
     * </p>
     */
    public void start()
    {
        while (true)
        {
            System.out.println();
            System.out.println("================================");
            System.out.println("           LOGIN SCREEN");
            System.out.println("================================");

            String username = InputHelper.readString("Username: ");
            String password = InputHelper.readString("Password: ");

            User user = null;

            try
            {
                user = UserDAO.authenticate(username, password);
            }
            catch (Exception e)
            {
                System.out.println("An unexpected error occurred while logging in.");
                System.out.println("Please contact your system administrator.");
                e.printStackTrace();
                return;
            }

            if (user != null)
            {
                Session.setCurrentUser(user);
                System.out.println("\nWelcome, " + user.getName() + " " +
                                   user.getSurname() + " (" + user.getRole() + ")");

                user.openMenu(); // polymorphism
                return;
            }
            else
            {
                System.out.println("Incorrect username or password. Please try again.\n");
            }
        }
    }
}
