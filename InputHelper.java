// File: InputHelper.java
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * A utility class that provides various input-handling methods for user interaction
 * through the console. This class includes validation logic for names, integers,
 * phone numbers, email addresses, dates, and yes/no responses.
 *
 * It also prints user-friendly guidance texts the first time certain fields (date, phone)
 * are requested, helping the user understand the expected input format.
 */
public class InputHelper
{
    private static final Scanner SCANNER = new Scanner(System.in);

    private static boolean PHONE_GUIDANCE_SHOWN = false;
    private static boolean DATE_GUIDANCE_SHOWN  = false;

    /**
     * Reads a line of input as a string (can be empty).
     *
     * @param prompt the message displayed to the user
     * @return the user's input trimmed of whitespace
     */
    public static String readString(String prompt)
    {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    /**
     * Reads a line of input as an optional string.
     *
     * @param prompt the message displayed to the user
     * @return the trimmed string (may be empty)
     */
    public static String readOptionalString(String prompt)
    {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    /**
     * Reads a non-empty string. Keeps asking until the user enters a valid value.
     *
     * @param prompt the message displayed to the user
     * @return a non-empty trimmed string
     */
    public static String readNonEmptyString(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();

            if (!line.isEmpty())
            {
                return line;
            }

            System.out.println("This field cannot be empty. Please try again.");
        }
    }

    /**
     * Reads a name and validates allowed characters (letters, spaces, Turkish letters).
     *
     * @param prompt the message displayed to the user
     * @return a validated, non-empty name string
     */
    public static String readName(String prompt)
    {
        while (true)
        {
            String value = readNonEmptyString(prompt);

            if (value.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ\\s'-]+"))
            {
                return value;
            }

            System.out.println("Please enter a valid name (letters only).");
        }
    }

    /**
     * Reads an integer from user input.
     *
     * @param prompt the message displayed to the user
     * @return a valid integer
     */
    public static int readInt(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();

            try
            {
                return Integer.parseInt(line);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    /**
     * Reads an integer and ensures it is within the given range (inclusive).
     *
     * @param prompt the message displayed to the user
     * @param min    the minimum allowed value
     * @param max    the maximum allowed value
     * @return a valid integer inside the given range
     */
    public static int readIntInRange(String prompt, int min, int max)
    {
        while (true)
        {
            int value = readInt(prompt + " (" + min + " - " + max + "): ");
            if (value >= min && value <= max)
            {
                return value;
            }

            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    /**
     * Reads a valid date in YYYY-MM-DD format. Guidance is shown only once.
     *
     * @param prompt the message displayed to the user
     * @return a valid LocalDate object
     */
    public static LocalDate readDate(String prompt)
    {
        if (!DATE_GUIDANCE_SHOWN)
        {
            System.out.println("\nDate input guidance:");
            System.out.println("- Please enter dates in the format YYYY-MM-DD (e.g., 2025-11-29).");
            System.out.println("- Logically invalid dates such as 2025-02-30 will be rejected.");
            System.out.println("- If you make a mistake, simply enter the date again.\n");
            DATE_GUIDANCE_SHOWN = true;
        }

        while (true)
        {
            System.out.print(prompt + " (YYYY-MM-DD): ");
            String line = SCANNER.nextLine().trim();

            try
            {
                return LocalDate.parse(line);
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Invalid date. Please use format YYYY-MM-DD.");
            }
        }
    }

    /**
     * Reads an optional date. Empty input returns null.
     *
     * @param prompt the message displayed to the user
     * @return a LocalDate or null if the user skipped the field
     */
    public static LocalDate readOptionalDate(String prompt)
    {
        if (!DATE_GUIDANCE_SHOWN)
        {
            System.out.println("\nDate input guidance:");
            System.out.println("- Please enter dates in the format YYYY-MM-DD.");
            System.out.println("- Leave empty to skip.\n");
            DATE_GUIDANCE_SHOWN = true;
        }

        while (true)
        {
            System.out.print(prompt + " (YYYY-MM-DD, empty = skip): ");
            String line = SCANNER.nextLine().trim();

            if (line.isEmpty())
            {
                return null;
            }

            try
            {
                return LocalDate.parse(line);
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Invalid date. Please use format YYYY-MM-DD.");
            }
        }
    }

    /**
     * Reads and validates an email address.
     *
     * @param prompt the message displayed to the user
     * @return a valid email string
     */
    public static String readEmail(String prompt)
    {
        System.out.println("\nEmail input guidance:");
        System.out.println("- Use format: name@domain.extension\n");

        while (true)
        {
            String email = readNonEmptyString(prompt);

            if (isValidEmail(email))
            {
                return email;
            }

            System.out.println("Please enter a valid e-mail address (example: name@example.com).");
        }
    }

    /**
     * Reads an optional email. Empty input returns an empty string.
     *
     * @param prompt the message displayed to the user
     * @return a valid email or an empty string if skipped
     */
    public static String readOptionalEmail(String prompt)
    {
        while (true)
        {
            System.out.print(prompt + " (empty = skip): ");
            String email = SCANNER.nextLine().trim();

            if (email.isEmpty())
            {
                return "";
            }

            if (isValidEmail(email))
            {
                return email;
            }

            System.out.println("Please enter a valid e-mail address.");
        }
    }

    /**
     * Reads and validates a phone number with detailed guidance (shown once).
     *
     * @param prompt the message displayed to the user
     * @return a validated phone number
     */
    public static String readPhone(String prompt)
    {
        if (!PHONE_GUIDANCE_SHOWN)
        {
            System.out.println("\nPhone number input guidance:");
            System.out.println("- Digits only, optionally + or spaces.");
            System.out.println("Examples: 05551234567, +90 555 123 45 67\n");
            PHONE_GUIDANCE_SHOWN = true;
        }

        while (true)
        {
            String phone = readNonEmptyString(prompt);

            if (isValidPhone(phone))
            {
                return phone;
            }

            System.out.println("Invalid phone number. Please try again.");
        }
    }

    /**
     * Reads an optional phone number. Empty input returns an empty string.
     *
     * @param prompt the message displayed to the user
     * @return a valid phone number or an empty string if skipped
     */
    public static String readOptionalPhone(String prompt)
    {
        if (!PHONE_GUIDANCE_SHOWN)
        {
            System.out.println("\nPhone number input guidance:");
            System.out.println("- Digits only, optionally + or spaces.\n");
            PHONE_GUIDANCE_SHOWN = true;
        }

        while (true)
        {
            System.out.print(prompt + " (empty = skip): ");
            String phone = SCANNER.nextLine().trim();

            if (phone.isEmpty())
            {
                return "";
            }

            if (isValidPhone(phone))
            {
                return phone;
            }

            System.out.println("Invalid phone number. Please try again.");
        }
    }

    /**
     * Reads a yes/no answer from the user. Supports English and Turkish inputs.
     *
     * @param prompt the message displayed to the user
     * @return true for yes/e/evet, false for no/h/hayır
     */
    public static boolean readYesNo(String prompt)
    {
        while (true)
        {
            System.out.print(prompt + " (y/n): ");
            String line = SCANNER.nextLine().trim().toLowerCase();

            if (line.equals("y") || line.equals("yes") || line.equals("e") || line.equals("evet"))
            {
                return true;
            }

            if (line.equals("n") || line.equals("no") || line.equals("h") || line.equals("hayir") || line.equals("hayır"))
            {
                return false;
            }

            System.out.println("Please answer y / n.");
        }
    }

    /**
     * Reads a role from user input and converts it into a {@link Role} enum value.
     *
     * @param prompt the message displayed to the user
     * @return a valid Role enum constant
     */
    public static Role readRole(String prompt)
    {
        while (true)
        {
            System.out.print(prompt + " (TESTER, JUNIOR_DEV, SENIOR_DEV, MANAGER): ");
            String value = SCANNER.nextLine().trim();

            if (value.isEmpty())
            {
                System.out.println("Role cannot be empty.");
                continue;
            }

            try
            {
                return Role.valueOf(value.toUpperCase());
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Invalid role. Please try again.");
            }
        }
    }

    // ------------------- PRIVATE HELPERS -------------------

    /**
     * Validates an email using a simple regular expression.
     */
    private static boolean isValidEmail(String email)
    {
        String regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        return Pattern.matches(regex, email);
    }

    /**
     * Validates a phone number using regex rules and logical checks.
     */
    private static boolean isValidPhone(String phone)
    {
        String regex = "^[0-9\\s+\\-()]{5,25}$";
        if (!Pattern.matches(regex, phone))
        {
            return false;
        }

        return isRealisticPhone(phone);
    }

    /**
     * Ensures the phone number has a realistic number of digits.
     */
    private static boolean isRealisticPhone(String phone)
    {
        String digits = phone.replaceAll("[^0-9]", "");

        return digits.length() >= 10 && digits.length() <= 15;
    }
}
