public class Incandescent extends Light {

    public Incandescent(int lumens) {
        super(lumens);
    }

    public double heatOutput() {
        return getLumens() * 87.4;
    }

    public boolean isFlourescent() {
        return false;
    }
}
