import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by Rita on 2016-11-15.
 * Create a Stack class that stores elements

 It should have a size method that returns number of elements it has
 It should have a push method that adds an element to the stack
 It should have a pop method that returns the last element form the stack and also deletes it from it
 Please don't use the built in methods!
 */
public class Stack {

    private ArrayList<Object> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public Stack(Object... objects) {
        stack = new ArrayList<>(Arrays.asList(objects));
    }

    public int size() {
        int counter = 0;
        for (Object item : stack) {
            counter += 1;
        }
        return counter;
    }

    public void push(Object item) {
        stack.add(0, item);
    }

    public Object pop() {
        Object o = stack.get(0);
        stack.remove(0);
        return o;
    }
}
