// File: UndoLogEntry.java

/**
 * Represents a single undo log record stored in the database.
 * <p>
 * Each entry captures the details of an operation performed on a system entity
 * (such as {@link Contact} or {@link User}), including the old and new states
 * of the entity, the user who triggered the operation, and the type of action
 * (INSERT, UPDATE, DELETE).
 * </p>
 */
public class UndoLogEntry
{
    private int undoId;
    private EntityType entityType;
    private UndoOperationType operationType;
    private int entityId;
    private String oldData;
    private String newData;
    private String createdBy;

    /**
     * Creates a new undo log entry with all required fields.
     *
     * @param undoId         the ID of the undo log record
     * @param entityType     the type of entity affected (e.g., CONTACT, USER)
     * @param operationType  the type of operation performed (INSERT, UPDATE, DELETE)
     * @param entityId       the ID of the affected entity
     * @param oldData        serialized JSON/XML of the previous entity state
     * @param newData        serialized JSON/XML of the new entity state
     * @param createdBy      username of the user who performed the operation
     */
    public UndoLogEntry(int undoId,
                        EntityType entityType,
                        UndoOperationType operationType,
                        int entityId,
                        String oldData,
                        String newData,
                        String createdBy)
    {
        this.undoId = undoId;
        this.entityType = entityType;
        this.operationType = operationType;
        this.entityId = entityId;
        this.oldData = oldData;
        this.newData = newData;
        this.createdBy = createdBy;
    }

    /**
     * @return the unique ID of this undo log entry
     */
    public int getUndoId()
    {
        return undoId;
    }

    /**
     * @return the type of entity affected by the logged operation
     */
    public EntityType getEntityType()
    {
        return entityType;
    }

    /**
     * @return the operation type (INSERT, UPDATE, DELETE)
     */
    public UndoOperationType getOperationType()
    {
        return operationType;
    }

    /**
     * @return the ID of the entity on which the operation was performed
     */
    public int getEntityId()
    {
        return entityId;
    }

    /**
     * @return the serialized previous state of the entity (may be null for INSERT)
     */
    public String getOldData()
    {
        return oldData;
    }

    /**
     * @return the serialized new state of the entity (may be null for DELETE)
     */
    public String getNewData()
    {
        return newData;
    }

    /**
     * @return the username of the user who performed the logged action
     */
    public String getCreatedBy()
    {
        return createdBy;
    }
}
