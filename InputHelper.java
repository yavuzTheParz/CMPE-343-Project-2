// File: InputHelper.java
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Utility class for reading and validating user input from the console.
 * <p>
 * Provides helper methods for reading strings, integers, dates, emails,
 * phone numbers, yes/no answers, and roles with basic validation.
 * </p>
 */
public class InputHelper
{
    private static final Scanner SCANNER = new Scanner(System.in);

    private static boolean PHONE_GUIDANCE_SHOWN = false;
    private static boolean DATE_GUIDANCE_SHOWN  = false;

    /**
     * Reads a basic string input.
     *
     * @param prompt text shown to the user
     * @return trimmed input string
     */
    public static String readString(String prompt)
    {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    /**
     * Reads a non-empty string.
     *
     * @param prompt input prompt
     * @return non-empty string
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
     * Reads a name consisting only of letters and allowed characters.
     *
     * @param prompt input prompt
     * @return validated name
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
     * Reads an integer value.
     *
     * @param prompt input prompt
     * @return parsed integer
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
     * Reads an integer within a specific range.
     *
     * @param prompt input prompt
     * @param min minimum allowed
     * @param max maximum allowed
     * @return validated integer
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
     * Reads a required date in YYYY-MM-DD format.
     *
     * @param prompt input prompt
     * @return valid LocalDate
     */
    public static LocalDate readDate(String prompt)
    {
        if (!DATE_GUIDANCE_SHOWN)
        {
            System.out.println("\nDate input guidance:");
            System.out.println("- Format: YYYY-MM-DD (e.g., 2025-11-29)");
            System.out.println("- Invalid dates such as 2025-02-30 are rejected.\n");
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
                System.out.println("Invalid date. Please try again.");
            }
        }
    }

    /**
     * Reads an optional date (empty input allowed).
     *
     * @param prompt input prompt
     * @return LocalDate or null
     */
    public static LocalDate readOptionalDate(String prompt)
    {
        if (!DATE_GUIDANCE_SHOWN)
        {
            System.out.println("\nDate input guidance:");
            System.out.println("- Format: YYYY-MM-DD");
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
                System.out.println("Invalid date. Please try again.");
            }
        }
    }

    /**
     * Reads an email address with validation.
     *
     * @param prompt input prompt
     * @return validated email
     */
    public static String readEmail(String prompt)
    {
        while (true)
        {
            String email = readNonEmptyString(prompt);

            if (isValidEmail(email))
            {
                return email;
            }

            System.out.println("Please enter a valid e-mail address.");
        }
    }

    /**
     * Reads an optional email address.
     *
     * @param prompt input prompt
     * @return validated email or empty string
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

            System.out.println("Please enter a valid email.");
        }
    }

    /**
     * Reads a phone number.
     *
     * @param prompt input prompt
     * @return validated phone number
     */
    public static String readPhone(String prompt)
    {
        if (!PHONE_GUIDANCE_SHOWN)
        {
            System.out.println("\nPhone number input guidance:");
            System.out.println("- Digits only, optionally + or spaces allowed.\n");
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
     * Reads a yes/no response.
     *
     * @param prompt question
     * @return true for yes, false for no
     */
    public static boolean readYesNo(String prompt)
    {
        while (true)
        {
            System.out.print(prompt + " (y/n): ");
            String line = SCANNER.nextLine().trim().toLowerCase();

            if (line.matches("y|yes|e|evet"))
            {
                return true;
            }

            if (line.matches("n|no|h|hayir|hayır"))
            {
                return false;
            }

            System.out.println("Please answer with y / n.");
        }
    }

    /**
     * Reads a Role enum value.
     *
     * @param prompt input prompt
     * @return Role constant
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
                System.out.println("Invalid role. Try again.");
            }
        }
    }

    // Validation helpers

    private static boolean isValidEmail(String email)
    {
        String regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        return Pattern.matches(regex, email);
    }

    private static boolean isValidPhone(String phone)
    {
        String regex = "^[0-9\\s+\\-()]{5,25}$";
        return Pattern.matches(regex, phone);
    }
}
