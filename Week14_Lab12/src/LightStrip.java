import java.util.ArrayList;

public class LightStrip {

    private ArrayList<Light> lights;

    public LightStrip() {
        lights = new ArrayList<>();
    }

    public void addLight(Light light) {
        lights.add(light);
    }

    public void removeLight(int index) {
        if (index >= 0 && index < lights.size()) {
            lights.remove(index);
        } else {
            System.out.println("ERROR: No light at that index");
        }
    }

    public void display() {
        double totalLumens = 0;
        double totalHeat = 0;
        int fluorescentCount = 0;

        for (int i = 0; i < lights.size(); i++) {
            Light light = lights.get(i);
            System.out.println(i + ": " + light);

            totalLumens += light.getLumens();
            totalHeat += light.heatOutput();
            if (light.isFlourescent()) {
                fluorescentCount++;
            }
        }

        System.out.println("Total lumens = " + totalLumens);
        System.out.println("Flourescent  = " + fluorescentCount);
        System.out.println("Heat output  = " + totalHeat);
    }
}
