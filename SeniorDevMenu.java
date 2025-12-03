// File: SeniorDevMenu.java
import java.util.List;
import java.time.LocalDate;

/**
 * This class provides the main menu interface for users with the SENIOR_DEV role.
 * It includes full contact management capabilities (Add, Delete, Update, List, Search, Sort)
 * and undo functionality.
 */
public class SeniorDevMenu extends JuniorDevMenu
{
    /**
     * Starts the Senior Developer menu loop. Displays options and executes
     * the selected operations until the user chooses to "Logout" (0).
     */
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
            System.out.println("7) Undo last action");
            System.out.println("0) Logout");

            int choice = InputHelper.readInt("Choice: ");

            switch (choice)
            {
                case 1:
                    addContact();
                    break;

                case 2:
                    deleteContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    listContacts();
                    break;

                case 5:
                    searchContacts();
                    break;

                case 6:
                    sortContacts();
                    break;

                case 7:
                    UndoService.undoLastOperation();
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
     * Collects new contact details from the user and adds them to the system.
     * Displays a success or failure message based on the result.
     */
    private static void addContact()
    {
        System.out.println("\n--- ADD CONTACT ---");

        String firstName  = InputHelper.readName("First name: ");
        String middleName = InputHelper.readString("Middle name (can be empty): ");
        String lastName   = InputHelper.readName("Last name: ");
        String nickname   = InputHelper.readNonEmptyString("Nickname: ");
        String email      = InputHelper.readEmail("Email: ");
        String phonePrimary   = InputHelper.readPhone("Primary phone: ");
        String phoneSecondary = InputHelper.readOptionalPhone("Secondary phone: ");
        String linkedinUrl    = InputHelper.readString("LinkedIn URL (can be empty): ");
        LocalDate birthDate   = InputHelper.readDate("Birth date");

        Contact contact = new Contact(
            0,
            firstName,
            middleName.isEmpty() ? null : middleName,
            lastName,
            nickname,
            phonePrimary,
            phoneSecondary.isEmpty() ? null : phoneSecondary,
            email,
            linkedinUrl.isEmpty() ? null : linkedinUrl,
            birthDate
        );

        boolean ok = ContactDAO.insertContact(contact);

        if (ok)
        {
            System.out.println("Contact added successfully.");
        }
        else
        {
            System.out.println("Failed to add contact.");
        }
    }

    /**
     * Deletes an existing contact based on the ID provided by the user.
     * Requests confirmation before proceeding with the deletion.
     */
    private static void deleteContact()
    {
        System.out.println("\n--- DELETE CONTACT ---");

        int id = InputHelper.readInt("Contact ID to delete: ");
        Contact existing = ContactDAO.getContactById(id);

        if (existing == null)
        {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("You are about to delete: " +
                           existing.getFirstName() + " " + existing.getLastName() +
                           " (" + existing.getNickname() + ")");
        boolean confirm = InputHelper.readYesNo("Are you sure");

        if (!confirm)
        {
            System.out.println("Delete cancelled.");
            return;
        }

        boolean ok = ContactDAO.deleteContact(id);
        if (ok)
        {
            System.out.println("Contact deleted.");
        }
        else
        {
            System.out.println("Failed to delete contact.");
        }
    }
}