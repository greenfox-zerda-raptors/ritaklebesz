/**
 * Created by Rita on 2016-11-15.
 */
public class Dog extends Animal {
    public boolean hasTail = true;
    public Dog() {
        super(15, true);
        System.out.println("Dog is created.");
    }

    public void speak() {
        System.out.println("barks");
    }

    public void beg() {
        System.out.println("beg");
    }
}
