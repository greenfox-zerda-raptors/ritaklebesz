import java.util.ArrayList;

/**
 * Created by Rita on 2016-12-02.
 */
public class Bank2 extends ArrayList<Account> {
    public void updateM() {
        for (Account a : this) {
            a.updateJob();
        }
    }
}
