// File: Contact.java
import java.time.LocalDate;

/**
 * Represents a single contact entry in the system. This class stores 
 * personal details such as name, nickname, phone numbers, email, 
 * LinkedIn profile URL, and birth date. It acts as a data container 
 * without business logic.
 */
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

    /**
     * Constructs a new Contact object with all personal information fields.
     *
     * @param contactId     unique identifier assigned to the contact
     * @param firstName     the contact's first name
     * @param middleName    the contact's middle name (may be null or empty)
     * @param lastName      the contact's last name
     * @param nickname      an optional nickname for the contact
     * @param phonePrimary  the main phone number
     * @param phoneSecondary an alternate phone number (optional)
     * @param email         the contact's email address
     * @param linkedinUrl   a link to the contact's LinkedIn profile
     * @param birthDate     the contact's date of birth
     */
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

    /**
     * @return the unique contact ID
     */
    public int getContactId()
    {
        return contactId;
    }

    /**
     * @return the first name of the contact
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @return the middle name of the contact
     */
    public String getMiddleName()
    {
        return middleName;
    }

    /**
     * @return the last name of the contact
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @return the contact's nickname
     */
    public String getNickname()
    {
        return nickname;
    }

    /**
     * @return the primary phone number
     */
    public String getPhonePrimary()
    {
        return phonePrimary;
    }

    /**
     * @return the secondary phone number
     */
    public String getPhoneSecondary()
    {
        return phoneSecondary;
    }

    /**
     * @return the email address
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @return the LinkedIn profile URL
     */
    public String getLinkedinUrl()
    {
        return linkedinUrl;
    }

    /**
     * @return the contact's birth date
     */
    public LocalDate getBirthDate()
    {
        return birthDate;
    }
}
