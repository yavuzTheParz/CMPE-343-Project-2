// File: JuniorDevMenu.java
import java.time.LocalDate;

/**
 * This class provides the main menu interface for users with the JUNIOR_DEV role.
 * It includes limited contact management capabilities (Update, List, Search, Sort)
 * and undo functionality. Unlike Senior Devs, Junior Devs cannot Add or Delete contacts.
 */
public class JuniorDevMenu extends TesterMenu
{

    private static final String RESET  = "\u001B[0m";
    private static final String ORANGE = "\u001B[38;2;255;180;80m";
    private static final String YELLOW = "\u001B[38;2;255;220;0m";
    private static final String BLUE   = "\u001B[38;2;100;180;255m";
    private static final String RED    = "\u001B[38;2;255;80;80m";
    private static final String WHITE  = "\u001B[38;2;255;255;255m";
    private static final String BOLD   = "\u001B[1m";


    /**
     * Starts the Junior Developer menu loop. Displays options and executes
     * the selected operations until the user chooses to "Logout" (0).
     */
    public static void start()
{
    while (true)
    {
        System.out.println();

        // Başlık kutusu
        String title = "👶💻  JUNIOR DEV MENU";
        int len = title.length();

        String border = WHITE + "       ┌" + "─".repeat(len) + "┐" + RESET;
        String middle = WHITE + "       │" + RESET + ORANGE + BOLD + title + RESET + WHITE + "│" + RESET;
        String bottom = WHITE + "       └" + "─".repeat(len) + "┘" + RESET;

        System.out.println(border);
        System.out.println(middle);
        System.out.println(bottom);

        // Menü seçenek kutusu
        System.out.println(WHITE + "┌──────────────────────────────────┐" + RESET);
        System.out.println(WHITE + "│ " + BLUE + "1) " + RESET + "Update Contact                " + WHITE + "│" + RESET);
        System.out.println(WHITE + "│ " + BLUE + "2) " + RESET + "List Contacts                 " + WHITE + "│" + RESET);
        System.out.println(WHITE + "│ " + BLUE + "3) " + RESET + "Search Contacts               " + WHITE + "│" + RESET);
        System.out.println(WHITE + "│ " + BLUE + "4) " + RESET + "Sort Contacts                 " + WHITE + "│" + RESET);
        System.out.println(WHITE + "│ " + BLUE + "5) " + RESET + "Undo last action              " + WHITE + "│" + RESET);
        System.out.println(WHITE + "│ " + BLUE + "0) " + RESET + "Logout                        " + WHITE + "│" + RESET);
        System.out.println(WHITE + "└──────────────────────────────────┘" + RESET);

        int choice = InputHelper.readInt(YELLOW + "Choice: " + RESET);

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
                System.out.println(ORANGE + "Logged out." + RESET);
                return;

            default:
                System.out.println(RED + "Invalid option." + RESET);
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
            InputHelper.waitForEnter();
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
        InputHelper.waitForEnter();
    }

}