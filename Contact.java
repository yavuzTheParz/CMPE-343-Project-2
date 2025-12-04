// File: Contact.java
import java.time.LocalDate;

<<<<<<< HEAD
/**
 * Represents a single contact entry in the system. This class stores 
 * personal details such as name, nickname, phone numbers, email, 
 * LinkedIn profile URL, and birth date. It acts as a data container 
 * without business logic.
 */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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

<<<<<<< HEAD
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
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
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

<<<<<<< HEAD
    /**
     * @return the unique contact ID
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public int getContactId()
    {
        return contactId;
    }

<<<<<<< HEAD
    /**
     * @return the first name of the contact
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public String getFirstName()
    {
        return firstName;
    }

<<<<<<< HEAD
    /**
     * @return the middle name of the contact
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public String getMiddleName()
    {
        return middleName;
    }

<<<<<<< HEAD
    /**
     * @return the last name of the contact
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public String getLastName()
    {
        return lastName;
    }

<<<<<<< HEAD
    /**
     * @return the contact's nickname
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public String getNickname()
    {
        return nickname;
    }

<<<<<<< HEAD
    /**
     * @return the primary phone number
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public String getPhonePrimary()
    {
        return phonePrimary;
    }

<<<<<<< HEAD
    /**
     * @return the secondary phone number
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public String getPhoneSecondary()
    {
        return phoneSecondary;
    }

<<<<<<< HEAD
    /**
     * @return the email address
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public String getEmail()
    {
        return email;
    }

<<<<<<< HEAD
    /**
     * @return the LinkedIn profile URL
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public String getLinkedinUrl()
    {
        return linkedinUrl;
    }

<<<<<<< HEAD
    /**
     * @return the contact's birth date
     */
=======
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public LocalDate getBirthDate()
    {
        return birthDate;
    }
}
