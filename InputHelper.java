// File: InputHelper.java
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

<<<<<<< HEAD
/**
 * A utility class that provides various input-handling methods for user interaction
 * through the console. This class includes validation logic for names, integers,
 * phone numbers, email addresses, dates, and yes/no responses.
 *
 * It also prints user-friendly guidance texts the first time certain fields (date, phone)
 * are requested, helping the user understand the expected input format.
 */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
public class InputHelper
{
    private static final Scanner SCANNER = new Scanner(System.in);

<<<<<<< HEAD
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
=======
    // Rehber metinleri sadece ilk seferde göstermek için
    private static boolean PHONE_GUIDANCE_SHOWN = false;
    private static boolean DATE_GUIDANCE_SHOWN  = false;

    // Basit string okuma
    public static String readString(String prompt)
    {
        System.out.print(prompt);
        return SCANNER.nextLine().trim(); // boş olabilir!
    }
    public static String readOptionalString(String prompt)
    {
        System.out.print(prompt);
        return SCANNER.nextLine().trim(); // boş olabilir!
    }


    public static void waitForEnter()
    {
        System.out.println("\nPress ENTER to continue...");

        try
        {
            // Buffer'ı temizle (animasyon, eski input vs. kalmasın)
            while (System.in.available() > 0)
                System.in.read();

            // ENTER bekle
            System.in.read();

            // Terminal temizle
            System.out.print("\u001B[H\u001B[2J");
            System.out.flush();
        }
        catch (Exception e)
        {
            // Ekstra güvenlik: hata olsa bile en azından break olur
            System.out.println();
        }
    }


    // Boş olmayan string (zorunlu alanlar için)
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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

<<<<<<< HEAD
    /**
     * Reads a name and validates allowed characters (letters, spaces, Turkish letters).
     *
     * @param prompt the message displayed to the user
     * @return a validated, non-empty name string
     */
=======
    // Sadece harf (ve boşluk) içeren isim alanları (Türkçe karakterler dahil)
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public static String readName(String prompt)
    {
        while (true)
        {
            String value = readNonEmptyString(prompt);

<<<<<<< HEAD
=======
            // Türkçe karakterleri de içeren basit bir pattern
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
            if (value.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ\\s'-]+"))
            {
                return value;
            }

            System.out.println("Please enter a valid name (letters only).");
        }
    }

<<<<<<< HEAD
    /**
     * Reads an integer from user input.
     *
     * @param prompt the message displayed to the user
     * @return a valid integer
     */
=======
    // Integer okuma
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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

<<<<<<< HEAD
    /**
     * Reads an integer and ensures it is within the given range (inclusive).
     *
     * @param prompt the message displayed to the user
     * @param min    the minimum allowed value
     * @param max    the maximum allowed value
     * @return a valid integer inside the given range
     */
=======
    // Belirli aralıkta integer
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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

<<<<<<< HEAD
    /**
     * Reads a valid date in YYYY-MM-DD format. Guidance is shown only once.
     *
     * @param prompt the message displayed to the user
     * @return a valid LocalDate object
     */
    public static LocalDate readDate(String prompt)
    {
=======
    // Tarih okuma (zorunlu)
    public static LocalDate readDate(String prompt)
    {
        // Kullanıcıya tarih formatı ve mantıksız tarihler için açıklama
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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
<<<<<<< HEAD
=======
                // LocalDate.parse zaten 30 Şubat, 31 Kasım gibi hatalı tarihleri de reddeder
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
                return LocalDate.parse(line);
            }
            catch (DateTimeParseException e)
            {
<<<<<<< HEAD
                System.out.println("Invalid date. Please use format YYYY-MM-DD.");
=======
                System.out.println("Invalid date. Make sure the date exists in the calendar and use YYYY-MM-DD (e.g., 2025-11-29).");
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
            }
        }
    }

<<<<<<< HEAD
    /**
     * Reads an optional date. Empty input returns null.
     *
     * @param prompt the message displayed to the user
     * @return a LocalDate or null if the user skipped the field
     */
=======
    // Tarih okuma (boş geçilebilir)
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public static LocalDate readOptionalDate(String prompt)
    {
        if (!DATE_GUIDANCE_SHOWN)
        {
            System.out.println("\nDate input guidance:");
<<<<<<< HEAD
            System.out.println("- Please enter dates in the format YYYY-MM-DD.");
            System.out.println("- Leave empty to skip.\n");
=======
            System.out.println("- Please enter dates in the format YYYY-MM-DD (e.g., 2025-11-29).");
            System.out.println("- Logically invalid dates such as 2025-02-30 will be rejected.");
            System.out.println("- Leave the field empty if you do not want to change the date.\n");
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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
<<<<<<< HEAD
                System.out.println("Invalid date. Please use format YYYY-MM-DD.");
=======
                System.out.println("Invalid date. Make sure the date exists in the calendar and use YYYY-MM-DD (e.g., 2025-11-29).");
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
            }
        }
    }

<<<<<<< HEAD
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
=======
    // Email okuma
    public static String readEmail(String prompt)
    {
        System.out.println("\nEmail input guidance:");
        System.out.println("- Please enter your email in the form username@domain.extension");
        System.out.println("  Examples:");
        System.out.println("    ahmet.kaya@gmail.com");
        System.out.println("    veli_123@outlook.com");
        System.out.println("    ayse@itu.edu.tr");
        System.out.println("- Common mistakes:");
        System.out.println("  * Missing '@' or using more than one '@' (e.g., ahmet@@gmail.com).");
        System.out.println("  * Missing domain or extension (e.g., ahmet@, ahmet@gmail).");
        System.out.println("  * Using spaces inside the email (e.g., ah met@gmail.com).");
        System.out.println("- If the system rejects your email, correct the format and try again.\n");
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22

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

<<<<<<< HEAD
    /**
     * Reads an optional email. Empty input returns an empty string.
     *
     * @param prompt the message displayed to the user
     * @return a valid email or an empty string if skipped
     */
=======
    // Opsiyonel email (boş olabilir)
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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

<<<<<<< HEAD
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
=======
            System.out.println("Please enter a valid e-mail address (example: name@example.com).");
        }
    }

    // Telefon numarası okuma (zorunlu)
    public static String readPhone(String prompt)
    {
        // Kullanıcıya telefon formatı ve yaygın hatalar hakkında rehber (sadece ilk sefer)
        if (!PHONE_GUIDANCE_SHOWN)
        {
            System.out.println("\nPhone number input guidance:");
            System.out.println("- Enter a realistic phone number with digits only, optionally starting with '+' and using spaces or dashes.");
            System.out.println("  Examples of accepted formats:");
            System.out.println("    05551234567");
            System.out.println("    5551234567");
            System.out.println("    +905551234567");
            System.out.println("    +90 555 123 45 67");
            System.out.println("- Common mistakes:");
            System.out.println("  * Too few digits or too many digits (we expect about 10–15 digits in total).");
            System.out.println("  * Using letters instead of digits.");
            System.out.println("  * Repeating the same digit many times (e.g., 0000000000).");
            System.out.println("- If the system rejects your phone number, check the length and characters, then try again.\n");
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
            PHONE_GUIDANCE_SHOWN = true;
        }

        while (true)
        {
            String phone = readNonEmptyString(prompt);

            if (isValidPhone(phone))
            {
                return phone;
            }

<<<<<<< HEAD
            System.out.println("Invalid phone number. Please try again.");
        }
    }

    /**
     * Reads an optional phone number. Empty input returns an empty string.
     *
     * @param prompt the message displayed to the user
     * @return a valid phone number or an empty string if skipped
     */
=======
            System.out.println("Invalid phone number. Please follow the guidance above and try again.");
        }
    }

    // Opsiyonel telefon
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public static String readOptionalPhone(String prompt)
    {
        if (!PHONE_GUIDANCE_SHOWN)
        {
            System.out.println("\nPhone number input guidance:");
<<<<<<< HEAD
            System.out.println("- Digits only, optionally + or spaces.\n");
=======
            System.out.println("- Enter a realistic phone number with digits only, optionally starting with '+' and using spaces or dashes.");
            System.out.println("  Examples of accepted formats:");
            System.out.println("    05551234567");
            System.out.println("    5551234567");
            System.out.println("    +905551234567");
            System.out.println("    +90 555 123 45 67");
            System.out.println("- Common mistakes:");
            System.out.println("  * Too few digits or too many digits (we expect about 10–15 digits in total).");
            System.out.println("  * Using letters instead of digits.");
            System.out.println("  * Repeating the same digit many times (e.g., 0000000000).");
            System.out.println("- If the system rejects your phone number, check the length and characters, then try again.\n");
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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

<<<<<<< HEAD
            System.out.println("Invalid phone number. Please try again.");
        }
    }

    /**
     * Reads a yes/no answer from the user. Supports English and Turkish inputs.
     *
     * @param prompt the message displayed to the user
     * @return true for yes/e/evet, false for no/h/hayır
     */
=======
            System.out.println("Invalid phone number. Please follow the guidance above and try again.");
        }
    }

    // Evet/Hayır (y/n) soruları için
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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

<<<<<<< HEAD
            System.out.println("Please answer y / n.");
        }
    }

    /**
     * Reads a role from user input and converts it into a {@link Role} enum value.
     *
     * @param prompt the message displayed to the user
     * @return a valid Role enum constant
     */
=======
            System.out.println("Please answer with y / n.");
        }
    }

    // Role okuma: yanlış girerse tekrar sor
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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
<<<<<<< HEAD
                System.out.println("Invalid role. Please try again.");
=======
                System.out.println("Invalid role. Please enter one of: TESTER, JUNIOR_DEV, SENIOR_DEV, MANAGER.");
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
            }
        }
    }

    // ------------------- PRIVATE HELPERS -------------------

<<<<<<< HEAD
    /**
     * Validates an email using a simple regular expression.
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    private static boolean isValidEmail(String email)
    {
        String regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        return Pattern.matches(regex, email);
    }

<<<<<<< HEAD
    /**
     * Validates a phone number using regex rules and logical checks.
     */
    private static boolean isValidPhone(String phone)
    {
=======
    // Telefon: izin verilen karakterler + gerçekçi uzunluk kontrolü
    private static boolean isValidPhone(String phone)
    {
        // Karakter setini kontrol et (sadece rakam, boşluk, +, -, parantez)
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
        String regex = "^[0-9\\s+\\-()]{5,25}$";
        if (!Pattern.matches(regex, phone))
        {
            return false;
        }

        return isRealisticPhone(phone);
    }

<<<<<<< HEAD
    /**
     * Ensures the phone number has a realistic number of digits.
     */
    private static boolean isRealisticPhone(String phone)
    {
        String digits = phone.replaceAll("[^0-9]", "");

        return digits.length() >= 10 && digits.length() <= 15;
=======
    // Gerçekçi telefon: 10–15 rakam, hepsi aynı rakam olmasın
    private static boolean isRealisticPhone(String phone)
    {
        // Sadece rakamları çıkar
        String digits = phone.replaceAll("[^0-9]", "");

        // Çok kısa veya çok uzun numaraları reddet
        if (digits.length() < 10 || digits.length() > 15)
        {
            return false;
        }

        return true;
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    }
}
