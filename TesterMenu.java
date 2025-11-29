// File: TesterMenu.java

import java.util.List;

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
                    listContacts();
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

    private static void listContacts()
    {
        List<Contact> contacts = ContactDAO.getAllContacts();

        if (contacts.isEmpty())
        {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("\n--- CONTACT LIST ---");
        for (Contact c : contacts)
        {
            System.out.println(
                c.getContactId() + " - " +
                c.getFirstName() + " " + c.getLastName() +
                " (" + c.getNickname() + ") | " +
                c.getPhonePrimary() + " | " +
                c.getEmail()
            );
        }
    }
}
