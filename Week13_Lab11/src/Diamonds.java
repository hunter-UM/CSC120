class Diamonds {
    private double carats;
    private double value;

    public Diamonds(double carats, double value) {
        this.carats = carats;
        this.value = value;
    }

    public double getCarats() {
        return carats;
    }

    public double getValue() {
        return value;
    }

    public String toString() {
        return carats + " carats, worth $" + value;
    }
}