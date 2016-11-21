import java.util.ArrayList;

/**
 * Created by Rita on 2016-11-21.
 */
public class Apple {
    String name = "apple";

    public String getName() {
        return name;
    }

    public int sum(ArrayList<Integer> integerArrayList) {
        int sum = 0;
        for (Integer i : integerArrayList) {
            sum += i;
        }
        return sum;
    }

    public int fibonacci(int number) {
        if (number < 3) {
            return 1;
        }
        return fibonacci(number-1) + fibonacci(number-2);
    }
}
