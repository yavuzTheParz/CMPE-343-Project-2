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

    private static final String RESET  = "\u001B[0m";
    private static final String BLUE   = "\u001B[38;2;100;180;255m";
    private static final String CYAN   = "\u001B[38;2;0;255;255m";
    private static final String GOLD   = "\u001B[38;2;255;215;0m";
    private static final String RED    = "\u001B[38;2;255;80;80m";
    private static final String WHITE  = "\u001B[38;2;255;255;255m";
    private static final String BOLD   = "\u001B[1m";



    public void start()
    {
        while (true)
        {
            System.out.println();

            String title = "🔐  LOGIN SCREEN";
            int len = title.length();

            // Kutulu başlık
            String border = WHITE + "         ┌" + "─".repeat(len) + "┐" + RESET;
            String middle = WHITE + "         │" + RESET + CYAN + BOLD + title + RESET + WHITE + "│" + RESET;
            String bottom = WHITE + "         └" + "─".repeat(len) + "┘" + RESET;

            System.out.println(border);
            System.out.println(middle);
            System.out.println(bottom);

            // Input kutusu
            System.out.println(WHITE + "┌────────────────────────────────┐" + RESET);
            System.out.println(WHITE + "│ " + BLUE + "Please enter your credentials" + RESET +
                            WHITE + "  │" + RESET);
            System.out.println(WHITE + "└────────────────────────────────┘" + RESET);

            // Kullanıcı adı ve şifre
            String username = InputHelper.readString(GOLD + "Username: " + RESET);
            String password = InputHelper.readString(GOLD + "Password: " + RESET);


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
                System.out.print("\033[H\033[2J");
                System.out.println("\nWelcome, " + user.getName() + " " +
                                   user.getSurname() + " (" + user.getRole() + ")");

                user.openMenu(); // polymorphism
                return;
            }
            else
            {
                System.out.print("\033[H\033[2J");
                System.out.println("Incorrect username or password. Please try again.\n");
            }
        }
    }
}
