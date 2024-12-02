/**
 * The FleetManagementApp class provides a console-based interface
 * for managing a fleet of boats. Users can load data from a CSV file
 * or serialized file, display fleet reports, add or remove boats, and
 * manage expenses.
 */
import java.io.*;
import java.util.Scanner;

public class FleetManagementApp {

    /**
     * Runs the Fleet Management System application, providing a menu-driven
     * interface for the user to interact with the fleet data.
     *
     * @param args Command-line arguments. If provided, the first argument is
     *             treated as the path to a CSV file to initialize the fleet.
     */
    public void run(String[] args) {
        FleetManager fleetManager = loadFleet(args);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Fleet Management System\n--------------------------------------");
        boolean exit = false;
        while (!exit) {
            displayMenu();
            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "P":
                    System.out.println(fleetManager.getFleetReport());
                    break;
                case "A":
                    addBoat(fleetManager, scanner);
                    break;
                case "R":
                    removeBoat(fleetManager, scanner);
                    break;
                case "E":
                    handleExpense(fleetManager, scanner);
                    break;
                case "X":
                    exit = true;
                    saveFleetToSerializedFile(fleetManager);
                    System.out.println("Exiting the Fleet Management System");
                    break;
                default:
                    System.out.println("Invalid menu option, try again");
            }
        }
        scanner.close();
    }

    /**
     * Loads the fleet data from a CSV file (if a file path is provided) or a serialized file.
     * If neither file exists, initializes an empty fleet.
     *
     * @param args Command-line arguments. The first argument is treated as a CSV file path.
     * @return An instance of FleetManager containing the loaded fleet data.
     */
    private FleetManager loadFleet(String[] args) {
        FleetManager fleetManager = new FleetManager();
        if (args.length > 0) {
            fleetManager = loadFleetFromCSV(args[0]);
        } else {
            File dbFile = new File("FleetData.db");
            if (dbFile.exists()) {
                fleetManager = loadFleetFromSerializedFile();
            } else {
                System.out.println("No prior fleet data found. Starting fresh.");
            }
        }
        return fleetManager;
    }
    /**
     * Loads fleet data from a CSV file.
     *
     * @param fleetDataPath Path to the CSV file containing fleet data.
     * @return An instance of FleetManager populated with boats from the CSV file.
     */
    private FleetManager loadFleetFromCSV(String fleetDataPath) {
        FleetManager fleetManager = new FleetManager();
        File csvFile = new File(fleetDataPath);
        if (!csvFile.exists()) {
            System.err.println("Error: CSV file not found at " + fleetDataPath);
            return fleetManager;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    if (data.length != 6) {
                        throw new IllegalArgumentException("Incorrect data format: " + line);
                    }
                    BoatType type = BoatType.valueOf(data[0].toUpperCase());
                    String name = data[1];
                    int year = Integer.parseInt(data[2]);
                    String makeModel = data[3];
                    double length = Double.parseDouble(data[4]);
                    double price = Double.parseDouble(data[5]);
                    Boat boat = new Boat(type, name, year, makeModel, length, price);
                    fleetManager.addBoat(boat);
                } catch (Exception e) {
                    System.err.println("Skipping invalid line in CSV: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        return fleetManager;
    }
    /**
     * Loads fleet data from a serialized file.
     *
     * @return An instance of FleetManager populated with data from the serialized file.
     */
    private FleetManager loadFleetFromSerializedFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FleetData.db"))) {
            return (FleetManager) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading serialized fleet data: " + e.getMessage());
            return new FleetManager();
        }
    }
    /**
     * Saves the current fleet data to a serialized file.
     *
     * @param fleetManager The FleetManager instance containing the fleet data to save.
     */
    private void saveFleetToSerializedFile(FleetManager fleetManager) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FleetData.db"))) {
            oos.writeObject(fleetManager);
        } catch (IOException e) {
            System.err.println("Error saving fleet data: " + e.getMessage());
        }
    }
    /**
     * Displays the main menu options for the Fleet Management System.
     */
    private void displayMenu() {
        System.out.print("\n(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
    }
    /**
     * Allows the user to add a new boat to the fleet by entering CSV-formatted data.
     *
     * @param fleetManager The FleetManager instance managing the fleet.
     * @param scanner      A Scanner instance for reading user input.
     */
    private void addBoat(FleetManager fleetManager, Scanner scanner) {
        System.out.print("Please enter the new boat CSV data          : ");
        String csvData = scanner.nextLine();
        String[] data = csvData.split(",");
        try {
            if (data.length != 6) {
                throw new IllegalArgumentException("Invalid number of fields. Expected 6.");
            }
            BoatType type = BoatType.valueOf(data[0].toUpperCase());
            String name = data[1];
            int year = Integer.parseInt(data[2]);
            String makeModel = data[3];
            double length = Double.parseDouble(data[4]);
            double price = Double.parseDouble(data[5]);
            Boat boat = new Boat(type, name, year, makeModel, length, price);
            fleetManager.addBoat(boat);
            System.out.println("Boat added successfully.");
        } catch (Exception e) {
            System.out.println("Error: Invalid data format. Boat not added. " + e.getMessage());
        }
    }
    /**
     * Allows the user to remove a boat from the fleet by specifying its name.
     *
     * @param fleetManager The FleetManager instance managing the fleet.
     * @param scanner      A Scanner instance for reading user input.
     */
    private void removeBoat(FleetManager fleetManager, Scanner scanner) {
        System.out.print("Which boat do you want to remove?           : ");
        String name = scanner.nextLine();
        if (fleetManager.removeBoat(name)) {
            System.out.println("Boat removed successfully.");
        } else {
            System.out.println("Cannot find boat " + name);
        }
    }
    /**
     * Allows the user to add an expense for a specific boat, validating that the
     * expense does not exceed the boat's purchase price.
     *
     * @param fleetManager The FleetManager instance managing the fleet.
     * @param scanner      A Scanner instance for reading user input.
     */
    private void handleExpense(FleetManager fleetManager, Scanner scanner) {
        System.out.print("Which boat do you want to spend on?         : ");
        String name = scanner.nextLine();
        Boat boat = fleetManager.findBoat(name);
        if (boat == null) {
            System.out.println("Cannot find boat " + name);
            return;
        }
        System.out.print("How much do you want to spend?              : ");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (boat.addExpense(amount)) {
                System.out.printf("Expense authorized, $%.2f spent.%n", boat.getExpenses());
            } else {
                System.out.printf("Expense not permitted, only $%.2f left to spend.%n", boat.getPurchasePrice() - boat.getExpenses());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered. Expense not added.");
        }
    }
    /**
     * The main entry point for the Fleet Management System application.
     *
     * @param args Command-line arguments. If provided, the first argument is treated
     *             as the path to a CSV file for initializing the fleet.
     */
    public static void main(String[] args) {
        new FleetManagementApp().run(args);
    }
}
