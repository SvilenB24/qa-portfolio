public class CheckingAccount extends Account {

    private double overdraftLimit;

    public CheckingAccount(String accountHolder, String accountNumber,
                           double balance, String currency, double overdraftLimit) {
        super(accountHolder, accountNumber, balance, currency);
        if (overdraftLimit < 0) {
            throw new IllegalArgumentException("Overdraft limit must not be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > this.balance + overdraftLimit) {
            return false; // exceeds balance + overdraft
        }
        this.balance -= amount; // may go negative — that is the point of an overdraft
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | overdraft up to %.2f", overdraftLimit);
    }
}
