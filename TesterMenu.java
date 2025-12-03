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
    /**
     * Starts the Tester menu loop.
     * <p>
     * Displays options and executes the selected operations until the user
     * chooses to log out (option {@code 0}).
     * </p>
     */
    public static void start()
    {
        // ...
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
        // ...
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
        // ...
    }

    /**
     * Sorts all contacts based on a user-selected field (first name, last name,
     * or birth date) and order (ascending or descending), then displays
     * the sorted list.
     */
    protected static void sortContacts()
    {
        // ...
    }
}
