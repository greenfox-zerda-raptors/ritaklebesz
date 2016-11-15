import java.util.Arrays;

/**
 * Created by Rita on 2016-11-15.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack newStack = new Stack(1,2,3,4,5,6);
        System.out.println(newStack.size());
        newStack.push(12);
        System.out.println(newStack.size());
        System.out.println(newStack.pop());
        System.out.println(newStack.size());
    }
}
