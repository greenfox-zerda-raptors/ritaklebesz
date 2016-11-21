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
        return true;
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
