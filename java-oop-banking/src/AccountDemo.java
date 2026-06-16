import java.util.ArrayList;
import java.util.List;

public class AccountDemo {
    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Ivan Ivanov", "111", 1000.0, "BGN"));
        accounts.add(new SavingsAccount("Maria Petrova", "222", 2000.0, "BGN", 0.05));
        accounts.add(new CheckingAccount("Georgi Georgiev", "333", 500.0, "BGN", 1000.0));

        // Polymorphism: one loop, type-specific toString for each account
        for (Account acc : accounts) {
            System.out.println(acc);
        }

        System.out.println("Total accounts: " + Account.totalAccounts);

        // CheckingAccount overrides withdraw() to allow an overdraft
        System.out.println("Overdraft withdraw (1200): " + accounts.get(2).withdraw(1200));
        System.out.println(accounts.get(2));

        // Transfer between two accounts
        accounts.get(0).transfer(accounts.get(1), 200);
        System.out.println("After transfer:");
        System.out.println(accounts.get(0));
        System.out.println(accounts.get(1));
    }
}
