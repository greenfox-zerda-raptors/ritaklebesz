import java.util.Arrays;

/**
 * Created by Rita on 2016-11-04.
 */
public class Workshop10 {
    public static void main(String[] args) {
        // Task 1: Create an array (jagged) which can contain the different shades of specified colors
        // in colors[0] store the shades of green: "lime", "forest green", "olive", "pale green", "spring green"
        // in colors[1] store the shades of red: "orange red", "red", "tomato"
        // in colors[2] store the shades of pink: "orchid", "violet", "pink", "hot pink"
        String[][] colors = new String[3][];
        colors[0] = new String[5];
        colors[1] = new String[3];
        colors[2] = new String[4];
        colors[0][0] = "lime";
        colors[0][1] = "forest green";
        colors[0][2] = "olive";
        colors[0][3] = "pale green";
        colors[0][4] = "spring green";
        colors[1][0] = "orange red";
        colors[1][1] = "red";
        colors[1][2] = "tomato";
        colors[2][0] = "orchid";
        colors[2][1] = "violet";
        colors[2][2] = "pink";
        colors[2][3] = "hot pink";
        // Task 2: Print the values of the array to the console
        for (String[] color : colors) {
            for (String colorShade : color)
            System.out.println(colorShade);
        }
    }
}