/**
 * Created by Rita on 2016-12-02.
 */
public class App {
    public static void main(String[] args) {
        Bank bankaccounts = new Bank();
        SavingsAccount savingsAccount = new SavingsAccount(2);
        bankaccounts.add(savingsAccount);
        CurrentAccount currentAccount = new CurrentAccount(3);
        bankaccounts.add(currentAccount);
        currentAccount.deposit(250);
        currentAccount.withdraw(270);
        currentAccount.print();
        currentAccount.withdraw(20);
        currentAccount.print();
        currentAccount.withdraw(150);
        currentAccount.print();
        savingsAccount.deposit(100);
        savingsAccount.print();
        bankaccounts.update();
        savingsAccount.print();
        currentAccount.print();

        System.out.println("****************");

        Bank2 bankaccounts2 = new Bank2();
        Account account2 = new SavingsAccount(1);
        bankaccounts2.add(account2);
        SavingsAccount savingsAccount2 = new SavingsAccount(2);
        bankaccounts2.add(savingsAccount2);
        CurrentAccount currentAccount2 = new CurrentAccount(3);
        bankaccounts2.add(currentAccount2);
        account2.deposit(300);
        savingsAccount2.deposit(100);
        currentAccount2.deposit(250);
        currentAccount2.withdraw(270);
        currentAccount2.print();
        bankaccounts2.updateM();
        account2.print();
        savingsAccount2.print();
        currentAccount2.print();
    }
}
