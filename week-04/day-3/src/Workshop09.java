/**************************************************************************************************
 * Workshop: Practice Exceptions: I have to have it my way.  When an exception occurs, I want a
 * special error message, namely "7's are cannibals!" printed.
 *
 *
 * So, I'm looking for the following output:
 * try - first statement
 * start - myMethod
 * An Exception Occurred
 * 7's are cannibals
 * Finally I did this instead
 * ::::FINISH LINE:::: out of the try/catch/finally statement
 *
 * Refer to Workshop07
 **************************************************************************************************/
import java.util.*;

public class Workshop09{

    public static void myMethod(int inNumber) throws Exception { // something should appear here before (see Workshop07)
        throw new Exception("7's are cannibals");
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
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally I did this instead");
        }
        System.out.println("::::FINISH LINE:::: out of the try/catch/finally statement");
    }

}
