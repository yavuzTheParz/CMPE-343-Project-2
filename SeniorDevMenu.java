// File: SeniorDevMenu.java

public class SeniorDevMenu
{
    public static void start()
    {
        while (true)
        {
            System.out.println("\n=== SENIOR DEV MENU ===");
            System.out.println("1) Add Contact");
            System.out.println("2) Delete Contact");
            System.out.println("3) Update Contact");
            System.out.println("4) List Contacts");
            System.out.println("5) Search Contacts");
            System.out.println("6) Sort Contacts");
            System.out.println("0) Logout");

            int choice = InputHelper.readInt("Choice: ");

            switch (choice)
            {
                case 1:
                    System.out.println("Add contact (placeholder)");
                    break;

                case 2:
                    System.out.println("Delete contact (placeholder)");
                    break;

                case 3:
                    System.out.println("Update contact (placeholder)");
                    break;

                case 4:
                    System.out.println("List contacts (placeholder)");
                    break;

                case 5:
                    System.out.println("Search (placeholder)");
                    break;

                case 6:
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
