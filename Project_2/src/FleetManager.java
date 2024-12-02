import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The FleetManager class manages a fleet of boats, providing functionality
 * to add, remove, find boats, and generate a fleet report.
 * This class is serializable to support persistent data storage.
 */
public class FleetManager implements Serializable {

    /**
     * A collection of boats managed by this FleetManager.
     */
    private ArrayList<Boat> fleet;

    /**
     * Constructs a new FleetManager with an empty fleet.
     */
    public FleetManager() {
        fleet = new ArrayList<>();
    }

    /**
     * Adds a new boat to the fleet.
     *
     * @param boat The Boat object to be added to the fleet.
     */
    public void addBoat(Boat boat) {
        fleet.add(boat);
    }

    /**
     * Removes a boat from the fleet by its name.
     *
     * @param name The name of the boat to remove (case-insensitive).
     * @return true if the boat was found and removed, false otherwise.
     */
    public boolean removeBoat(String name) {
        Optional<Boat> boat = fleet.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst();
        boat.ifPresent(fleet::remove);
        return boat.isPresent();
    }

    /**
     * Finds a boat in the fleet by its name.
     *
     * @param name The name of the boat to find (case-insensitive).
     * @return The Boat object if found, or null if no boat with the given name exists.
     */
    public Boat findBoat(String name) {
        return fleet.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Generates a report of the fleet, including each boat's details
     * and the total purchase price and expenses of all boats.
     *
     * @return A formatted String containing the fleet report.
     */
    public String getFleetReport() {
        StringBuilder report = new StringBuilder("Fleet report:\n");
        double totalPaid = 0;
        double totalSpent = 0;
        for (Boat boat : fleet) {
            report.append("    ").append(boat).append("\n");
            totalPaid += boat.getPurchasePrice();
            totalSpent += boat.getExpenses();
        }
        report.append(String.format("    Total                                             : Paid $%8.2f : Spent $%8.2f\n", totalPaid, totalSpent));
        return report.toString();
    }

    /**
     * Retrieves the list of boats in the fleet.
     *
     * @return An ArrayList of Boat objects representing the fleet.
     */
    public ArrayList<Boat> getFleet() {
        return fleet;
    }
}
