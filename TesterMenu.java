// File: TesterMenu.java
import java.util.List;

/**
 * This class provides the main menu interface for users with the TESTER role.
 * It includes read-only capabilities such as Listing, Searching, and Sorting contacts.
 */
public class TesterMenu
{
    /**
     * Starts the Tester menu loop. Displays options and executes
     * the selected operations until the user chooses to "Logout" (0).
     */
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
                    searchContacts();
                    break;

                case 3:
                    sortContacts();
                    break;

                case 0:
                    Session.clear();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Retrieves all contacts from the database and prints them to the console.
     * Displays ID, name, nickname, primary phone, and email.
     */
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

    /**
     * Allows the user to search through contacts based on selected criteria.
     * Offers single-field and multi-field search options (e.g., phone, email, nickname).
     * Displays matching results or a message if no contacts are found.
     */
    public static void searchContacts()
    {
        System.out.println("\n--- SEARCH CONTACTS ---");

    // Guidance for the user regarding input format and search behavior
    System.out.println("Input guidance:");
    System.out.println("- All text searches are CASE-INSENSITIVE and use SUBSTRING matching.");
    System.out.println("  For example, phone search '55' will match any phone number containing '55'.");
    System.out.println("- Phone and e-mail searches accept partial values (e.g., 'yah' in e-mail).");
    System.out.println("- If you make a mistake, simply run the search again with corrected input.\n");

    System.out.println("Single-field searches:");
    System.out.println("1) By phone (primary, substring match)");
    System.out.println("2) By e-mail (substring match)");
    System.out.println("3) By nickname (substring match)");

    System.out.println("Multi-field searches:");
    System.out.println("4) Phone contains X AND e-mail contains Y");
    System.out.println("5) Nickname contains X AND e-mail contains Y");
    System.out.println("6) First name equals X AND birth month is Y (1-12)");

    System.out.println("0) Back to menu");

    int option = InputHelper.readInt("Option: ");

    if (option == 0)
    {
        return;
    }

    List<Contact> all = ContactDAO.getAllContacts();
    List<Contact> result = null;

    switch (option)
    {
        case 1:
        {
            String q = InputHelper.readNonEmptyString("Phone contains: ");
            result = ContactSearch.searchByPhone(all, q);
            break;
        }
        case 2:
        {
            String q = InputHelper.readNonEmptyString("E-mail contains: ");
            result = ContactSearch.searchByEmail(all, q);
            break;
        }
        case 3:
        {
            String q = InputHelper.readNonEmptyString("Nickname contains: ");
            result = ContactSearch.searchByNickname(all, q);
            break;
        }
        case 4:
        {
            String phoneSub = InputHelper.readNonEmptyString("Phone contains: ");
            String emailSub = InputHelper.readNonEmptyString("E-mail contains: ");
            result = ContactSearch.searchByPhoneAndEmail(all, phoneSub, emailSub);
            break;
        }
        case 5:
        {
            String nickSub = InputHelper.readNonEmptyString("Nickname contains: ");
            String emailSub = InputHelper.readNonEmptyString("E-mail contains: ");
            result = ContactSearch.searchByNicknameAndEmail(all, nickSub, emailSub);
            break;
        }
        case 6:
        {
            String firstNameExact = InputHelper.readNonEmptyString("First name (exact match): ");
            int month = InputHelper.readIntInRange("Birth month", 1, 12);
            result = ContactSearch.searchByFirstNameAndBirthMonth(all, firstNameExact, month);
            break;
        }
        default:
            System.out.println("Invalid option.");
            return;
    }

    if (result == null || result.isEmpty())
    {
        System.out.println("No matching contacts found.");
        return;
    }

    System.out.println("\n--- SEARCH RESULTS ---");
    for (Contact c : result)
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

    /**
     * Sorts all contacts based on a user-selected field (Name, Last Name, Birth Date)
     * and order (Ascending/Descending), then displays the sorted list.
     */
    public static void sortContacts()
    {
        System.out.println("\n--- SORT CONTACTS ---");
        System.out.println("1) By first name");
        System.out.println("2) By last name");
        System.out.println("3) By birth date");
        int fieldOpt = InputHelper.readInt("Field: ");

        System.out.println("Order: 1) Ascending  2) Descending");
        int orderOpt = InputHelper.readInt("Order: ");

        ContactSorter.SortField field;

        switch (fieldOpt)
        {
            case 1:
                field = ContactSorter.SortField.FIRST_NAME;
                break;
            case 2:
                field = ContactSorter.SortField.LAST_NAME;
                break;
            case 3:
                field = ContactSorter.SortField.BIRTH_DATE;
                break;
            default:
                System.out.println("Invalid field.");
                return;
        }

        boolean ascending = (orderOpt == 1);

        List<Contact> contacts = ContactDAO.getAllContacts();
        ContactSorter.sort(contacts, field, ascending);

        System.out.println("\n--- SORTED CONTACT LIST ---");
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