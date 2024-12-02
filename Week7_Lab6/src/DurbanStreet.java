import java.util.Scanner;

public class DurbanStreet {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("WEEK 7 - LAB 6");

        System.out.print("How many houses in the street? : ");
        int numberOfHouses = keyboard.nextInt();

        int [] houseNumbers = new int [numberOfHouses];

        // Updating the array
        int index;
        for (index = 0; index < houseNumbers.length; index++){


            System.out.print("What is the next house number? : ");
            houseNumbers[index] = keyboard.nextInt();

        }// end of the for loop

        int[][] houseAges = new int [numberOfHouses][];

        //Update array
        int rowIndex;
        int colIndex;

        for (rowIndex = 0; rowIndex < houseAges.length; rowIndex++){

            System.out.print("How many people live in number " + houseNumbers[rowIndex] + " : ");
            int peopleInHouse = keyboard.nextInt();
            houseAges[rowIndex] = new int[peopleInHouse];

            for (colIndex = 0; colIndex < houseAges[rowIndex].length; colIndex++){

                System.out.print("What is the age of person " + (colIndex + 1) + " : ");
                houseAges[rowIndex][colIndex] = keyboard.nextInt();

            }// end of the inner for loop ----> COLUMN

        }// end of the outer for loop ----> ROW

        //COUNTING

        int totalStreetAge = 0;

        for (rowIndex = 0; rowIndex < houseAges.length; rowIndex++){

            int totalAge = 0;

            for (colIndex = 0; colIndex < houseAges[rowIndex].length; colIndex++){

                totalAge = totalAge + houseAges[rowIndex][colIndex];

            }// end of the inner for loop ----> COLUMN

            System.out.println("House " + (houseNumbers[rowIndex]) + " has a total age of " + totalAge);

            totalStreetAge += totalAge;
        }// end of the outer for loop ----> ROW

        //Finding the total street age
        System.out.println("The street has a total age of " + totalStreetAge);

    }// end of the main method


}// end of the Durban Street class
