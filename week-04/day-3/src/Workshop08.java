/**************************************************************************************************
 * Workshop: Practice Exceptions: Having raised exceptions, then what?  I'm looking to get some
 * closure here.  "Finally" would do... whatever else, this is what I need if something goes
 * wrong...
 *
 *
 *
 * So, I'm looking for the following output:
 * try - first statement
 * start - myMethod
 * An Exception Occurred
 * Finally I did this instead
 * ::::FINISH LINE:::: out of the try/catch/finally statement
 *
 **************************************************************************************************/
import java.util.*;

public class Workshop08 {

    public static void myMethod(int inNumber) throws Exception { // something should appear here before (see Workshop07)
        throw new Exception();
    }
    public static void main(String  args[]) { // see Workshop07
        int i = 0;
        try {
            System.out.println("try - first statement");
            System.out.println("start - myMethod");
            myMethod(i);
            System.out.println("this should not be printed");
        } catch (Exception e) {
            System.out.println("An Exception Occurred");
        } finally {
            System.out.println("Finally I did this instead");
        }
        System.out.println("::::FINISH LINE:::: out of the try/catch/finally statement");
    }
}
