// File: UndoLogDAO.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UndoLogDAO
{
    // ------- CONTACT LOGGING -------

    public static void logContactOperation(UndoOperationType opType,
                                           Contact oldContact,
                                           Contact newContact)
    {
        int entityId = 0;

        if (opType == UndoOperationType.INSERT && newContact != null)
        {
            entityId = newContact.getContactId();
        }
        else if (oldContact != null)
        {
            entityId = oldContact.getContactId();
        }
        else if (newContact != null)
        {
            entityId = newContact.getContactId();
        }

        String oldData = ContactSerializer.serialize(oldContact);
        String newData = ContactSerializer.serialize(newContact);

        String createdBy = null;
        User current = Session.getCurrentUser();
        if (current != null)
        {
            createdBy = current.getUsername();
        }

        String sql = "INSERT INTO undo_log " +
                     "(entity_type, operation_type, entity_id, old_data, new_data, created_by) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, EntityType.CONTACT.name());
            ps.setString(2, opType.name());
            ps.setInt(3, entityId);
            ps.setString(4, oldData);
            ps.setString(5, newData);
            ps.setString(6, createdBy);

            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // ------- USER LOGGING -------

    public static void logUserOperation(UndoOperationType opType,
                                        User oldUser,
                                        User newUser)
    {
        int entityId = 0;

        if (opType == UndoOperationType.INSERT && newUser != null)
        {
            entityId = newUser.getUserId();
        }
        else if (oldUser != null)
        {
            entityId = oldUser.getUserId();
        }
        else if (newUser != null)
        {
            entityId = newUser.getUserId();
        }

        String oldData = UserSerializer.serialize(oldUser);
        String newData = UserSerializer.serialize(newUser);

        String createdBy = null;
        User current = Session.getCurrentUser();
        if (current != null)
        {
            createdBy = current.getUsername();
        }

        String sql = "INSERT INTO undo_log " +
                     "(entity_type, operation_type, entity_id, old_data, new_data, created_by) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, EntityType.USER.name());
            ps.setString(2, opType.name());
            ps.setInt(3, entityId);
            ps.setString(4, oldData);
            ps.setString(5, newData);
            ps.setString(6, createdBy);

            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    // ------- LAST ENTRY + DELETE -------

    public static UndoLogEntry getLastEntryAndDelete()
    {
        String selectSql = "SELECT undo_id, entity_type, operation_type, entity_id, old_data, new_data, created_by " +
                           "FROM undo_log ORDER BY undo_id DESC LIMIT 1";

        try (Connection conn = Database.getConnection();
             PreparedStatement psSelect = conn.prepareStatement(selectSql);
             ResultSet rs = psSelect.executeQuery())
        {
            if (!rs.next())
            {
                return null;
            }

            int undoId = rs.getInt("undo_id");
            String entityTypeStr = rs.getString("entity_type");
            String opTypeStr = rs.getString("operation_type");
            int entityId = rs.getInt("entity_id");
            String oldData = rs.getString("old_data");
            String newData = rs.getString("new_data");
            String createdBy = rs.getString("created_by");

            EntityType entityType = EntityType.valueOf(entityTypeStr);
            UndoOperationType opType = UndoOperationType.valueOf(opTypeStr);

            // Önce log kaydını sil
            String deleteSql = "DELETE FROM undo_log WHERE undo_id = ?";

            try (PreparedStatement psDelete = conn.prepareStatement(deleteSql))
            {
                psDelete.setInt(1, undoId);
                psDelete.executeUpdate();
            }

            return new UndoLogEntry(
                undoId,
                entityType,
                opType,
                entityId,
                oldData,
                newData,
                createdBy
            );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
