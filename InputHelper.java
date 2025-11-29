// File: InputHelper.java
import java.util.Scanner;

public class InputHelper
{
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readString(String prompt)
    {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    public static int readInt(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();

            try
            {
                return Integer.parseInt(line);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}
