/**
 * Created by Rita on 2016-12-02.
 */
public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(int a) {
        super(a);
        overdraftLimit = 100;
    }

    public void withdraw(double sum)
    {
        if (getBalance()+overdraftLimit > sum)
            super.withdraw(sum);
        else
            System.err.println("CurrentAccount.withdraw(...): "
                    +"not enough balance for withdraw");
    }

    public void updateJob() {
        if (getBalance()<0) {
            System.out.println("letter sent because you are in overdraft");
        }
    }
}
