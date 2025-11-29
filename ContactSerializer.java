// File: ContactSerializer.java
import java.time.LocalDate;

public class ContactSerializer
{
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

    public static Contact deserialize(String str)
    {
        if (str == null || str.isEmpty())
        {
            return null;
        }

        String[] parts = str.split("\\|", -1); // empty'leri de koru

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

    private static String nullToEmpty(String s)
    {
        return (s == null) ? "" : s;
    }

    private static String emptyToNull(String s)
    {
        return (s == null || s.isEmpty()) ? null : s;
    }
}
