import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Rita on 2016-11-14.
 */
public class Workshop01Array {
    static ArrayList<String> colors = new ArrayList<>(Arrays.asList("white", "blue", "red", "silver", "black", "green", "banana"));
    static ArrayList<String> makes = new ArrayList<>(Arrays.asList("toyota", "mazda", "bmw", "vw", "opel", "suzuki", "ford", "mercedes"));
    static ArrayList<Integer> engineSizes = new ArrayList<>(Arrays.asList(1100, 1400, 1600, 1800, 2500));
    static ArrayList<Car> lsCars = new ArrayList<>(10);
    static Random random = new Random();
    static String color;
    static String make;
    static int engineSize;

    public static void main(String[] args) {
        System.out.println("Number of Cars Available = " + Car.getCount());
        for (int i = 0; i < 10; i++) {
            color = colors.get(random.nextInt(colors.size()));
            make = makes.get(random.nextInt(makes.size()));
            engineSize = engineSizes.get(random.nextInt(engineSizes.size()));
            lsCars.add(i, new Car(color, engineSize, make));
            System.out.println(Car.toString(lsCars.get(i)));
        }
        lsCars.get(0).drive(25);
        lsCars.get(1).drive(120);
        System.out.println(lsCars.size());
        System.out.println("Number of Cars Available = " + Car.getCount());
    }
}
