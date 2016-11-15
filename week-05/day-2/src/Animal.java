/**
 * Created by Rita on 2016-11-15.
 */
public class Animal {
    int lifeExpectancy;
    boolean isCarnivore;

    public Animal() {
        this(10, false);
    }

    public Animal(int lifeExpectancy, boolean isCarnivore) {
        this.lifeExpectancy = lifeExpectancy;
        this.isCarnivore = isCarnivore;
        System.out.println("Animal is created");
    }

    public Animal(String type) {
        this();
        System.out.printf("%s animal is created\n", type);
    }

    public void eat() {
        System.out.println("Animal is eating");
    }
    public void sleep() {
        System.out.println("Animal is sleeping");
    }

    public void speak() {
        System.out.println("speaks");
    }

    public String toString() {
        return "isCarnivore= " + isCarnivore + ", lifeExpectancy= " + lifeExpectancy;
    }

}
