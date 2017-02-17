/**
 * Created by Rita on 2017-02-17.
 */
public class ManualTesting {

    public static void main(String[] args) {
        ExamExercise15 test = new ExamExercise15();
        System.out.println(test.spiltStringByTwoCharacters("abcdef").toString());
        System.out.println(test.spiltStringByTwoCharacters("abcdefg").toString());
        System.out.println(test.spiltStringByTwoCharacters("a").toString());
        System.out.println(test.spiltStringByTwoCharacters("").toString());
        System.out.println(test.spiltStringByTwoCharacters("abc").toString());
    }
}
