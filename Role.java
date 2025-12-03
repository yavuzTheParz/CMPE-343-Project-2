// File: Role.java

/**
 * Represents the available user roles within the system.
 * Each role determines the level of access and permissions a user has.
 */
public enum Role
{
    /** Role for testing-level users with limited permissions. */
    TESTER,

    /** Role for junior developers. */
    JUNIOR_DEV,

    /** Role for senior developers with advanced permissions. */
    SENIOR_DEV,

    /** Role for managerial users with the highest access level. */
    MANAGER
}
