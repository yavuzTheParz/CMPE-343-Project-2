// File: InputHelper.java
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHelper
{
    private static final Scanner SCANNER = new Scanner(System.in);

    // Rehber metinleri sadece ilk seferde göstermek için
    private static boolean PHONE_GUIDANCE_SHOWN = false;
    private static boolean DATE_GUIDANCE_SHOWN  = false;

    // Basit string okuma
    public static String readString(String prompt)
    {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    // Boş olmayan string (zorunlu alanlar için)
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

    // Sadece harf (ve boşluk) içeren isim alanları (Türkçe karakterler dahil)
    public static String readName(String prompt)
    {
        while (true)
        {
            String value = readNonEmptyString(prompt);

            // Türkçe karakterleri de içeren basit bir pattern
            if (value.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ\\s'-]+"))
            {
                return value;
            }

            System.out.println("Please enter a valid name (letters only).");
        }
    }

    // Integer okuma
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

    // Belirli aralıkta integer
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

    // Tarih okuma (zorunlu)
    public static LocalDate readDate(String prompt)
    {
        // Kullanıcıya tarih formatı ve mantıksız tarihler için açıklama
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
                // LocalDate.parse zaten 30 Şubat, 31 Kasım gibi hatalı tarihleri de reddeder
                return LocalDate.parse(line);
            }
            catch (DateTimeParseException e)
            {
                System.out.println("Invalid date. Make sure the date exists in the calendar and use YYYY-MM-DD (e.g., 2025-11-29).");
            }
        }
    }

    // Tarih okuma (boş geçilebilir)
    public static LocalDate readOptionalDate(String prompt)
    {
        if (!DATE_GUIDANCE_SHOWN)
        {
            System.out.println("\nDate input guidance:");
            System.out.println("- Please enter dates in the format YYYY-MM-DD (e.g., 2025-11-29).");
            System.out.println("- Logically invalid dates such as 2025-02-30 will be rejected.");
            System.out.println("- Leave the field empty if you do not want to change the date.\n");
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
                System.out.println("Invalid date. Make sure the date exists in the calendar and use YYYY-MM-DD (e.g., 2025-11-29).");
            }
        }
    }

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

    // Opsiyonel email (boş olabilir)
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
            PHONE_GUIDANCE_SHOWN = true;
        }

        while (true)
        {
            String phone = readNonEmptyString(prompt);

            if (isValidPhone(phone))
            {
                return phone;
            }

            System.out.println("Invalid phone number. Please follow the guidance above and try again.");
        }
    }

    // Opsiyonel telefon
    public static String readOptionalPhone(String prompt)
    {
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

            System.out.println("Invalid phone number. Please follow the guidance above and try again.");
        }
    }

    // Evet/Hayır (y/n) soruları için
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

            System.out.println("Please answer with y / n.");
        }
    }

    // Role okuma: yanlış girerse tekrar sor
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
                System.out.println("Invalid role. Please enter one of: TESTER, JUNIOR_DEV, SENIOR_DEV, MANAGER.");
            }
        }
    }

    // ------------------- PRIVATE HELPERS -------------------

    private static boolean isValidEmail(String email)
    {
        String regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        return Pattern.matches(regex, email);
    }

    // Telefon: izin verilen karakterler + gerçekçi uzunluk kontrolü
    private static boolean isValidPhone(String phone)
    {
        // Karakter setini kontrol et (sadece rakam, boşluk, +, -, parantez)
        String regex = "^[0-9\\s+\\-()]{5,25}$";
        if (!Pattern.matches(regex, phone))
        {
            return false;
        }

        return isRealisticPhone(phone);
    }

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
    }
}
