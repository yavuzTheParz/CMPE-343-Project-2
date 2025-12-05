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

            String border  = WHITE + "        ┌" + "─".repeat(len) + "┐" + RESET;
            String middle  = WHITE + "        │" + RESET + CYAN + title + RESET + WHITE + "│" + RESET;
            String bottom  = WHITE + "        └" + "─".repeat(len) + "┘" + RESET;

            System.out.println(border);
            System.out.println(middle);
            System.out.println(bottom);

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
                    asciiAnimator.playClosingAnimation();
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

    private static final int W_ID        = 4;
    private static final int W_FIRST     = 12;
    private static final int W_MIDDLE    = 12;
    private static final int W_LAST      = 12;
    private static final int W_NICK      = 14;
    private static final int W_PRIMARY   = 14;
    private static final int W_SECONDARY = 14;
    private static final int W_EMAIL     = 24;
    private static final int W_LINKEDIN  = 40;
    private static final int W_BIRTH     = 12;



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
        if (text == null || text.isBlank())
        {
            text = "-";
        }

        if (text.length() > width)
        {
            return text.substring(0, width); // cut long text
        }

        return String.format("%-" + width + "s", text);
    }

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

        int cID   = W_ID + 2;
        int cF    = W_FIRST + 2;
        int cM    = W_MIDDLE + 2;
        int cL    = W_LAST + 2;
        int cN    = W_NICK + 2;
        int cP    = W_PRIMARY + 2;
        int cS    = W_SECONDARY + 2;
        int cMail = W_EMAIL + 2;
        int cLin  = W_LINKEDIN + 2;
        int cB    = W_BIRTH + 2;

        String top =
            "┌" + "─".repeat(cID) +
            "┬" + "─".repeat(cF) +
            "┬" + "─".repeat(cM) +
            "┬" + "─".repeat(cL) +
            "┬" + "─".repeat(cN) +
            "┬" + "─".repeat(cP) +
            "┬" + "─".repeat(cS) +
            "┬" + "─".repeat(cMail) +
            "┬" + "─".repeat(cLin) +
            "┬" + "─".repeat(cB) +
            "┐";

        String mid =
            "├" + "─".repeat(cID) +
            "┼" + "─".repeat(cF) +
            "┼" + "─".repeat(cM) +
            "┼" + "─".repeat(cL) +
            "┼" + "─".repeat(cN) +
            "┼" + "─".repeat(cP) +
            "┼" + "─".repeat(cS) +
            "┼" + "─".repeat(cMail) +
            "┼" + "─".repeat(cLin) +
            "┼" + "─".repeat(cB) +
            "┤";

        String bottom =
            "└" + "─".repeat(cID) +
            "┴" + "─".repeat(cF) +
            "┴" + "─".repeat(cM) +
            "┴" + "─".repeat(cL) +
            "┴" + "─".repeat(cN) +
            "┴" + "─".repeat(cP) +
            "┴" + "─".repeat(cS) +
            "┴" + "─".repeat(cMail) +
            "┴" + "─".repeat(cLin) +
            "┴" + "─".repeat(cB) +
            "┘";

        String header =
            "│ " + pad("ID",        W_ID) +
            " │ " + pad("First",     W_FIRST) +
            " │ " + pad("Middle",    W_MIDDLE) +
            " │ " + pad("Last",      W_LAST) +
            " │ " + pad("Nick",      W_NICK) +
            " │ " + pad("Primary",   W_PRIMARY) +
            " │ " + pad("Secondary", W_SECONDARY) +
            " │ " + pad("Email",     W_EMAIL) +
            " │ " + pad("LinkedIn",  W_LINKEDIN) +
            " │ " + pad("Birth",     W_BIRTH) +
            " │";

        System.out.println(top);
        System.out.println(header);
        System.out.println(mid);

        for (Contact c : contacts)
        {
            String row =
                "│ " + pad(String.valueOf(c.getContactId()), W_ID) +
                " │ " + pad(c.getFirstName(),               W_FIRST) +
                " │ " + pad(c.getMiddleName(),              W_MIDDLE) +
                " │ " + pad(c.getLastName(),                W_LAST) +
                " │ " + pad(c.getNickname(),                W_NICK) +
                " │ " + pad(c.getPhonePrimary(),            W_PRIMARY) +
                " │ " + pad(c.getPhoneSecondary(),          W_SECONDARY) +
                " │ " + pad(c.getEmail(),                   W_EMAIL) +
                " │ " + pad(c.getLinkedinUrl(),             W_LINKEDIN) +
                " │ " + pad(c.getBirthDate() == null ? "-" : c.getBirthDate().toString(), W_BIRTH) +
                " │";

            System.out.println(row);
        }

        System.out.println(bottom);
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
            InputHelper.waitForEnter();
            return;
        }

        System.out.println("\n--- CHANGE PASSWORD ---");

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


            break;
        }


        User updated = UserFactory.createUser(
            current.getUserId(),
            current.getUsername(),
            current.getPasswordHash(), 
            current.getName(),
            current.getSurname(),
            current.getRole()
        );

        boolean ok;
        try
        {
            ok = UserDAO.updateUser(updated, true, newPassword);
        }
        catch (Exception e)
        {
            System.out.println("An unexpected error occurred while updating the password.");
            e.printStackTrace();
            return;
        }

        if (ok)
        {
            // Session'daki user'ı da tazeleyelim (hash vs. güncellensin)
            User refreshed = UserDAO.getUserById(current.getUserId());
            if (refreshed != null)
            {
                Session.setCurrentUser(refreshed);
            }

            System.out.println("Password successfully updated.");
        }
        else
        {
            System.out.println("Failed to update password.");
        }
        InputHelper.waitForEnter();
    }

    

}


