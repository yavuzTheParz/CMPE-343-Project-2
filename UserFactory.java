/**
 * Factory class for creating instances of {@link User} subclasses.
 * This class encapsulates the object creation logic based on the user's role.
 */
public class UserFactory
{
    /**
     * Creates and returns a specific User subclass instance based on the provided Role.
     *
     * @param userId       The unique identifier of the user.
     * @param username     The username.
     * @param passwordHash The hashed password.
     * @param name         The first name of the user.
     * @param surname      The last name of the user.
     * @param role         The role determining which User subclass to instantiate.
     * @return A concrete implementation of the User abstract class (e.g., TesterUser, ManagerUser).
     */
    public static User createUser(int userId,
                                  String username,
                                  String passwordHash,
                                  String name,
                                  String surname,
                                  Role role)
    {
        if (role == null)
        {
            // Safety measure: Although role should not be null in practice,
            // we default to TESTER behavior to prevent crashes.
            role = Role.TESTER;
        }

        switch (role)
        {
            case TESTER:
                return new TesterUser(userId, username, passwordHash, name, surname);

            case JUNIOR_DEV:
                return new JuniorDevUser(userId, username, passwordHash, name, surname);

            case SENIOR_DEV:
                return new SeniorDevUser(userId, username, passwordHash, name, surname);

            case MANAGER:
                return new ManagerUser(userId, username, passwordHash, name, surname);

            default:
                return new TesterUser(userId, username, passwordHash, name, surname);
        }
    }
}