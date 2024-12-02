import java.util.Scanner;
//==========================================================
public class Nitrox_SCUBA {
//----------------------------------------------------------
private static Scanner keyboard = new Scanner(System.in);

private static final double CONTINGENCY_O2 = 1.6;
private static final double MAXIMAL_O2 = 1.4;
//----------------------------------------------------------
    public static void main(String[] args) {
        int depth, percentO2;
        double ambientPressure, partialPressureO2;
        char o2Group;
        boolean maxO2, contingencyO2;

        //Gather input
        System.out.print("Enter depth and percentage O2: ");
        depth = keyboard.nextInt();
        percentO2 = keyboard.nextInt();

        //Calculations
        ambientPressure = depth/33 + 1;
        partialPressureO2 = percentO2/100.0 * ambientPressure;
        o2Group = (char)((int)(partialPressureO2 * 10) + (int)'A');

        //True/False Statements
        if (partialPressureO2 > MAXIMAL_O2) {
            maxO2 = true;
        }
        else {
            maxO2 = false;
        }

        if (partialPressureO2 > CONTINGENCY_O2) {
            contingencyO2 = true;
        }
        else {
            contingencyO2 = false;
        }
        //Display Output
        System.out.println("Ambient pressure: " + ambientPressure);
        System.out.println("O2 pressure: " + partialPressureO2);
        System.out.println("O2 group: " + o2Group);
        System.out.println("Exceeds maximal O2 pressure: " + maxO2);
        System.out.println("Exceeds contingency O2 pressure: " + contingencyO2);
        System.out.println("WEEK 4 - LAB 3");

    }// End of the main method



}// End of the Nitrox_SCUBA class
