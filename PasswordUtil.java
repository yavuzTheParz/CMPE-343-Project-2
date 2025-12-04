// File: PasswordUtil.java
<<<<<<< HEAD
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Utility class that provides password hashing functionality for the application.
 * Uses the SHA-256 cryptographic algorithm and returns the hash
 * in lowercase hexadecimal format.
 */
public class PasswordUtil
{
    /**
     * Hashes the given plain-text password using SHA-256 and returns the result
     * as a lowercase hexadecimal string.
     *
     * @param plainText the input password to be hashed
     * @return SHA-256 hashed value of the input as a hex string
     * @throws RuntimeException if SHA-256 is not supported on the system
     */
=======
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class PasswordUtil
{
>>>>>>> 9782e30fac3495bab4c37e2194c8516f6621ae22
    public static String hashPassword(String plainText)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(plainText.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes)
            {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException("SHA-256 not supported", e);
        }
    }
}
