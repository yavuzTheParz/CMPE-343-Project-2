// File: JuniorDevMenu.java

public class JuniorDevMenu
{
    public static void start()
    {
        while (true)
        {
            System.out.println("\n=== JUNIOR DEV MENU ===");
            System.out.println("1) Update Contact");
            System.out.println("2) List Contacts");
            System.out.println("3) Search Contacts");
            System.out.println("4) Sort Contacts");
            System.out.println("0) Logout");

            int choice = InputHelper.readInt("Choice: ");

            switch (choice)
            {
                case 1:
                    System.out.println("Update contact (placeholder)");
                    break;

                case 2:
                    System.out.println("List (placeholder)");
                    break;

                case 3:
                    System.out.println("Search (placeholder)");
                    break;

                case 4:
                    System.out.println("Sort (placeholder)");
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
