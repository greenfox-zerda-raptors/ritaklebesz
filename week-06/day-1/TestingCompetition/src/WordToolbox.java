import java.util.HashMap;

/**
 * Created by Rita on 2016-11-21.
 */
public class WordToolbox implements IWordToolbox {
    private String stringHeld;

    public WordToolbox(String stringHeld) {
        this.stringHeld = stringHeld;
    }

    public String getS() {
        return stringHeld;
    }

    public void setS(String stringHeld) {
        this.stringHeld = stringHeld;
    }

    public boolean isAnAnagram(String stringToCheck) throws Exception {
        if (countAllLetters(stringHeld).equals(countAllLetters(stringToCheck))) {
            return true;
        } else {
            return false;
        }
    }

    private HashMap<Character, Integer> countAllLetters(String word) {
        WordToolbox wordToAnalyze = new WordToolbox(word.toLowerCase());
        HashMap<Character, Integer> mapOfWord = new HashMap<>();
        for (int i=0; i<word.length(); i++) {
            mapOfWord.put(word.toLowerCase().charAt(i), wordToAnalyze.countHowMany(word.toLowerCase().charAt(i)));
        }
        return mapOfWord;
    }

    public int countHowMany(char charToFind) {
        int count =0;
        for (int i = 0; i < stringHeld.length(); i++){
            if (Character.toLowerCase(charToFind) == stringHeld.toLowerCase().charAt(i)) {
                count += 1;
            }
        }
        return count;
    }

    @Override
    public void WaitingItOut() {
        
    }
}
