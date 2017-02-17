import java.util.ArrayList;

/**
 * Created by Rita on 2017-02-17.
 * Create a function that takes a string and splits it to a list of two character strings like: "abcdef" becomes ["ab", "cd", "ef"]
 */
public class ExamExercise15 {
    public ArrayList<String> spiltStringByTwoCharacters(String string) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder split = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            split.append(string.charAt(i));
            if (i % 2 == 1 || i == string.length()-1) {
                result.add(split.toString());
                split.setLength(0);
            }
        }
        return result;
    }
}
