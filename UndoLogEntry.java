// File: UndoLogEntry.java
public class UndoLogEntry
{
    private int undoId;
    private EntityType entityType;
    private UndoOperationType operationType;
    private int entityId;
    private String oldData;
    private String newData;
    private String createdBy;

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

    public int getUndoId()
    {
        return undoId;
    }

    public EntityType getEntityType()
    {
        return entityType;
    }

    public UndoOperationType getOperationType()
    {
        return operationType;
    }

    public int getEntityId()
    {
        return entityId;
    }

    public String getOldData()
    {
        return oldData;
    }

    public String getNewData()
    {
        return newData;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }
}