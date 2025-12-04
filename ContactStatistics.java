// File: ContactStatistics.java

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * Provides various statistics and summary information for {@link Contact} data.
 * <p>
 * The statistics are printed to the console and include:
 * <ul>
 *     <li>Youngest and oldest contacts</li>
 *     <li>Average age and age standard deviation</li>
 *     <li>Age clusters (18–25, 26–40, 41+)</li>
 *     <li>Phone prefix (country/area code) distribution</li>
 * </ul>
 */
public class ContactStatistics
{
    /**
     * Retrieves all contacts from {@link ContactDAO} and prints various statistics
     * to the console. If there are no contacts, a message is displayed and
     * no further calculations are performed.
     */
    public static void showStats()
    {
        List<Contact> all = ContactDAO.getAllContacts();
        if (all.isEmpty())
        {
            System.out.println("No contacts found.");
            return;
        }

        List<Integer> ages = computeAges(all);
        printYoungestAndOldest(all, ages);
        printStandardDeviation(ages);
        printAgeClusters(ages);
        printPhonePrefixDistribution(all);

        System.out.println("\n--- END OF STATISTICS ---\n");
        InputHelper.waitForEnter();

    }

    // ------------------ AGE CALCULATION ------------------

    /**
     * Computes the ages (in full years) for all contacts that have a non-null birth date.
     * The age is calculated as the difference in years between the birth date
     * and the current date.
     *
     * @param contacts the list of contacts
     * @return a list of ages corresponding to contacts with a valid birth date
     */
    private static List<Integer> computeAges(List<Contact> contacts)
    {
        List<Integer> ages = new ArrayList<>();
        for (Contact c : contacts)
        {
            LocalDate bd = c.getBirthDate();
            if (bd != null)
            {
                int age = Period.between(bd, LocalDate.now()).getYears();
                ages.add(age);
            }
        }
        return ages;
    }

    // ------------------ YOUNGEST & OLDEST ------------------

    /**
     * Finds and prints the youngest and oldest contacts based on their age.
     * <p>
     * The method uses the provided list of ages to determine the minimum and
     * maximum age, and then scans the contact list to find a contact matching
     * each of those ages. The result is printed to the console.
     *
     * @param all  the list of all contacts
     * @param ages the list of ages corresponding to contacts with a birth date
     */
    private static void printYoungestAndOldest(List<Contact> all, List<Integer> ages)
    {
        int minAge = Collections.min(ages);
        int maxAge = Collections.max(ages);

        Contact youngest = null;
        Contact oldest   = null;

        for (Contact c : all)
        {
            LocalDate bd = c.getBirthDate();
            if (bd != null)
            {
                int age = Period.between(bd, LocalDate.now()).getYears();

                if (age == minAge)
                {
                    youngest = c;
                }
                if (age == maxAge)
                {
                    oldest = c;
                }
            }
        }

        System.out.println("\n--- YOUNGEST & OLDEST CONTACTS ---");
        System.out.println("Youngest: " + youngest.getFirstName() + " " +
                           youngest.getLastName() + " (" + minAge + " years old)");

        System.out.println("Oldest: " + oldest.getFirstName() + " " +
                           oldest.getLastName() + " (" + maxAge + " years old)");
    }

    // ------------------ STANDARD DEVIATION ------------------

    /**
     * Computes and prints the average age and the standard deviation of ages
     * to the console.
     * <p>
     * The standard deviation is calculated using the population formula:
     * variance = sum((age - mean)^2) / N, where N is the number of ages.
     *
     * @param ages the list of ages to analyze; must not be empty
     */
    private static void printStandardDeviation(List<Integer> ages)
    {
        double mean = ages.stream().mapToInt(a -> a).average().orElse(0);

        double variance = 0;
        for (int age : ages)
        {
            variance += Math.pow(age - mean, 2);
        }
        variance /= ages.size();

        double stdDev = Math.sqrt(variance);

        System.out.println("\n--- AGE STANDARD DEVIATION ---");
        System.out.printf("Average age: %.2f\n", mean);
        System.out.printf("Standard deviation: %.2f\n", stdDev);
    }

    // ------------------ AGE CLUSTERING ------------------

    /**
     * Groups ages into predefined clusters and prints the count in each cluster:
     * <ul>
     *     <li>18–25: Young</li>
     *     <li>26–40: Adult</li>
     *     <li>41+: Senior</li>
     * </ul>
     *
     * @param ages the list of ages to classify
     */
    private static void printAgeClusters(List<Integer> ages)
    {
        int young = 0;   // 18–25
        int adult = 0;   // 26–40
        int senior = 0;  // 41+

        for (int age : ages)
        {
            if (age <= 25) young++;
            else if (age <= 40) adult++;
            else senior++;
        }

        System.out.println("\n--- AGE CLUSTERS ---");
        System.out.println("18–25 (Young):  " + young);
        System.out.println("26–40 (Adult):  " + adult);
        System.out.println("41+   (Senior): " + senior);


    }

    // ------------------ PHONE PREFIX DISTRIBUTION ------------------

    /**
     * Calculates and prints the distribution of phone prefixes (e.g., country/area codes)
     * based on the primary phone number of each contact.
     * <p>
     * The method:
     * <ol>
     *     <li>Extracts only digits from the phone number</li>
     *     <li>Skips numbers shorter than 5 digits</li>
     *     <li>Uses the first two digits as a prefix (e.g., 90, 55, 49, 44)</li>
     *     <li>Counts how many contacts share each prefix</li>
     * </ol>
     *
     * @param contacts the list of contacts whose phone prefixes will be analyzed
     */
    private static void printPhonePrefixDistribution(List<Contact> contacts)
    {
        Map<String, Integer> prefixCount = new HashMap<>();

        for (Contact c : contacts)
        {
            String phone = c.getPhonePrimary();
            if (phone == null) continue;

            String digits = phone.replaceAll("[^0-9]", "");

            if (digits.length() < 5) continue;

            // rule: country code is first 1–3 digits
            String prefix = digits.substring(0, 2); // e.g., 90, 55, 49, 44
            prefixCount.put(prefix, prefixCount.getOrDefault(prefix, 0) + 1);
        }

        System.out.println("\n--- PHONE PREFIX DISTRIBUTION (by country/area code) ---");

        for (Map.Entry<String, Integer> e : prefixCount.entrySet())
        {
            System.out.println("Prefix +" + e.getKey() + ": " + e.getValue() + " contacts");
        }

    }
}
