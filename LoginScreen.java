// File: LoginScreen.java
public class LoginScreen
{
    public void start()
    {
        while (true)
        {
            System.out.println("================================");
            System.out.println("           LOGIN SCREEN         ");
            System.out.println("================================");

            String username = InputHelper.readString("Username: ");
            String password = InputHelper.readString("Password: ");

            User user = UserDAO.authenticate(username, password);

            if (user != null)
            {
                Session.setCurrentUser(user);
                System.out.println("Welcome, " + user.getName() + " " + user.getSurname() + "!");
                System.out.println("Role: " + user.getRole());
                return; // başarıyla login oldu, main loop'a geçeceğiz
            }
            else
            {
                System.out.println("Incorrect username or password. Please try again.\n");
            }
        }
    }
}
