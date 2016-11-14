import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Rita on 2016-11-14.
 */
public class Garage {
    private int size = 5;
    private ArrayList<Car> garage;
    static ArrayList<String> colors = new ArrayList<>(Arrays.asList("white", "blue", "red", "silver", "black", "green", "banana"));
    static ArrayList<String> makes = new ArrayList<>(Arrays.asList("toyota", "mazda", "bmw", "vw", "opel", "suzuki", "ford", "mercedes"));
    static ArrayList<Integer> engineSizes = new ArrayList<>(Arrays.asList(1100, 1400, 1600, 1800, 2500));
    private static Random random = new Random();


    public Garage() {
        garage = new ArrayList<>(size);
        this.addRandomCar(5);
    }

    public void addCar(Car c) {
        garage.add(c);
    }

    public void addRandomCar() {
        String color = colors.get(random.nextInt(colors.size()));
        String make = makes.get(random.nextInt(makes.size()));
        int engineSize = engineSizes.get(random.nextInt(engineSizes.size()));
        garage.add(new Car(color, engineSize, make));
    }

    public void addRandomCar(int numCarsToAdd) {
        for (int i = 0; i < numCarsToAdd; i++) {
            addRandomCar();
        }
    }

    public String toString() {
        return "There are " + garage.size() + " cars in the garage.";
    }

    public int size() {
        return garage.size();
    }
}
