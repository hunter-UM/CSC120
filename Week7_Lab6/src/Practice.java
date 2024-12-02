import java.util.Scanner;

public class Practice {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Practice Arrays");


        //Declaring 2D Array
        int [][] yourArray = new int[3][2];

        //Update array
        int rowIndex;
        int colIndex;

        for (rowIndex = 0; rowIndex < yourArray.length; rowIndex++){
            System.out.println("At row " + rowIndex + ":");
            for (colIndex = 0; colIndex < yourArray[rowIndex].length; colIndex++){

                System.out.print("At index [" + rowIndex + "] [" + colIndex + "]: Enter a number: ");
                yourArray[rowIndex][colIndex] = keyboard.nextInt();

            }// end of the inner for loop ----> COLUMN

        }// end of the outer for loop ----> ROW


        //DISPLAY
        for (rowIndex = 0; rowIndex < yourArray.length; rowIndex++){
            System.out.println("At row " + rowIndex + ":");
            for (colIndex = 0; colIndex < yourArray[rowIndex].length; colIndex++){

                System.out.println("At index [" + rowIndex + "] [" + colIndex + "]: The value is: " + yourArray[rowIndex][colIndex]);

            }// end of the inner for loop ----> COLUMN

        }// end of the outer for loop ----> ROW


    } // end of the main method

} // end of the Practice class
