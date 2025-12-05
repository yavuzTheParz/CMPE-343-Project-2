// File: ManagerMenu.java
import java.util.List;

/**
 * This class provides the main menu interface for users with the MANAGER role.
 * It includes user management capabilities (Add, Update, Delete, List Users),
 * statistics viewing, and undo functionality.
 */
public class ManagerMenu
{

    private static final String RESET  = "\u001B[0m";
    private static final String GOLD   = "\u001B[38;2;255;215;0m";
    private static final String GREEN  = "\u001B[38;2;0;200;120m";
    private static final String CYAN   = "\u001B[38;2;0;255;255m";
    private static final String RED    = "\u001B[38;2;255;80;80m";
    private static final String WHITE  = "\u001B[38;2;255;255;255m";
    private static final String BOLD   = "\u001B[1m";



    /**
     * Starts the Manager menu loop. Displays options and executes
     * the selected operations until the user chooses to "Logout" (0).
     */
    public static void start()
    {
        while (true)
        {
            System.out.println();

            // Başlık kutusu
            String title = "👑📊  MANAGER MENU";
            int len = title.length();

            String border = WHITE + "        ┌" + "─".repeat(len) + "┐" + RESET;
            String middle = WHITE + "        │" + RESET + GOLD + BOLD + title + RESET + WHITE + "│" + RESET;
            String bottom = WHITE + "        └" + "─".repeat(len) + "┘" + RESET;

            System.out.println(border);
            System.out.println(middle);
            System.out.println(bottom);

            // Menü kutusu
            System.out.println(WHITE + "┌──────────────────────────────────┐" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "1) " + RESET + "Add User                      " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "2) " + RESET + "Update User                   " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "3) " + RESET + "Delete User                   " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "4) " + RESET + "List Users                    " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "5) " + RESET + "Show Statistics               " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "6) " + RESET + "Undo last action              " + WHITE + "│" + RESET);
            System.out.println(WHITE + "│ " + CYAN + "0) " + RESET + "Logout                        " + WHITE + "│" + RESET);
            System.out.println(WHITE + "└──────────────────────────────────┘" + RESET);

            int choice = InputHelper.readInt(GREEN + "Choice: " + RESET);

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
                    asciiAnimator.playClosingAnimation();
                    System.out.println(GREEN + "Logged out." + RESET);
                    return;

                default:
                    System.out.println(RED + "Invalid option." + RESET);
                    InputHelper.waitForEnter();

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
            InputHelper.waitForEnter();
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
        InputHelper.waitForEnter();

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
            InputHelper.waitForEnter();
            return;
        }

        System.out.println("Current user:");
        printUsersTable(List.of(existing), "--- CURRENT USER ---");

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
            existing.getPasswordHash(), // hash DAO'da gerekirse güncelleniyor
            newName,
            newSurname,
            newRole
        );

        boolean ok = UserDAO.updateUser(updated, changePassword, newPassword);

        if (ok)
        {
            System.out.println("User updated.");

            User refreshed = UserDAO.getUserById(existing.getUserId());
            if (refreshed != null)
            {
                printUsersTable(List.of(refreshed), "--- UPDATED USER ---");
            }
        }
        else
        {
            System.out.println("Failed to update user.");
        }

        InputHelper.waitForEnter();
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
            InputHelper.waitForEnter();
            return;
        }

        User current = Session.getCurrentUser();

        // A) Manager cannot delete their own account
        if (current != null && current.getUserId() == userId)
        {
            System.out.println("You cannot delete your own account.");
            InputHelper.waitForEnter();
            return;
        }

        // B) At least one MANAGER must remain in the system
        if (existing.getRole() == Role.MANAGER)
        {
            int managerCount = UserDAO.countManagers();
            if (managerCount <= 1)
            {
                System.out.println("You cannot delete the last MANAGER user.");
                InputHelper.waitForEnter();
                return;
            }
        }

        System.out.println("You are about to delete this user:");
        printUsersTable(List.of(existing), "--- USER TO DELETE ---");

        boolean confirm = InputHelper.readYesNo("Are you sure");

        if (!confirm)
        {
            System.out.println("Delete cancelled.");
            InputHelper.waitForEnter();
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

        InputHelper.waitForEnter();
    }


    /**
     * Retrieves all users from the database and prints them to the console.
     * Displays User ID, username, name, surname, and role.
     */
    //todo fix output
    private static void listUsers()
    {
        List<User> users = UserDAO.getAllUsers();

        if (users.isEmpty())
        {
            System.out.println("\n--- USER LIST ---");
            System.out.println("No users found.");
            InputHelper.waitForEnter();
            return;
        }

        printUsersTable(users, "--- USER LIST ---");
        InputHelper.waitForEnter();
    }


    // USER TABLE COLUMN WIDTHS
    private static final int U_ID       = 4;
    private static final int U_USERNAME = 16;
    private static final int U_NAME     = 22; // name + surname
    private static final int U_ROLE     = 12;

    private static String pad(String text, int width)
    {
        if (text == null)
        {
            text = "-";
        }

        if (text.length() > width)
        {
            return text.substring(0, width);
        }

        return String.format("%-" + width + "s", text);
    }

    private static void printUsersTable(List<User> users, String title)
    {
        if (users == null || users.isEmpty())
        {
            System.out.println("No users found.");
            return;
        }

        System.out.println();
        System.out.println(title);
        System.out.println();

        int cellId   = U_ID + 2;
        int cellUser = U_USERNAME + 2;
        int cellName = U_NAME + 2;
        int cellRole = U_ROLE + 2;

        String topBorder =
            "┌" + "─".repeat(cellId) +
            "┬" + "─".repeat(cellUser) +
            "┬" + "─".repeat(cellName) +
            "┬" + "─".repeat(cellRole) +
            "┐";

        String midBorder =
            "├" + "─".repeat(cellId) +
            "┼" + "─".repeat(cellUser) +
            "┼" + "─".repeat(cellName) +
            "┼" + "─".repeat(cellRole) +
            "┤";

        String bottomBorder =
            "└" + "─".repeat(cellId) +
            "┴" + "─".repeat(cellUser) +
            "┴" + "─".repeat(cellName) +
            "┴" + "─".repeat(cellRole) +
            "┘";

        String header =
            "│ " + pad("ID",       U_ID) +
            " │ " + pad("Username", U_USERNAME) +
            " │ " + pad("Name",     U_NAME) +
            " │ " + pad("Role",     U_ROLE) + " │";

        System.out.println(topBorder);
        System.out.println(header);
        System.out.println(midBorder);

        for (User u : users)
        {
            String fullName = (u.getName() + " " + u.getSurname()).trim();

            String row =
                "│ " + pad(String.valueOf(u.getUserId()), U_ID) +
                " │ " + pad(u.getUsername(),             U_USERNAME) +
                " │ " + pad(fullName,                    U_NAME) +
                " │ " + pad(u.getRole().name(),          U_ROLE) + " │";

            System.out.println(row);
        }

        System.out.println(bottomBorder);
    }



}