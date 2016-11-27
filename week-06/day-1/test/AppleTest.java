import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Rita on 2016-11-21.
 */
public class AppleTest {

    Apple apple = new Apple();
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1));
    ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1,2,3));
    ArrayList<Integer> list4;


    @Test
    public void getName() throws Exception {
        assertEquals("apple", apple.getName());
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(0, apple.sum(list1));
        assertEquals(1, apple.sum(list2));
        assertEquals(6, apple.sum(list3));
    }

    @Test (expected = NullPointerException.class)
    public void testSumNull() throws Exception {
        assertEquals(0, apple.sum(list4));
    }

    @Test
    public void testFibonacci() throws Exception {
        assertEquals(1, apple.fibonacci(1));
        assertEquals(1, apple.fibonacci(2));
        assertEquals(2, apple.fibonacci(3));
        assertEquals(5, apple.fibonacci(5));
    }
}