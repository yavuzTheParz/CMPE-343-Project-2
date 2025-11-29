// File: UndoService.java
public class UndoService
{
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
