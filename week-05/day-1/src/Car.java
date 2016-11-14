/**
 * Created by Rita on 2016-11-14.
 */
public class Car {
    private String color;
    private int engineSize;
    private String typeCar;
    private int kmOdometer;
    private static int countCars = -1;

    public void setColor (String color) {
        this.color = color;
    }

    public void setEngineSize (int engineSize) {
        this.engineSize = engineSize;
    }

    public void setTypeCar (String typeCar) {
        this.typeCar = typeCar;
    }

    public void setKmOdometer(int kmOdometer) {
        this.kmOdometer = kmOdometer;
    }

    public String getColor() {
        return color;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public int getKmOdometer() {
        return kmOdometer;
    }

    public Car() {
        this("red", 1600, "Mazda", 10);
    }

    public Car(String color, String typeCar) {
        this(color, 1600, typeCar, 10);
    }

    public Car(int engineSize, int kmOdometer) {
        this("red", engineSize, "Mazda", kmOdometer);
    }

    public Car(String color, int engineSize, String typeCar) {
        this(color, engineSize, typeCar, 10);
    }

    public Car(String color, int engineSize, String typeCar, int kmOdometer) {
        this.color = color;
        this.engineSize = engineSize;
        this.typeCar = typeCar;
        this.kmOdometer = kmOdometer;
        countCars += 1;
    }

    public void drive(int kmDriven) {
        kmOdometer += kmDriven;
        if (kmDriven < 20) {
            System.out.printf("Brrm, %s just drove around town %d clicks.\n", typeCar, kmDriven);
        } else if (kmDriven < 50){
            System.out.printf("Brrm, screech, brrm, screech; %s commuted %d clicks.\n", typeCar, kmDriven);
        } else {
            System.out.printf("Whee, %s %d clicks.\n", typeCar, kmDriven);
        }
    }

    public static String toString(Car myCar) {
        return "This " + myCar.getTypeCar() + " is " + myCar.getColor() + ", has " + myCar.getEngineSize() + " cc engine and clocked " + myCar.getKmOdometer() + " km's.";
    }

    public static int getCount() {
        return countCars;
    }
}