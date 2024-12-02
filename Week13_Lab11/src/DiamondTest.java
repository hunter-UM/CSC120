import java.util.Scanner;

// Driver program
public class DiamondTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create girl
        System.out.print("Enter the name of the girl: ");
        String name = scanner.nextLine();
        Girls girl = new Girls(name);

        while (true) {
            // Display current diamond info
            girl.displayInfo();

            // Prompt for new diamond
            System.out.print("Enter carats and value: ");
            double carats = scanner.nextDouble();
            double value = scanner.nextDouble();

            // Stop if carats is 0
            if (carats == 0) {
                break;
            }

            // Create a new diamond and attempt to give it to the girl
            Diamonds newDiamond = new Diamonds(carats, value);
            girl.acceptDiamond(newDiamond);
        }

        // Display final diamond info
        girl.displayInfo();
        System.out.println(girl);

        scanner.close();
    }
}
