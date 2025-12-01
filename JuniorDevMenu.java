// File: JuniorDevMenu.java
import java.util.List;
import java.time.LocalDate;

/**
 * This class provides the main menu interface for users with the JUNIOR_DEV role.
 * It includes limited contact management capabilities (Update, List, Search, Sort)
 * and undo functionality. Unlike Senior Devs, Junior Devs cannot Add or Delete contacts.
 */
public class JuniorDevMenu
{
    /**
     * Starts the Junior Developer menu loop. Displays options and executes
     * the selected operations until the user chooses to "Logout" (0).
     */
    public static void start()
    {
        while (true)
        {
            System.out.println("\n=== JUNIOR DEV MENU ===");
            System.out.println("1) Update Contact");
            System.out.println("2) List Contacts");
            System.out.println("3) Search Contacts");
            System.out.println("4) Sort Contacts");
            System.out.println("5) Undo last action");
            System.out.println("0) Logout");

            int choice = InputHelper.readInt("Choice: ");

            switch (choice)
            {
                case 1:
                    updateContact();
                    break;

                case 2:
                    listContacts();
                    break;

                case 3:
                    searchContacts();
                    break;

                case 4:
                    sortContacts();
                    break;

                case 5:
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
     * Updates an existing contact's details based on the ID provided by the user.
     * Shows current values for each field; if the input is empty, the old value is preserved.
     */
    private static void updateContact()
    {
        System.out.println("\n--- UPDATE CONTACT (Junior) ---");

        int id = InputHelper.readInt("Contact ID to update: ");
        Contact existing = ContactDAO.getContactById(id);

        if (existing == null)
        {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Updating contact: " +
                           existing.getFirstName() + " " + existing.getLastName() +
                           " (" + existing.getNickname() + ")");

        // Read new values; if input is empty, the old value is kept later.
        String firstName  = InputHelper.readString("New first name [" + existing.getFirstName() + "]: ");
        String middleName = InputHelper.readString("New middle name [" +
                                                   (existing.getMiddleName() == null ? "" : existing.getMiddleName()) +
                                                   "]: ");
        String lastName   = InputHelper.readString("New last name [" + existing.getLastName() + "]: ");
        String nickname   = InputHelper.readString("New nickname [" + existing.getNickname() + "]: ");
        String phonePrimary   = InputHelper.readString("New primary phone [" + existing.getPhonePrimary() + "]: ");
        String phoneSecondary = InputHelper.readString("New secondary phone [" +
                                                       (existing.getPhoneSecondary() == null ? "" : existing.getPhoneSecondary()) +
                                                       "]: ");
        String email      = InputHelper.readString("New email [" + existing.getEmail() + "]: ");
        String linkedinUrl= InputHelper.readString("New LinkedIn URL [" +
                                                   (existing.getLinkedinUrl() == null ? "" : existing.getLinkedinUrl()) +
                                                   "]: ");

        // Birth date can optionally be updated
        LocalDate birthDate = InputHelper.readOptionalDate("New birth date");

        // Preserve existing values for empty inputs
        if (firstName.isEmpty())    firstName = existing.getFirstName();
        if (middleName.isEmpty())   middleName = existing.getMiddleName();
        if (lastName.isEmpty())     lastName = existing.getLastName();
        if (nickname.isEmpty())     nickname = existing.getNickname();
        if (phonePrimary.isEmpty()) phonePrimary = existing.getPhonePrimary();
        if (phoneSecondary.isEmpty()) phoneSecondary = existing.getPhoneSecondary();
        if (email.isEmpty())        email = existing.getEmail();
        if (linkedinUrl.isEmpty())  linkedinUrl = existing.getLinkedinUrl();
        if (birthDate == null)      birthDate = existing.getBirthDate();

        Contact updated = new Contact(
            id,
            firstName,
            middleName,
            lastName,
            nickname,
            phonePrimary,
            phoneSecondary,
            email,
            linkedinUrl,
            birthDate
        );

        boolean ok = ContactDAO.updateContact(updated);

        if (ok)
        {
            System.out.println("Contact updated.");
        }
        else
        {
            System.out.println("Failed to update contact.");
        }
    }

    /**
     * Initiates the contact search functionality by calling the method in TesterMenu.
     */
    private static void searchContacts()
    {
        TesterMenu.searchContacts();
    }

    /**
     * Initiates the contact sorting functionality by calling the method in TesterMenu.
     */
    private static void sortContacts()
    {
        TesterMenu.sortContacts();
    }
}