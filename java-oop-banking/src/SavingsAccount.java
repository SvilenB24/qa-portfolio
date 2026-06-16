public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(String accountHolder, String accountNumber,
                          double balance, String currency, double interestRate) {
        super(accountHolder, accountNumber, balance, currency);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %.1f%% interest", interestRate * 100);
    }
}
