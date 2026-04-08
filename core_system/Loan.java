package core_system;

public class Loan extends BaseEntity {
    private Customer customer;
    private double principalAmount;
    private double interestRate;
    private double paidAmount;

    public Loan(String id, String name, double principal, double rate) {
        super(id, name);
        this.principalAmount = principal;
        this.interestRate = rate;
        this.paidAmount = 0;
    }

    @Override
    public String getEntityType() {
        return "LOAN";
    }

    @Override
    public boolean isValid() {
        return id != null && principalAmount > 0 && interestRate >= 0;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void makePayment(double amount) {
        if (amount > 0) {
            paidAmount += amount;
        }
    }

    public double getRemainingBalance() {
        return principalAmount + (principalAmount * interestRate) - paidAmount;
    }

    public boolean isPaidOff() {
        return getRemainingBalance() <= 0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
