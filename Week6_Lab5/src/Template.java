import java.util.Scanner;

    public class Template {

        /**
         * Method to read integers into an array from user input.
         * Entry stops when the user enters 0 or the array reaches 10 elements.
         */
        public static int getNumbers(int[] numbers) {
            Scanner scanner = new Scanner(System.in);
            int count = 0;  // Number of integers entered
            int input;

            // Loop to get user input, stops at 0 or when 10 numbers are entered
            do {
                System.out.print("Please enter a number (0 to stop): ");
                input = scanner.nextInt();
                if (input > 0 && count < 10) {
                    numbers[count] = input;
                    count++;
                } else if (input < 0) {
                    System.out.println("Please enter a non-negative integer.");
                }
            } while (input != 0 && count < 10);
            return count;  // Returns the number of integers entered
        }

        /**
         * Method to check if a number is a Fibonacci number.
         * Uses a while loop to generate Fibonacci numbers until the number is found or passed.
         */
        public static boolean isFibonacci(int num) {
            if (num == 0 || num == 1) return true;  // Special case for 0 and 1

            int a = 0, b = 1;
            int fibonacci = a + b;

            // Generate Fibonacci numbers and check against the input
            while (fibonacci <= num) {
                if (fibonacci == num) {
                    return true;  // Number is Fibonacci
                }
                a = b;
                b = fibonacci;
                fibonacci = a + b;
            }
            return false;  // Number is not Fibonacci
        }

        /**
         * Method to check if a number is prime.
         * A prime number has no divisors other than 1 and itself.
         */
        public static boolean isPrime(int num) {
            if (num < 2) return false;  // Numbers less than 2 are not prime
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;  // Number is divisible, so not prime
                }
            }
            return true;  // Number is prime
        }

        /**
         * Main method to control program flow.
         * Gets user input, checks each number for Fibonacci and prime properties, and reports results.
         */
        public static void main(String[] args) {
            int[] numbers = new int[10];  // Array to hold up to 10 numbers
            int count = getNumbers(numbers);  // Get the numbers from user input

            // Loop through the entered numbers and check each one
            for (int i = 0; i < count; i++) {
                int number = numbers[i];
                boolean fibonacci = isFibonacci(number);  // Check if the number is Fibonacci
                boolean prime = isPrime(number);  // Check if the number is prime

                // Print the result for each number
                System.out.print(number + " is ");
                if (fibonacci) {
                    System.out.print("Fibonacci ");
                } else {
                    System.out.print("not Fibonacci ");
                }
                if (prime) {
                    System.out.println("and is prime.");
                } else {
                    System.out.println("and is not prime.");
                }
            }
        }
    }

