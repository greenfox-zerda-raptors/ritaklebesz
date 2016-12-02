import java.util.ArrayList;

/**
 * Created by Rita on 2016-12-02.
 */
public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void add(Account account) {
        accounts.add(account);
    }

    public void update() {
        for (Account account : accounts) {
            if (account.getClass() == SavingsAccount.class) {
                ((SavingsAccount)account).addInterest();
            } else if (account.getClass() == CurrentAccount.class) {
                if (account.getBalance()<0) {
                    System.out.println("letter sent because you are in overdraft");
                }
            }
        }
    }
}
