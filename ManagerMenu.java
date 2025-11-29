// File: ManagerMenu.java

public class ManagerMenu
{
    public static void start()
    {
        while (true)
        {
            System.out.println("\n=== MANAGER MENU ===");
            System.out.println("1) Add User");
            System.out.println("2) Update User");
            System.out.println("3) Delete User");
            System.out.println("4) List Users");
            System.out.println("5) Show Statistics");
            System.out.println("0) Logout");

            int choice = InputHelper.readInt("Choice: ");

            switch (choice)
            {
                case 1:
                    System.out.println("Add user (placeholder)");
                    break;

                case 2:
                    System.out.println("Update user (placeholder)");
                    break;

                case 3:
                    System.out.println("Delete user (placeholder)");
                    break;

                case 4:
                    System.out.println("List users (placeholder)");
                    break;

                case 5:
                    System.out.println("Statistics (placeholder)");
                    break;

                case 0:
                    Session.clear();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
