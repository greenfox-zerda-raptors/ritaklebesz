/**
 * Created by Rita on 2016-11-04.
 */
public class Workshop08 {
    public static void main(String[] args) {
        // Task 1: Create (dynamically) a two dimensional array with the following matrix. Use a loop!
        // 1 0 0 0
        // 0 1 0 0
        // 0 0 1 0
        // 0 0 0 1
        int[][] matrix = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = 0;
                if (j == i) {
                    matrix[i][j] = 1;
                }
            }
        }

        // Task 2: Print this two dimensional array to the output
        for (int[] row : matrix) {
            String mr = "";
            for (int item : row) {
                mr = mr + item + " ";
            }
            System.out.println(mr);
        }
    }
}
