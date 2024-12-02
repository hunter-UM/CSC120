import java.util.Scanner;

/**
 * This program stores house numbers and people's ages in each house,
 * and calculates the total age for each house and for the entire street.
 */
public class StreetMaintenance {

    /**
     * Main method that drives the program.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input the number of houses
        System.out.print("How many houses in the street?   : ");
        int numHouses = scanner.nextInt();

        // Step 2: Arrays for house numbers and ages
        int[] houseNumbers = new int[numHouses];
        int[][] peopleAges = new int[numHouses][];  // Irregular 2D array for ages

        // Step 3: Input house numbers and people's ages
        inputHouseData(scanner, houseNumbers, peopleAges);

        // Step 4: Calculate and report totals
        reportTotals(houseNumbers, peopleAges);

        scanner.close();
    }

    /**
     * Method to input house data, including house numbers and people's ages.
     * @param scanner Scanner object for input
     * @param houseNumbers Array of house numbers
     * @param peopleAges Irregular 2D array for people's ages
     */
    public static void inputHouseData(Scanner scanner, int[] houseNumbers, int[][] peopleAges) {
        for (int i = 0; i < houseNumbers.length; i++) {
            System.out.print("What is the next house number?   : ");
            houseNumbers[i] = scanner.nextInt();

            System.out.print("How many people live in number " + houseNumbers[i] + " : ");
            int numPeople = scanner.nextInt();

            peopleAges[i] = new int[numPeople];  // Create a new array for each house

            for (int j = 0; j < numPeople; j++) {
                System.out.print("What is the age of person " + (j + 1) + "      : ");
                peopleAges[i][j] = scanner.nextInt();
            }
        }
    }

    /**
     * Method to calculate and report the total ages for each house and for the entire street.
     * @param houseNumbers Array of house numbers
     * @param peopleAges Irregular 2D array of people's ages
     */
    public static void reportTotals(int[] houseNumbers, int[][] peopleAges) {
        int totalStreetAge = 0;

        // Calculate total age for each house
        for (int i = 0; i < houseNumbers.length; i++) {
            int totalHouseAge = 0;
            for (int age : peopleAges[i]) {
                totalHouseAge += age;
            }
            System.out.println("House " + houseNumbers[i] + " has a total age of " + totalHouseAge);
            totalStreetAge += totalHouseAge;
        }

        // Report total age of the street
        System.out.println("The street has a total age of " + totalStreetAge);
    }
}