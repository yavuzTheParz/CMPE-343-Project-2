// File: App.java

/**
 * Entry point of the CMPE343 Contact Management System application.
 * <p>
 * This class prints the welcome banner and starts the login flow by
 * delegating control to the {@link LoginScreen}.
 * </p>
 */
public class App
{
    /**
     * The main method of the application.
     * <p>
     * It shows the welcome animation, creates a {@link LoginScreen} instance,
     * starts the login process, and finally prints a goodbye message when
     * the application is about to exit.
     * </p>
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args)
    {
        asciiAnimator.playOpeningAnimation();

        System.out.print("\u001B[H\u001B[2J");


        LoginScreen loginScreen = new LoginScreen();
        loginScreen.start();

        System.out.println("Goodbye.");
    }

}

