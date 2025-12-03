/**
 * Service class responsible for handling "Undo" operations within the application.
 * It retrieves the last logged operation from the database and reverses the action
 * based on the entity type (Contact or User) and operation type (INSERT, DELETE, UPDATE).
 */
public class UndoService
{
    /**
     * Reverses the last performed operation.
     * <p>
     * It fetches the last entry from {@link UndoLogDAO}, determines the entity type,
     * and delegates the undo logic to specific handler methods.
     * If no entry is found or an error occurs, appropriate messages are logged to the console.
     * </p>
     */
    public static void undoLastOperation()
    {
        UndoLogEntry entry = UndoLogDAO.getLastEntryAndDelete();

        if (entry == null)
        {
            System.out.println("Nothing to undo.");
            return;
        }

        try
        {
            if (entry.getEntityType() == EntityType.CONTACT)
            {
                undoContact(entry);
            }
            else if (entry.getEntityType() == EntityType.USER)
            {
                undoUser(entry);
            }
            else
            {
                System.out.println("Unsupported entity type for undo.");
            }
        }
        catch (Exception e)
        {
            System.out.println("An error occurred while trying to undo the last operation.");
            e.printStackTrace();
        }
    }

    // -------- CONTACT UNDO --------

    /**
     * Dispatches the undo logic for Contact entities based on the operation type.
     *
     * @param entry The undo log entry containing details about the operation to reverse.
     */
    private static void undoContact(UndoLogEntry entry)
    {
        UndoOperationType op = entry.getOperationType();

        switch (op)
        {
            case INSERT:
                undoInsertContact(entry);
                break;
            case DELETE:
                undoDeleteContact(entry);
                break;
            case UPDATE:
                undoUpdateContact(entry);
                break;
            default:
                System.out.println("Unknown contact operation type.");
        }
    }

    /**
     * Reverses a Contact INSERT operation.
     * Logic: Deletes the contact that was previously inserted.
     *
     * @param entry The undo log entry.
     */
    private static void undoInsertContact(UndoLogEntry entry)
    {
        int id = entry.getEntityId();
        boolean ok = ContactDAO.deleteContact(id);

        if (ok)
        {
            System.out.println("Undo INSERT contact: contact " + id + " deleted.");
        }
        else
        {
            System.out.println("Failed to undo INSERT contact.");
        }
    }

    /**
     * Reverses a Contact DELETE operation.
     * Logic: Re-inserts the contact using its original ID and data.
     *
     * @param entry The undo log entry containing the serialized old data.
     */
    private static void undoDeleteContact(UndoLogEntry entry)
    {
        Contact oldContact = ContactSerializer.deserialize(entry.getOldData());
        if (oldContact == null)
        {
            System.out.println("No old contact data to restore.");
            return;
        }

        boolean ok = ContactDAO.insertContactWithId(oldContact);

        if (ok)
        {
            System.out.println("Undo DELETE contact: contact " + oldContact.getContactId() + " restored.");
        }
        else
        {
            System.out.println("Failed to undo DELETE contact.");
        }
    }

    /**
     * Reverses a Contact UPDATE operation.
     * Logic: Updates the contact record back to its previous state.
     *
     * @param entry The undo log entry containing the serialized pre-update data.
     */
    private static void undoUpdateContact(UndoLogEntry entry)
    {
        Contact oldContact = ContactSerializer.deserialize(entry.getOldData());
        if (oldContact == null)
        {
            System.out.println("No old contact data to restore.");
            return;
        }

        boolean ok = ContactDAO.updateContact(oldContact);

        if (ok)
        {
            System.out.println("Undo UPDATE contact: contact " + oldContact.getContactId() + " reverted.");
        }
        else
        {
            System.out.println("Failed to undo UPDATE contact.");
        }
    }

    // -------- USER UNDO --------

    /**
     * Dispatches the undo logic for User entities based on the operation type.
     *
     * @param entry The undo log entry containing details about the operation to reverse.
     */
    private static void undoUser(UndoLogEntry entry)
    {
        UndoOperationType op = entry.getOperationType();

        switch (op)
        {
            case INSERT:
                undoInsertUser(entry);
                break;
            case DELETE:
                undoDeleteUser(entry);
                break;
            case UPDATE:
                undoUpdateUser(entry);
                break;
            default:
                System.out.println("Unknown user operation type.");
        }
    }

    /**
     * Reverses a User INSERT operation.
     * Logic: Deletes the user that was inserted, without creating a new log entry.
     *
     * @param entry The undo log entry.
     */
    private static void undoInsertUser(UndoLogEntry entry)
    {
        int id = entry.getEntityId();
        boolean ok = UserDAO.deleteUserWithoutLogging(id);

        if (ok)
        {
            System.out.println("Undo INSERT user: user " + id + " deleted.");
        }
        else
        {
            System.out.println("Failed to undo INSERT user.");
        }
    }

    /**
     * Reverses a User DELETE operation.
     * Logic: Re-inserts the user with the original ID and data.
     *
     * @param entry The undo log entry containing the serialized old user data.
     */
    private static void undoDeleteUser(UndoLogEntry entry)
    {
        User oldUser = UserSerializer.deserialize(entry.getOldData());
        if (oldUser == null)
        {
            System.out.println("No old user data to restore.");
            return;
        }

        boolean ok = UserDAO.insertUserWithId(oldUser);

        if (ok)
        {
            System.out.println("Undo DELETE user: user " + oldUser.getUserId() + " restored.");
        }
        else
        {
            System.out.println("Failed to undo DELETE user.");
        }
    }

    /**
     * Reverses a User UPDATE operation.
     * Logic: Updates the user record back to its previous state using raw update methods.
     *
     * @param entry The undo log entry containing the serialized pre-update user data.
     */
    private static void undoUpdateUser(UndoLogEntry entry)
    {
        User oldUser = UserSerializer.deserialize(entry.getOldData());
        if (oldUser == null)
        {
            System.out.println("No old user data to restore.");
            return;
        }

        boolean ok = UserDAO.updateUserRaw(oldUser);

        if (ok)
        {
            System.out.println("Undo UPDATE user: user " + oldUser.getUserId() + " reverted.");
        }
        else
        {
            System.out.println("Failed to undo UPDATE user.");
        }
    }
}