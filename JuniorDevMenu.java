// File: JuniorDevMenu.java
import java.util.List;
import java.time.LocalDate;

/**
 * This class provides the main menu interface for users with the JUNIOR_DEV role.
 * It includes limited contact management capabilities (Update, List, Search, Sort)
 * and undo functionality. Unlike Senior Devs, Junior Devs cannot Add or Delete contacts.
 */
public class JuniorDevMenu extends TesterMenu
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
     * Updates an existing contact's details based on the ID provided by the user.
     * Shows current values for each field; if the input is empty, the old value is preserved.
     */
    protected static void updateContact()
    {
        System.out.println("\n--- UPDATE CONTACT ---");

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

        // Boş bırakılabilir alanlar
        String firstName      = InputHelper.readOptionalString("New first name [" + existing.getFirstName() + "]: ");
        String middleName     = InputHelper.readOptionalString("New middle name [" +
                                                            (existing.getMiddleName() == null ? "" : existing.getMiddleName()) +
                                                            "]: ");
        String lastName       = InputHelper.readOptionalString("New last name [" + existing.getLastName() + "]: ");
        String nickname       = InputHelper.readOptionalString("New nickname [" + existing.getNickname() + "]: ");
        String phonePrimary   = InputHelper.readOptionalString("New primary phone [" + existing.getPhonePrimary() + "]: ");
        String phoneSecondary = InputHelper.readOptionalString("New secondary phone [" +
                                                            (existing.getPhoneSecondary() == null ? "" : existing.getPhoneSecondary()) +
                                                            "]: ");
        String email          = InputHelper.readOptionalString("New email [" + existing.getEmail() + "]: ");
        String linkedinUrl    = InputHelper.readOptionalString("New LinkedIn URL [" +
                                                            (existing.getLinkedinUrl() == null ? "" : existing.getLinkedinUrl()) +
                                                            "]: ");

        LocalDate birthDate   = InputHelper.readOptionalDate("New birth date");

        // Boş girişleri eski değerlerle dolduruyoruz
        if (firstName.isEmpty())      firstName = existing.getFirstName();
        if (middleName.isEmpty())     middleName = existing.getMiddleName();
        if (lastName.isEmpty())       lastName = existing.getLastName();
        if (nickname.isEmpty())       nickname = existing.getNickname();
        if (phonePrimary.isEmpty())   phonePrimary = existing.getPhonePrimary();
        if (phoneSecondary.isEmpty()) phoneSecondary = existing.getPhoneSecondary();
        if (email.isEmpty())          email = existing.getEmail();
        if (linkedinUrl.isEmpty())    linkedinUrl = existing.getLinkedinUrl();
        if (birthDate == null)        birthDate = existing.getBirthDate();

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

}