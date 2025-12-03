// File: ContactSearch.java
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * Utility class providing various search operations over lists of {@link Contact}.
 * All search operations are case-insensitive and return a new list of matching contacts.
 */
public class ContactSearch
{
    // ---------------- SINGLE-FIELD SEARCHES ----------------

    /**
     * Searches contacts by checking whether their primary phone number contains
     * the given substring (case-insensitive).
     *
     * @param all             the list of all contacts to search
     * @param phoneSubstring  the substring to look for inside the primary phone number
     * @return a list of contacts whose primary phone number contains the substring;
     *         an empty list if the substring is null or empty
     */
    public static List<Contact> searchByPhone(List<Contact> all, String phoneSubstring)
    {
        List<Contact> result = new ArrayList<>();

        if (phoneSubstring == null || phoneSubstring.isEmpty())
        {
            return result;
        }

        String needle = phoneSubstring.toLowerCase();

        for (Contact c : all)
        {
            String phone = c.getPhonePrimary();
            if (phone != null && phone.toLowerCase().contains(needle))
            {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Searches contacts by checking whether their email address contains
     * the given substring (case-insensitive).
     *
     * @param all             the list of all contacts to search
     * @param emailSubstring  the substring to look for inside the email
     * @return a list of matching contacts; empty list if substring is null or empty
     */
    public static List<Contact> searchByEmail(List<Contact> all, String emailSubstring)
    {
        List<Contact> result = new ArrayList<>();

        if (emailSubstring == null || emailSubstring.isEmpty())
        {
            return result;
        }

        String needle = emailSubstring.toLowerCase();

        for (Contact c : all)
        {
            String email = c.getEmail();
            if (email != null && email.toLowerCase().contains(needle))
            {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Searches contacts by checking whether their nickname contains
     * the given substring (case-insensitive).
     *
     * @param all                the list of all contacts to search
     * @param nicknameSubstring  the substring to search inside the nickname
     * @return a list of matching contacts; empty list if substring is null or empty
     */
    public static List<Contact> searchByNickname(List<Contact> all, String nicknameSubstring)
    {
        List<Contact> result = new ArrayList<>();

        if (nicknameSubstring == null || nicknameSubstring.isEmpty())
        {
            return result;
        }

        String needle = nicknameSubstring.toLowerCase();

        for (Contact c : all)
        {
            String nick = c.getNickname();
            if (nick != null && nick.toLowerCase().contains(needle))
            {
                result.add(c);
            }
        }

        return result;
    }

    // ---------------- MULTI-FIELD SEARCHES ----------------

    /**
     * Searches for contacts whose primary phone number contains the given substring
     * AND whose email contains the given email substring.
     * Both conditions must be satisfied.
     *
     * @param all             the list of all contacts to search
     * @param phoneSubstring  substring to search inside the primary phone number
     * @param emailSubstring  substring to search inside the email
     * @return a list of matching contacts; empty list if either substring is null or empty
     */
    public static List<Contact> searchByPhoneAndEmail(List<Contact> all,
                                                      String phoneSubstring,
                                                      String emailSubstring)
    {
        List<Contact> result = new ArrayList<>();

        if (phoneSubstring == null || phoneSubstring.isEmpty())
        {
            return result;
        }
        if (emailSubstring == null || emailSubstring.isEmpty())
        {
            return result;
        }

        String phoneNeedle = phoneSubstring.toLowerCase();
        String emailNeedle = emailSubstring.toLowerCase();

        for (Contact c : all)
        {
            String phone = c.getPhonePrimary();
            String email = c.getEmail();

            boolean phoneMatches = (phone != null && phone.toLowerCase().contains(phoneNeedle));
            boolean emailMatches = (email != null && email.toLowerCase().contains(emailNeedle));

            if (phoneMatches && emailMatches)
            {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Searches for contacts whose nickname contains the given substring
     * AND whose email contains the given email substring.
     * Both conditions must be satisfied.
     *
     * @param all            the list of all contacts to search
     * @param nickSubstring  substring to search inside nickname
     * @param emailSubstring substring to search inside email
     * @return list of matching contacts; empty if any input is null/empty
     */
    public static List<Contact> searchByNicknameAndEmail(List<Contact> all,
                                                         String nickSubstring,
                                                         String emailSubstring)
    {
        List<Contact> result = new ArrayList<>();

        if (nickSubstring == null || nickSubstring.isEmpty())
        {
            return result;
        }
        if (emailSubstring == null || emailSubstring.isEmpty())
        {
            return result;
        }

        String nickNeedle = nickSubstring.toLowerCase();
        String emailNeedle = emailSubstring.toLowerCase();

        for (Contact c : all)
        {
            String nick = c.getNickname();
            String email = c.getEmail();

            boolean nickMatches = (nick != null && nick.toLowerCase().contains(nickNeedle));
            boolean emailMatches = (email != null && email.toLowerCase().contains(emailNeedle));

            if (nickMatches && emailMatches)
            {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Searches for contacts whose first name matches the given name exactly (case-insensitive)
     * AND whose birth month equals the specified month value (1–12).
     *
     * @param all            the list of all contacts
     * @param firstNameExact the exact first name to match (case-insensitive)
     * @param birthMonth     month number (1–12)
     * @return a list of contacts satisfying both conditions; empty list if inputs are invalid
     */
    public static List<Contact> searchByFirstNameAndBirthMonth(List<Contact> all,
                                                               String firstNameExact,
                                                               int birthMonth)
    {
        List<Contact> result = new ArrayList<>();

        if (firstNameExact == null || firstNameExact.isEmpty())
        {
            return result;
        }
        if (birthMonth < 1 || birthMonth > 12)
        {
            return result;
        }

        String nameTarget = firstNameExact.toLowerCase();

        for (Contact c : all)
        {
            String firstName = c.getFirstName();
            LocalDate dob = c.getBirthDate();

            boolean nameMatches = (firstName != null &&
                                   firstName.toLowerCase().equals(nameTarget));
            boolean monthMatches = (dob != null &&
                                    dob.getMonthValue() == birthMonth);

            if (nameMatches && monthMatches)
            {
                result.add(c);
            }
        }

        return result;
    }

    // ---------------- LEGACY / GENERAL SEARCHES ----------------

    /**
     * Searches contacts by substring matching on their first name (case-insensitive).
     *
     * @param all                 the list of contacts
     * @param firstNameSubstring  substring to search inside first name
     * @return a list of matching contacts; empty list if substring is invalid
     */
    public static List<Contact> searchByFirstName(List<Contact> all, String firstNameSubstring)
    {
        List<Contact> result = new ArrayList<>();

        if (firstNameSubstring == null || firstNameSubstring.isEmpty())
        {
            return result;
        }

        String needle = firstNameSubstring.toLowerCase();

        for (Contact c : all)
        {
            String firstName = c.getFirstName();
            if (firstName != null && firstName.toLowerCase().contains(needle))
            {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Searches contacts by substring matching on their last name (case-insensitive).
     *
     * @param all               the list of contacts
     * @param lastNameSubstring substring to search inside last name
     * @return list of matching contacts; empty if substring is invalid
     */
    public static List<Contact> searchByLastName(List<Contact> all, String lastNameSubstring)
    {
        List<Contact> result = new ArrayList<>();

        if (lastNameSubstring == null || lastNameSubstring.isEmpty())
        {
            return result;
        }

        String needle = lastNameSubstring.toLowerCase();

        for (Contact c : all)
        {
            String lastName = c.getLastName();
            if (lastName != null && lastName.toLowerCase().contains(needle))
            {
                result.add(c);
            }
        }

        return result;
    }

    /**
     * Searches contacts by checking whether the given substring matches the first name,
     * last name, or nickname (case-insensitive). At least one field must match.
     *
     * @param all       the list of contacts
     * @param substring the substring to search in multiple text fields
     * @return a list of contacts where first name, last name, or nickname contains the substring;
     *         empty list if substring is invalid
     */
    public static List<Contact> searchByNameOrNickname(List<Contact> all, String substring)
    {
        List<Contact> result = new ArrayList<>();

        if (substring == null || substring.isEmpty())
        {
            return result;
        }

        String needle = substring.toLowerCase();

        for (Contact c : all)
        {
            String firstName = c.getFirstName();
            String lastName = c.getLastName();
            String nick = c.getNickname();

            boolean match = false;

            if (firstName != null && firstName.toLowerCase().contains(needle))
            {
                match = true;
            }
            else if (lastName != null && lastName.toLowerCase().contains(needle))
            {
                match = true;
            }
            else if (nick != null && nick.toLowerCase().contains(needle))
            {
                match = true;
            }

            if (match)
            {
                result.add(c);
            }
        }

        return result;
    }
}
