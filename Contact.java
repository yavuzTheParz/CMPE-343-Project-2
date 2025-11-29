// File: Contact.java
import java.time.LocalDate;

public class Contact
{
    private int contactId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickname;
    private String phonePrimary;
    private String phoneSecondary;
    private String email;
    private String linkedinUrl;
    private LocalDate birthDate;

    public Contact(int contactId, String firstName, String middleName, String lastName,
                   String nickname, String phonePrimary, String phoneSecondary,
                   String email, String linkedinUrl, LocalDate birthDate)
    {
        this.contactId = contactId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.phonePrimary = phonePrimary;
        this.phoneSecondary = phoneSecondary;
        this.email = email;
        this.linkedinUrl = linkedinUrl;
        this.birthDate = birthDate;
    }

    public int getContactId()
    {
        return contactId;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getNickname()
    {
        return nickname;
    }

    public String getPhonePrimary()
    {
        return phonePrimary;
    }

    public String getPhoneSecondary()
    {
        return phoneSecondary;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLinkedinUrl()
    {
        return linkedinUrl;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }
}
