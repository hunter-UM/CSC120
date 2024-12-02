import java.util.Scanner;

public class IRS_Program {

    private static final Scanner keyboard = new Scanner(System.in);

    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double HIGH_RATE = 0.25;
    private static final double MEDIUM_RATE = 0.10;
    private static final double LOW_RATE = 0.03;


    public static void main(String[] args) {

        double amount, income, deductions;
        double taxableIncome;
        char taxGroup;
        double tax;

        income = 0.0;
        deductions = 0.0;

        do {
            System.out.print("Enter next amount: ");

            amount = keyboard.nextDouble();

            if (amount > 0.0) {
                income += amount;
            }
            else {
                deductions -= amount;
            }
        } while (amount != 0.0);

        taxableIncome = computeTaxableIncome(income, deductions);
        taxGroup = chooseTaxGroup(taxableIncome);
        tax = computeTax(taxableIncome, taxGroup);
        displayTaxInformation(income, deductions, taxableIncome, taxGroup, tax);





        System.out.println("WEEK 5 - LAB 4");
    } // end of the main method

//----------------------------------------------------------------------------------------------------
    private static double computeTaxableIncome (double income, double deductions) {

    double taxable;
    if (income >= deductions) {
        taxable = income - deductions;
    }
    else {
        taxable = 0.0;
    }
    return taxable;

} // end of the computeTaxableIncome method

//----------------------------------------------------------------------------------------------------

    private static char chooseTaxGroup(double income) {

        if (income >= STINKING_RICH){
            return 'S';
        }
        else if (income >= QUITE_RICH) {
            return 'Q';
        }
        else if (income >= MIAMI_POOR) {
            return 'M';
        }
        else if (income >= AVERAGE) {
            return 'A';
        }
        else if (income >= REALISTIC) {
            return 'R';
        }
        else {
            return 'P';
        }

    } // end of the computeTaxGroup method

//----------------------------------------------------------------------------------------------------

    private static double computeTax(double taxable, char group){
        switch (group) {
            case 'S':
            case 'Q':
                return taxable * HIGH_RATE;
            case 'M':
                return taxable * MEDIUM_RATE;
            case 'A':
            case 'R':
                return taxable * LOW_RATE;
            case 'P':
                return 0.0;
        }
        return group;
} // end of the computeTax method

//----------------------------------------------------------------------------------------------------

    private static void displayTaxInformation(double income, double deductions, double taxableIncome, char taxGroup, double tax) {
        System.out.printf("Income         = $%.2f%n", income);
        System.out.printf("Deductions     = $%.2f%n", deductions);
        System.out.printf("Taxable income = $%.2f%n", taxableIncome);
        System.out.printf("Tax group      = %c%n", taxGroup);
        System.out.printf("Tax owed       = $%.2f%n", tax);

} // end of the displayTaxInformation method

//----------------------------------------------------------------------------------------------------

} // end of the IRS_Program class
