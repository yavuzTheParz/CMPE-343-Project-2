// File: ManagerMenu.java
import java.util.List;

/**
 * This class provides the main menu interface for users with the MANAGER role.
 * It includes user management capabilities (Add, Update, Delete, List Users),
 * statistics viewing, and undo functionality.
 */
public class ManagerMenu
{
    /**
     * Starts the Manager menu loop. Displays options and executes
     * the selected operations until the user chooses to "Logout" (0).
     */
    public static void start()
    {
        while (true)
        {
            System.out.println("\n=== MANAGER MENU ===");
            System.out.println("1) Add User");
            System.out.println("2) Update User");
            System.out.println("3) Delete User");
            System.out.println("4) List Users");
            System.out.println("5) Show Statistics");
            System.out.println("6) Undo last action");
            System.out.println("0) Logout");

            int choice = InputHelper.readInt("Choice: ");

            switch (choice)
            {
                case 1:
                    addUser();
                    break;

                case 2:
                    updateUser();
                    break;

                case 3:
                    deleteUser();
                    break;

                case 4:
                    listUsers();
                    break;

                case 5:
                    ContactStatistics.showStats();
                    break;

                case 6:
                    UndoService.undoLastOperation();
                    break;

                case 0:
                    Session.clear();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    /**
     * Creates a new user in the system. Collects username, password, name,
     * surname, and role. Ensures the username is unique.
     */
    private static void addUser()
    {
        System.out.println("\n--- ADD USER ---");

        String username = InputHelper.readNonEmptyString("Username: ");

        /**
         * Check if a user with the same username already exists
        */
        User existing = UserDAO.getUserByUsername(username);
        if (existing != null)
        {
            System.out.println("A user with this username already exists (ID: " + existing.getUserId() + ").");
            System.out.println("Please choose a different username.");
            return;
        }

        String password = InputHelper.readNonEmptyString("Initial password: ");
        String name = InputHelper.readName("Name: ");
        String surname = InputHelper.readName("Surname: ");

        Role role = InputHelper.readRole("Role");

        boolean ok = UserDAO.insertUser(username, password, name, surname, role);

        if (ok)
        {
            System.out.println("User added successfully.");
        }
        else
        {
            System.out.println("Failed to add user.");
        }
    }

    /**
     * Updates an existing user's details (username, name, surname, role, password).
     * If fields are left empty, the current values are preserved.
     */
    private static void updateUser()
    {
        System.out.println("\n--- UPDATE USER ---");

        int userId = InputHelper.readInt("User ID to update: ");
        User existing = UserDAO.getUserById(userId);

        if (existing == null)
        {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Updating user: " +
                           existing.getUsername() + " (" +
                           existing.getName() + " " + existing.getSurname() + ")");

        /**
         * Read new values; if input is empty, the old value is kept.  
        */
        String newUsername = InputHelper.readString("New username [" + existing.getUsername() + "]: ");
        if (newUsername.isEmpty())
        {
            newUsername = existing.getUsername();
        }

        String newName = InputHelper.readString("New name [" + existing.getName() + "]: ");
        if (newName.isEmpty())
        {
            newName = existing.getName();
        }

        String newSurname = InputHelper.readString("New surname [" + existing.getSurname() + "]: ");
        if (newSurname.isEmpty())
        {
            newSurname = existing.getSurname();
        }

        System.out.println("Current role: " + existing.getRole());
        System.out.println("Leave empty to keep current role.");
        String roleStr = InputHelper.readString("New role (TESTER, JUNIOR_DEV, SENIOR_DEV, MANAGER): ");

        Role newRole;
        if (roleStr.isEmpty())
        {
            newRole = existing.getRole();
        }
        else
        {
            try
            {
                newRole = Role.valueOf(roleStr.toUpperCase());
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Invalid role. Keeping old role.");
                newRole = existing.getRole();
            }
        }

        boolean changePassword = InputHelper.readYesNo("Change password");
        String newPassword = null;

        if (changePassword)
        {
            newPassword = InputHelper.readNonEmptyString("New password: ");
        }

        User updated = UserFactory.createUser(
        existing.getUserId(),
        newUsername,
        existing.getPasswordHash(), 
        /**
        * hash is handled in DAO if necessary
        */
        newName,
        newSurname,
        newRole
        );

        boolean ok = UserDAO.updateUser(updated, changePassword, newPassword);


        if (ok)
        {
            System.out.println("User updated.");
        }
        else
        {
            System.out.println("Failed to update user.");
        }
    }

    /**
     * Deletes a user from the system based on the provided ID.
     * Enforces safeguards:
     * 1. A Manager cannot delete their own account.
     * 2. The system must always retain at least one Manager.
     */
    private static void deleteUser()
    {
        System.out.println("\n--- DELETE USER ---");

        int userId = InputHelper.readInt("User ID to delete: ");
        User existing = UserDAO.getUserById(userId);

        if (existing == null)
        {
            System.out.println("User not found.");
            return;
        }

        User current = Session.getCurrentUser();
        /**
         * A) Manager cannot delete their own account
        */
        if (current != null && current.getUserId() == userId)
        {
            System.out.println("You cannot delete your own account.");
            return;
        }
        /** 
         * B) At least one MANAGER must remain in the system 
        */
        if (existing.getRole() == Role.MANAGER)
        {
            int managerCount = UserDAO.countManagers();
            if (managerCount <= 1)
            {
                System.out.println("You cannot delete the last MANAGER user.");
                return;
            }
        }

        System.out.println("You are about to delete: " +
                           existing.getUsername() + " (" +
                           existing.getName() + " " + existing.getSurname() + ")");
        boolean confirm = InputHelper.readYesNo("Are you sure");

        if (!confirm)
        {
            System.out.println("Delete cancelled.");
            return;
        }

        boolean ok = UserDAO.deleteUser(userId);

        if (ok)
        {
            System.out.println("User deleted.");
        }
        else
        {
            System.out.println("Failed to delete user.");
        }
    }

    /**
     * Retrieves all users from the database and prints them to the console.
     * Displays User ID, username, name, surname, and role.
     */
    private static void listUsers()
    {
        System.out.println("\n--- USER LIST ---");

        List<User> users = UserDAO.getAllUsers();

        if (users.isEmpty())
        {
            System.out.println("No users found.");
            return;
        }

        for (User u : users)
        {
            System.out.println(
                u.getUserId() + " - " +
                u.getUsername() + " | " +
                u.getName() + " " + u.getSurname() +
                " | " + u.getRole()
            );
        }
    }

}