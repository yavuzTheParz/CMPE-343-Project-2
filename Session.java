// File: Session.java

/**
 * Manages the active user session within the application.
 * <p>
 * This class maintains the currently logged-in {@link User} and provides
 * helper methods for setting, retrieving, and clearing the session.
 * Only one user can be logged in at a time.
 * </p>
 */
public class Session
{
    /** The currently logged-in user, or {@code null} if no session is active. */
    private static User currentUser;

    /**
     * Sets the currently logged-in user.
     *
     * @param user the user who has successfully logged in;
     *             may be {@code null} in rare cases, but normally non-null
     */
    public static void setCurrentUser(User user)
    {
        currentUser = user;
    }

    /**
     * Returns the currently logged-in user.
     *
     * @return the active {@link User}, or {@code null} if no session exists
     */
    public static User getCurrentUser()
    {
        return currentUser;
    }

    /**
     * Clears the active session by removing the current user.
     * <p>
     * This method is typically invoked during a logout operation.
     * </p>
     */
    public static void clear()
    {
        currentUser = null;
    }
}
