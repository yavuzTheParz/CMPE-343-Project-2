/**
 * Represents the type of an undoable operation performed on an entity.
 * <p>
 * Each value corresponds to an action logged by the Undo system,
 * allowing the operation to be reversed when needed.
 * </p>
 */
public enum UndoOperationType
{
    /**
     * A new entity was created and inserted into the system.
     */
    INSERT,

    /**
     * An existing entity was modified.
     */
    UPDATE,

    /**
     * An existing entity was removed from the system.
     */
    DELETE
}
