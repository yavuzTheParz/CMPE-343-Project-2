// File: ContactSorter.java
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Utility class providing sorting operations for lists of {@link Contact}.
 * Sorting can be performed by first name, last name, or birth date,
 * in either ascending or descending order.
 */
public class ContactSorter
{
    /**
     * Defines the available fields by which contacts can be sorted.
     */
    public enum SortField
    {
        /** Sort contacts by their first name (case-insensitive). */
        FIRST_NAME,

        /** Sort contacts by their last name (case-insensitive). */
        LAST_NAME,

        /** Sort contacts by their birth date (oldest to newest or reverse). */
        BIRTH_DATE
    }

    /**
     * Sorts the provided list of contacts using the specified field and order.
     * Sorting is performed in-place — the original list is modified.
     *
     * <p><b>Case Handling:</b> For textual fields (first name, last name),
     * comparison is done case-insensitively. Null values are treated as empty strings.
     *
     * <p><b>Birth Date:</b> Birth dates are sorted chronologically. Null dates appear last
     * when sorting in ascending order (and first when descending).
     *
     * @param contacts  the list of contacts to sort; must not be null
     * @param field     the field by which to sort (first name, last name, birth date)
     * @param ascending true for ascending order, false for descending order
     */
    public static void sort(List<Contact> contacts, SortField field, boolean ascending)
    {
        Comparator<Contact> comparator;

        switch (field)
        {
            case FIRST_NAME:
                comparator = Comparator.comparing(
                    c -> c.getFirstName() != null ? c.getFirstName().toLowerCase() : ""
                );
                break;

            case LAST_NAME:
                comparator = Comparator.comparing(
                    c -> c.getLastName() != null ? c.getLastName().toLowerCase() : ""
                );
                break;

            case BIRTH_DATE:
                comparator = Comparator.comparing(
                    c -> c.getBirthDate(),
                    Comparator.nullsLast(Comparator.naturalOrder())
                );
                break;

            default:
                return;
        }

        if (!ascending)
        {
            comparator = comparator.reversed();
        }

        Collections.sort(contacts, comparator);
    }
}
