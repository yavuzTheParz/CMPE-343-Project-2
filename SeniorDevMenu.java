// File: SeniorDevMenu.java
import java.time.LocalDate;

/**
 * This class provides the main menu interface for users with the SENIOR_DEV role.
 * It includes full contact management capabilities (Add, Delete, Update, List, Search, Sort)
 * and undo functionality.
 */
public class SeniorDevMenu extends JuniorDevMenu
{
    
    private static final String RESET  = "\u001B[0m";
    private static final String BLUE   = "\u001B[38;2;100;150;255m";
    private static final String PURPLE = "\u001B[38;2;180;100;255m";
    private static final String CYAN   = "\u001B[38;2;0;255;255m";
    private static final String RED    = "\u001B[38;2;255;80;80m";
    private static final String WHITE  = "\u001B[38;2;255;255;255m";
    private static final String BRIGHT = "\u001B[1m"; // Bold

    /**
     * Starts the Senior Developer menu loop. Displays options and executes
     * the selected operations until the user chooses to "Logout" (0).
     */
    public static void start()
    {
        while (true)
        {
            System.out.println();

            // Başlık tasarımı
            String title = "🛠️  SENIOR DEV MENU";
            int len = title.length();

            String border = WHITE + "       ┌" + "─".repeat(len) + "┐" + RESET;
            String middle = WHITE + "       │" + RESET + BLUE + BRIGHT + title + RESET + WHITE + " │" + RESET;
            String bottom = WHITE + "       └" + "─".repeat(len) + "┘" + RESET;

            System.out.println(border);
            System.out.println(middle);
            System.out.println(bottom);

            // Menü seçenekleri
            System.out.println(WHITE + "┌──────────────────────────────────┐" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "1) " + RESET + "Add Contact                   " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "2) " + RESET + "Delete Contact                " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "3) " + RESET + "Update Contact                " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "4) " + RESET + "List Contacts                 " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "5) " + RESET + "Search Contacts               " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "6) " + RESET + "Sort Contacts                 " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "7) " + RESET + "Undo last action              " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "0) " + RESET + "Logout                        " + WHITE + "│" + RESET);
            System.out.println(WHITE + "└──────────────────────────────────┘" + RESET);

            int choice = InputHelper.readInt(PURPLE + "Choice: " + RESET);

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
                    asciiAnimator.playClosingAnimation();
                    System.out.println(PURPLE + "Logged out." + RESET);
                    return;

                default:
                    System.out.println(RED + "Invalid option." + RESET);
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
        String linkedinUrl    = InputHelper.readLinkedn("LinkedIn URL (can be empty): ");
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
        InputHelper.waitForEnter();
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
            InputHelper.waitForEnter();
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
        InputHelper.waitForEnter();
    }
}