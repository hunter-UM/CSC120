public class Flourescent extends Light {

    public Flourescent(int lumens) {
        super(lumens);
    }

    public double heatOutput() {
        return 0.0;
    }

    public boolean isFlourescent() {
        return true;
    }
}
