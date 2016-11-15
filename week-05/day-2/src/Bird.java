/**
 * Created by Rita on 2016-11-15.
 */
public class Bird extends Animal {


    public Bird() {
        super("Bird");
        lifeExpectancy = 2;
        isCarnivore = false;
    }

    public void fly () {
        System.out.println("The bird can fly");
    }

    public void sleep() {
        System.out.println("The bird is sleeping");
        super.sleep();
    }

    public void nightyNight() {
        super.eat();
        this.sleep();
    }

    public void speak() {
        System.out.println("chirp");
    }
}
