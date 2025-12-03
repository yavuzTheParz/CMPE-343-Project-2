// File: UserFactory.java
public class UserFactory
{
    public static User createUser(int userId,
                                  String username,
                                  String passwordHash,
                                  String name,
                                  String surname,
                                  Role role)
    {
        if (role == null)
        {
            // Safety: default olarak TESTER gibi davranabilir ama pratikte null gelmemeli.
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
