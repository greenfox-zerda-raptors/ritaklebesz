/**************************************************************************************************
 * Workshop: Practice Exceptions: Nested Try Catch
 *
 * Run this and explain the what the heck is going on
 *
 * ADD YOUR EXPLANATION HERE -----------------------------------
 * Try to execute Statement in line 19 -> raise Arithmetic Exception which is caught, therefore
 * statement in line 26 executed.
 * try to execute Statement in line 31 -> raise Arithmetic Exception, that is not caught within the child block
 * parent block reached an uncaught exception, therefore line 38 never reached.
 * the parent block's uncaught expression is caught in line 41, therefore line 42 and 43 is printed.
 * Finally, statement outside of try is executed.
 *
 **************************************************************************************************/
import java.util.*;

public class Workshop05{
    public static void main(String[] args){

        //Parent try block
        try{
            //Child try block1
            try{
                System.out.println("Inside block1");
                int b =45/0;
                System.out.println(b);
            }
            catch(ArithmeticException e1){
                System.out.println("Exception: e1");
            }
            //Child try block2
            try{
                System.out.println("Inside block2");
                int b =45/0;
                System.out.println(b);
            }
            catch(ArrayIndexOutOfBoundsException e2){
                System.out.println("Exception: e2");
            }
            System.out.println("Just other statement");
        }
        catch(ArithmeticException e3){
            System.out.println("Arithmetic Exception");
            System.out.println("Inside parent try catch block");
        }
        catch(ArrayIndexOutOfBoundsException e4){
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println("Inside parent try catch block");
        }
        catch(Exception e5){
            System.out.println("Exception");
            System.out.println("Inside parent try catch block");
        }
        System.out.println("Next statement..");
    }
}
