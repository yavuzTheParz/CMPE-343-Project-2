// File: ContactDAO.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Data Access Object (DAO) class for the {@link Contact} entity.
 * <p>
 * Provides methods to query, insert, update and delete contacts in the database.
 * It also integrates with the Undo logging system to record changes for
 * possible rollback operations.
 * </p>
 */
public class ContactDAO
{
    /**
     * Maps the current row of the given {@link ResultSet} to a {@link Contact} object.
     *
     * @param rs result set positioned on a contact row
     * @return a new {@link Contact} instance created from the row data
     * @throws SQLException if a column cannot be read properly
     */
    private static Contact mapRow(ResultSet rs) throws SQLException
    {
        int id = rs.getInt("contact_id");
        String firstName = rs.getString("first_name");
        String middleName = rs.getString("middle_name");
        String lastName = rs.getString("last_name");
        String nickname = rs.getString("nickname");
        String phonePrimary = rs.getString("phone_primary");
        String phoneSecondary = rs.getString("phone_secondary");
        String email = rs.getString("email");
        String linkedinUrl = rs.getString("linkedin_url");
        Date birthDateSql = rs.getDate("birth_date");
        LocalDate birthDate = birthDateSql != null ? birthDateSql.toLocalDate() : null;

        return new Contact(
            id,
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
     * Retrieves all contacts from the database ordered by their ID.
     *
     * @return a list of all contacts, possibly empty but never {@code null}
     */
    public static List<Contact> getAllContacts()
    {
        List<Contact> list = new ArrayList<>();

        String sql = "SELECT * FROM contacts ORDER BY contact_id";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                list.add(mapRow(rs));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return list;
    }
     /**
     * Finds a contact by its ID.
     *
     * @param id the contact ID
     * @return the matching {@link Contact}, or {@code null} if not found
     */
    public static Contact getContactById(int id)
    {
        String sql = "SELECT * FROM contacts WHERE contact_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    return mapRow(rs);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }
     /**
     * Deletes a contact from the database and logs the operation for Undo.
     *
     * @param id the ID of the contact to delete
     * @return {@code true} if at least one row was deleted, otherwise {@code false}
     */
    public static boolean deleteContact(int id)
    {
        // 1) First takes the previous version
        Contact before = getContactById(id);
        if (before == null)
        {
            System.out.println("Contact not found with id: " + id);
            return false;
        }

        String sql = "DELETE FROM contacts WHERE contact_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();

            if (affected > 0)
            {
                // 2) Undo log yaz
                UndoLogDAO.logContactOperation(
                    UndoOperationType.DELETE,
                    before,
                    null
                );
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
     /**
     * Inserts a new contact into the database and writes an Undo log entry.
     *
     * @param contact the contact object that contains the values to insert
     * @return {@code true} if insertion succeeded, otherwise {@code false}
     */
    public static boolean insertContact(Contact contact)
    {
        String sql = "INSERT INTO contacts " +
                     "(first_name, middle_name, last_name, nickname, " +
                     " phone_primary, phone_secondary, email, linkedin_url, birth_date) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1, contact.getFirstName());
            ps.setString(2, contact.getMiddleName());
            ps.setString(3, contact.getLastName());
            ps.setString(4, contact.getNickname());
            ps.setString(5, contact.getPhonePrimary());
            ps.setString(6, contact.getPhoneSecondary());
            ps.setString(7, contact.getEmail());
            ps.setString(8, contact.getLinkedinUrl());

            if (contact.getBirthDate() != null)
            {
                ps.setDate(9, Date.valueOf(contact.getBirthDate()));
            }
            else
            {
                ps.setDate(9, null);
            }

            int affected = ps.executeUpdate();

            if (affected > 0)
            {
                // Takes new ID
                int newId = 0;

                try (ResultSet keys = ps.getGeneratedKeys())
                {
                    if (keys.next())
                    {
                        newId = keys.getInt(1);
                    }
                }

                // Contact object representing the actual record in the DataBase
                Contact inserted = new Contact(
                    newId,
                    contact.getFirstName(),
                    contact.getMiddleName(),
                    contact.getLastName(),
                    contact.getNickname(),
                    contact.getPhonePrimary(),
                    contact.getPhoneSecondary(),
                    contact.getEmail(),
                    contact.getLinkedinUrl(),
                    contact.getBirthDate()
                );

                // Writes undo log (INSERT)
                UndoLogDAO.logContactOperation(
                    UndoOperationType.INSERT,
                    null,
                    inserted
                );

                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
     /**
     * Updates an existing contact record and logs before/after states for Undo.
     *
     * @param contact the updated contact object (must contain a valid ID)
     * @return {@code true} if the update affected at least one row, otherwise {@code false}
     */
    public static boolean updateContact(Contact contact)
    {
        // 1) It takes the previous version before update
        Contact before = getContactById(contact.getContactId());
        if (before == null)
        {
            System.out.println("Contact not found with id: " + contact.getContactId());
            return false;
        }

        String sql = "UPDATE contacts SET " +
                     "first_name = ?, " +
                     "middle_name = ?, " +
                     "last_name = ?, " +
                     "nickname = ?, " +
                     "phone_primary = ?, " +
                     "phone_secondary = ?, " +
                     "email = ?, " +
                     "linkedin_url = ?, " +
                     "birth_date = ? " +
                     "WHERE contact_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, contact.getFirstName());
            ps.setString(2, contact.getMiddleName());
            ps.setString(3, contact.getLastName());
            ps.setString(4, contact.getNickname());
            ps.setString(5, contact.getPhonePrimary());
            ps.setString(6, contact.getPhoneSecondary());
            ps.setString(7, contact.getEmail());
            ps.setString(8, contact.getLinkedinUrl());

            if (contact.getBirthDate() != null)
            {
                ps.setDate(9, Date.valueOf(contact.getBirthDate()));
            }
            else
            {
                ps.setDate(9, null);
            }

            ps.setInt(10, contact.getContactId());

            int affected = ps.executeUpdate();

            if (affected > 0)
            {
                // 2) Write undo log (UPDATE)
                UndoLogDAO.logContactOperation(
                    UndoOperationType.UPDATE,
                    before,
                    contact
                );
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    
     /**
     * Inserts a contact with a manually specified ID.
     * <p>
     * This method is intended only for use by the UndoService and is not part
     * of the normal application flow.
     * </p>
     *
     * @param contact contact object that already has its ID set
     * @return {@code true} if the insert operation succeeded, otherwise {@code false}
     */
    public static boolean insertContactWithId(Contact contact)
    {
        String sql = "INSERT INTO contacts " +
                     "(contact_id, first_name, middle_name, last_name, nickname, " +
                     " phone_primary, phone_secondary, email, linkedin_url, birth_date) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, contact.getContactId());
            ps.setString(2, contact.getFirstName());
            ps.setString(3, contact.getMiddleName());
            ps.setString(4, contact.getLastName());
            ps.setString(5, contact.getNickname());
            ps.setString(6, contact.getPhonePrimary());
            ps.setString(7, contact.getPhoneSecondary());
            ps.setString(8, contact.getEmail());
            ps.setString(9, contact.getLinkedinUrl());

            if (contact.getBirthDate() != null)
            {
                ps.setDate(10, Date.valueOf(contact.getBirthDate()));
            }
            else
            {
                ps.setDate(10, null);
            }

            int affected = ps.executeUpdate();
            return affected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
