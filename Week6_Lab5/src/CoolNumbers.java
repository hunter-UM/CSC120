import java.util.Scanner;

public class CoolNumbers {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        int count = getNumbers(numbers);

        for (int i = 0; i < count; i++) {
            int number = numbers[i];
            boolean fibonacci = isFibonacci(number);
            boolean prime = isPrime(number);

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
        System.out.println("WEEK 6 - LAB 5");

    } // end of the main class

    public static int getNumbers(int[] numbers) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int input;

        System.out.print("Please enter numbers (0 to stop) : ");

        do {
            input = scanner.nextInt();
            if (input > 0 && count <= 10) {
                numbers[count] = input;
                count++;
            } else if (input < 0) {
                System.out.println("Please enter a non-negative number.");
            }
        }
        while (input != 0 && count < 10);
        return count;

    } // end of the getNumbers class

    public static boolean isFibonacci(int number) {
        if (number == 1) return true;

        int a = 0, b = 1;
        int fibonacci = a + b;

        while (fibonacci <= number) {
            if (fibonacci == number) {
                return true;
            }
            a = b;
            b = fibonacci;
            fibonacci = a + b;
        }
        return false;

    } //end of the isFibonacci class

    public static boolean isPrime(int number) {

        int divisor = 2;

        while (divisor <= Math.sqrt(number)) {
            if (number % divisor == 0) {
                return (false);
            }
            divisor++;
        }
        return (true);

    } // end of isPrime method

} // end of the CoolNumbers class
