// File: ContactDAO.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO
{
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

    public static boolean deleteContact(int id)
    {
        String sql = "DELETE FROM contacts WHERE contact_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();
            return affected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insertContact(Contact contact)
    {
        String sql = "INSERT INTO contacts " +
                     "(first_name, middle_name, last_name, nickname, " +
                     " phone_primary, phone_secondary, email, linkedin_url, birth_date) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

            int affected = ps.executeUpdate();
            return affected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateContact(Contact contact)
    {
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
            return affected > 0;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
