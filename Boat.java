import java.io.Serializable;

/**
 * The Boat class represents a single boat in the fleet, containing details
 * about its type, name, year of manufacture, make and model, length, purchase price,
 * and maintenance expenses. This class is serializable to support data persistence.
 */
public class Boat implements Serializable {

    /** The type of the boat (e.g., SAILING or POWER). */
    private BoatType type;

    /** The name of the boat. */
    private String name;

    /** The year the boat was manufactured. */
    private int yearOfManufacture;

    /** The make and model of the boat. */
    private String makeModel;

    /** The length of the boat in feet. */
    private double length;

    /** The purchase price of the boat. */
    private double purchasePrice;

    /** The current maintenance expenses for the boat. */
    private double expenses;

    /**
     * Constructs a new Boat with the specified details.
     *
     * @param type              The type of the boat (e.g., SAILING or POWER).
     * @param name              The name of the boat.
     * @param yearOfManufacture The year the boat was manufactured.
     * @param makeModel         The make and model of the boat.
     * @param length            The length of the boat in feet.
     * @param purchasePrice     The purchase price of the boat.
     */
    public Boat(BoatType type, String name, int yearOfManufacture, String makeModel, double length, double purchasePrice) {
        this.type = type;
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.makeModel = makeModel;
        this.length = length;
        this.purchasePrice = purchasePrice;
        this.expenses = 0;
    }

    /**
     * Adds an expense to the boat's total maintenance expenses, ensuring the
     * total does not exceed the boat's purchase price.
     *
     * @param amount The amount to add to the expenses.
     * @return true if the expense was added successfully, false if it exceeds the allowed budget.
     */
    public boolean addExpense(double amount) {
        if (expenses + amount > purchasePrice) {
            return false;
        }
        expenses += amount;
        return true;
    }

    /**
     * Retrieves the type of the boat.
     *
     * @return The boat's type.
     */
    public BoatType getType() {
        return type;
    }

    /**
     * Retrieves the name of the boat.
     *
     * @return The boat's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the year the boat was manufactured.
     *
     * @return The year of manufacture.
     */
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    /**
     * Retrieves the make and model of the boat.
     *
     * @return The make and model.
     */
    public String getMakeModel() {
        return makeModel;
    }

    /**
     * Retrieves the length of the boat.
     *
     * @return The length in feet.
     */
    public double getLength() {
        return length;
    }

    /**
     * Retrieves the purchase price of the boat.
     *
     * @return The purchase price.
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Retrieves the total maintenance expenses for the boat.
     *
     * @return The maintenance expenses.
     */
    public double getExpenses() {
        return expenses;
    }

    /**
     * Generates a string representation of the boat, including all its key details.
     *
     * @return A formatted string representation of the boat.
     */
    @Override
    public String toString() {
        return String.format("%-8s %-20s %4d %-10s %4.1f' : Paid $%8.2f : Spent $%8.2f",
                type, name, yearOfManufacture, makeModel, length, purchasePrice, expenses);
    }
}
