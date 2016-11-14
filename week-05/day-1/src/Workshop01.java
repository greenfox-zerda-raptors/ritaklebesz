/**
 * Created by Rita on 2016-11-14.
 */
public class Workshop01 {
    public static void main(String[] args) {
        System.out.println("Number of Cars Available = " + Car.getCount());
        Car myCar = new Car();
        System.out.println("Number of Cars Available = " + Car.getCount());
        myCar.setKmOdometer(12312);
        myCar.setTypeCar("Mazda");

        Car myCar2 = new Car();
        myCar2.setColor("silver");
        myCar2.setEngineSize(2500);
        myCar2.setKmOdometer(152312);
        myCar2.setTypeCar("Ford");

        Car myCar3 = new Car();
        myCar3.setColor("green");
        myCar3.setEngineSize(2800);
        myCar3.setKmOdometer(42421);
        myCar3.setTypeCar("Beamer");

        myCar.drive(15);
        myCar2.drive(1200);
        myCar3.drive(49);
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's.\n",
                myCar.getTypeCar(), myCar.getColor(), myCar.getEngineSize(), myCar.getKmOdometer());
        System.out.println(Car.toString(myCar));
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's.\n",
                myCar2.getTypeCar(), myCar2.getColor(), myCar2.getEngineSize(), myCar2.getKmOdometer());
        System.out.println(Car.toString(myCar2));
        System.out.printf("This %s is %s, has %d cc engine and clocked %d km's.\n",
                myCar3.getTypeCar(), myCar3.getColor(), myCar3.getEngineSize(), myCar3.getKmOdometer());
        System.out.println(Car.toString(myCar3));
        System.out.println("Number of Cars Available = " + Car.getCount());

        Car myCar05 = new Car("white", 1400, "Opel", 25);
        Car myCar06 = new Car("grey", "VW");
        Car myCar07 = new Car(1100, 15);

        System.out.println(Car.toString(myCar05));
        System.out.println(Car.toString(myCar06));
        System.out.println(Car.toString(myCar07));
        System.out.println("Number of Cars Available = " + Car.getCount());

        Garage garage = new Garage();
        garage.addCar(myCar);
        garage.addRandomCar();
        System.out.println(garage.toString());

    }
}
