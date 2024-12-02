import java.util.Scanner;

public class IAm {

    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        StringBuilder qualities = new StringBuilder();
        String sentence;

        System.out.println("Please enter sentences, . to end.");
        sentence = keyboard.nextLine();
        while(!sentence.equals(".")) {
            sentence = keyboard.nextLine();

            if (sentence.startsWith("I am")) {
                String quality = sentence.substring(5);

                if (qualities.length() > 0) {
                    qualities.append(", ");
                }
                qualities.append(quality);
            }

        }

        System.out.println("The qualities are " + qualities.toString() + ".");

        System.out.println("WEEK 10 - LAB 8");


    } // end of the main method

} // end of the IAm class
