// File: TesterMenu.java
import java.util.List;

/**
 * This class provides the main menu interface for users with the TESTER role.
 * <p>
 * It includes read-only capabilities such as listing, searching, and sorting
 * contacts. Testers cannot modify the stored contact data.
 * </p>
 */
public class TesterMenu
{

    private static final String RESET  = "\u001B[0m";
    private static final String CYAN   = "\u001B[38;2;0;255;255m";
    private static final String YELLOW = "\u001B[38;2;255;255;0m";
    private static final String GREEN  = "\u001B[38;2;0;255;128m";
    private static final String RED    = "\u001B[38;2;255;80;80m";
    private static final String WHITE  = "\u001B[38;2;255;255;255m";

    /**
     * Starts the Tester menu loop.
     * <p>
     * Displays options and executes the selected operations until the user
     * chooses to log out (option {@code 0}).
     * </p>
     */
    public static void start()
    {
        while (true)
        {
            System.out.println();

            String title = "🧪 TESTER MENU";
            int len = title.length();

            // Başlık kutusu
            String border  = WHITE + "        ┌" + "─".repeat(len) + "┐" + RESET;
            String middle  = WHITE + "        │" + RESET + CYAN + title + RESET + WHITE + "│" + RESET;
            String bottom  = WHITE + "        └" + "─".repeat(len) + "┘" + RESET;

            System.out.println(border);
            System.out.println(middle);
            System.out.println(bottom);

            // Menü seçenekleri
            System.out.println(WHITE + "┌──────────────────────────────┐" + RESET);
            System.out.println(WHITE + "│ " + YELLOW + "1) " + RESET + "List Contacts             " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + YELLOW + "2) " + RESET + "Search Contacts           " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + YELLOW + "3) " + RESET + "Sort Contacts             " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + YELLOW + "4) " + RESET + "Change Password           " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + YELLOW + "0) " + RESET + "Logout                    " + WHITE + "│" + RESET);
            System.out.println(WHITE + "└──────────────────────────────┘" + RESET);

            int choice = InputHelper.readInt(GREEN + "Choice: " + RESET);

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
                case 4:
                    changePassword();
                    break;

                case 0:
                    Session.clear();
                    System.out.println(GREEN + "Logged out." + RESET);
                    return;

                default:
                    System.out.println(RED + "Invalid option." + RESET);
            }
        }
    }


    /**
     * Retrieves all contacts from the database and prints them to the console.
     * <p>
     * Displays columns for ID, name, nickname, primary phone, secondary phone,
     * e-mail, and LinkedIn URL.
     * </p>
     */
    protected static void listContacts()
    {
        List<Contact> contacts = ContactDAO.getAllContacts();

        if (contacts.isEmpty())
        {
            System.out.println("No contacts found.");
            return;
        }

        printContactsTable(contacts, "--- CONTACT LIST ---");
        InputHelper.waitForEnter();

    }

    

    /**
     * Pads or truncates the given text so that it fits in a fixed-width column.
     * <p>
     * If the text is {@code null}, a single dash ("-") is used instead.
     * If the text is longer than the specified width, it is truncated.
     * Otherwise it is right-padded with spaces.
     * </p>
     *
     * @param text  the text to format (may be {@code null})
     * @param width the target column width
     * @return a non-null string with exactly {@code width} characters
     */
    private static String pad(String text, int width)
    {
        if (text == null)
            text = "-";

        if (text.length() > width)
            return text.substring(0, width);

        return String.format("%-" + width + "s", text);
    }

    /**
     * Allows the user to search through contacts based on selected criteria.
     * <p>
     * Supports both single-field and multi-field search options
     * (e.g., phone, e-mail, nickname, first name and birth month).
     * Matching contacts are printed to the console.
     * </p>
     */
    protected static void searchContacts()
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

        printContactsTable(result, "--- SEARCH RESULT ---");
        InputHelper.waitForEnter();
    }

    /**
     * Sorts all contacts based on a user-selected field (first name, last name,
     * or birth date) and order (ascending or descending), then displays
     * the sorted list.
     */
    protected static void sortContacts()
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

        printContactsTable(contacts, "--- SORTED CONTACT LIST ---");
        InputHelper.waitForEnter();
    }

        private static final int W_ID       = 4;
        private static final int W_NAME     = 20;
        private static final int W_NICK     = 15;
        private static final int W_PRIMARY  = 15;
        private static final int W_SECOND   = 15;
        private static final int W_EMAIL    = 25;
        private static final int W_LINKEDIN = 30;



    private static void printContactsTable(List<Contact> contacts, String title)
    {
        if (contacts == null || contacts.isEmpty())
        {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println();
        System.out.println(title);
        System.out.println();

        int cellId       = W_ID + 2;
        int cellName     = W_NAME + 2;
        int cellNick     = W_NICK + 2;
        int cellPrimary  = W_PRIMARY + 2;
        int cellSecond   = W_SECOND + 2;
        int cellEmail    = W_EMAIL + 2;
        int cellLinkedIn = W_LINKEDIN + 2;

        // Top border
        String topBorder =
            "┌" + "─".repeat(cellId) +
            "┬" + "─".repeat(cellName) +
            "┬" + "─".repeat(cellNick) +
            "┬" + "─".repeat(cellPrimary) +
            "┬" + "─".repeat(cellSecond) +
            "┬" + "─".repeat(cellEmail) +
            "┬" + "─".repeat(cellLinkedIn) +
            "┐";

        // Header/Body separator
        String midBorder =
            "├" + "─".repeat(cellId) +
            "┼" + "─".repeat(cellName) +
            "┼" + "─".repeat(cellNick) +
            "┼" + "─".repeat(cellPrimary) +
            "┼" + "─".repeat(cellSecond) +
            "┼" + "─".repeat(cellEmail) +
            "┼" + "─".repeat(cellLinkedIn) +
            "┤";

        // Bottom border
        String bottomBorder =
            "└" + "─".repeat(cellId) +
            "┴" + "─".repeat(cellName) +
            "┴" + "─".repeat(cellNick) +
            "┴" + "─".repeat(cellPrimary) +
            "┴" + "─".repeat(cellSecond) +
            "┴" + "─".repeat(cellEmail) +
            "┴" + "─".repeat(cellLinkedIn) +
            "┘";

        // Header row
        String header =
            "│ " + pad("ID",       W_ID)       +
            " │ " + pad("Name",     W_NAME)     +
            " │ " + pad("Nickname", W_NICK)     +
            " │ " + pad("Primary",  W_PRIMARY)  +
            " │ " + pad("Secondary",W_SECOND)   +
            " │ " + pad("Email",    W_EMAIL)    +
            " │ " + pad("LinkedIn", W_LINKEDIN) + " │";

        System.out.println(topBorder);
        System.out.println(header);
        System.out.println(midBorder);

        // Rows
        for (Contact c : contacts)
        {
            String fullName = c.getFirstName() + " " + c.getLastName();

            String secondaryPhone =
                (c.getPhoneSecondary() == null || c.getPhoneSecondary().isBlank())
                    ? "-"
                    : c.getPhoneSecondary();

            String linkedin =
                (c.getLinkedinUrl() == null || c.getLinkedinUrl().isBlank())
                    ? "-"
                    : c.getLinkedinUrl();

            String row =
                "│ " + pad(String.valueOf(c.getContactId()), W_ID) +
                " │ " + pad(fullName,                         W_NAME) +
                " │ " + pad(c.getNickname(),                  W_NICK) +
                " │ " + pad(c.getPhonePrimary(),              W_PRIMARY) +
                " │ " + pad(secondaryPhone,                   W_SECOND) +
                " │ " + pad(c.getEmail(),                     W_EMAIL) +
                " │ " + pad(linkedin,                         W_LINKEDIN) + " │";

            System.out.println(row);
        }

        System.out.println(bottomBorder);

    }
    /**
 * Allows the currently logged-in TESTER user to change their own password.
 * Verifies the current password first, then asks for a new password twice.
 */
protected static void changePassword()
{
    User current = Session.getCurrentUser();

    if (current == null)
    {
        System.out.println("No active session. Please log in again.");
        return;

    }

    System.out.println("\n--- CHANGE PASSWORD ---");

    // 1) Eski şifreyi doğrula
    String oldPassword = InputHelper.readNonEmptyString("Current password: ");

    User verified = null;
    try
    {
        verified = UserDAO.authenticate(current.getUsername(), oldPassword);
    }
    catch (Exception e)
    {
        System.out.println("An unexpected error occurred while verifying password.");
        System.out.println("Please contact your system administrator.");
        e.printStackTrace();
        return;
    }

    if (verified == null)
    {
        System.out.println("Current password is incorrect.");
        return;
    }

    // 2) Yeni şifreyi iste (iki kez)
    String newPassword;
    while (true)
    {
        newPassword = InputHelper.readNonEmptyString("New password: ");
        String confirm = InputHelper.readNonEmptyString("Confirm new password: ");

        if (!newPassword.equals(confirm))
        {
            System.out.println("Passwords do not match. Please try again.\n");
            continue;
        }

        if (newPassword.length() < 6)
        {
            System.out.println("Password must be at least 6 characters long.\n");
            continue;
        }

        break;
    }

    boolean ok;
    try
    {

        ok = UserDAO.updatePassword(current.getUserId(), newPassword);
    }
    catch (Exception e)
    {
        System.out.println("An unexpected error occurred while updating the password.");
        e.printStackTrace();
        return;
    }

    if (ok)
    {
        System.out.println("Password successfully updated.");
    }
    else
    {
        System.out.println("Failed to update password.");
    }

}


