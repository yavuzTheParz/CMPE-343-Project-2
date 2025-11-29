// File: TesterMenu.java

public class TesterMenu
{
    public static void start()
    {
        while (true)
        {
            System.out.println("\n=== TESTER MENU ===");
            System.out.println("1) List Contacts");
            System.out.println("2) Search Contacts");
            System.out.println("3) Sort Contacts");
            System.out.println("0) Logout");

            int choice = InputHelper.readInt("Choice: ");

            switch (choice)
            {
                case 1:
                    System.out.println("Listing contacts (placeholder)...");
                    break;

                case 2:
                    System.out.println("Searching contacts (placeholder)...");
                    break;

                case 3:
                    System.out.println("Sorting contacts (placeholder)...");
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
