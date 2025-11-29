// File: App.java

public class App
{
    public static void main(String[] args)
    {
        showWelcomeAnimation();

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.start();

        // Login başarılı → ilgili role menüsüne yönlendir
        RoleRouter.start();

        System.out.println("Goodbye.");
    }

    private static void showWelcomeAnimation()
    {
        System.out.println("========================================");
        System.out.println("   CMPE343 CONTACT MANAGEMENT SYSTEM    ");
        System.out.println("========================================");
        System.out.println();
    }
}
