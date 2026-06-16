public class Account {
    private String accountHolder;
    private String accountNumber;
    protected double balance;
    private String currency;

    public static int totalAccounts = 0;

    public Account(String accountHolder, String accountNumber, double balance, String currency) {
        if (accountHolder == null || accountHolder.isBlank()) {
            throw new IllegalArgumentException("Account holder must not be empty");
        }
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number must not be empty");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency must not be empty");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must not be less than 0");
        }

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;

        totalAccounts++;
    }

    public String getAccountHolder() { return accountHolder; }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getCurrency() { return currency; }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > this.balance) {
            return false; // not enough funds
        }
        this.balance -= amount;
        return true;
    }

    public boolean transfer(Account target, double amount) {
        if (target == null) {
            throw new IllegalArgumentException("Target account must not be null");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > this.balance) {
            return false; // not enough funds
        }
        this.balance -= amount;
        target.balance += amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %.2f %s", accountHolder, accountNumber, balance, currency);
    }
}
