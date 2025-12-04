// File: ContactSerializer.java
import java.time.LocalDate;

/**
 * Utility class responsible for converting {@link Contact} objects
 * to serialized string formats and reconstructing them back into Contact
 * instances. This class provides simple pipe-delimited serialization.
 */
public class ContactSerializer
{
    /**
     * Serializes a Contact object into a pipe-separated string format.
     * Null fields are converted into empty values to preserve structure.
     *
     * Format:
     * contactId|firstName|middleName|lastName|nickname|phonePrimary|
     * phoneSecondary|email|linkedinUrl|birthDate
     *
     * @param c the Contact object to serialize
     * @return a pipe-delimited string representation of the contact,
     *         or null if the input is null
     */
    public static String serialize(Contact c)
    {
        if (c == null)
        {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(c.getContactId()).append("|");
        sb.append(nullToEmpty(c.getFirstName())).append("|");
        sb.append(nullToEmpty(c.getMiddleName())).append("|");
        sb.append(nullToEmpty(c.getLastName())).append("|");
        sb.append(nullToEmpty(c.getNickname())).append("|");
        sb.append(nullToEmpty(c.getPhonePrimary())).append("|");
        sb.append(nullToEmpty(c.getPhoneSecondary())).append("|");
        sb.append(nullToEmpty(c.getEmail())).append("|");
        sb.append(nullToEmpty(c.getLinkedinUrl())).append("|");

        if (c.getBirthDate() != null)
        {
            sb.append(c.getBirthDate().toString());
        }

        return sb.toString();
    }

    /**
     * Deserializes a pipe-separated string back into a Contact object.
     * Empty values are interpreted as null where appropriate.
     *
     * @param str the serialized contact string
     * @return a reconstructed Contact object, or null if the input is null/empty
     */
    public static Contact deserialize(String str)
    {
        if (str == null || str.isEmpty())
        {
            return null;
        }

        String[] parts = str.split("\\|", -1); // keep empty values

        int idx = 0;
        int contactId = Integer.parseInt(parts[idx++]);
        String firstName = emptyToNull(parts[idx++]);
        String middleName = emptyToNull(parts[idx++]);
        String lastName = emptyToNull(parts[idx++]);
        String nickname = emptyToNull(parts[idx++]);
        String phonePrimary = emptyToNull(parts[idx++]);
        String phoneSecondary = emptyToNull(parts[idx++]);
        String email = emptyToNull(parts[idx++]);
        String linkedinUrl = emptyToNull(parts[idx++]);

        LocalDate birthDate = null;
        if (idx < parts.length && !parts[idx].isEmpty())
        {
            birthDate = LocalDate.parse(parts[idx]);
        }

        return new Contact(
            contactId,
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
    }

    /**
     * Converts a null string into an empty string.
     * Used to maintain consistent serialization formatting.
     *
     * @param s the input string
     * @return an empty string if input is null; otherwise the same string
     */
    private static String nullToEmpty(String s)
    {
        return (s == null) ? "" : s;
    }

    /**
     * Converts an empty string into null.
     * Used during deserialization to restore original null values.
     *
     * @param s the input string
     * @return null if the string is empty or null; otherwise the same string
     */
    private static String emptyToNull(String s)
    {
        return (s == null || s.isEmpty()) ? null : s;
    }
}
