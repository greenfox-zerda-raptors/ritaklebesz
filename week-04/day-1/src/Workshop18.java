/**
 * Created by Rita on 2016-11-07.
 */
public class Workshop18 {
    public static void main(String[] args) {
        String example = "A long example string";
        StringBuilder exampleSB = new StringBuilder(example);

        exampleSB.replace(exampleSB.indexOf("long"), (exampleSB.indexOf("long")+4), "short");
        // I would like to replace "long" with "short" in this example, but it has a problem. Please fix it! Don't forget that String is immutable
        // Expected ouput: A short example string


        System.out.println(exampleSB);
    }
}
