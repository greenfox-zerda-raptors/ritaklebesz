/**
 * Created by Rita on 2016-12-02.
 */
public class SavingsAccount extends Account {
    private double interest;

    public SavingsAccount(int a) {
        super(a);
        interest = 2;
    }

    public void addInterest()
    {
        deposit(getBalance() * interest/100);
    }

    public void withdraw(double sum)
    {
        if (sum>getBalance())
            super.withdraw(sum);
        else
            System.err.println("Account.withdraw(...): "
                    +"not enough balance for withdraw");
    }

    public void updateJob() {
        addInterest();
    }
}
