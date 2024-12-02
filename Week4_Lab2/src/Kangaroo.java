import java.util.Scanner;
//===========================================================================================================
public class Kangaroo {
    private static final double ROAD_KILL_PROBABILITY_CONSTANT = 1.47;
    private static final double ROAD_WIDTH = 0.01;
//-----------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input---------------------------------------------------------------------------------------------
        System.out.print("Enter side of square in km  : ");
        double side = scanner.nextDouble();
        System.out.print("Enter roads length in km    : ");
        double roadLength = scanner.nextDouble();
        System.out.print("Enter number of 'roos       : ");
        int numberOfRoos = scanner.nextInt();

        // Kangaroo Density-----------------------------------------------------------------------------------
        double area = side * side;
        double kangarooDensity = numberOfRoos / area;

        // Road surface area-----------------------------------------------------------------------------------
        double roadSurfaceArea = roadLength * ROAD_WIDTH;

        // Expected number of kills & expected number of injuries----------------------------------------------
        double expectedKills = kangarooDensity * roadSurfaceArea * ROAD_KILL_PROBABILITY_CONSTANT;
        int kills = (int) expectedKills;
        int injuries = (expectedKills > kills) ? 1 : 0;

        // Output-----------------------------------------------------------------------------------------------
        System.out.println("Expected number of kills is : " + kills);
        System.out.println("Expected number of injuries : " + injuries);
    }
//===============================================================================================================
}
